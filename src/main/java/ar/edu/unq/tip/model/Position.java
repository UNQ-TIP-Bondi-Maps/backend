package ar.edu.unq.tip.model;

public class Position extends Entity {

	private static final long serialVersionUID = 296870812500050872L;
	private float lat;
	private float lng;

	public Position() { }

	public Position(float lat, float lng) {
		this.lat = lat;
		this.lng = lng;
	}
	
	public float getLat() {
		return lat;
	}
	
	public void setLat(float lat) {
		this.lat = lat;
	}
	
	public float getLng() {
		return lng;
	}
	
	public void setLng(float lng) {
		this.lng = lng;
	}	
}
