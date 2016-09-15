package ar.edu.unq.tip.repositories;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T> {
	
	void save(T entity);
	
	void delete(T entity);
	
	void update(T entity);

	void merge(T entity);
	
	T findBy(Serializable id);
	
	List<T> findAll();
	
	void deleteById(Serializable id);
	
	int count();
	
	List<T> findByExample(T exampleObject); 
}
