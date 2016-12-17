package base;

import java.util.List;

public interface BaseDao<T> {

	void save(T obj) throws Exception;

	void update(T obj) throws Exception;

	void delete(int id) throws Exception;

	List<T> findAll() throws Exception;

	T findById(int id) throws Exception;

}
