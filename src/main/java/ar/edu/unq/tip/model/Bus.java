package ar.edu.unq.tip.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class Bus extends Entity {

	private static final long serialVersionUID = -2456253918188565568L;
	private int internal;
	private String directionOfTravel;
	private Position position;
	private String routeWay;
	private String routeBack;
	private String timeToDestinyGoogle;
	private List<Position> busStopsWay;
	private List<Position> busStopsBack;
	
	public Bus() { }
	
	public Bus(int internal, String directionOfTravel, Position position, String routeWay, String routeBack, ArrayList<Position> busStopsWay, ArrayList<Position> busStopsBack) {
		this.internal = internal;
		this.directionOfTravel = directionOfTravel;
		this.position = position;
		this.routeWay = routeWay;
		this.routeBack = routeBack;
		this.timeToDestinyGoogle = "";
		this.busStopsWay = busStopsWay;
		this.busStopsBack = busStopsBack;
	}
	
	public void updatePosition(Position newPosition){
		this.setPosition(newPosition);
	}
	
	public void changeDirectionOfTravel(String newDirection){
		this.setDirectionOfTravel(newDirection);
	}
	
	public String getTimeToDestiny(Position aDestination){	
		String time = "";
		String origin = this.getPosition().getLat() + "," +this.getPosition().getLng();
	    String destination = aDestination.getLat() + "," + aDestination.getLng();
	    JSONObject data = null;
		try {
			data = this.getBusDataFromGoogle(origin, destination);
			if(data != null){
				JSONArray routes = data.getJSONArray("routes");
				JSONArray legs = routes.getJSONObject(0).getJSONArray("legs");
				JSONArray steps = legs.getJSONObject(0).getJSONArray("steps");
				int tam = steps.length();
				for(int i = 0; i<tam; i++){	
					JSONObject step = steps.getJSONObject(i);
					String travelMode = step.getString("travel_mode");
					System.out.println(travelMode);
					if(travelMode.equals("TRANSIT")){
						JSONObject duration = step.getJSONObject("duration");
						time = duration.getString("text");
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(time.equals("")){
			time = this.getPosition().timeBetweenPositions(aDestination);
		}
		return time;
	}
	
	public  JSONObject getBusDataFromGoogle(String aOrigin, String aDestination) throws Exception{
		
        JSONObject responseObject = null;
        
		try {
				URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + aOrigin 
						+ "&destination=" + aDestination + 
						"&mode=transit&transit_mode=bus&key=AIzaSyBguaY_FCTfT645X3m4PowN-PsxtSWcKu4");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
	
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
	
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));
	
				String output;
				StringBuffer response = new StringBuffer();
				while ((output = br.readLine()) != null) {
					response.append(output);
				}
	
				conn.disconnect();
				
	            responseObject = new JSONObject(response.toString());
	           
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
		return responseObject;
	}

	public int getInternal() {
		return internal;
	}
	
	public void setInternal(int internal) {
		this.internal = internal;
	}
	
	public String getDirectionOfTravel() {
		return directionOfTravel;
	}
	
	public void setDirectionOfTravel(String directionOfTravel) {
		this.directionOfTravel = directionOfTravel;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public String getRouteWay() {
		return routeWay;
	}

	public void setRouteWay(String routeWay) {
		this.routeWay = routeWay;
	}

	public String getRouteBack() {
		return routeBack;
	}

	public void setRouteBack(String routeBack) {
		this.routeBack = routeBack;
	}

	public String getTimeToDestinyGoogle() {
		return timeToDestinyGoogle;
	}

	public void setTimeToDestinyGoogle(String timeToDestinyGoogle) {
		this.timeToDestinyGoogle = timeToDestinyGoogle;
	}

	public List<Position> getBusStopsBack() {
		return busStopsBack;
	}

	public void setBusStopsBack(List<Position> busStopsBack) {
		this.busStopsBack = busStopsBack;
	}

	public List<Position> getBusStopsWay() {
		return busStopsWay;
	}

	public void setBusStopsWay(List<Position> busStopsWay) {
		this.busStopsWay = busStopsWay;
	}
}
