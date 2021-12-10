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
	
	public void interactWithObject()
	{
		if (objectOnTheTile == null)
		{
			System.out.println("There is an empty space.");
			return;
		}
		
		if (objectOnTheTile instanceof Obstacle)
		{
			Obstacle.obstacleType obstacleType = ((Obstacle) objectOnTheTile).getObstacleType();
			switch (obstacleType)
			{
				case HOLE -> System.out.println("Sorry, WHAT to do with a hole?");
				case ROCK ->
						{
							objectOnTheTile = new Obstacle(Obstacle.obstacleType.SAMPLE);
							System.out.println("Rock cracked successfully");
						}
				case SAMPLE ->
						{
							System.out.println("Samples gathered, well done.");
							objectOnTheTile = null;
						}
				default -> System.out.println("Unknown obstacle type");
			}
		}
		
		System.out.println("Looks like another Rover ahead?");
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
