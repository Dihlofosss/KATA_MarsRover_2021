package com.kostyukov.map;

public enum CardinalPoints
{
	N("North")
			{
				@Override
				public CardinalPoints previousPoint()
				{
					return values()[values().length - 1];
				}
			},
	E("East"),
	S("South"),
	W("West")
			{
				@Override
				public CardinalPoints nextPoint()
				{
					return values()[0];
				}
			};
	
	final String cardinalDirection;
	
	CardinalPoints(String name)
	{
		cardinalDirection = name;
	}
	
	public CardinalPoints nextPoint()
	{
		return values()[ordinal() + 1];
	}
	
	public CardinalPoints previousPoint()
	{
		return values()[ordinal() - 1];
	}
	
	@Override
	public String toString()
	{
		return cardinalDirection;
	}
}
