package com.gorthaur.franza.openlayers.client.controls;

import com.google.gwt.core.client.JavaScriptObject;
import com.gorthaur.franza.openlayers.client.layers.Layer;

public class OverviewMap extends Control {

	public OverviewMap() {
		super(_newInstance(256, 256));
	}

	private native static JavaScriptObject _newInstance(int width, int height)/*-{     
    	var options = {'size': new $wnd.OpenLayers.Size(width, height)};
    	return new $wnd.OpenLayers.Control.OverviewMap();;
	}-*/; 
	
	private native static void addControl(JavaScriptObject o, JavaScriptObject c) /*-{
		o.ovmap.addControl(c);
	}-*/; 
	
	private native static void addLayer(JavaScriptObject o, JavaScriptObject c) /*-{
		o.ovmap.addLayer(c);
	}-*/; 

	public void addControl(Control c) {
		addControl(getJsObject(), c.getJsObject());
	}
	
	public void addLayer(Layer l) {
		addLayer(getJsObject(), l.getJsObject());
	}
}
