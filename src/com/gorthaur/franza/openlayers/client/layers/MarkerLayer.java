package com.gorthaur.franza.openlayers.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.gorthaur.franza.openlayers.client.markers.Marker;

public class MarkerLayer extends Layer {

	private static native JavaScriptObject _construct(String name)   /*-{
		return new $wnd.OpenLayers.Layer.Markers(name);
	}-*/;

	public MarkerLayer(String name) {
		super(_construct(name));
	}
	
	public void setOpacity(double opacity) {
		_setOpacity(getJsObject(), opacity);
	}
	
	private static native void _setOpacity(JavaScriptObject l, double o) /*-{
		l.setOpacity(o);
	}-*/;
	
	public void addMarker(Marker m) {
		_addMarker(getJsObject(), m.getJsObject());
	}
	
	private static native void _addMarker(JavaScriptObject l, JavaScriptObject o) /*-{
		l.addMarker(o);
	}-*/;
	
	public void removeMarker(Marker m) {
		_removeMarker(getJsObject(), m.getJsObject());
	}
	
	private static native void _removeMarker(JavaScriptObject l, JavaScriptObject o) /*-{
		l.removeMarker(o);
	}-*/;
}
