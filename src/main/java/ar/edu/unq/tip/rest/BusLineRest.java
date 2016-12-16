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
import javax.ws.rs.core.Response.Status;

import ar.edu.unq.tip.model.Bus;
import ar.edu.unq.tip.model.BusLine;
import ar.edu.unq.tip.model.Position;
import ar.edu.unq.tip.services.BusLineService;

@Path("/busLines")
public class BusLineRest {
	
	private BusLineService busLineService;
	
	public BusLineService getBusLineService() {
		return busLineService;
	}
	
	public void setBusLineService(BusLineService busLineService) {
		this.busLineService = busLineService;
		BusLine busLine1 = new BusLine(10, "aUrl");
		busLine1.setBuses(new ArrayList<Bus>());
		String routeEncode1 = "z|gsEj~qbJeAm@mBaEwBuEyB_FsDiIwDwIoH_QaFaL}F{MkBaEiAyCm@iAIQaD`DgHpHaGrGeIhIcHhHmBjBkB|A_GhFcFhEc@ZaBuDKMIEG@eDjCGM_@c@YYiEwDmAoAcGyFi@c@eAcAwBuBoDmDcC{B[UoBkBeI_IaGaG_H}GeKsJmCbC{GdG{EpEcCrB_ChBoBdB_D|BmErDuLtJQe@KUmGrF{DbDkAlA_BnBsBzBqA|@kFrDkFvDuAkEsAaEyAiD_BgE_BqD}AyD{CjBeErCwBrA}CxBcDpBwCvByCnB{HhF"; 
		Bus bus1 = new Bus(1, "10 a Recoleta", new Position(-34.779671, -58.262805), routeEncode1, routeEncode1);
		busLine1.addBus(bus1);
		this.busLineService.save(busLine1);
		
		BusLine busLine2 = new BusLine(159, "aUrl");
		busLine2.setBuses(new ArrayList<Bus>());
		String routeEncode2 = "htyrEzhubJnSsi@kVyJrEmPjc@ccA?sH"; 
		Bus bus2 = new Bus(2, "159 a Correo Central", new Position(-34.770671, -58.261805), routeEncode2, routeEncode2);
		String routeEncode3 = "htyrEzhubJnSsi@kVyJrEmPjc@ccA?sH"; 
		Bus bus3 = new Bus(3, "159 a Correo Central", new Position(-34.779250, -58.262101), routeEncode3, routeEncode3);
		busLine2.addBus(bus2);
		busLine2.addBus(bus3);
		this.busLineService.save(busLine2);
		
		BusLine busLine3 = new BusLine(98, "aUrl");
		busLine3.setBuses(new ArrayList<Bus>());
		String routeEncode4 = "xwyrEzbubJ|Q`Nea@hmAeNxs@{LcHcBv_@kRfCqKbKlGjJ}n@z}@"; 
		Bus bus4 = new Bus(4, "98 a Plaza Once", new Position(-34.777771, -58.263524), routeEncode4, routeEncode4);
		busLine3.addBus(bus4);
		this.busLineService.save(busLine3);
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
	
	@GET
	@Path("/lines/{lines}/buses")
	@Produces("application/json")
	public List<Bus> allBusListLines(@PathParam("lines") String lines) {
		//TODO Use QueryParam
		String[] arrayBusLines = lines.split("&");
		List<Bus> buses = new ArrayList<Bus>();
	    for(int i = 0; i < arrayBusLines.length; i++){	
            buses.addAll(getBusLineService().findBy(Integer.valueOf(arrayBusLines[i])).getBuses());
	    }
	    return buses;
	}	
	
	@GET
	@Path("/closest/{lines}/lat/{lat}/lng/{lng}")
	@Produces("application/json")
	public List<Bus> closestBuses(@PathParam("lines") String lines, @PathParam("lat") double lat, @PathParam("lng") double lng) {
		String[] arrayBusLines = lines.split("&");
		Position myPosition = new Position(lat, lng);
		List<Bus> buses = new ArrayList<Bus>();
	    for(int i = 0; i < arrayBusLines.length; i++){	
	    	Bus busToAdd = getBusLineService().findBy(Integer.valueOf(arrayBusLines[i])).getClosestBus(myPosition); 
            busToAdd.setTimeToDestinyGoogle(busToAdd.getTimeToDestiny(myPosition));
	    	buses.add(busToAdd);
	    }
	    return buses;
	}	
	
	@DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public void deleteBusLine(@PathParam("id") final Integer id) {
        getBusLineService().delete(getBusLineService().findBy(id));
    }
	
	@PUT
    @Path("/update")
	@Produces("application/json")
    @Consumes("application/json")
    public Response updateBusLine(BusLine busLine) {
		try {
			getBusLineService().update(busLine);
		} catch (Exception e) {
			return Response.serverError().status(Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
        
    }
}
