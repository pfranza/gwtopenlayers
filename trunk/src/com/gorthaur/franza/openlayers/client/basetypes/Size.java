package com.gorthaur.franza.openlayers.client.basetypes;

public class Size {

	private double width;
	private double height;
	
	public final double getWidth() {
		return width;
	}

	public final void setWidth(double width) {
		this.width = width;
	}

	public final double getHeight() {
		return height;
	}

	public final void setHeight(double height) {
		this.height = height;
	}

	public Size(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
}
