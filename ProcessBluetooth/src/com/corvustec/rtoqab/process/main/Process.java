package com.corvustec.rtoqab.process.main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.corvustec.rtoqab.process.jdbc.ConnectionJDBC;
import com.corvustec.rtoqab.process.util.ReadAgencia;
import com.corvustec.rtoqab.process.util.UtilApplication;

public class Process {

	public static void main(String[] args) {
		//insertValue();
		//processOne();
		generateInterval();
	}

	
	private static void insertValue()
	{
		
		File fileIn=new File(ReadAgencia.readValue("com.corvustec.rtoqab.process.0016")+"20140424.txt");
		
		List<String> lines;
		String line[];
		Integer linea = null;
		try{
			System.out.print(new Date());
			lines = FileUtils.readLines(fileIn);
			ConnectionJDBC.init();
			ConnectionJDBC.executeSql("delete from tfi_dato where dat_agencia=1;");
			for(int i=0;i<lines.size();i++)
			{
				linea=i;
				line=lines.get(i).split("\\|");
			
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
			System.out.println("Error linea: "+linea);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error linea: "+linea);
			e.printStackTrace();
		}
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
	
	private void processTwo()
	{
		
	}
	
	
	private static void generateInterval()
	{
		ConnectionJDBC.init();
		String desde,hasta,incremento;
		StringBuilder sb;
		try {
			desde="08:00:00";
			hasta= "17:00:00";
			
			while(UtilApplication.convertTimetoDate(hasta).before(UtilApplication.convertTimetoDate(desde)))
			{
				incremento=UtilApplication.addSecond(desde, 15);
				
				sb=new StringBuilder();
				sb.append("insert into tfi_intervalo(insert into tfi_intervalo(int_agencia,int_tipo,int_desde,int_hasta) ");
				sb.append("values(1,1,'");
				sb.append(desde);
				sb.append("','");
				sb.append(incremento);
				sb.append("')");
				
				desde=UtilApplication.addSecond(desde, 15);
				
				ConnectionJDBC.executeSql(sb.toString());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionJDBC.close();		
	}
}
