package com.gorthaur.franza.openlayers.client.basetypes;

public class LonLat {

	private double lat;
	private double lon;
	
	public LonLat(double lon, double lat) {
		this.lat = lat;
		this.lon = lon;
	}
	
 	public double getLongitude() {
		return lat;
	}

	public double getLatitude() {
		return lon;
	}

}