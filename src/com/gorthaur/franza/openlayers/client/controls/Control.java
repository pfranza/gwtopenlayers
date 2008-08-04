package com.gorthaur.franza.openlayers.client.controls;

import com.google.gwt.core.client.JavaScriptObject;

public class Control {

	private JavaScriptObject obj;
	
	public Control(JavaScriptObject o) {
		this.obj = o;
	}
	
	public JavaScriptObject getJsObject() {
		return obj;
	}
	
}
