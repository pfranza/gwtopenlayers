package com.gorthaur.franza.openlayers.client.basetypes;

import com.gorthaur.franza.openlayers.client.BaseTest;

public class SizeTest extends BaseTest {

	public void testSetWidth() {
		Size s = new Size(0, 0);
			s.setWidth(14.5);
		assertEquals(14.5, s.getWidth());
	}

	public void testSetHeight() {
		Size s = new Size(0, 0);
			s.setHeight(22.3);
		assertEquals(22.3, s.getHeight());
	}


}
