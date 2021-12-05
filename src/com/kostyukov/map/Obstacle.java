package com.kostyukov.map;

public class Obstacle
{
	public enum obstacleType
	{
		ROCK("\u0394"),
		HOLE("\u039F"),
		SAMPLE("\u2237");
		
		private String icon;
		
		obstacleType(String icon)
		{
			this.icon = icon;
		}
		
		@Override
		public String toString()
		{
			return icon;
		}
	}
	
	private obstacleType obstacleType;
	
	public Obstacle(obstacleType obstacleType)
	{
		this.obstacleType = obstacleType;
	}
	
	public Obstacle.obstacleType getObstacleType()
	{
		return obstacleType;
	}
	
	@Override
	public String toString()
	{
		return obstacleType.toString();
	}
}
