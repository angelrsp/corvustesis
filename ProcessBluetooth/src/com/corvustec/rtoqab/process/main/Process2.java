package com.corvustec.rtoqab.process.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.io.FileUtils;

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
		File fileIn=new File(ReadAgencia.readValue("com.corvustec.rtoqab.process.0016")+"20140424.txt");
		
		File fileOut=new File(ReadAgencia.readValue("com.corvustec.rtoqab.process.0016")+"20140424Out.txt");
		
		List<String> lines;
		String line[];
		Integer linea = null;
		List<DataDTO> dataList;
		DataDTO data;
		
		List<DataDTO> dataListMenor=new ArrayList<DataDTO>();
		
		FileWriter writer;
		
		try{
			writer=new FileWriter(fileOut);
			dataList=new ArrayList<DataDTO>();
			
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
			
			//dataListMenor=select(dataList, having(on(DataDTO.class).getRssi(),lessThan(-65)));
			
			dataList= (List<DataDTO>) CollectionUtils.select(dataList, new Predicate() {
				@Override
				public boolean evaluate(Object arg0) {
                     DataDTO dat= (DataDTO)arg0;
                     if(dat.getRssi()>=-65)
                    	 return true;
                     else
                    	 return false;
				}
			});
			
			
			for(DataDTO dat:dataList)
			{
				
				System.out.print(dat.getFecha());
				System.out.print(dat.getMac());
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
