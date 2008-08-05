package com.gorthaur.franza.openlayers.client.controls;

import com.google.gwt.core.client.JavaScriptObject;

public class NavToolBar extends Control {

	public NavToolBar() {
		super(_newInstance());
	}

	private native static JavaScriptObject _newInstance()/*-{
	  return new $wnd.OpenLayers.Control.NavToolbar();
	}-*/; 

}
