package com.corvustec.rtoqab.process.main;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.corvustec.rtoqab.process.jdbc.ConnectionJDBC;
import com.corvustec.rtoqab.process.util.ReadAgencia;
import com.corvustec.rtoqab.process.util.UtilApplication;

public class Process {

	public static void main(String[] args) {
		
		long start, end,diff;
		start = System.currentTimeMillis();
		
		//insertValue();
		//processOne();
		processTwo();
		//generateIntervalSecond();
		//generateIntervalMinute();		
		
		end = System.currentTimeMillis();
		diff=end-start;
		diff=(long) (diff* 0.001);
		System.out.println("Procesado en: "+ ( diff ) +" segundos");				
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
	
	private static void processTwo()
	{
		ConnectionJDBC.init();
		StringBuilder sb;
		ResultSet rs;
		try {
			sb=new StringBuilder();
			
			sb.append("select * from tfi_intervalo where int_tipo=1");
			
			rs= ConnectionJDBC.executeSelect(sb.toString());
			
			while(rs.next())
			{
				sb=new StringBuilder();
				sb.append("update tfi_valido ");
				sb.append("set val_intervalo_segundo='");
				sb.append(rs.getString("int_hasta"));
				sb.append("'");
				sb.append("where val_fecha::time >'");
				sb.append(rs.getString("int_desde"));
				sb.append("' and val_fecha::time<='");
				sb.append(rs.getString("int_hasta"));
				sb.append("'");

				ConnectionJDBC.executeSql(sb.toString());
			}
			
			rs.close();

			
			
			sb=new StringBuilder();
			
			sb.append("select * from tfi_intervalo where int_tipo=2");
			
			rs= ConnectionJDBC.executeSelect(sb.toString());
			
			while(rs.next())
			{
				sb=new StringBuilder();
				sb.append("update tfi_valido ");
				sb.append("set val_intervalo_minuto='");
				sb.append(rs.getString("int_hasta"));
				sb.append("'");
				sb.append("where val_fecha::time >'");
				sb.append(rs.getString("int_desde"));
				sb.append("' and val_fecha::time<='");
				sb.append(rs.getString("int_hasta"));
				sb.append("'");

				ConnectionJDBC.executeSql(sb.toString());
			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionJDBC.close();

	}
	
	
	public static void generateIntervalSecond()
	{
		ConnectionJDBC.init();
		Time desde,hasta;
		String incremento;
		StringBuilder sb;
		
		try {
			desde=Time.valueOf("08:00:00");
			hasta= Time.valueOf("17:00:00");
			
			while(desde.before(hasta))
			{
				incremento= UtilApplication.addSecond(desde.toString(), 15);
				
				sb=new StringBuilder();
				sb.append("insert into tfi_intervalo(int_agencia,int_tipo,int_desde,int_hasta) ");
				sb.append("values(1,1,'");
				sb.append(desde);
				sb.append("','");
				sb.append(incremento);
				sb.append("')");
				
				desde=Time.valueOf(UtilApplication.addSecond(desde.toString(), 15));
				
				ConnectionJDBC.executeSql(sb.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionJDBC.close();		
	}
	

	
	public static void generateIntervalMinute()
	{
		ConnectionJDBC.init();
		Time desde,hasta;
		String incremento;
		StringBuilder sb;
		
		try {
			desde=Time.valueOf("08:00:00");
			hasta= Time.valueOf("17:00:00");
			
			while(desde.before(hasta))
			{
				incremento= UtilApplication.addMinute(desde.toString(), 15);
				
				sb=new StringBuilder();
				sb.append("insert into tfi_intervalo(int_agencia,int_tipo,int_desde,int_hasta) ");
				sb.append("values(1,2,'");
				sb.append(desde);
				sb.append("','");
				sb.append(incremento);
				sb.append("')");
				
				desde=Time.valueOf(UtilApplication.addMinute(desde.toString(), 15));
				
				ConnectionJDBC.executeSql(sb.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionJDBC.close();		
	}

	
}
