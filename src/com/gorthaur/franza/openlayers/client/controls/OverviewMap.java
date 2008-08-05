package com.gorthaur.franza.openlayers.client.controls;

import com.google.gwt.core.client.JavaScriptObject;
import com.gorthaur.franza.openlayers.client.layers.Layer;

public class OverviewMap extends Control {

	public OverviewMap(Layer layer) {
		super(_newInstance(256, 256, layer.getJsObject()));
	}

	private native static JavaScriptObject _newInstance(int width, int height, JavaScriptObject layer)/*-{     
    	var options = {
    		layers: [layer],
    	    projection: "EPSG:26912",
        	units: 'm',
        	maxExtent: new $wnd.OpenLayers.Bounds(455402, 4967657, 473295, 4984095)
    	};
    	return new $wnd.OpenLayers.Control.OverviewMap(options);
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
