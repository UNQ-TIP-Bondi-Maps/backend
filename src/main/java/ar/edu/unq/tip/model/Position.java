package ar.edu.unq.tip.model;

public class Position extends Entity {

	private static final long serialVersionUID = 296870812500050872L;
	private double lat;
	private double lng;

	public Position() { }

	public Position(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
	
	public double getLat() {
		return lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public double getLng() {
		return lng;
	}
	
	public void setLng(double lng) {
		this.lng = lng;
	}	
}
