/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author khooks
 */
public class EventListenerLogger implements PropertyChangeListener{

    private static final Logger logger = LogManager.getLogger(EventListenerLogger.class); 
    /**
     *
     * @param pce
     */
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        logger.debug("EventListLoggere: propertyChange: {} from class: {}", pce.getPropertyName(), pce.getSource().getClass().getName() );
    }
    
}
