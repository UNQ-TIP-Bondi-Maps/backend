package ar.edu.unq.tip.rest;

import java.util.ArrayList;
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
import ar.edu.unq.tip.model.BusLine;
import ar.edu.unq.tip.services.BusLineService;

@Path("/busLines")
public class BusLineRest {
	
	private BusLineService busLineService;
	
	public BusLineService getBusLineService() {
		return busLineService;
	}
	
	public void setBusLineService(BusLineService busLineService) {
		this.busLineService = busLineService;
		BusLine busLine = new BusLine(10, "aUrl");
		busLine.setBuses(new ArrayList<Bus>());
		this.busLineService.save(busLine);
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	@Consumes("application/json")
	public Response createBusLine(BusLine busLine) {
		getBusLineService().save(busLine);
		return Response.ok(busLine).build();
	}
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<BusLine> getAll() {
		return getBusLineService().retriveAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public BusLine getById(@PathParam("id") final Integer id) {
		return getBusLineService().findBy(id);
	}
	
	@POST
	@Path("/{id}/addBus")
	@Produces("application/json")
	@Consumes("application/json")
	public Response addBus(@PathParam("id") final Integer id, Bus bus) {
		BusLine busLine = getBusLineService().findBy(id);
		busLine.addBus(bus);
		getBusLineService().update(busLine);
		return Response.ok(busLine).build();
	}
	
	@GET
	@Path("/{id}/buses")
	@Produces("application/json")
	public List<Bus> allBusLines(@PathParam("id") final Integer id) {
		return getBusLineService().findBy(id).getBuses();
	}
	
	@DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public void deleteBusLine(@PathParam("id") final Integer id) {
        getBusLineService().delete(getBusLineService().findBy(id));
    }
	
	@PUT
    @Path("/update")
    @Consumes("application/json")
    public void updateBusLine(BusLine busLine) {
        getBusLineService().update(busLine);
    }
}
