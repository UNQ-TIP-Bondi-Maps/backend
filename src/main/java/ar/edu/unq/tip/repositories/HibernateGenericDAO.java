package ar.edu.unq.tip.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class HibernateGenericDAO<T> extends HibernateDaoSupport implements
	GenericRepository<T>, Serializable {
	
	private static final long serialVersionUID = 5725321270476860858L;
	protected Class<T> persistentClass = this.getDomainClass();
	
	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
		getHibernateTemplate().flush();
	}
	
	protected abstract Class<T> getDomainClass();
	
	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}
	
	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}
	
	@Override
	public void merge(T entity) {
		getHibernateTemplate().merge(entity);
	}
	
	@Override
	public T findBy(Serializable id) {
		return getHibernateTemplate().get(persistentClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getHibernateTemplate().find("from " + this.persistentClass.getName() + " o");
	}
	
	@Override
	public void deleteById(Serializable id) {
		delete(findBy(id));
	}
	
	@Override
	public int count() {
		return findAll().size();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByExample(T exampleObject) {
		return getHibernateTemplate().findByExample(exampleObject);
	}
}
