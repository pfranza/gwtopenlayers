package com.gorthaur.franza.openlayers.client.markers;

import com.google.gwt.core.client.JavaScriptObject;
import com.gorthaur.franza.openlayers.client.basetypes.Icon;
import com.gorthaur.franza.openlayers.client.basetypes.LonLat;

public class IconMarker extends Marker{

	public IconMarker(Icon icon, LonLat ll) {
		super(_newInstance(icon.getIconClone(), ll.getLongitude(), ll.getLatitude())); 
	}

	private native static JavaScriptObject _newInstance(JavaScriptObject icon,
			double lon, double lat) /*-{
			$wnd.alert(lon);
		return new $wnd.OpenLayers.Marker(new $wnd.OpenLayers.LonLat(lon,lat),icon)
	}-*/;
	
}
