package com.gorthaur.franza.openlayers.client.basetypes;

import com.google.gwt.core.client.JavaScriptObject;

public class Icon {

	private JavaScriptObject object;
	
	private native JavaScriptObject createIcon(String url, int sx, int sy, int ox, int oy) /*-{
		return new $wnd.OpenLayers.Icon(url, new $wnd.OpenLayers.Size(sx,sy), new $wnd.OpenLayers.Pixel(ox, oy));
	}-*/;
	
	public Icon(String url, Size size, Pixel offset) {
		object = createIcon(url, (int)size.getWidth(), (int)size.getHeight(), offset.getX(), offset.getY());
	}
	
	public JavaScriptObject getIconClone() {
		return getIconClone(object);
	}
	
	private native JavaScriptObject getIconClone(JavaScriptObject o) /*-{
		return o.clone();
	}-*/;
}
