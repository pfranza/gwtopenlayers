package com.gorthaur.franza.openlayers.client.controls;

import com.google.gwt.core.client.JavaScriptObject;

public class OverviewMap extends Control {

	public OverviewMap() {
		super(_newInstance());
		// TODO Auto-generated constructor stub
	}

	private native static JavaScriptObject _newInstance()/*-{
	

        var goog = new $wnd.OpenLayers.Layer.Google("Overview", {type: $wnd.G_NORMAL_MAP, sphericalMercator: true});
    	var options = {'layers': [goog], 'size': new $wnd.OpenLayers.Size(256, 256)};
		var m = new $wnd.OpenLayers.Control.OverviewMap(options);
		//	m.ovmap.addControl(new $wnd.OpenLayers.Control.NavToolbar());
    	return m;
	}-*/; 
	
	private native static void addControl(JavaScriptObject o, JavaScriptObject c) /*-{
		o.ovmap.addControl(c);
	}-*/; 

	public void addControl(Control c) {
		addControl(getJsObject(), c.getJsObject());
	}
}
