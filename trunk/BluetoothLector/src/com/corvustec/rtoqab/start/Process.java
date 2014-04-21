package com.corvustec.rtoqab.start;

import java.io.File;
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
		end = System.currentTimeMillis();
		diff=end-start;
		
		diff=(long) (diff* 0.001);
		
		System.out.println("the task has taken "+ ( diff ) +" seconds");		
	}

	
	private static void insertValue()
	{
		
		File fileIn=new File(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.path.in")+"hci3.txt");
		
		List<String> lines;
		
		int indexRssi;
		try{
			System.out.print(new Date());
			lines = FileUtils.readLines(fileIn);
			ConnectionJDBC.init();
			ConnectionJDBC.executeSql("delete from tfi_dato;");
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
					sb.append(")");
					
					ConnectionJDBC.executeSql(sb.toString());
				}
			}
			ConnectionJDBC.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
