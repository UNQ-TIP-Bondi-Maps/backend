package ar.edu.unq.tip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ar.edu.unq.tip.model.Position;
import ar.edu.unq.tip.services.PositionService;

@Path("/positions")
public class PositionRest {
	
	private PositionService positionService;
	
	public PositionService getPositionService() {
		return positionService;
	}

	public void setPostionService(PositionService positionService) {
		this.positionService = positionService;
		Position position = new Position(1, 1);
		this.positionService.save(position);
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	@Consumes("application/json")
	public Response createPosition(Position position) {
		getPositionService().save(position);
		return Response.ok(position).build();
	}
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Position> getAll() {
		return getPositionService().retriveAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Position getById(@PathParam("id") final Integer id) {
		return getPositionService().findBy(id);
	}
}
