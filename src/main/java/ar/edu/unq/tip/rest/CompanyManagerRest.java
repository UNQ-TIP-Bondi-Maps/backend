package ar.edu.unq.tip.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.unq.tip.model.Bus;
import ar.edu.unq.tip.model.Company;
import ar.edu.unq.tip.model.CompanyManager;
import ar.edu.unq.tip.services.CompanyManagerService;

@Path("/companyManagers")
public class CompanyManagerRest {
	
	private CompanyManagerService companyManagerService;
	
	public CompanyManagerService getCompanyManagerService() {
		return companyManagerService;
	}

	public void setCompanyManagerService(CompanyManagerService companyManagerService) {
		this.companyManagerService = companyManagerService;
		Company company = new Company("moqsa", "unaurl.com");
		company.setBuses(new ArrayList<Bus>());
		CompanyManager companyManager = new CompanyManager("Juan Perez", 43521, "perez@gmail.com", "jp", "1234abc", company);
		this.companyManagerService.save(companyManager);
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	@Consumes("application/json")
	public Response createCompanyManager(CompanyManager companyManager) {
		getCompanyManagerService().save(companyManager);
		return Response.ok(companyManager).build();
	}
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<CompanyManager> getAll() {
		return getCompanyManagerService().retriveAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public CompanyManager getById(@PathParam("id") final Integer id) {
		return getCompanyManagerService().findBy(id);
	}
	
	@POST
	@Path("/{id}/addBus")
	@Produces("application/json")
	@Consumes("application/json")
	public Response addBus(@PathParam("id") final Integer id, Bus bus) {
		CompanyManager companyManager = getCompanyManagerService().findBy(id);
		companyManager.getCompany().addBus(bus);
		getCompanyManagerService().update(companyManager);
		return Response.ok(companyManager).build();
	}
	
	@GET
	@Path("/{id}/buses")
	@Produces("application/json")
	public List<Bus> allBuses(@PathParam("id") final Integer id) {
		return getCompanyManagerService().findBy(id).getCompany().getBuses();
	}
}
