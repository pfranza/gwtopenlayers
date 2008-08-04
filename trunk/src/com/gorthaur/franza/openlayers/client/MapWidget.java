package com.gorthaur.franza.openlayers.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.SimplePanel;

public class MapWidget extends SimplePanel {

    private Map map;
    private static int idx = 1;
    
    public MapWidget(boolean isSphericalMercator) {
    	super(DOM.createDiv());
        	super.getElement().setId("MapWidget-" + (idx++));
        this.map = new Map(super.getElement(), this,  isSphericalMercator);
        setSize("100%", "100%");
        
    }
    

	public Map getMap() {
        return this.map;
    }
    
    protected void onLoad() {
        super.onLoad();
        this.map.redraw();
    }
 

}

