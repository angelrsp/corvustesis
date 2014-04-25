package com.corvustec.rtoqab.process.main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.corvustec.rtoqab.process.jdbc.ConnectionJDBC;
import com.corvustec.rtoqab.process.util.ReadConfiguration;

public class Process {

	public static void main(String[] args) {
		insertValue();
	}

	
	private static void insertValue()
	{
		
		File fileIn=new File(ReadConfiguration.readValue("com.corvustec.rtoqab.jdbc.path.in")+"hci3.txt");
		
		List<String> lines;
		String line[];

		try{
			System.out.print(new Date());
			lines = FileUtils.readLines(fileIn);
			ConnectionJDBC.init();
			ConnectionJDBC.executeSql("delete from tfi_dato;");
			for(int i=0;i<lines.size();i++)
			{

				line=lines.get(i).split("|");
				
				StringBuilder sb=new StringBuilder();
				sb.append("insert into tfi_dato (dat_agencia, dat_fecha, dat_mac, dat_rssi) ");
				sb.append("values (1,'");
				sb.append(line[0]);
				sb.append("','");
				sb.append(line[1]);
				sb.append("',");
				sb.append(line[2]);
				sb.append(")");
				
				ConnectionJDBC.executeSql(sb.toString());

			}
			ConnectionJDBC.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
