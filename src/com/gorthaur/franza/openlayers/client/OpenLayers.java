package com.gorthaur.franza.openlayers.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.gorthaur.franza.openlayers.client.layers.WorldWind;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OpenLayers implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  	MapWidget map = new MapWidget(false);
	  	map.getMap().addLayer(new WorldWind("LANDSAT", "http://worldwind25.arc.nasa.gov/tile/tile.aspx", 2.25f, 4));
	  	RootPanel.get().add(map);
  }
}
