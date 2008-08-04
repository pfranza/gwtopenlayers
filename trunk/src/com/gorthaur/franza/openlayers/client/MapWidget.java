package com.gorthaur.franza.openlayers.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

public class MapWidget extends Widget {

    private final Map map;
    
    public MapWidget(boolean isSphericalMercator) {
        Element mapDomElement = DOM.createDiv();
        this.setElement(mapDomElement);
        this.map = new Map(mapDomElement, isSphericalMercator);
    }
    
    public Map getMap() {
        return this.map;
    }
    
    protected void onLoad() {
        super.onLoad();
        this.map.redraw();
    }
}

