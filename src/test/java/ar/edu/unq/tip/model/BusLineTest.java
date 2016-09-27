package ar.edu.unq.tip.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BusLineTest {
	
	private BusLine busLine;
	private Bus bus1;
	private Bus bus2;
	private List<Bus> buses;
	
	@Before
	public void init(){
		bus1 = Mockito.mock(Bus.class);
		Mockito.when(bus1.getInternal()).thenReturn(1);
		bus2 = Mockito.mock(Bus.class);
		Mockito.when(bus2.getInternal()).thenReturn(2);
		busLine = new BusLine();
		buses = new ArrayList<Bus>();
		busLine.setBuses(buses);
		busLine.addBus(bus1);
	}

	@Test
	public void testAddBus(){
		busLine.addBus(bus1);
		
		assertTrue(busLine.getBuses().contains(bus1));
	}
	
	@Test
	public void testRemoveBus(){
		busLine.addBus(bus2);
		busLine.removeBus(bus1);
		assertTrue(busLine.getBuses().size() == 1);
	}
	
}
