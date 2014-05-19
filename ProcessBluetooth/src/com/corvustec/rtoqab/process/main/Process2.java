package com.corvustec.rtoqab.process.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;







import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.io.FileUtils;

import ch.lambdaj.function.matcher.HasArgumentWithValue;

import com.corvustec.rtoqab.process.util.ReadAgencia;
import com.corvustec.rtoqad.process.dto.DataDTO;

import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.*;


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
				 data.setRssi(min(dataMac, on(DataDTO.class).getRssi()));
				 data.setMac(dat.getMac());
				 data.setFecha(dat.getFecha());
				 
				 dataMax.add(data);
			}

		
			
			
//			dataList= (List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
//				@Override
//				public boolean evaluate(Object arg0) {
//                     DataDTO dat= (DataDTO)arg0;
//                     if(dat.getRssi()>=-65)
//                    	 return true;
//                     else
//                    	 return false;
//				}
//			});
			
			
			
			
			for(DataDTO dat:dataMax)
			{				
				System.out.print(dat.getFecha()+"|");
				System.out.print(dat.getMac()+"|");
				System.out.println(dat.getRssi());
			}

			
			
			
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
	
	
	
	

	
}
