package ar.edu.unq.tip.model;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Company extends Entity {

	private static final long serialVersionUID = 6112286552950376023L;
	private String name;
	private String imageUrl;
	private List<Bus> buses;
	
	public Company() { }
	
	public Company(String name, String imageUrl) { 
		this.name = name;
		this.imageUrl = imageUrl;
	}
	
	public void addBus(Bus aBus){
		this.getBuses().add(aBus);
	}
	
	public void removeBus(Bus aBus){
		setBuses(getBuses().stream().filter(b -> b.getInternal() == aBus.getInternal()).collect(Collectors.toList()));
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
