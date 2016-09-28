package ar.edu.unq.tip.repositories;

import ar.edu.unq.tip.model.BusLine;

public class BusLineRepository extends HibernateGenericDAO<BusLine>
	implements GenericRepository<BusLine>{

	private static final long serialVersionUID = -1979144674094224425L;

	@Override
	protected Class<BusLine> getDomainClass() {
		return BusLine.class;
	}

}
