package com.gorthaur.franza.openlayers.client.controls;

import com.google.gwt.core.client.JavaScriptObject;

public class LayerSwitcher extends Control {

	public LayerSwitcher() {
		super(_newInstance());
	}

	private native static JavaScriptObject _newInstance()/*-{
	  return new $wnd.OpenLayers.Control.LayerSwitcher();
	}-*/;
	
}
