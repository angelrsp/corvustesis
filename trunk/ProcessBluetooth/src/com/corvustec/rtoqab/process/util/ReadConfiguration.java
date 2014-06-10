package com.corvustec.rtoqab.process.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ReadConfiguration {

	private static ReadConfiguration instance;
	
	private List<String> linesEncryp,linesDecrypt;
	private String pathConfiguration=MessagesApplicacion.getString("com.corvustec.rtoqab.configurarion.file.path");
	
	
	public static ReadConfiguration getInstance() {
		if(instance==null)
			instance=new ReadConfiguration();
		return instance;
	}

	public ReadConfiguration() {
		File file;
		try {
			file=new File(pathConfiguration);
			linesEncryp=FileUtils.readLines(file);
			linesDecrypt=new ArrayList<String>();
			for(int i=0;i<linesEncryp.size();i++)
			{
				linesDecrypt.add(Cryptography.getInstance().decrypt(linesEncryp.get(i)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readValue(String key)
	{
		String value = null;
		List<String> lines;
		Integer indexBase;
		String[] words;
		try {
			lines=linesDecrypt;
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
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return value;
	}
	
	
}
