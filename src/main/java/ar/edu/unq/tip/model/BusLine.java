package ar.edu.unq.tip.model;

import java.util.List;
import java.util.stream.Collectors;

public class BusLine extends Entity {

	private static final long serialVersionUID = -2966950043119337832L;
	private int line;
	private String imageUrl;
	private List<Bus> buses;
	
	public BusLine() {}
	
	public BusLine(int aLine, String aUrl){
		this.line = aLine;
		this.imageUrl = aUrl;
	}
	
	public void addBus(Bus aBus){
		this.getBuses().add(aBus);
	}
	
	public void removeBus(Bus aBus){
		setBuses(getBuses().stream().filter(b -> b.getInternal() == aBus.getInternal()).collect(Collectors.toList()));
	}
	
	public Bus getClosestBus(Position aPosition){
		Bus busResult = null;
		for(Bus bus : this.getBuses()){
			if(busResult == null){
				busResult = bus;
			}
			else{
				if(busResult.getPosition().distanceInMeters(aPosition)>bus.getPosition().distanceInMeters(aPosition)){
					busResult = bus;
				}
			}
			
		}
		
		return busResult;
	}
	
	public List<Bus> getBuses() {
		return buses;
	}
	
	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
