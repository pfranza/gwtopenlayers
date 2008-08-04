package com.gorthaur.franza.openlayers.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.gorthaur.franza.openlayers.client.layers.Layer;

public class Map {

	private JavaScriptObject map;

	public Map(Element mapDomElement, boolean speherical) {
		this.map = _newInstance(mapDomElement, 20, speherical);
	}
	
	private static native JavaScriptObject _newInstance(Element mapDomElement, int totalNumZoomLevels, boolean isSphericalMercator) /*-{
    // projection, displayProjection, units, maxRes and maxExtent allow
    // layers like Google, Yahoo, Virtual Earth, etc. to be projected correctly
    var mapOptions;
    if(isSphericalMercator) {
        mapOptions = {
            numZoomLevels: totalNumZoomLevels,
            controls: [],
            projection: new $wnd.OpenLayers.Projection("EPSG:900913"),
            displayProjection: new $wnd.OpenLayers.Projection("EPSG:4326"),
            units: "m",
            maxResolution: 156543.0339,
            maxExtent: new $wnd.OpenLayers.Bounds(-20037508.34, -20037508.34, 20037508.34, 20037508.34)
        };
    } else {
        mapOptions = {
            numZoomLevels: totalNumZoomLevels,
            controls: []
        };
    }

    return new $wnd.OpenLayers.Map(mapDomElement, mapOptions);
	}-*/;

	private static native void _addControl(JavaScriptObject map, JavaScriptObject control) /*-{
    map.addControl(control);
	}-*/;

	private static native void _addLayer(JavaScriptObject map, JavaScriptObject layer) /*-{
    map.addLayer(layer);
	}-*/;

	private static native void _removeLayer(JavaScriptObject map, JavaScriptObject layer) /*-{
    map.removeLayer(layer);
	}-*/;

	private static native void _setLayerIndex(JavaScriptObject map, JavaScriptObject layer, int index) /*-{
    map.setLayerIndex(layer, index);
	}-*/;

	private static native void _panTo(JavaScriptObject map, JavaScriptObject lonLat) /*-{
    map.panTo(lonLat);
	}-*/;

	private static native void _updateSize(JavaScriptObject map) /*-{
    map.updateSize();
	}-*/;

	private static native void _zoomTo(JavaScriptObject map, int zoomLevel) /*-{
    map.zoomTo(zoomLevel);
	}-*/;

	private static native int _getNumZoomLevels(JavaScriptObject map) /*-{
    return map.getNumZoomLevels();
	}-*/;

	private static native int _getZoom(JavaScriptObject map) /*-{
    return map.getZoom();
	}-*/;

	public void redraw() {
		 _updateSize(this.map);

	}

	public void addLayer(Layer l) {
		_addLayer(map, l.getJsObject());
	}
	
    public void removeLayer(Layer layer) {
        _removeLayer(this.map, layer.getJsObject());
    }
    
    public void setLayerIndex(Layer layer, int index) {
        _setLayerIndex(this.map, layer.getJsObject(), index);
    }

    public void setZoomLevel(int zoomLevel) {
        zoomLevel = (zoomLevel >= this.getNumZoomLevels()) ? this.getNumZoomLevels()-1 : zoomLevel;
        _zoomTo(this.map, zoomLevel);
    }
    
    public int getNumZoomLevels() {
        return _getNumZoomLevels(this.map);
    }

    public int getZoomLevel() {
        return _getZoom(this.map);
    }
    
//    public boolean isSphericalMercator() {
//        return this.isSphericalMercator;
//    }


	
}
