package model;

import java.io.Serializable;

/**
 * This class describes a boat. 
 * @author secret
 */
public class Boat implements Serializable {
	private static final long serialVersionUID = 1L;
	private String type;
	private double length;
	
	public Boat(String type, double length) {
		this.type = type;
		this.length = length;
	}
	
	/**
	 * Method to set the attribute type.
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Method to set the attribute length.
	 * @param length
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	/**
	 * Method to get the attribute type.
	 * @return	A string representing the type of the boat.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Method to get the attribute length.
	 * @return	A double representing the length of the boat.
	 */
	public double getLength() {
		return length;
	}
}
