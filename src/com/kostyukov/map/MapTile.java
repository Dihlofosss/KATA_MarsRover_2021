package com.kostyukov.map;

import java.util.Map;
import java.util.TreeMap;

public class MapTile
{
	
	private final Map<CardinalPoints, MapTile> linkedTiles = new TreeMap<>();
	
	public Object getLocalObject()
	{
		return localObject;
	}
	
	public void setLocalObject(Object localObject)
	{
		this.localObject = localObject;
	}
	
	public int shoot()
	{
		int messageID = 0;
		
		if (localObject == null)
		{
			return 1;
		}
		
		if (localObject instanceof MapItem)
		{
			MapItem.itemType itemType = ((MapItem) localObject).getObstacleType();
			switch (itemType)
			{
				case HOLE -> messageID = 2;
				case ROCK ->
						{
							localObject = new MapItem(MapItem.itemType.SAMPLE);
							messageID = 3;
						}
				case SAMPLE ->
						{
							localObject = null;
							messageID = 4;
						}
				default -> messageID = 5;
			}
		}
		return messageID;
	}
	
	public int gather()
	{
		int messageID = 0;
		
		if (localObject == null)
		{
			return 1;
		}
		
		if (localObject instanceof MapItem)
		{
			MapItem.itemType itemType = ((MapItem) localObject).getObstacleType();
			switch (itemType)
			{
				case HOLE -> messageID = 6;
				case ROCK -> messageID = 7;
				case SAMPLE ->
						{
							messageID = 8;
							localObject = null;
						}
				default -> messageID = 5;
			}
		}
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
	
	public String getCoordinates()
	{
		return "x (" + coordinates[0] + ") y (" + coordinates[1] + ")";
	}
	
	@Override
	public String toString()
	{
		return localObject != null ? localObject.toString() : "_";
	}
}
