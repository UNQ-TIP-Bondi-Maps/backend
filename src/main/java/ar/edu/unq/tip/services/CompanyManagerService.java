package ar.edu.unq.tip.services;

import javax.ws.rs.core.Response;

import ar.edu.unq.tip.model.Bus;
import ar.edu.unq.tip.model.CompanyManager;

public class CompanyManagerService extends GenericService<CompanyManager> {

	private static final long serialVersionUID = -6390661270908293143L;

	public Response addBusInCompany(Integer id, Bus bus) {
		CompanyManager companyManager = getRepository().findBy(id);
		companyManager.getCompany().addBus(bus);
		getRepository().save(companyManager);
		return Response.ok(companyManager).build();
	}
	
}
