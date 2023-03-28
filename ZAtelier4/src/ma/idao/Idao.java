package ma.idao;

import java.util.List;

public interface Idao<T> {
	
	List<T> getAll();
	T getOne(int id);
	boolean save(T obj);
	boolean update(T obj);
	boolean delete(T id);
}
