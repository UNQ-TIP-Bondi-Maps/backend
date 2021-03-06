package ar.edu.unq.tip.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ar.edu.unq.tip.exceptions.LoginException;
import ar.edu.unq.tip.model.BusLine;
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
		company.setBusLines(new ArrayList<BusLine>());
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
	@Path("/{id}/addBusLine")
	@Produces("application/json")
	@Consumes("application/json")
	public Response addBusLine(@PathParam("id") final Integer id, BusLine busLine) {
		CompanyManager companyManager = getCompanyManagerService().findBy(id);
		try {
			companyManager.getCompany().addBusLine(busLine);
			getCompanyManagerService().update(companyManager);
		} catch (Exception e) {
			return Response.serverError().status(Status.BAD_REQUEST).build();
		}
		return Response.ok(companyManager).build();
	}
	
	@GET
	@Path("/{id}/busLines")
	@Produces("application/json")
	public List<BusLine> allBusLines(@PathParam("id") final Integer id) {
		return getCompanyManagerService().findBy(id).getCompany().getBusLines();
	}
	
	@GET
	@Path("/existsUserName/{userName}")
	@Produces("application/json")
	public boolean existsUserName(@PathParam("userName") final String userName) {
		return getCompanyManagerService().existsUserName(userName);
	}
	
	@GET
	@Path("/login/{userName}/{password}")
	@Produces("application/json")
	public Response login(@PathParam("userName") final String userName, @PathParam("password") final String password) {
		try {
			return Response.ok(getCompanyManagerService().login(userName, password)).build();
		} catch (LoginException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).type(MediaType.TEXT_PLAIN).build();
		}
	}
}
