package com.corvustec.rtoqab.process.main;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.max;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static ch.lambdaj.Lambda.sumFrom;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.io.FileUtils;

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
		
		int balizaSum,index;
		float balizaAvg;
		double varianza= 0.0,desviacion = 0.0,rango=0.0,balizaSumDbl,balizaAvgDbl,limiteSuperior,limiteInferior;
		
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
			   rango = Math.pow(dat.getRssi()-balizaAvg,2);
			   varianza = varianza + rango;				
			}
			
			varianza=varianza/baliza.size();
			desviacion=Math.sqrt(varianza);
			
			varianza=0.0;
			
			dataListDistinct = getDistinct(dataList);
			
			
			for(DataDTO dat:dataListDistinct)
			{
				 dataMac= select(dataList, having(on(DataDTO.class).getMac(), equalTo(dat.getMac())));
				 data=new DataDTO();
				 data.setRssi(max(dataMac, on(DataDTO.class).getRssi()));
				 data.setMac(dat.getMac());
				 data.setFecha(dat.getFecha());
				 
				 dataMax.add(data);
			}

			//Libero memoria lista
			dataListDistinct=null;
			
			/*
			 * Se descartan las señales menores entre la media y desv. estandar por un factor.
			 */
			for(DataDTO dat:dataMax)
			{
				//El numero 1 debe ser dinamico (pendiente por analizar)
				if(dat.getRssi()<(balizaAvg-(desviacion*1)))
				{
					dataList.removeAll(select(dataList, having(on(DataDTO.class).getMac(), equalTo(dat.getMac()))));
				}
			}		 			
			dataMax=null;
			
			//Todavia es el Paso 1
			List<IntervaloTiempoDTO> intervaloSegundo;
			
			List<DataDTO> temp=new ArrayList<DataDTO>();
			List<DataDTO> temp2=new ArrayList<DataDTO>();
			List<DataDTO> temp3=new ArrayList<DataDTO>();
			List<DataDTO> temp4=new ArrayList<DataDTO>();
			StringBuilder sb=new StringBuilder();
			
			intervaloSegundo=generateIntervalSecond();
			
			DataDTO datoTemp;

			index=1;
			//selecciona solo intervalos necesarios
			for(final IntervaloTiempoDTO inter:intervaloSegundo)
			{
				temp= (List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
                     DataDTO dat= (DataDTO)arg0;
                     if(dat.getMinuto().getTime()>=inter.getTimeDesde().getTime()
                    		 &&dat.getMinuto().getTime()<inter.getTimeHasta().getTime())
                    	 return true;
                     else
                    	 return false;
					}
				});
			
				if(temp.size()>0)
				{
					for(DataDTO dat:temp)
					{
						datoTemp=dat;
						datoTemp.setIntervaloSegundoDesde(inter.getTimeDesde());
						datoTemp.setIntervaloSegundoHasta(inter.getTimeHasta());
						datoTemp.setNumeroIntervalo(index);
						temp2.add(datoTemp);
					}
					index=index+1;
				}
			}
			
			
			//Paso los datos con intervalos a dataList			
			dataList=temp2;
						
			dataListDistinct=getDistinct(dataList);

			//Encuentro promedio por intervalos
			for(final DataDTO dato:dataListDistinct)
			{
				temp= (List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
                     DataDTO dat= (DataDTO)arg0;
                     if(dat.getMac().equals(dato.getMac()))
                    	 return true;
                     else
                    	 return false;
					}
				});
				
				temp2=getDistinctByNumeroIntervalo(temp);

				//Sorting
				Collections.sort(temp2, new Comparator<DataDTO>() {
			        @Override
			        public int compare(DataDTO  dato1, DataDTO  dato2){
			            return dato1.getNumeroIntervalo()> dato2.getNumeroIntervalo()?1:-1;
			        }
			    });
				
				for(final DataDTO d:temp2)
				{
					temp3= (List<DataDTO>) CollectionUtils.select(temp, new Predicate() {
						@Override
						public boolean evaluate(Object arg0) {
	                     DataDTO dat= (DataDTO)arg0;
	                     if(dat.getNumeroIntervalo()==d.getNumeroIntervalo())
	                    	 return true;
	                     else
	                    	 return false;
						}
					});
					
					if(temp3.size()>0)
					{
						datoTemp=temp3.get(0);
						balizaSum=sumFrom(temp3).getRssi();
						balizaAvg=(float)balizaSum/temp3.size();
						datoTemp.setMedia(balizaAvg);
						temp4.add(datoTemp);
					}
										
				}
			}

			dataList=temp4;
			
			dataListDistinct=getDistinct(dataList);
			
			//Suavizar la curso con limites
			temp2=new ArrayList<DataDTO>();
			
			for(final DataDTO dato:dataListDistinct)
			{
				temp=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
                     DataDTO dat= (DataDTO)arg0;
                     if(dat.getMac().equals(dato.getMac()))
                    	 return true;
                     else
                    	 return false;
					}
				});
				balizaSumDbl=sumFrom(temp).getMedia();
				balizaAvgDbl=balizaSumDbl/(temp.size());
				
				varianza=0.0;
				
				for(DataDTO dat:temp)
				{
				   rango = Math.pow(dat.getMedia()-balizaAvgDbl,2);
				   varianza = varianza + rango;				
				}
				varianza=varianza/(temp.size());
				desviacion=Math.sqrt(varianza);
				
				//3 es el numero de sigmas
				limiteSuperior=balizaAvgDbl+(desviacion*1);
				limiteInferior=balizaAvgDbl-(desviacion*1);
				
				index=0;
				for(DataDTO dat:temp)
				{
										
					datoTemp=new DataDTO();
					datoTemp=dat;
					
					if(!(dat.getMedia()>=limiteInferior&&dat.getMedia()<=limiteSuperior))
						if((index-1)>=0&&index+1<temp.size())
							datoTemp.setMedia((temp.get(index-1).getMedia()+temp.get(index+1).getMedia())/2);
					
					index=index+1;
					temp2.add(datoTemp);
				}
			}
			
			dataList=temp2;

			
			//Obtengo la media de las balizas en grupo para cada intervalo
			baliza=(List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
				@Override
				public boolean evaluate(Object arg0) {
                 DataDTO dat= (DataDTO)arg0;
                 if(dat.getMac().equals("00:68:58:09:15:33")
                		 ||dat.getMac().equals("2C:44:01:B3:F9:DD")
                		 ||dat.getMac().equals("F8:5F:2A:79:66:8F")
                		 ||dat.getMac().equals("40:BA:61:5B:31:E9"))
                	 return true;
                 else
                	 return false;
				}
			});
			

			temp=getDistinctByNumeroIntervalo(baliza);
			
			temp3=new ArrayList<DataDTO>();
			
			for(final DataDTO dato:temp)
			{
				temp2=(List<DataDTO>) CollectionUtils.select(baliza, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
	                 DataDTO dat= (DataDTO)arg0;
	                 if(dat.getNumeroIntervalo()==dato.getNumeroIntervalo())
	                	 return true;
	                 else
	                	 return false;
					}
				});				

				if(temp2.size()>0)
				{
					datoTemp=temp2.get(0);
					balizaSum=sumFrom(temp2).getRssi();
					balizaAvg=(float)balizaSum/temp2.size();
					datoTemp.setMedia(balizaAvg);
					temp3.add(datoTemp);
				}
			}
			
			baliza=temp3;
			temp3=new ArrayList<DataDTO>();
			//Comparcion con balizas
			for(final DataDTO dato:dataList)
			{
				temp2=(List<DataDTO>) CollectionUtils.select(baliza, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
	                 DataDTO dat= (DataDTO)arg0;
	                 if(dat.getNumeroIntervalo()==dato.getNumeroIntervalo())
	                	 return true;
	                 else
	                	 return false;
					}
				});
				datoTemp=new DataDTO();
				datoTemp=dato;
				if(temp2.size()>0)
				{
					if(dato.getMedia()<temp2.get(0).getMedia())
						datoTemp.setEstado(0);
					else
						datoTemp.setEstado(1);					
				}
				temp3.add(datoTemp);
			}

			dataList=temp3;
			
			for(DataDTO dat:dataList){
				sb.append(dat.getMac()+"|");
				sb.append(dat.getMinuto()+"|");
				sb.append(dat.getNumeroIntervalo()+"|");
				sb.append(dat.getIntervaloSegundoDesde()+"|");
				sb.append(dat.getIntervaloSegundoHasta()+"|");
				sb.append(dat.getEstado()+"|");
				sb.append(dat.getMedia()+"\n");
				writer.write(sb.toString());
				sb=new StringBuilder();
			}
			writer.close();

			
			
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
	
	public static List<DataDTO> getDistinct(List<DataDTO> dataList)
	{
		List<DataDTO> list;
		Map<String, DataDTO> map = new HashMap<String, DataDTO>();
		for (DataDTO p : dataList) {
		    if (!map.containsKey(p.getMac())) {
		        map.put(p.getMac(), p);
		    }
		}
		list= new ArrayList<DataDTO>(map.values());
		return list;
	}

	
	public static List<DataDTO> getDistinctByNumeroIntervalo(List<DataDTO> dataList)
	{
		List<DataDTO> list;
		Map<Integer, DataDTO> map = new HashMap<Integer, DataDTO>();
		for (DataDTO p : dataList) {
		    if (!map.containsKey(p.getNumeroIntervalo())) {
		        map.put(p.getNumeroIntervalo(), p);
		    }
		}
		list= new ArrayList<DataDTO>(map.values());
		return list;
	}

}
