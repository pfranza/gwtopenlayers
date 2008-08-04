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
		return jsToString(object);
	}

	private native String jsToString(JavaScriptObject x) /*-{
		return x.toString();
	}-*/;
	
}
