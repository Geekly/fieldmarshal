/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.util;

import java.sql.Date;

/**
 *
 * @author khooks
 */
public class DateUtils {
    static public java.sql.Date todaysSQLDate()
    {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        Date today = new Date(utilDate.getTime());
        return today;
    }
}
