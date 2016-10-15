package ar.edu.unq.tip.repositories;

import ar.edu.unq.tip.model.CompanyManager;

public class CompanyManagerRepository extends HibernateGenericDAO<CompanyManager> 
	implements GenericRepository<CompanyManager> {

	private static final long serialVersionUID = -8539277508681476555L;

	@Override
	protected Class<CompanyManager> getDomainClass() {
		return CompanyManager.class;
	}
}