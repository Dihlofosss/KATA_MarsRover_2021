package com.kostyukov.rover;

import com.kostyukov.map.CardinalPoints;
import com.kostyukov.map.MapTile;
import com.kostyukov.map.WorldMap;

public class MarsRover extends Rover
{
	public MarsRover(WorldMap map, CardinalPoints direction)
	{
		currentDirection = direction;
		LandThisRover(map);
	}
	
	@Override
	public void interact()
	{
		currentPosition.getMapTile(currentDirection).interactWithObject();
	}
	
	@Override
	public void Move(RoverCommands moveDirection)
	{
		MapTile newPosition;
		
		if (moveDirection == RoverCommands.FORWARDS)
			newPosition = currentPosition.getMapTile(currentDirection);
		else
			newPosition = currentPosition.getMapTile(currentDirection.nextPoint().nextPoint());
		
		if (newPosition.getObjectOnTheTile() != null)
		{
			System.out.println("You ask me to move " + moveDirection + ", but there is an obstacle. Can't move there.");
			return;
		}
		
		newPosition.setObjectOnTheTile(this);
		currentPosition.setObjectOnTheTile(null);
		currentPosition = newPosition;
	}
	
	@Override
	public String toString()
	{
		String roverSign;
		System.out.print("\u001B[32m");
		switch (currentDirection)
		{
			case N -> roverSign = "\u25B2";
			case E -> roverSign = "\u25B6";
			case S -> roverSign = "\u25BC";
			case W -> roverSign = "\u25C0";
			default -> roverSign = "Have no idea why but Rover's direction is not set";
		}
		return roverSign + "\u001B[0m";
	}
}
