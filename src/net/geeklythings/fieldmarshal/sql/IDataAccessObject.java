package net.geeklythings.fieldmarshal.sql;

import java.sql.SQLException;

public interface IDataAccessObject<E> {
		
	public E[] findAll() throws SQLException;
	public E find(String name) throws SQLException;
	public void insert(E x) throws SQLException;
	public void update(E x) throws SQLException;
	public void delete(E x) throws SQLException;
	
}
