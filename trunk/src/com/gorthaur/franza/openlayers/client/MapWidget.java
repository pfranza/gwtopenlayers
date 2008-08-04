package com.gorthaur.franza.openlayers.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.SimplePanel;

public class MapWidget extends SimplePanel {

    private Map map;
    private static int idx = 1;
    
    private OverViewMap overview;
    
    public MapWidget(boolean isSphericalMercator, boolean hasOverViewMap) {
    	super(DOM.createDiv());
        	super.getElement().setId("MapWidget-" + (idx++));
        this.map = new Map(super.getElement(), isSphericalMercator);
        setSize("100%", "100%");
        if(hasOverViewMap) {
        	overview = new OverViewMap(this);
        	DOM.appendChild(getElement(), overview.getElement());
        }
    }
    

	public Map getMap() {
        return this.map;
    }
    
    protected void onLoad() {
        super.onLoad();
        this.map.redraw();
    }
    
    public OverViewMap getOverviewMap() {
    	return overview;
    }
    

}

