package com.gorthaur.franza.openlayers.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public class Yahoo extends Layer {

	public Yahoo(String name) {
		super(_newInstance(name));
	}

	private native static JavaScriptObject _newInstance(String name)/*-{
	  return new $wnd.OpenLayers.Layer.Yahoo(name);
	}-*/; 

}
