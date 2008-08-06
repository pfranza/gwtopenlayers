package com.gorthaur.franza.openlayers.client.markers;

import com.google.gwt.core.client.JavaScriptObject;

public class Marker {

	private JavaScriptObject obj;
	
	public Marker(JavaScriptObject o) {
		this.obj = o;
	}
	
	public JavaScriptObject getJsObject() {
		return obj;
	}
	
}
