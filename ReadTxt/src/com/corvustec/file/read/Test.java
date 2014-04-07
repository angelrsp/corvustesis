package com.corvustec.file.read;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file=new File("/home/corvustec/Escritorio/hci1.txt");
		
		List<String> lines;
		try {
			lines = FileUtils.readLines(file);
			for(int i=0;i<lines.size();i++)
			{
				if(lines.get(i).indexOf("rssi")!=-1)
				{
					System.out.println("Fecha: "+lines.get(i-1).substring(0, 25)+" "+lines.get(i).substring(4, 28)+" "+lines.get(i).substring(68, 76));
					//System.out.println(lines.get(i-1).substring(0, 25));
					//System.out.println(lines.get(i));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
