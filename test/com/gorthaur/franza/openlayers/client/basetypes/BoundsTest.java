package com.gorthaur.franza.openlayers.client.basetypes;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class BoundsTest extends GWTTestCase {

  /**
   * Must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "com.gorthaur.franza.openlayers.OpenLayers";
  }

  /**
   * Add as many tests as you like.
   */
  public void testSimple() {
    assertTrue(true);
  }
  
	public void testLatLonExtends() throws Exception {
		Bounds b = new Bounds();
		b.extend(new LonLat(5, 4));
		assertEquals("left-bottom=(4,5) right-top=(4,5)", b.toString());
	}

}
