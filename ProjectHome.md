Visit the project home @ http://www.peterfranza.com/projects/gwt-openlayers-bindings/


Adding an Open Layers map bean to your GWT application is as easy as

```

		MapWidget map = new MapWidget(true);
		map.getMap().addLayer(new Google(Google.TYPE.SATELLITE, "World View", false), true);
		
		
		map.getMap().addControl(new NavToolBar());
		map.getMap().addControl(new PanZoomBar());
		
		final MarkerLayer ml = new MarkerLayer("Icons");
		map.getMap().addLayer(ml, false);
		map.getMap().setCenter(new LonLat(-98, 40), 5, true, true);
		map.getMap().addMapListener(new MapIconManager(ml, map));

		
		RootPanel.get().add(map);
```
