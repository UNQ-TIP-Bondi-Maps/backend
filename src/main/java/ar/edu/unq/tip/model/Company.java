package ar.edu.unq.tip.model;

import java.util.List;
import java.util.stream.Collectors;

public class Company extends Entity {

	private static final long serialVersionUID = 6112286552950376023L;
	private String name;
	private String imageUrl;
	private List<BusLine> busLines;
	
	public Company() { }
	
	public Company(String name, String imageUrl) { 
		this.name = name;
		this.imageUrl = imageUrl;
	}
	
	public void addBusLine(BusLine aBusLine){
		this.getBusLines().add(aBusLine);
	}
	
	public void removeBusLine(BusLine aBusLine){
		setBusLines(getBusLines().stream().filter(b -> b.getLine() == aBusLine.getLine()).collect(Collectors.toList()));
	}
	
	public BusLine getBusLineByLine(int lineNumber){
		List<BusLine> busLine = this.getBusLines().stream().filter(l -> l.getLine() == lineNumber).collect(Collectors.toList()); 
		return busLine==null?null:busLine.get(0);
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

	public List<BusLine> getBusLines() {
		return busLines;
	}

	public void setBusLines(List<BusLine> busLines) {
		this.busLines = busLines;
	}
}
