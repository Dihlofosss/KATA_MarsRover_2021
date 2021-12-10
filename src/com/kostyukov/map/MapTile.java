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
	
	public void shoot()
	{
		if (localObject == null)
		{
			System.out.println("There is an empty space.");
			return;
		}
		
		if (localObject instanceof Obstacle)
		{
			Obstacle.obstacleType obstacleType = ((Obstacle) localObject).getObstacleType();
			switch (obstacleType)
			{
				case HOLE -> System.out.println("Shoot in the hole? PEW-PEW! Eat this, hole!\nLooks like that even hole ignores you");
				case ROCK ->
						{
							localObject = new Obstacle(Obstacle.obstacleType.SAMPLE);
							System.out.println("Rock cracked successfully");
						}
				case SAMPLE ->
						{
							System.out.println("O-o-o-o-ps, fossil samples are destroyed.");
							localObject = null;
						}
				default -> System.out.println("Unknown obstacle type");
			}
		}
	}
	
	public void gather()
	{
		if (localObject == null)
		{
			System.out.println("There is an empty space.");
			return;
		}
		
		if (localObject instanceof Obstacle)
		{
			Obstacle.obstacleType obstacleType = ((Obstacle) localObject).getObstacleType();
			switch (obstacleType)
			{
				case HOLE -> System.out.println("Gather... The hole???");
				case ROCK -> System.out.println("I would do this if this rock would be smaller. Try to crack it with a laser shot.");
				case SAMPLE ->
						{
							System.out.println("Samples collected successfully.");
							localObject = null;
						}
				default -> System.out.println("Unknown obstacle type");
			}
		}
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
