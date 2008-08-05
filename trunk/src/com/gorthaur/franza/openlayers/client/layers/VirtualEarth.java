package com.gorthaur.franza.openlayers.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public class VirtualEarth extends Layer {

	public VirtualEarth(String name) {
		super(_newInstance(name));
	}

	private native static JavaScriptObject _newInstance(String name)/*-{
	  return new $wnd.OpenLayers.Layer.VirtualEarth(name);
	}-*/; 
	
}
