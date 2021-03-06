package com.kostyukov.map;

import java.util.Map;
import java.util.TreeMap;

public class MapTile
{
	
	private final Map<CardinalPoints, MapTile> linkedTiles = new TreeMap<>();
	
	public Object getObjectOnTheTile()
	{
		return objectOnTheTile;
	}
	
	public void setObjectOnTheTile(Object objectOnTheTile)
	{
		this.objectOnTheTile = objectOnTheTile;
	}
	
	private Object objectOnTheTile;
	
	private final int[] coordinates = new int[2];
	
	public MapTile(int x, int y)
	{
		coordinates[0] = x;
		coordinates[1] = y;
	}
	
	public void setTileLink(CardinalPoints point, MapTile mapTile)
	{
		
		linkedTiles.putIfAbsent(point, mapTile);
	}
	
	public MapTile getMapTile(CardinalPoints point)
	{
		return linkedTiles.get(point);
	}
	
	public String getCoordinates()
	{
		return "x (" + coordinates[0] + ") y (" + coordinates[1] + ")";
	}
	
	@Override
	public String toString()
	{
		return objectOnTheTile != null ? objectOnTheTile.toString() : "_";
	}
}
