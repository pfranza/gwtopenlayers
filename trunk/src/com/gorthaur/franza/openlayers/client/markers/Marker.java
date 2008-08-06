package com.gorthaur.franza.openlayers.client.markers;

import java.util.ArrayList;

import com.google.gwt.core.client.JavaScriptObject;

public class Marker {

	public interface MarkerClickEventHandler {
		void markerClicked(Marker m);
	}
	
	public interface MarkerHoverEventHandler {
		void markerMouseOver(Marker m);
		void markerMouseOut(Marker m);
	}
	
	private ArrayList<MarkerClickEventHandler> clickHandlers = new ArrayList<MarkerClickEventHandler>();
	private ArrayList<MarkerHoverEventHandler> hoverHandlers = new ArrayList<MarkerHoverEventHandler>();
	
	private JavaScriptObject obj;
	
	public Marker(JavaScriptObject o) {
		this.obj = o;
	}
	
	public JavaScriptObject getJsObject() {
		return obj;
	}
	
	public void add(MarkerClickEventHandler h) {
		clickHandlers.add(h);
	}
	
	public void add(MarkerHoverEventHandler h) {
		hoverHandlers.add(h);
	}
	
	protected void fireClickEvent() {
		for(MarkerClickEventHandler e: clickHandlers) {
			e.markerClicked(this);
		}
	}
	
	protected void fireHoverOverEvent() {
		for(MarkerHoverEventHandler e: hoverHandlers) {
			e.markerMouseOver(this);
		}
	}
	
	protected void fireHoverOutEvent() {
		for(MarkerHoverEventHandler e: hoverHandlers) {
			e.markerMouseOut(this);
		}
	}
}
