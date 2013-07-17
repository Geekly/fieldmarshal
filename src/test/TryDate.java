package test;

import java.sql.Date;
import org.joda.time.*;

import java.io.PrintStream;
import java.lang.System;

public class TryDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintStream out = System.out;
		
		out.println("test");
		
		
		
		DateTime dateTime = new DateTime();
		Date date = new Date(dateTime.getMillis());
		
		out.println(date.toString());
		
		

	}

}
