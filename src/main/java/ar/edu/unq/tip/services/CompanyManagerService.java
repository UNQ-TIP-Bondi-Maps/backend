package ar.edu.unq.tip.services;

import java.util.List;

import javax.ws.rs.core.Response;

import ar.edu.unq.tip.model.Bus;
import ar.edu.unq.tip.model.CompanyManager;

public class CompanyManagerService extends GenericService<CompanyManager> {

	private static final long serialVersionUID = -6390661270908293143L;

	public Response addBusInCompany(Integer id, Integer idBusLine,Bus bus) {
		CompanyManager companyManager = getRepository().findBy(id);
		companyManager.getCompany().getBusLineByLine(idBusLine).addBus(bus);
		getRepository().save(companyManager);
		return Response.ok(companyManager).build();
	}

	public boolean existsUserName(String userName) {
		List<CompanyManager> companyManagers = getRepository().findAll();
		return companyManagers.stream().anyMatch(cm -> cm.getUserName().equals(userName));
	}
	
}
