package com.corvustec.rtoqab.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ReadConfiguration {

	
	public static String readValue(String key)
	{
		String pathConfiguration=MessagesApplicacion.getString("com.corvustec.rtoqab.configurarion.file.path");
		String value = null;
		File file=new File(pathConfiguration);
		List<String> lines;
		Integer indexBase;
		String[] words;
		try {
			lines = FileUtils.readLines(file);
			
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
	
}
