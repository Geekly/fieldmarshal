/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.type;

/**
 *
 * @author khooks
 */
public enum FormatType {
	
	SR2013 ("Steam Roller 2013"),
	MANGLEDMETAL ("Mangled Metal"),
	HARDCORE ("Hardcore"),
	IRONGAUNTLET ("Iron Gauntlet"),
        RELEASE ("Release Event");

	 
	private final String name;
	
	private FormatType(String s) {
		name = s;
	}
	
        public String getName()
        {
            return name;    
        }
        
	public static String[] enumsToStringArray() {
		
		String result[] = new String[FormatType.values().length];
	
		int count = 0;
		for ( FormatType each : FormatType.values()) {
			result[count] = each.toString();
			count++;
		}
	
		return result;
	}
}