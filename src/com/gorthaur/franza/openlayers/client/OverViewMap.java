package com.gorthaur.franza.openlayers.client;

import com.google.gwt.user.client.DOM;
import com.gorthaur.franza.openlayers.client.Map.MapClickListener;
import com.gorthaur.franza.openlayers.client.basetypes.LonLat;

public class OverViewMap extends MapWidget{



	public OverViewMap(final MapWidget parent) {
		super(false, false);
//		this.parent = parent;
		
		DOM.setStyleAttribute(getElement(), "border-style", "dashed");
		DOM.setStyleAttribute(getElement(), "position", "relative");
		getMap().addClickListener(new MapClickListener() {

			public void mapClicked(LonLat position) {
				parent.getMap().setCenter(position, 13, true, true);
				parent.getMap().redraw();
				System.out.println("Panning");
			}
			
		});

	}
	
	@Override
	public void setPixelSize(int width, int height) {
		int w = 10;
		int h = height + 10;
		
		DOM.setStyleAttribute(getElement(), "bottom", h +  "px");
		DOM.setStyleAttribute(getElement(), "left", w + "px");
		super.setPixelSize(width, height);
	}
}
