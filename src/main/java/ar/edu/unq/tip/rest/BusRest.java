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
		String routeEncode = "z|gsEj~qbJeAm@mBaEwBuEyB_FsDiIwDwIoH_QaFaL}F{MkBaEiAyCm@iAIQaD`DgHpHaGrGeIhIcHhHmBjBkB|A_GhFcFhEc@ZaBuDKMIEG@eDjCGM_@c@YYiEwDmAoAcGyFi@c@eAcAwBuBoDmDcC{B[UoBkBeI_IaGaG_H}GeKsJmCbC{GdG{EpEcCrB_ChBoBdB_D|BmErDuLtJQe@KUmGrF{DbDkAlA_BnBsBzBqA|@kFrDkFvDuAkEsAaEyAiD_BgE_BqD}AyD{CjBeErCwBrA}CxBcDpBwCvByCnB{HhF"; 
		Bus bus = new Bus(5, "Once - Wilde", new Position(-34.772671, -58.265805), routeEncode, routeEncode);
		this.busService.save(bus);
		this.busService.delete(bus);
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
	
	@PUT
    @Path("/updateList")
    @Consumes("application/json")
    public void updateListBuses(List<Bus> buses) {
        for(Bus bus : buses){
        	getBusService().update(bus);
        }
    }
}
