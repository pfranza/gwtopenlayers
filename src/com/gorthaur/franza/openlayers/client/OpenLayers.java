package com.gorthaur.franza.openlayers.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowResizeListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.gorthaur.franza.openlayers.client.basetypes.LonLat;
import com.gorthaur.franza.openlayers.client.layers.Google;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OpenLayers implements EntryPoint {

  /**
   * This is the entry point method.
   */
	public void onModuleLoad() {
		fixSize();
		Window.enableScrolling(false);
		MapWidget map = new MapWidget(false);
			map.getMap().addLayer(new Google(Google.TYPE.SATELLITE, "Overview", false));
			map.getMap().setZoomLevel(15);
			map.getMap().panTo(new LonLat(18, 34));


		RootPanel.get().add(map);
		Timer t = new Timer() {

			@Override
			public void run() {
				fixSize();
			}
			
		};
		t.schedule(500);
		
		Window.addWindowResizeListener(new WindowResizeListener() {

			public void onWindowResized(int width, int height) {
				fixSize();
			}

		});
	}

	private void fixSize() {
		RootPanel.get().setSize(Window.getClientWidth() + "px", Window.getClientHeight() + "px");
		System.out.println("Size Fixed");
	}
	
}
