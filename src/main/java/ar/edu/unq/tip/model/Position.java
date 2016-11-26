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
	
	public  double distanceInMeters(Position aPosition) {
		double radiusEarth = 6378137; //Earth radius in meters
		double distanceLat = rad(aPosition.getLat()- this.getLat());
		double distanceLong = rad(aPosition.getLng() - this.getLng());
		double a = Math.sin(distanceLat / 2) * Math.sin(distanceLat / 2) + 
					Math.cos(rad(this.getLat())) * Math.cos(rad(aPosition.getLat())) * 
						Math.sin(distanceLong / 2) * Math.sin(distanceLong / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = radiusEarth * c;
		System.out.println("distancia: " + Math.round(d));
		return Math.round(d);
	}
	
	public String timeBetweenPositions(Position aPosition){
		return (int)(this.distanceInMeters(aPosition)/250) +" mins";
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
