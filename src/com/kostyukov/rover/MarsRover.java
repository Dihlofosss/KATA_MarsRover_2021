package com.kostyukov.rover;

import com.kostyukov.map.CardinalPoints;
import com.kostyukov.map.MapTile;
import com.kostyukov.map.WorldMap;

public class MarsRover extends Rover
{
	public MarsRover(WorldMap map, CardinalPoints direction, int capacitor)
	{
		capacitorLevel = maxCapacitorLevel = capacitor;
		currentDirection = direction;
		LandThisRover(map);
	}
	
	@Override
	public int interact(RoverCommands command)
	{
		int messageID = 0;
		switch (command)
		{
			case SHOT -> messageID = currentPosition.getMapTile(currentDirection).shoot();
			case GATHER -> messageID = currentPosition.getMapTile(currentDirection).gather();
		}
		return messageID;
	}
	
	@Override
	public int Move(RoverCommands moveDirection)
	{
		int messageID;
		
		MapTile newPosition;
		
		if (moveDirection == RoverCommands.FORWARDS)
		{
			newPosition = currentPosition.getMapTile(currentDirection);
			messageID = 9;
		}
		else
		{
			newPosition = currentPosition.getMapTile(currentDirection.nextPoint().nextPoint());
			messageID = 10;
		}
		
		if (newPosition.getLocalObject() != null)
		{
			return 11; //return if there is obstacle on the target position
		}
		
		newPosition.setLocalObject(this);
		currentPosition.setLocalObject(null);
		currentPosition = newPosition;
		
		return messageID;
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
		return roverSign + "\u001B[0m"; //add green color to the rover's icon
	}
}
