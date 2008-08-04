package com.gorthaur.franza.openlayers.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public class Google extends Layer {

	public static enum TYPE {NORMAL, PHYSICAL, HYBRID, SATELLITE};
	
	public Google(TYPE type, String name, boolean isSphericalMercator) {
		super(createLayer(type, name, isSphericalMercator));
	}

	private static JavaScriptObject createLayer(TYPE t, String layerName, boolean isSphericalMercator) {
		switch(t) {
		case SATELLITE: return _createSatelliteLayer(layerName, isSphericalMercator);
		case HYBRID: return _createHybridLayer(layerName, isSphericalMercator);
		case PHYSICAL: return _createPhysicalLayer(layerName, isSphericalMercator);
		}
		return _createNormalLayer(layerName, isSphericalMercator);
		
	}

    private static native JavaScriptObject _createSatelliteLayer(String layerName, boolean isSphericalMercator) /*-{
    return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_SATELLITE_MAP, sphericalMercator: isSphericalMercator});
	}-*/;

    private static native JavaScriptObject _createHybridLayer(String layerName, boolean isSphericalMercator) /*-{
    return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_HYBRID_MAP, sphericalMercator: isSphericalMercator});
	}-*/;

    private static native JavaScriptObject _createNormalLayer(String layerName, boolean isSphericalMercator) /*-{
    return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_NORMAL_MAP, sphericalMercator: isSphericalMercator});
	}-*/;

    private static native JavaScriptObject _createPhysicalLayer(String layerName, boolean isSphericalMercator) /*-{
    return new $wnd.OpenLayers.Layer.Google(layerName, {'type' : $wnd.G_PHYSICAL_MAP, sphericalMercator: isSphericalMercator});
	}-*/;

	
}
