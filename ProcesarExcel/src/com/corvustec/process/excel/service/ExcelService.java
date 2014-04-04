package com.corvustec.process.excel.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.corvustec.process.excel.jdbc.ConnectionJDBC;
import com.corvustec.process.excel.util.MessagesApplicacion;

public class ExcelService {

	
	public static void executeImport(String pathFile) throws SQLException
	{
		if(MessagesApplicacion.getInteger("com.corvustec.connection.database")==1)
		{
			ConnectionJDBC.executeSql("delete from seg_temporal;");
			ConnectionJDBC.executeSql("SET CLIENT_ENCODING TO 'LATIN1'; COPY seg_temporal FROM '"+pathFile+"' WITH DELIMITER ';' CSV HEADER;");
		}
	}
		
	public static void cargarExcel(String pathPlantilla) throws IOException, SQLException
	{
	    FileInputStream file = new FileInputStream(new File(pathPlantilla));
	     
	    //Get the workbook instance for XLS file
	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	    
	    //Get first sheet from the workbook
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    ResultSet rs=ConnectionJDBC.executeSelect("select * from seg_temporal where codigo_usuario='SURRESTA';");

	    ResultSetMetaData rsmd = rs.getMetaData();

	    int rownum=1;
        while(rs.next())
        {
        	Row row = sheet.createRow(rownum++);
        	for(int i=0;i<rsmd.getColumnCount();i++)
        	{
        		Cell cell = row.createCell(i);
        		cell.setCellValue(rs.getString(i+1));
        	}
        }
        rs.close();
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File("D:\\SURRESTA.xlsx"));
        workbook.write(out);
        out.close();
	    
	}
	
}
