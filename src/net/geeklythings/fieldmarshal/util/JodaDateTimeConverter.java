/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.util;

import java.sql.Date;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;
import org.joda.time.DateTime;

/**
 *
 * @author khooks
 */
public class JodaDateTimeConverter implements Converter {

 private static final long serialVersionUID = 1L;
 
 @Override
 public Object convertDataValueToObjectValue(Object dataValue, Session session) {
  return dataValue == null ? null : new DateTime((Date) dataValue);
 }
 
 @Override
 public Object convertObjectValueToDataValue(Object objectValue, Session session) {
  return objectValue == null ? null : new Date(((DateTime) objectValue).getMillis());
 }
 
 @Override
 public void initialize(DatabaseMapping mapping, Session session) {
 }
 
 @Override
 public boolean isMutable() {
  return false;
 }
    
}
