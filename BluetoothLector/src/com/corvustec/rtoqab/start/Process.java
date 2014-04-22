package com.corvustec.rtoqab.start;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.corvustec.rtoqab.jdbc.ConnectionJDBC;
import com.corvustec.rtoqab.util.ReadConfiguration;

public class Process {

	public static void main(String[] args) {
		
		long start, end,diff;
		start = System.currentTimeMillis();
		insertValue();
		processOne();
		outTxt();
		end = System.currentTimeMillis();
		diff=end-start;
		
		diff=(long) (diff* 0.001);
		
		System.out.println("the task has taken "+ ( diff ) +" seconds");		
	}

	
	private static void insertValue()
	{
		
		File fileIn=new File(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.path.in")+"hci321-4.txt");
		
		List<String> lines;
		
		int indexRssi;
		
		
		try{
			System.out.print(new Date());
			lines = FileUtils.readLines(fileIn);
			ConnectionJDBC.init();	
			ConnectionJDBC.executeSql("truncate tfi_dato;");
			
			for(int i=0;i<lines.size();i++)
			{
				//System.out.print("Linea " + i);
				indexRssi= lines.get(i).indexOf("rssi");
				if(indexRssi!=-1)
				{
					StringBuilder sb=new StringBuilder();
					sb.append("insert into tfi_dato (dat_agencia, dat_fecha, dat_mac, dat_rssi) ");
					sb.append("values (1,'");
					sb.append(lines.get(i-1).substring(0, 25));
					sb.append("','");
					sb.append(lines.get(i).substring(11, 28));
					sb.append("',");
					sb.append(lines.get(i).substring(indexRssi+5, indexRssi+8));
					sb.append(") ");
					
					//System.out.println(sb.toString());
					
					ConnectionJDBC.executeSql(sb.toString());
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			//System.out.println(sb.toString());
			
			e.printStackTrace();
		}
		ConnectionJDBC.close();
	}
	
	
	private static void processOne()
	{
		ConnectionJDBC.init();
		try {
			StringBuilder sb=new StringBuilder();
			
			sb.append("insert into tfi_valido(val_agencia,val_fecha,val_mac,val_rssi) ");
			sb.append("select dat_agencia,dat_fecha,dat_mac,dat_rssi ");
			sb.append("from tfi_dato ");
			sb.append("where dat_mac in( ");
			sb.append("select dat_mac ");
			sb.append("from tfi_dato ");
			sb.append("group by dat_mac ");
			sb.append("having max(dat_rssi)<=-65);");
			
			ConnectionJDBC.executeSql(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionJDBC.close();
	}	
	
	
	private static void outTxt()
	{
		
		File fileIn=new File(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.path.in")+"hci321-4.txt");
		File fileOut=new File(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.path.in")+"hci321-4Out.txt");
		
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
