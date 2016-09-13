package ar.edu.unq.tip.tip_bondi_maps_backend;

public class Bus {

	private int internal;
	private String directionOfTravel;
	private Position position;
	
	public void updatePosition(Position newPosition){
		this.setPosition(newPosition);
	}
	
	public void changeDirectionOfTravel(String newDirection){
		this.setDirectionOfTravel(newDirection);
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
}
