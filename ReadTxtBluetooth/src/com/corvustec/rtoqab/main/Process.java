package com.corvustec.rtoqab.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.corvustec.rtoqab.util.CalendarUtil;
import com.corvustec.rtoqab.util.ReadConfiguration;

public class Process {

	
	public static void main(String[] args) {
		outTxt();
		outTxt2();
	}

	private static void outTxt()
	{
		String month=String.valueOf(CalendarUtil.getMonth());
		month=month.length()==1?"0"+month:month;
		String fileNameIn=String.valueOf(CalendarUtil.getYear())+month+String.valueOf(CalendarUtil.getDay());
		
		File fileIn=new File(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.path.in")+fileNameIn+".txt");
		File fileOut=new File(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.path.out")+fileNameIn+".txt");
		
		List<String> lines;
		
		FileWriter writer ;
		int indexRssi;
		
		try{
			lines = FileUtils.readLines(fileIn);
			writer= new FileWriter(fileOut);
			for(int i=0;i<lines.size();i++)
			{
				//System.out.print("Linea " + i);
				indexRssi= lines.get(i).indexOf("rssi");
				if(indexRssi!=-1)
				{
					String out=lines.get(i-1).substring(0, 25)+"|"+lines.get(i).substring(11, 28)+"|"+lines.get(i).substring(indexRssi+5, indexRssi+8)+"\n";
					//System.out.print(out);					
					writer.write(out);
				}
			}
			writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	
	private static void outTxt2()
	{
		
		String month=String.valueOf(CalendarUtil.getMonth());
		month=month.length()==1?"0"+month:month;
		String fileNameIn=String.valueOf(CalendarUtil.getYear())+month+String.valueOf(CalendarUtil.getDay());

		
		File fileIn=new File(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.path.in")+fileNameIn+".txt");
		File fileOut=new File(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.path.out")+fileNameIn+"Old.txt");
		
		List<String> lines;
		
		FileWriter writer ;
		int indexRssi;
		
		try{
			lines = FileUtils.readLines(fileIn);
			writer= new FileWriter(fileOut);
			for(int i=0;i<lines.size();i++)
			{
				//System.out.print("Linea " + i);
				indexRssi= lines.get(i).indexOf("rssi");
				if(indexRssi!=-1)
				{
					
					String out="Fecha: "+lines.get(i-1).substring(0, 25)+" "+lines.get(i).substring(4, 28)+" "+lines.get(i).substring(indexRssi, indexRssi+8)+"\n";
					//System.out.print(out);					
					writer.write(out);
				}
			}
			
			writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
