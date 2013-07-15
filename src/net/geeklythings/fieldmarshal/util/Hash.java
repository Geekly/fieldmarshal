package net.geeklythings.fieldmarshal.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


public class Hash {

	public static String getStringHash()
	{

		String today = (new Date()).toString();
		
		MessageDigest m;
		
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			
			m.update(today.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			String hashtext = bigInt.toString();
			
			return hashtext;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
	
	public static int getIntHash()
	{

		String today = (new Date()).toString();
		
		MessageDigest m;
		
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			
			m.update(today.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			
			return Math.abs(bigInt.intValue());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
		
	}
	public static void main(String[] args)
	{
		
		String test = Hash.getStringHash();
		return;
	}


}
