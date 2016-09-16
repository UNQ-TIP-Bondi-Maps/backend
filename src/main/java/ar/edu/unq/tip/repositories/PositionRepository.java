package ar.edu.unq.tip.repositories;

import ar.edu.unq.tip.model.Position;

public class PositionRepository extends HibernateGenericDAO<Position> 
	implements GenericRepository<Position> {

	private static final long serialVersionUID = 5408429112494868866L;

	@Override
	protected Class<Position> getDomainClass() {
		return Position.class;
	}

}
