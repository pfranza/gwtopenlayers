package com.gorthaur.franza.openlayers.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public class WorldWind extends Layer{

	private static native JavaScriptObject _construct(String name, String url, float tileSize, int zoomLevel)   /*-{
		return new $wnd.OpenLayers.Layer.WorldWind(name, url, tileSize, zoomLevel);
	}-*/;
	
	public WorldWind(String name, String url, float tileSize, int zoomLevels) {
		super(_construct(name, url, tileSize, zoomLevels));
	}
	
}
