package com.gorthaur.franza.openlayers.client.basetypes;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class BoundsTest extends GWTTestCase {


	public String getModuleName() {
		return "com.gorthaur.franza.openlayers.OpenLayers";
	}

	public void testLatLonExtends() throws Exception {
		Bounds b = new Bounds();
		b.extend(new LonLat(5, 4));
		assertEquals("left-bottom=(4,5) right-top=(4,5)", b.toString());
		b.extend(new LonLat(7, 6));
		assertEquals(2.0, b.getWidth());
		assertEquals(2.0, b.getHeight());
	}

}
