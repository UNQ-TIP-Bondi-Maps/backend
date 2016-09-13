package ar.edu.unq.tip.tip_bondi_maps_backend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BusTest {
	
	private Bus bus;
	private Position newPos;
	String newDir;
	
	@Before
	public void init(){
		bus = new Bus();
		newPos = Mockito.mock(Position.class);
		newDir = "Once - Quilmes";
	}

	@Test
	public void testUpdatePosition(){
		bus.updatePosition(newPos);
		
		assertEquals(bus.getPosition(),newPos);
	}
	
	@Test
	public void testChangeDirectionOfTravel(){
		bus.changeDirectionOfTravel(newDir);
		
		assertEquals(bus.getDirectionOfTravel(), newDir);
	}
}
