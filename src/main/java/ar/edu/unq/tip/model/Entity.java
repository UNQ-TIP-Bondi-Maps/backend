package ar.edu.unq.tip.model;

import java.io.Serializable;

public abstract class Entity implements Serializable {
	
	private static final long serialVersionUID = -3846920640219794671L;
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(final int id) {
		this.id= id;
	}
}