package com.kostyukov.rover;

import com.kostyukov.map.CardinalPoints;
import com.kostyukov.map.MapTile;
import com.kostyukov.map.MarsMap;

public class MarsRover extends Rover
{
	
	public MarsRover(MarsMap map, CardinalPoints direction)
	{
		currentDirection = direction;
		LandThisRover(map);
	}
	
	@Override
	public void Move(MoveDirection direction)
	{
		MapTile newPosition;
		
		if (direction == MoveDirection.FORWARDS)
			newPosition = currentPosition.getMapTile(currentDirection);
		else
			newPosition = currentPosition.getMapTile(currentDirection.nextPoint().nextPoint());
		
		if (newPosition.getObjectOnTheTile() != null)
		{
			System.out.println("Obstacle ahead, can't move there.");
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
		switch (currentDirection)
		{
			case N -> roverSign = "\u25B2";
			case E -> roverSign = "\u25B6";
			case S -> roverSign = "\u25BC";
			case W -> roverSign = "\u25C0";
			default -> roverSign = "Have no idea why but Rover direction is not set";
		}
		return roverSign;
	}
}
