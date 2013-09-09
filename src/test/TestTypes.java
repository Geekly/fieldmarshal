/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import net.geeklythings.fieldmarshal.type.Faction;
import net.geeklythings.fieldmarshal.type.EventFormatType;

/**
 *
 * @author khooks
 */
public class TestTypes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EventFormatType format = EventFormatType.HARDCORE;
        
        System.out.println(format);
        System.out.println(format.getName());
        
        
        for( EventFormatType f: EventFormatType.values() )
        {
            System.out.println(f.getName());
        }
        
        for( String s: EventFormatType.enumsToStringArray())
        {
            System.out.println(s);
        }
        
        System.out.println(EventFormatType.MANGLEDMETAL);
        
    }
}
