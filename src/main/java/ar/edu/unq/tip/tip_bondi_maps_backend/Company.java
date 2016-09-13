package ar.edu.unq.tip.tip_bondi_maps_backend;

import java.util.List;

public class Company {

	private String name;
	private String imageUrl;
	private List<Bus> buses;
	
	public void addBus(Bus aBus){
		this.getBuses().add(aBus);
	}
	
	public void removeBus(Bus aBus){
		this.getBuses().remove(aBus);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public List<Bus> getBuses() {
		return buses;
	}
	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

}
