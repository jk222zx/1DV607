package model;

import java.io.Serializable;

/**
 * This class describes a boat. 
 * 
 * @author secret
 *
 */
public class Boat implements Serializable {
	private static final long serialVersionUID = 1L;
	private String type;
	private double length;
	
	public Boat(String type, double length) {
		this.type = type;
		this.length = length;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public String getType() {
		return type;
	}
	
	public double getLength() {
		return length;
	}
}
