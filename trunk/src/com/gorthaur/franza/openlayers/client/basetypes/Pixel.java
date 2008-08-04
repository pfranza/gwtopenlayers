package com.gorthaur.franza.openlayers.client.basetypes;

public class Pixel {

	private int x, y;

	public Pixel(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public final int getX() {
		return x;
	}

	public final void setX(int x) {
		this.x = x;
	}

	public final int getY() {
		return y;
	}

	public final void setY(int y) {
		this.y = y;
	}
	
	public final void add(Pixel p) {
		x += p.x;
		y += p.y;
	}
	
	public final void offset(Pixel p) {
		x -= p.x;
		y -= p.y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pixel) {
			Pixel o = (Pixel) obj;
			return o.x == x && o.y == y;
		}
		
		return false;
	}
	
}
