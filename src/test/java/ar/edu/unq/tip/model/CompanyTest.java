package ar.edu.unq.tip.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ar.edu.unq.tip.model.Bus;
import ar.edu.unq.tip.model.Company;

public class CompanyTest {

	private Company company;
	private Bus bus1;
	private Bus bus2;
	private List<Bus> buses;
	
	@Before
	public void init(){
		bus1 = Mockito.mock(Bus.class);
		bus2 = Mockito.mock(Bus.class);
		company = new Company();
		buses = new ArrayList<Bus>();
		company.setBuses(buses);
		company.addBus(bus1);
	}

	@Test
	public void testAddBus(){
		company.addBus(bus1);
		
		assertTrue(company.getBuses().contains(bus1));
	}
	
	@Test
	public void testRemoveBus(){
		company.addBus(bus2);
		company.removeBus(bus1);
		
		assertTrue(company.getBuses().contains(bus2) && !company.getBuses().contains(bus1));
	}
	
}
