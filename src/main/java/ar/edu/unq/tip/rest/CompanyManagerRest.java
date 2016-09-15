package ar.edu.unq.tip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
		CompanyManager companyManager = new CompanyManager("as", 43521, "a@gmail.com", "vv", "1234abc", null);
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
}
