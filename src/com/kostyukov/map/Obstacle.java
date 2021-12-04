package com.kostyukov.map;

public class Obstacle
{
	char obstacleType;
	
	public Obstacle(char obstacleType)
	{
		this.obstacleType = obstacleType;
	}
	
	@Override
	public String toString()
	{
		return "" + obstacleType;
	}
}
