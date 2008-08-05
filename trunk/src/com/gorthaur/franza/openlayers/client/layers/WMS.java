package com.gorthaur.franza.openlayers.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public class WMS extends Layer {

	public WMS(String name, String url, String options) {
		super(_newInstance(name, url, options));
	}

	private native static JavaScriptObject _newInstance(String name, String url, String options)/*-{
	  return new $wnd.OpenLayers.Layer.WMS(name, url, options);
	}-*/; 
	
}
