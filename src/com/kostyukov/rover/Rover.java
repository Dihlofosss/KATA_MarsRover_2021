package com.kostyukov.rover;

import com.kostyukov.map.CardinalPoints;
import com.kostyukov.map.MapTile;
import com.kostyukov.map.WorldMap;

public abstract class Rover
{
	MapTile currentPosition;
	CardinalPoints currentDirection;
	
	public abstract void Move(RoverCommands moveDirection);
	
	public void Turn(RoverCommands turnDirection)
	{
		switch (turnDirection)
		{
			case LEFT -> currentDirection = currentDirection.previousPoint();
			case RIGHT -> currentDirection = currentDirection.nextPoint();
			default -> System.out.println("Wrong command");
		}
	}
	
	public void LandThisRover(WorldMap map)
	{
		currentPosition = map.getFirstFreeTile();
		currentPosition.setLocalObject(this);
	}
	
	public abstract void interact(RoverCommands interaction);
}