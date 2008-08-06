package com.gorthaur.franza.openlayers.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.gorthaur.franza.openlayers.client.basetypes.Bounds;
import com.gorthaur.franza.openlayers.client.basetypes.LonLat;
import com.gorthaur.franza.openlayers.client.basetypes.Pixel;
import com.gorthaur.franza.openlayers.client.controls.Control;
import com.gorthaur.franza.openlayers.client.layers.Layer;

public class Map {

	private List<MapClickListener> listeners = new ArrayList<MapClickListener>();
	private List<MapMoveListener> moveListeners = new ArrayList<MapMoveListener>();
	
	private static native void _addControl(JavaScriptObject map, JavaScriptObject control) /*-{
    	map.addControl(control);
	}-*/;

	private static native void _addLayer(JavaScriptObject map, JavaScriptObject layer, boolean isBase) /*-{
    	map.addLayer(layer);
    	if(isBase) {
    	  map.setBaseLayer(layer);
    	}
	}-*/;
	
	private static native int _getNumZoomLevels(JavaScriptObject map) /*-{
    return map.getNumZoomLevels();
	}-*/;

	private static native int _getZoom(JavaScriptObject map) /*-{
    return map.getZoom();
	}-*/;

	private static native JavaScriptObject _newInstance(Map m, Element mapDomElement, int totalNumZoomLevels, boolean isSphericalMercator) /*-{
                
        function mapEvent(e) { 
            m.@com.gorthaur.franza.openlayers.client.Map::fireMoveListeners()();
        }
       
        var map =  new $wnd.OpenLayers.Map(mapDomElement);
        map.events.register("moveend", null, mapEvent);

        return map;
	}-*/;

	private native void _addClickListener(JavaScriptObject map, Map m) /*-{
	 
 	            $wnd.OpenLayers.Control.Click = $wnd.OpenLayers.Class($wnd.OpenLayers.Control, {               
	                defaultHandlerOptions: {
 	                    'single': true,
 	                    'double': false,
 	                    'pixelTolerance': 0,
 	                    'stopSingle': false,
 	                    'stopDouble': false
 	                },
 	
 	                initialize: function(options) {
 	                    this.handlerOptions = $wnd.OpenLayers.Util.extend(
 	                        {}, this.defaultHandlerOptions
 	                    );
 	                    $wnd.OpenLayers.Control.prototype.initialize.apply(
 	                        this, arguments
 	                    );
 	                    this.handler = new $wnd.OpenLayers.Handler.Click(
 	                        this, {
 	                            'click': this.onClick
 	                        }, this.handlerOptions
 	                    );
 	                },
 	
 	                onClick: function(e) {
 	                  m.@com.gorthaur.franza.openlayers.client.Map::fireSingleClick(II)(e.xy.x, e.xy.y);		
 	                }
 	
 	                  
 	
 	            });

    var click = new $wnd.OpenLayers.Control.Click();
    	map.addControl(click);
    click.activate();
   
	}-*/;
	
	private static native void _panTo(JavaScriptObject map, double lon, double lat) /*-{
    	map.panTo(new $wnd.OpenLayers.LonLat(lon, lat));
	}-*/;

	private static native void _removeLayer(JavaScriptObject map, JavaScriptObject layer) /*-{
    map.removeLayer(layer);
	}-*/;

	private static native void _setLayerIndex(JavaScriptObject map, JavaScriptObject layer, int index) /*-{
    map.setLayerIndex(layer, index);
	}-*/;

	private static native void _updateSize(JavaScriptObject map) /*-{
    map.updateSize();
	}-*/;

	private static native void _zoomTo(JavaScriptObject map, int zoomLevel) /*-{
    map.zoomTo(zoomLevel);
	}-*/;
	
	private static native void _setCenter(JavaScriptObject map, double lon, double lat, int zoom, boolean dragging, boolean forceZoomChange) /*-{
    	map.setCenter(new $wnd.OpenLayers.LonLat(lon, lat), zoom, dragging);
	}-*/;

	private JavaScriptObject map;
	private MapWidget parent;

