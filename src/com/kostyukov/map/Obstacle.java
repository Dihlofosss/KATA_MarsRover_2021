package com.kostyukov.map;

public class Obstacle
{
	public enum obstacleType
	{
		ROCK("\u0394"),
		HOLE("\u039F");
		
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
	
	@Override
	public String toString()
	{
		return obstacleType.toString();
	}
}
