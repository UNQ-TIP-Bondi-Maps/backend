package ar.edu.unq.tip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.unq.tip.model.Bus;
import ar.edu.unq.tip.model.Position;
import ar.edu.unq.tip.services.BusService;

@Path("/buses")
public class BusRest {
	
	private BusService busService;
	
	public BusService getBusService() {
		return busService;
	}

	public void setBusService(BusService busService) {
		this.busService = busService;
		Bus bus = new Bus(1, "Once - Wilde", new Position(-34.779671, -58.262805));
		this.busService.save(bus);
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	@Consumes("application/json")
	public Response createBus(Bus bus) {
		getBusService().save(bus);
		return Response.ok(bus).build();
	}
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Bus> getAll() {
		return getBusService().retriveAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Bus getById(@PathParam("id") final Integer id) {
		return getBusService().findBy(id);
	}
	
	@DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public void deleteBus(@PathParam("id") final Integer id) {
        getBusService().delete(getBusService().findBy(id));
    }
	
	@PUT
    @Path("/update")
    @Consumes("application/json")
    public void updateBus(Bus bus) {
        getBusService().update(bus);
    }
}
