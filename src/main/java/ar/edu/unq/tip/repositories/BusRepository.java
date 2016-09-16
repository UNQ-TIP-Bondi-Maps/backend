package ar.edu.unq.tip.repositories;

import ar.edu.unq.tip.model.Bus;

public class BusRepository extends HibernateGenericDAO<Bus> 
	implements GenericRepository<Bus> {

	private static final long serialVersionUID = -8539277508681476555L;

	@Override
	protected Class<Bus> getDomainClass() {
		return Bus.class;
	}

}
