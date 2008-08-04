package com.gorthaur.franza.openlayers.client.basetypes;

import com.google.gwt.core.client.JavaScriptObject;

public class Bounds {

	private JavaScriptObject object = createBounds();
	
	private native JavaScriptObject createBounds() /*-{
		return new $wnd.OpenLayers.Bounds();
	}-*/;
	
	
	public void extend(LonLat point) {
		extendLonLat(object, point.getLongitude(), point.getLatitude());
	}
	
	private native void extendLonLat(JavaScriptObject x, double lon, double lat) /*-{
		x.extend(new $wnd.OpenLayers.LonLat(lon, lat));
	}-*/;

	@Override
	public String toString() {
		return _toString(object);
	}

	private native String _toString(JavaScriptObject x) /*-{
		return x.toString();
	}-*/;
	
	public double getWidth() {
		return _getWidth(object);
	}

	private native double _getWidth(JavaScriptObject x)/*-{
		return x.getWidth();
	}-*/;
	
	public double getHeight() {
		return _getHeight(object);
	}

	private native double _getHeight(JavaScriptObject x)/*-{
		return x.getHeight();
	}-*/;
	
}
