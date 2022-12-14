package dao;

import java.sql.SQLException;
import java.util.List;

public interface Idao<T> {
	
	T get(int id) throws SQLException;
	List<T> getAll() throws SQLException;
	int add (T t) throws SQLException;
	int update (T t) throws SQLException;
	int delete (int id) throws SQLException;	

}
