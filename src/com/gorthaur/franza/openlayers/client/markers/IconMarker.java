package com.gorthaur.franza.openlayers.client.markers;

import com.google.gwt.core.client.JavaScriptObject;
import com.gorthaur.franza.openlayers.client.basetypes.Icon;
import com.gorthaur.franza.openlayers.client.basetypes.LonLat;

public class IconMarker extends Marker{

	public IconMarker(Icon icon, LonLat ll) {
		super(_newInstance(icon.getIconClone(), ll.getLongitude(), ll.getLatitude())); 
		_registerListeners(this, getJsObject());
	}

	private native void _registerListeners(IconMarker m, JavaScriptObject marker) /*-{
		marker.events.register("mousedown", null, function clickEvent(evt) {
			m.@com.gorthaur.franza.openlayers.client.markers.IconMarker::fireClickEvent()();
        });
       	marker.events.register("mouseover", null, function overEvent(evt) {
			m.@com.gorthaur.franza.openlayers.client.markers.IconMarker::fireHoverOverEvent()();
        }); 
        marker.events.register("mouseout", null, function overEvent(evt) {
			m.@com.gorthaur.franza.openlayers.client.markers.IconMarker::fireHoverOutEvent()();
        });
	}-*/;

	private native static JavaScriptObject _newInstance(JavaScriptObject icon,
			double lon, double lat) /*-{
		return new $wnd.OpenLayers.Marker(new $wnd.OpenLayers.LonLat(lon,lat),icon);
	}-*/;
	
}
