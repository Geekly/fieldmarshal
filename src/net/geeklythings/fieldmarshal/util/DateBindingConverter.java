/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.util;

import org.jdesktop.beansbinding.Converter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author khooks
 */
public class DateBindingConverter extends Converter{

    //@Override
    public String convertForward(DateTime date) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM e, yyyy");
        String formattedDate = formatter.print(date);
        return formattedDate;
    }

    //@Override
    public DateTime convertReverse(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object convertForward(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object convertReverse(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
