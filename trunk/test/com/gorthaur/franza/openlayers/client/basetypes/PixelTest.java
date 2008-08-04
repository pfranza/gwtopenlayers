package com.gorthaur.franza.openlayers.client.basetypes;

import com.gorthaur.franza.openlayers.client.BaseTest;

public class PixelTest extends BaseTest {

	public void testPixel() {
		assertNotNull(new Pixel(0, 0));
	}

	public void testSetX() {
		Pixel p = new Pixel(0, 0);
			p.setX(20);
		assertEquals(20, p.getX());
	}

	public void testSetY() {
		Pixel p = new Pixel(0, 0);
			p.setY(20);
		assertEquals(20, p.getY());
	}

	public void testAdd() {
		Pixel p = new Pixel(5, 5);
			p.add(new Pixel(10, 10));
			
		assertEquals(new Pixel(15, 15), p);
	}

	public void testOffset() {
		Pixel p = new Pixel(15, 15);
			p.offset(new Pixel(10, 10));
			
		assertEquals(new Pixel(5, 5), p);
	}

}
