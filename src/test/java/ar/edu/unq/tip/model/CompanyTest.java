package ar.edu.unq.tip.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ar.edu.unq.tip.model.Company;

public class CompanyTest {

	private Company company;
	private BusLine busLine1;
	private BusLine busLine2;
	private List<BusLine> busLines;
	
	@Before
	public void init(){
		busLine1 = Mockito.mock(BusLine.class);
		Mockito.when(busLine1.getLine()).thenReturn(1);
		busLine2 = Mockito.mock(BusLine.class);
		Mockito.when(busLine2.getLine()).thenReturn(2);
		company = new Company();
		busLines = new ArrayList<BusLine>();
		company.setBusLines(busLines);
		company.addBusLine(busLine1);
	}

	@Test
	public void testAddBusLine(){
		
		assertTrue(company.getBusLines().contains(busLine1));
	}
	
	@Test
	public void testRemoveBusLine(){
		company.addBusLine(busLine2);;
		company.removeBusLine(busLine1);;
		assertTrue(company.getBusLines().size() == 1);
	}

}
