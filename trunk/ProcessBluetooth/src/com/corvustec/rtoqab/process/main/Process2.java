package com.corvustec.rtoqab.process.main;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.max;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static ch.lambdaj.Lambda.sumFrom;
import static ch.lambdaj.Lambda.sort;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.io.FileUtils;

import com.corvustec.rtoqab.process.jdbc.ConnectionJDBC;
import com.corvustec.rtoqab.process.util.ReadAgencia;
import com.corvustec.rtoqab.process.util.UtilApplication;
import com.corvustec.rtoqad.process.dto.DataDTO;
import com.corvustec.rtoqad.process.dto.IntervaloTiempoDTO;


public class Process2 {

	
	
	public static void main(String[] args) {
		
		long start, end,diff;
		start = System.currentTimeMillis();
		
		//insertValue();
		processOne();

		//generateIntervalSecond();
		//generateIntervalMinute();		
		
		end = System.currentTimeMillis();
		diff=end-start;
		diff=(long) (diff* 0.001);
		System.out.println("Procesado en: "+ ( diff ) +" segundos");				
	}

	
	@SuppressWarnings("unchecked")
	private static void processOne()
	{
		File fileIn=new File(ReadAgencia.readValue("com.corvustec.rtoqab.process.0036")+"20140510.txt");
		
		File fileOut=new File(ReadAgencia.readValue("com.corvustec.rtoqab.process.0036")+"20140510Final.txt");
		
		List<String> lines;
		String line[];
		Integer linea = null;
		List<DataDTO> dataList;
		DataDTO data;
		
		FileWriter writer;
		
		List<DataDTO> dataListDistinct;
		List<DataDTO> baliza;
		List<DataDTO> dataMac;
		List<DataDTO> dataMax;
		
		int balizaSum;
		float balizaAvg;
		double varianza= 0.0,desviacion = 0.0;
		
		try{			
			dataListDistinct =new ArrayList<DataDTO>();
			baliza=new ArrayList<DataDTO>();
			writer=new FileWriter(fileOut);
			dataList=new ArrayList<DataDTO>();
			dataMac=new ArrayList<DataDTO>();
			dataMax=new ArrayList<DataDTO>();
			
			lines = FileUtils.readLines(fileIn);

			for(int i=0;i<lines.size();i++)
			{
				line=lines.get(i).split("\\|");
				data=new DataDTO();
				data.setFecha(Timestamp.valueOf(line[0]));
				data.setMinuto(Time.valueOf(line[0].substring(11, 19)));
				data.setMac(line[1]);
				data.setRssi(Integer.valueOf(line[2]));
				dataList.add(data);
			}
			
			lines=null;
			
			//dataListMenor=select(dataList, having(on(DataDTO.class).getRssi(),lessThan(-65)));
			
			baliza.addAll(select(dataList, having(on(DataDTO.class).getMac(), equalTo("00:68:58:09:15:33"))));
			baliza.addAll(select(dataList, having(on(DataDTO.class).getMac(), equalTo("2C:44:01:B3:F9:DD"))));
			baliza.addAll(select(dataList, having(on(DataDTO.class).getMac(), equalTo("F8:5F:2A:79:66:8F"))));
			baliza.addAll(select(dataList, having(on(DataDTO.class).getMac(), equalTo("40:BA:61:5B:31:E9"))));
					
			balizaSum=sumFrom(baliza).getRssi();
			
			balizaAvg=(float)balizaSum/(baliza.size());
			
			for(DataDTO dat:baliza)
			{
			   double rango;
			   rango = Math.pow(dat.getRssi()-balizaAvg,2);
			   varianza = varianza + rango;				
			}
			
			varianza=varianza/baliza.size();
			desviacion=Math.sqrt(varianza);
			
			varianza=0.0;
			

			Map<String, DataDTO> map = new HashMap<String, DataDTO>();
			for (DataDTO p : dataList) {
			    if (!map.containsKey(p.getMac())) {
			        map.put(p.getMac(), p);
			    }
			}
			dataListDistinct = new ArrayList<DataDTO>(map.values());
			
			
			for(DataDTO dat:dataListDistinct)
			{
				 dataMac= select(dataList, having(on(DataDTO.class).getMac(), equalTo(dat.getMac())));
				 data=new DataDTO();
				 data.setRssi(max(dataMac, on(DataDTO.class).getRssi()));
				 data.setMac(dat.getMac());
				 data.setFecha(dat.getFecha());
				 
				 dataMax.add(data);
			}

			
			/*
			 * Se descartan las señales menores a a la sua entre la media y desv. estandar por un factor.
			 */
			for(DataDTO dat:dataMax)
			{
				//El numero 1 debe ser dinamico (pendiente por analizar)
				if(dat.getRssi()<(balizaAvg-(desviacion*1)))
				{
					dataList.removeAll(select(dataList, having(on(DataDTO.class).getMac(), equalTo(dat.getMac()))));
				}
			}		
			//Fin paso 			
			
			
			//Todavia es el Paso 1
			List<IntervaloTiempoDTO> intervaloMinuto,intervaloSegundo;
			
			List<DataDTO> temp=new ArrayList<DataDTO>();
			List<DataDTO> temp2=new ArrayList<DataDTO>();
			List<DataDTO> temp3=new ArrayList<DataDTO>();
			intervaloMinuto=generateMinute();
			intervaloSegundo=generateIntervalSecond();
			
			DataDTO datoTemp;
			
			for(final IntervaloTiempoDTO inter:intervaloSegundo)
			{
				temp= (List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
				@Override
				public boolean evaluate(Object arg0) {
                     DataDTO dat= (DataDTO)arg0;
                     if(dat.getMinuto().getTime()>inter.getTimeDesde().getTime()&&dat.getMinuto().getTime()<=inter.getTimeHasta().getTime())
                    	 return true;
                     else
                    	 return false;
				}
				});
				for(DataDTO dato: temp)
				{
					datoTemp=dato;
					datoTemp.setIntervaloSegundoDesde(inter.getTimeDesde());
					datoTemp.setIntervaloSegundoHasta(inter.getTimeHasta());
					temp2.add(datoTemp);
				}
			}
			
			
//			for(final IntervaloTiempoDTO interM:intervaloMinuto)
//			{
//				temp= (List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
//				@Override
//				public boolean evaluate(Object arg0) {
//                     DataDTO dat= (DataDTO)arg0;
//                     if(dat.getMinuto().getTime()>interM.getTimeDesde().getTime()&&dat.getMinuto().getTime()<=interM.getTimeHasta().getTime())
//                    	 return true;
//                     else
//                    	 return false;
//				}
//				});
//				for(DataDTO dato: temp)
//				{
//					datoTemp=dato;
//					datoTemp.setIntervaloSegundoDesde(interM.getTimeDesde());
//					datoTemp.setIntervaloSegundoHasta(interM.getTimeHasta());
//					temp3.add(datoTemp);
//				}
//			}
//			
			dataList=temp2;
			
			for(DataDTO dat:dataList){
				System.out.print(dat.getRssi()+" ");
				System.out.print(dat.getMac()+" ");
				System.out.print(dat.getMinuto()+" ");
				System.out.print(dat.getIntervaloSegundoDesde()+" ");
				System.out.println(dat.getIntervaloSegundoHasta());
			}


			
			//dataList= sort(dataList, on(DataDTO.class).getFecha());
					
			
			
//			dataList= (List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
//				@Override
//				public boolean evaluate(Object arg0) {
//                     DataDTO dat= (DataDTO)arg0;
//                     if(dat.getRssi()>=balizaAvg-desviacion)
//                    	 return true;
//                     else
//                    	 return false;
//				}
//			});
			
			
//			map = new HashMap<String, DataDTO>();
//			for (DataDTO p : dataList) {
//			    if (!map.containsKey(p.getMac())) {
//			        map.put(p.getMac(), p);
//			    }
//			}
//			dataListDistinct = new ArrayList<DataDTO>(map.values());
//
//			for(DataDTO dat:dataList)
//			{				
//				writer.write(dat.getFecha()+"|"+dat.getMac()+"|"+dat.getRssi()+"\n");
//			}
//			writer.close();
//			
//			for(DataDTO dat:dataListDistinct)
//			{
//				System.out.print(dat.getFecha());
//				System.out.print(dat.getMac());
//				System.out.println(dat.getRssi());
//			}

			
//	
//			List<DataDTO> all = new ArrayList<DataDTO>();
//			all.addAll(dataListMenor);
//			all.addAll(dataListMenor);
//
//			Map<String, DataDTO> map = new HashMap<String, DataDTO>();
//			for (DataDTO p : all) {
//			    if (!map.containsKey(p.getMac())) {
//			        map.put(p.getMac(), p);
//			    }
//			}
//			dataListMenor = new ArrayList<DataDTO>(map.values());
////			
////			
////			
////			
//			
//			List<DataDTO> listTemp;
//			for(DataDTO dat:dataListMenor)
//			{
//				listTemp=new ArrayList<DataDTO>();
//				listTemp=select(dataList, having(on(DataDTO.class).getMac(),equalTo(dat.getMac())));
//				
//				for(DataDTO temp: listTemp)
//				{
//					dataList.remove(temp);
//				}
//			}
//			
//			
//			for(DataDTO dat:dataList)
//			{
//				System.out.print(dat.getFecha());
//				System.out.print(dat.getMac());
//				System.out.println(dat.getRssi());
//			}

			
		} catch (IOException e) {
			System.out.println("Error linea: "+linea);
			e.printStackTrace();
		}
	}
	
	
	public static List<IntervaloTiempoDTO> generateIntervalSecond()
	{
		Time desde,hasta;
		String incremento;
		List<IntervaloTiempoDTO> intervaloTiempo = null;
		IntervaloTiempoDTO intervalo;
		try {
			intervaloTiempo=new ArrayList<IntervaloTiempoDTO>();
			desde=Time.valueOf("08:00:00");
			hasta= Time.valueOf("17:00:00");
			
			while(desde.before(hasta))
			{
				incremento= UtilApplication.addSecond(desde.toString(), 15);

				intervalo= new IntervaloTiempoDTO();
				intervalo.setTimeDesde(desde);
				intervalo.setTimeHasta(Time.valueOf(incremento));
				intervaloTiempo.add(intervalo);
				
				desde=Time.valueOf(UtilApplication.addSecond(desde.toString(), 15));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return intervaloTiempo;		
	}
	
	public static List<IntervaloTiempoDTO> generateMinute()
	{
		Time desde,hasta;
		String incremento;
		List<IntervaloTiempoDTO> intervaloTiempo = null;
		IntervaloTiempoDTO intervalo;
		try {
			intervaloTiempo=new ArrayList<IntervaloTiempoDTO>();
			desde=Time.valueOf("08:00:00");
			hasta= Time.valueOf("17:00:00");
			
			while(desde.before(hasta))
			{
				incremento= UtilApplication.addMinute(desde.toString(), 15);

				intervalo= new IntervaloTiempoDTO();
				intervalo.setTimeDesde(desde);
				intervalo.setTimeHasta(Time.valueOf(incremento));
				intervaloTiempo.add(intervalo);
				
				desde=Time.valueOf(UtilApplication.addMinute(desde.toString(), 15));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return intervaloTiempo;		
	}
	
	

}
