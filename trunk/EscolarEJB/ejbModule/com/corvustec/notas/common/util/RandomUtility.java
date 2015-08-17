package com.corvustec.notas.common.util;

import java.util.UUID;

public class RandomUtility {

	private static RandomUtility randomUtility = new RandomUtility();
	
	public static RandomUtility getInstance(){
		if(randomUtility==null)
			randomUtility=new RandomUtility();
		return randomUtility;
	}
	
	
	public String getRandomString()
	{
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
	
	
	public String getRandomString2()
	{
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		java.util.Random random=new java.util.Random();
		for (int i = 0; i < 10; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		return sb.toString();
	}
}
