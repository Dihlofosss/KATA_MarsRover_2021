package com.kostyukov.map;

import com.kostyukov.ControlCenter;

import java.util.Map;
import java.util.TreeMap;

public class MapTile
{
	private final Map<CardinalPoints, MapTile> linkedTiles = new TreeMap<>();
	
	public Object getLocalObject()
	{
		return localObject;
	}
	
	public void addLocalObject(Object localObject)
	{
		this.localObject = localObject;
	}
	
	public int removeLocalObject()
	{
		int messageID = 0;
		
		if (localObject == null)
			return 1;
		else
			localObject = null;
		
		return messageID;
	}
	
	private Object localObject;
	
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
	
	@Override
	public String toString()
	{
		return localObject != null ? localObject.toString() : "_";
	}
}
