package com.gorthaur.franza.openlayers.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowResizeListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.gorthaur.franza.openlayers.client.Map.MapMoveListener;
import com.gorthaur.franza.openlayers.client.basetypes.Bounds;
import com.gorthaur.franza.openlayers.client.basetypes.Icon;
import com.gorthaur.franza.openlayers.client.basetypes.LonLat;
import com.gorthaur.franza.openlayers.client.basetypes.Pixel;
import com.gorthaur.franza.openlayers.client.basetypes.Size;
import com.gorthaur.franza.openlayers.client.controls.NavToolBar;
import com.gorthaur.franza.openlayers.client.layers.Google;
import com.gorthaur.franza.openlayers.client.layers.MarkerLayer;
import com.gorthaur.franza.openlayers.client.markers.IconMarker;
import com.gorthaur.franza.openlayers.client.markers.Marker;
import com.gorthaur.franza.openlayers.client.markers.Marker.MarkerClickEventHandler;

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
		final MapWidget map = new MapWidget(true);
//			map.getMap().addLayer(new Google(Google.TYPE.PHYSICAL, "Normal", false), true);
//			map.getMap().addLayer(new Google(Google.TYPE.PHYSICAL, "Physical", true), true);
//			map.getMap().addLayer(new Google(Google.TYPE.HYBRID, "Hybrid", false), false);
			map.getMap().addLayer(new Google(Google.TYPE.SATELLITE, "Satellite", false), false);
			MarkerLayer ml = new MarkerLayer("Markers");
			map.getMap().addLayer(ml, false);
//			map.getMap().addLayer(new Yahoo("Yahoo Layer"), false);
//			map.getMap().addLayer(new WMS("WMS", "http://terraservice.net/ogcmap.ashx", "{'layers': 'DRG'}"), true);
//			map.getMap().addLayer(new VirtualEarth("VE"), true);
//			map.getMap().setZoomLevel(4);
//			map.getMap().panTo(new LonLat(18, 34));
//			OverviewMap ov = new OverviewMap(new Google(Google.TYPE.NORMAL, "Overview",  true));
//			map.getMap().addControl(ov);
			IconMarker marker = new IconMarker(new Icon("http://boston.openguides.org/markers/AQUA.png",new Size(10, 17), new Pixel(0, 0)), new LonLat( -76.207844, 36.756947));
			marker.add(new MarkerClickEventHandler() {

				public void markerClicked(Marker m) {
					System.out.println("Marker Clicked");
				}
				
			});
			ml.addMarker(marker);
			map.getMap().addControl(new NavToolBar());
//			map.getMap().addControl(new PanZoomBar());
//			map.getMap().addControl(new LayerSwitcher());
			
//			ov.addControl(new NavToolBar());
//			ov.addLayer(new Google(Google.TYPE.NORMAL, "Overview",  true));
//			, 'size': new $wnd.OpenLayers.Size(width, height)
			
//		map.getMap().zoomToMaxExtent();
			
		map.getMap().addMapListener(new MapMoveListener() {

			public void mapMoved(LonLat center, int zoomLevel,
					Bounds boundingBox) {
				System.out.println("Move Complete " + boundingBox);
				System.out.println("Center: " + center);
				System.out.println("ZoomLevel: " + zoomLevel);
			}
			
		});
			
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
	}
	
}
