package com.corvustec.rtoqab.process.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ReadConfiguration {

	private static ReadConfiguration instance;
	
	public static ReadConfiguration getInstance() {
		if(instance==null)
			instance=new ReadConfiguration();
		return instance;
	}
	
	
	public String readValue(String key)
	{
		String pathConfiguration=MessagesApplicacion.getString("com.corvustec.rtoqab.configurarion.file.path");
		String value = null;
		File file=new File(pathConfiguration);
		List<String> lines;
		Integer indexBase;
		String[] words;
		List<String> linesDecryp;
		try {
			lines=new ArrayList<String>();
			linesDecryp = FileUtils.readLines(file);
			for(int i=0;i<linesDecryp.size();i++)
			{
				try {
					lines.add(Cryptography.getInstance().decrypt(linesDecryp.get(i)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			for(int i=0;i<lines.size();i++)
			{
				indexBase= lines.get(i).indexOf(key);
				if(indexBase!=-1)
				{
					words=lines.get(i).split(key);
					value=words[1].substring(3, words[1].length());
					value=value.trim();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return value;
	}
	
	public String readLine(String key)
	{
		String pathConfiguration=MessagesApplicacion.getString("com.corvustec.rtoqab.configurarion.file.path");
		String value = null;
		File file=new File(pathConfiguration);
		List<String> lines;
		Integer indexBase;
		List<String> linesDecryp;
		try {
			lines=new ArrayList<String>();
			linesDecryp = FileUtils.readLines(file);
			for(int i=0;i<linesDecryp.size();i++)
			{
				try {
					lines.add(Cryptography.getInstance().decrypt(linesDecryp.get(i)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for(int i=0;i<lines.size();i++)
			{
				indexBase= lines.get(i).indexOf(key);
				if(indexBase!=-1)
				{
					//words=lines.get(i).split(key);
					value=lines.get(i);
					value=value.trim();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return value;
	}
	
	public String replaceValue(String key,String val)
	{
		String pathConfiguration=MessagesApplicacion.getString("com.corvustec.rtoqab.configurarion.file.path");
		String value = null;
		File file=new File(pathConfiguration);
		List<String> lines;
		List<String> linesDecryp;
		Integer indexBase,indexLine = null;
		String line;
		try {
			linesDecryp=new ArrayList<String>();
			lines = FileUtils.readLines(file);
			for(int i=0;i<lines.size();i++)
			{
				try {
					linesDecryp.add(Cryptography.getInstance().decrypt(lines.get(i)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for(int i=0;i<linesDecryp.size();i++)
			{
				indexBase= linesDecryp.get(i).indexOf(key);
				if(indexBase!=-1)
				{
					indexLine=i;
				}
			}
			if(indexLine!=null)
			{
				line=key+" = "+val;
				try {
					lines.set(indexLine, Cryptography.getInstance().encrypt(line));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			FileUtils.writeLines(file, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return value;
	}
}
