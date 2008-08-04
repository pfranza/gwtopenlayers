package com.gorthaur.franza.openlayers.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class Layer {
	
	private JavaScriptObject obj;
	
	public Layer(JavaScriptObject o) {
		this.obj = o;
	}
	
	public JavaScriptObject getJsObject() {
		return obj;
	}
}
