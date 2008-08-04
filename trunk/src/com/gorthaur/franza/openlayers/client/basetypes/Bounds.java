package com.gorthaur.franza.openlayers.client.basetypes;

import com.google.gwt.core.client.JavaScriptObject;
import com.gorthaur.franza.openlayers.client.geometry.Point;

public class Bounds {

	//Wrapped From http://dev.openlayers.org/releases/OpenLayers-2.6/doc/apidocs/files/OpenLayers/BaseTypes/Bounds-js.html
	
	private JavaScriptObject object = createBounds();
	
	private native JavaScriptObject createBounds() /*-{
		return new $wnd.OpenLayers.Bounds();
	}-*/;
	
	public void extend(Point point) {
		_extendPoint(object, point.getX(), point.getY());
	}
	
	private native void _extendPoint(JavaScriptObject o, double x, double y) /*-{
		o.extend(new $wnd.OpenLayers.Geometry.Point(x, y));
	}-*/;
	
	public void extend(LonLat point) {
		_extend(object, point.getLongitude(), point.getLatitude());
	}
	
	public void extend(Bounds bound) {
		_extend(object, bound.object);
	}
	
	private native void _extend(JavaScriptObject x, JavaScriptObject o) /*-{
		x.extend(o);
	}-*/;

	private native void _extend(JavaScriptObject x, double lon, double lat) /*-{
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

	public Size getSize() {
		return new Size(getWidth(), getHeight());
	}

	public Pixel getCenterPixel() {
		return new Pixel(_getCenterXPixel(object), _getCenterYPixel(object));
	}


	private native int _getCenterYPixel(JavaScriptObject x)/*-{
		return x.getCenterPixel().y;
	}-*/;


	private native int _getCenterXPixel(JavaScriptObject x)/*-{
		return x.getCenterPixel().x;
	}-*/;
	
	public LonLat getCenterLatLon() {
		return new LonLat(_getCenterLon(object), _getCenterLat(object));
	}


	private native double _getCenterLon(JavaScriptObject x)/*-{
		return x.getCenterLonLat().lon;
	}-*/;

	private native double _getCenterLat(JavaScriptObject x)/*-{
		return x.getCenterLonLat().lat;
	}-*/;
	
	public boolean contains(LonLat ll, boolean inclusive) {
		return _containsLonLat(object, ll.getLongitude(), ll.getLatitude(), inclusive);
	}

	private native boolean _containsLonLat(JavaScriptObject x, double lon,
			double lat, boolean inc) /*-{
		return x.containsLonLat(new $wnd.OpenLayers.LonLat(lon, lat), inc);
	}-*/;
	
	public boolean contains(Pixel ll, boolean inclusive) {
		return _containsPixel(object, ll.getX(), ll.getY(), inclusive);
	}

	private native boolean _containsPixel(JavaScriptObject o, double x,
			double y, boolean inc) /*-{
		return o.containsPixel(new $wnd.OpenLayers.Pixel(x, y), inc);
	}-*/;
	
	public boolean intersectsBounds(Bounds bounds, boolean inclusive) {
		return _intersectsBounds(object, bounds.object, inclusive);
	}

	private native boolean _intersectsBounds(JavaScriptObject x, JavaScriptObject o,
			boolean inclusive) /*-{
		return x.intersectsBounds(o, inclusive);
	}-*/;
	
	public boolean containsBounds(Bounds bounds, boolean partial, boolean inclusive) {
		return _containsBounds(object, bounds.object, partial, inclusive);
	}

	private native boolean _containsBounds(JavaScriptObject x, JavaScriptObject o,
			boolean partial, boolean inclusive) /*-{
		return x.intersectsBounds(o, partial, inclusive);
	}-*/;
}
