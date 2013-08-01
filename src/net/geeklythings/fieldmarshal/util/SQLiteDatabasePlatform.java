/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.util;

import org.eclipse.persistence.platform.database.DatabasePlatform;

/**
 *
 * @author khooks
 */
public class SQLiteDatabasePlatform extends DatabasePlatform {
    @Override
    public boolean supportsForeignKeyConstraints() {
        return false;
    }
}
