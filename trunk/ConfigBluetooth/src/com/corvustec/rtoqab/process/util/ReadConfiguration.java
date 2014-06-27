package com.corvustec.rtoqab.process.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadConfiguration {

	private final static Logger logger = LoggerFactory.getLogger(ReadConfiguration.class);
	
	private String pathConfiguration;
	
	private List<String> linesEncryp,linesDecryp;
	
	
	private static ReadConfiguration instance;
	
	public static ReadConfiguration getInstance() {
		if(instance==null)
			instance=new ReadConfiguration();
		return instance;
	}
	
	public ReadConfiguration() {
		try{
			pathConfiguration=MessagesApplicacion.getString("com.corvustec.rtoqab.configurarion.file.path");
		}
		catch(Exception e){
			logger.info("Error {}",e.toString());	
		}
	}
	
	public String readValue(String key) throws Exception
	{
		String value = null;
		List<String> lines;
		Integer indexBase;
		String[] words;		
		try{
			readFile();
			lines=new ArrayList<String>();
			lines=linesDecryp;
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
		}
		catch(Exception e){
			logger.info("Error {}",e.toString());
		}
		return value;
	}
	
	public String readLine(String key)
	{
		String value = null;
		List<String> lines;
		Integer indexBase;
		try {
			readFile();
			lines=new ArrayList<String>();
			lines=linesDecryp;			
			
			for(int i=0;i<lines.size();i++)
			{
				indexBase= lines.get(i).indexOf(key);
				if(indexBase!=-1)
				{
					value=lines.get(i);
					value=value.trim();
				}
			}
		}catch (Exception e) {
			logger.info("Error {}",e.toString());
		}
		return value;
	}
	
	public String replaceValue(String key,String val) throws Exception 
	{
		new ReadConfiguration();
		String value = null;
		List<String> lines;
		Integer indexBase,indexLine = null;
		String line;
		File file;
		try{
			readFile();
			file=new File(pathConfiguration);
			lines=linesEncryp;
			for(int i=0;i<linesDecryp.size();i++)
			{
				indexBase= linesDecryp.get(i).indexOf(key);
				if(indexBase!=-1)
					indexLine=i;
			}
			if(indexLine!=null)
			{
				line=key+" = "+val;				
				lines.set(indexLine, Cryptography.getInstance().encrypt(line));
			}
			FileUtils.writeLines(file, lines);
		}
		catch(Exception e){
			logger.info("Error {}",e.toString());
		}
		return value;
	}
	
	private void readFile()
	{
		File file;
		try{
			file=new File(pathConfiguration);
			linesEncryp = FileUtils.readLines(file);
			
			for(int i=0;i<linesEncryp.size();i++)
				linesDecryp.add(Cryptography.getInstance().decrypt(linesEncryp.get(i)));
		}
		catch(Exception e){
			logger.info("Error {}",e.toString());
		}
	}
}
