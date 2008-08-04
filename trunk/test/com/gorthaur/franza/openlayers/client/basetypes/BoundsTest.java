package com.gorthaur.franza.openlayers.client.basetypes;

import com.google.gwt.junit.client.GWTTestCase;
import com.gorthaur.franza.openlayers.client.geometry.Point;

/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class BoundsTest extends GWTTestCase {


	public String getModuleName() {
		return "com.gorthaur.franza.openlayers.OpenLayers";
	}

	public void testExtendPoint() {
		Bounds b = new Bounds();
			b.extend(new Point(4.0, 7.0));
			b.extend(new Point(6.0, 8.0));
			
		assertEquals(2.0, b.getWidth());
		assertEquals(1.0, b.getHeight());
	}

	public void testExtendLonLat() {
		Bounds b = new Bounds();
			b.extend(new LonLat(4.0, 7.0));
			b.extend(new LonLat(6.0, 8.0));
			
		assertEquals(1.0, b.getWidth());
		assertEquals(2.0, b.getHeight());
	}

	public void testExtendBounds() {

		Bounds b = new Bounds();
			b.extend(new Point(4.0, 7.0));
			
		Bounds c = new Bounds();
			c.extend(new Point(5.0, 9.0));
		
		b.extend(c);
		
		assertEquals(1.0, b.getWidth());
		assertEquals(2.0, b.getHeight());
	}

	public void testToString() {
		Bounds b = new Bounds();
			b.extend(new Point(4.0, 7.0));
		
		assertEquals("left-bottom=(4,7) right-top=(4,7)", b.toString());
	}

	public void testGetWidth() {
		Bounds b = new Bounds();
			b.extend(new Point(4.0, 7.0));
			b.extend(new Point(6.0, 8.0));

		assertEquals(2.0, b.getWidth());
	}

	public void testGetHeight() {
		Bounds b = new Bounds();
			b.extend(new Point(4.0, 7.0));
			b.extend(new Point(6.0, 8.0));

		assertEquals(1.0, b.getHeight());
	}

	public void testGetSize() {
		Bounds b = new Bounds();
			b.extend(new Point(4.0, 7.0));
			b.extend(new Point(6.0, 8.0));
			
		assertEquals(1.0, b.getSize().getHeight());
		assertEquals(2.0, b.getSize().getWidth());
	}

	public void testGetCenterPixel() {
		Bounds b = new Bounds();
			b.extend(new Point(4.0, 7.0));
			b.extend(new Point(6.0, 9.0));
			
		assertEquals(5, b.getCenterPixel().getX());
		assertEquals(8, b.getCenterPixel().getY());
	}

	public void testGetCenterLatLon() {
		Bounds b = new Bounds();
			b.extend(new LonLat(5.0, 7.0));
			b.extend(new LonLat(6.0, 8.0));
			
			assertEquals(5.5, b.getCenterLatLon().getLongitude());
			assertEquals(7.5, b.getCenterLatLon().getLatitude());
	}

	public void testContainsLonLat() {
		Bounds b = new Bounds();
			b.extend(new LonLat(5.0, 7.0));
			b.extend(new LonLat(6.0, 8.0));
			
		assertTrue(b.contains(new LonLat(5.5, 7.5), true));
		assertFalse(b.contains(new LonLat(15.5, 17.5), true));
	}
	
	public void testContainsPixel() throws Exception {
		Bounds b = new Bounds();
			b.extend(new Point(4.0, 7.0));
			b.extend(new Point(6.0, 9.0));
			
		assertTrue(b.contains(b.getCenterPixel(), true));
		assertFalse(b.contains(new Pixel(10, 10), true));
	}

	public void testIntersectBounds() throws Exception {
		Bounds b = new Bounds();
			b.extend(new Point(4.0, 7.0));
			b.extend(new Point(6.0, 9.0));
			
		Bounds c = new Bounds();
			c.extend(new Point(5.0, 8.0));
			
		assertTrue(b.intersectsBounds(c, true));
	}
	
	public void testContainsBounds() throws Exception {
		Bounds b = new Bounds();
			b.extend(new Point(4.0, 7.0));
			b.extend(new Point(6.0, 9.0));
		
		Bounds c = new Bounds();
			c.extend(new Point(5.0, 8.0));
		
		assertTrue(b.containsBounds(c, true, true));
	}
	
	public void testProjection() throws Exception {
		fail("Not Implemented");
	}
	
	public void testWrapDateline() throws Exception {
		fail("Not Implemented");
	}
}
