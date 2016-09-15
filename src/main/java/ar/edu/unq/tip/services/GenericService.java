package ar.edu.unq.tip.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.tip.repositories.GenericRepository;

public class GenericService<T> implements Serializable {

	private static final long serialVersionUID = 1906386626064088920L;
	private GenericRepository<T> repository;
	
	public GenericRepository<T> getRepository() {
		return repository;
	}
	public void setRepository(GenericRepository<T> repository) {
		this.repository = repository;
	}
	
	@Transactional
	public void delete(final T object) {
		getRepository().delete(object);
	}
	
	@Transactional(readOnly = true)
	public List<T> retriveAll() {
		return getRepository().findAll();
	}
	
	@Transactional
	public void save(final T object) {
		getRepository().save(object);
	}
	
	@Transactional
	public void update(final T object) {
		getRepository().update(object);
	}

	@Transactional
	public void merge(final T object) {
		getRepository().merge(object);
	}
	
	@Transactional(readOnly = true)
	public T findBy(Serializable id) {
		return getRepository().findBy(id);
	}	
}
