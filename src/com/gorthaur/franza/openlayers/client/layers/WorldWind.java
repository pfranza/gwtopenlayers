package com.gorthaur.franza.openlayers.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public class WorldWind implements Layer{

	private final JavaScriptObject obj;

	private native JavaScriptObject _construct(String name, String url, float tileSize, int zoomLevel)   /*-{
		return new $wnd.OpenLayers.Layer.WorldWind(name, url, tileSize, zoomLevel);
	}-*/;
	
	public WorldWind(String name, String url, float tileSize, int zoomLevels) {
		obj = _construct(name, url, tileSize, zoomLevels);
	}
	
	public JavaScriptObject getJsObject() {
		return obj;
	}
}
