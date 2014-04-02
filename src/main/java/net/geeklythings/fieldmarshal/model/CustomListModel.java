/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author khooks
 */
public class CustomListModel extends AbstractListModel {

    private final ArrayList<String> elements = new ArrayList<>();
    
    public void addElement(String element)
    {
        elements.add(element);
        fireIntervalAdded(this, elements.size()-1, elements.size()-1);
    }
    
    @Override
    public int getSize() {
        return elements.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getElementAt(int i) {
        return elements.get(i);
    }
    
}
