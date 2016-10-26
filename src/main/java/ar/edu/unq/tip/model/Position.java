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
	
	public double distanceBetween(Position aPosition) {
		double cat1 = this.getLat() - aPosition.getLat();
		double cat2 = this.getLng() - aPosition.getLng();
		return Math.sqrt(cat1*cat1 + cat2*cat2);
	}
	
	public static double distanceInMeters(Position start, Position end) {
		double radiusEarth = 6378137; //Earth radius in meters
		double distanceLat = rad(end.getLat()- start.getLat());
		double distanceLong = rad(end.getLng() - start.getLng());
		double a = Math.sin(distanceLat / 2) * Math.sin(distanceLat / 2) + 
					Math.cos(rad(start.getLat())) * Math.cos(rad(end.getLat())) * 
						Math.sin(distanceLong / 2) * Math.sin(distanceLong / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = radiusEarth * c;
		return Math.round(d);
	}
	
	private static double rad(double x) {
		return x * Math.PI / 180;
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