	public Map(Element mapDomElement, MapWidget parent, boolean speherical) {
		this.map = _newInstance(this, mapDomElement, 14, speherical);
		this.parent = parent;
	}

	public void addControl(Control c) {
    	_addControl(map, c.getJsObject());
    }

	public void addLayer(Layer l, boolean isBaseLayer) {
		_addLayer(map, l.getJsObject(), isBaseLayer);
	}
	
    public int getNumZoomLevels() {
        return _getNumZoomLevels(this.map);
    }
    
    public int getZoomLevel() {
        return _getZoom(this.map);
    }

    public void panTo(LonLat ll) {
    	_panTo(map, ll.getLongitude(), ll.getLatitude());
    	fireMoveListeners();
    }
    
    public void redraw() {
		 _updateSize(this.map);

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
        fireMoveListeners();
    }

	public JavaScriptObject getJsObject() {
		return map;
	}
	
	public LonLat getLonLatFromPixel(Pixel p) {
		return new LonLat(_getLonFromPixel(map, p.getX(), p.getY()), _getLatFromPixel(map, p.getX(), p.getY()));
	}

	public void setCenter(LonLat ll, int zoom, boolean dragging, boolean forceZoomChange) {
		_setCenter(map, ll.getLongitude(), ll.getLatitude(), zoom, dragging, forceZoomChange);
		fireMoveListeners();
	}
	
	private native double _getLonFromPixel(JavaScriptObject o, int x, int y) /*-{
    	return o.getLonLatFromPixel(new $wnd.OpenLayers.Pixel(x, y)).lon;
	}-*/;

	private native double _getLatFromPixel(JavaScriptObject o, int x, int y) /*-{
    	return o.getLonLatFromPixel(new $wnd.OpenLayers.Pixel(x, y)).lat;
	}-*/;

	public void addClickListener(MapClickListener mouseListener) {
		if(listeners.isEmpty()) {
			_addClickListener(this.map, this);
		}
		listeners.add(mouseListener);
	
	}
	
	public void addMapListener(MapMoveListener listener) {
		moveListeners.add(listener);
	}
	
	public Bounds getExtent() {
		Bounds b =  new Bounds();
			b.extend(new LonLat(_getLowerLonBound(map), _getLowerLatBound(map)));
			b.extend(new LonLat(_getUpperLonBound(map), _getUpperLatBound(map)));
		return b;
	}
	
	private native double _getLowerLonBound(JavaScriptObject o)  /*-{
    	return o.getExtent().toArray()[0];
	}-*/;
	
	private native double _getUpperLonBound(JavaScriptObject o)  /*-{
		return o.getExtent().toArray()[2];
	}-*/;
	
	private native double _getLowerLatBound(JavaScriptObject o)  /*-{
		return o.getExtent().toArray()[1];
	}-*/;

	private native double _getUpperLatBound(JavaScriptObject o)  /*-{
		return o.getExtent().toArray()[3];
	}-*/;
	
	public void fireSingleClick(int x, int y) {
		double xl = (double)x / (double) parent.getOffsetWidth();
		System.out.println(xl);
		double llat = _getLowerLatBound(map);
		System.out.println(llat);

	}
	
	public void fireMoveListeners() {	
		for(MapMoveListener l: moveListeners) {
			Bounds exts = getExtent();
			l.mapMoved(exts.getCenterLatLon(), getZoomLevel(), exts);
		}
	}
	
	public void zoomToMaxExtent() {
		_zoomToMaxExtent(map);
	}
	
	private static native void _zoomToMaxExtent(JavaScriptObject m)  /*-{
		m.zoomToMaxExtent();
	}-*/;
	
//	public void zoomToExtent(Bounds bounds) {
//		_zoomToExtent(map, bounds.getJsObject());
//	}
//	
//	private static native void _zoomToExtent(JavaScriptObject m)  /*-{
//		m.zoomToMaxExtent();
//	}-*/;

	public interface MapClickListener {		
		void mapClicked(LonLat position);
	}
	
	public interface MapMoveListener {
		void mapMoved(LonLat center, int zoomLevel, Bounds boundingBox);
	}
    
	
}
