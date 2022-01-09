package com.kostyukov.rover;

import com.kostyukov.ControlCenter;
import com.kostyukov.map.CardinalPoints;
import com.kostyukov.map.MapItem;
import com.kostyukov.map.MapTile;
import com.kostyukov.map.WorldMap;

public class MarsRover extends Rover
{
	private int shootPowerConsumption, gatherPowerConsumption;
	
	public MarsRover(WorldMap map, CardinalPoints direction, int capacitor)
	{
		capacitorLevel = maxCapacitorLevel = capacitor;
		currentDirection = direction;
		LandThisRover(map);
	}
	
	/**
	 * 4 power drain values:
	 * move, turn, shoot and gather.
	 * @param values
	 */
	@Override
	public void setPowerConsumption(int... values)
	{
		super.setPowerConsumption(values);
		shootPowerConsumption = values[2];
		gatherPowerConsumption = values[3];
	}
	
	@Override
	public int interact(RoverCommands command)
	{
		int messageID = 0;
		MapTile targetTile = currentPosition.getMapTile(currentDirection);
		
		if (targetTile.getLocalObject() == null)
			return 1;
		
		switch (command)
		{
			case SHOT -> messageID = shoot(targetTile);
			case GATHER -> messageID = gather(targetTile);
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
			newPosition = currentPosition.getMapTile(currentDirection.oppositeDirection());
			messageID = 10;
		}
		
		if (newPosition.getLocalObject() != null)
		{
			if (((MapItem)newPosition.getLocalObject()).getItemType() == MapItem.ItemType.HOLE)
			{
				ControlCenter.gameOver = true;
				messageID = 16;
			}
			else
				return 11; //return if there is an obstacle on the target position
		}
		
		if (!updateCapacitor(-movePowerConsumption))
			return 18;
		
		newPosition.addLocalObject(this);
		currentPosition.addLocalObject(null);
		currentPosition = newPosition;
		
		return messageID;
	}
	
	public int stayAndCharge()
	{
		updateCapacitor(2);
		return 17;
	}
	
	@Override
	public String toString()
	{
		String roverSign;
		System.out.print("\u001B[32m"); //make rove icon green
		switch (currentDirection)
		{
			case N -> roverSign = "\u25B2";
			case E -> roverSign = "\u25B6";
			case S -> roverSign = "\u25BC";
			case W -> roverSign = "\u25C0";
			default -> roverSign = "Something is broken in rover icon setup";
		}
		return roverSign + "\u001B[0m"; //switch text color back to normal
	}
	
	private int shoot(MapTile targetTile)
	{
		int messageID;
		
		MapItem.ItemType itemType;
		try
		{
			itemType = ((MapItem)targetTile.getLocalObject()).getItemType();
		}
		catch (ClassCastException e)
		{
			e.printStackTrace();
			return 18;
		}
		
		if (updateCapacitor(-shootPowerConsumption))
		{
			switch (itemType)
			{
				case HOLE -> messageID = 2;
				case ROCK ->
						{
							targetTile.addLocalObject(MapItem.getNewMapItem(MapItem.ItemType.SAMPLE));
							messageID = 3;
						}
				case SAMPLE ->
						{
							targetTile.removeLocalObject();
							messageID = 4;
						}
				default -> messageID = 5;
			}
		}
		else
			messageID = 18;
		
		return messageID;
	}
	
	private int gather(MapTile targetTile)
	{
		int messageID;
		
		MapItem.ItemType itemType;
		try
		{
			itemType = ((MapItem)targetTile.getLocalObject()).getItemType();
		}
		catch (ClassCastException e)
		{
			e.printStackTrace();
			return 18;
		}
		
		if (updateCapacitor(-gatherPowerConsumption))
		{
			switch (itemType)
			{
				case HOLE -> messageID = 6;
				case ROCK -> messageID = 7;
				case SAMPLE ->
						{
							messageID = 8;
							targetTile.removeLocalObject();
							ControlCenter.sampleGathered();
						}
				default -> messageID = 5;
			}
		}
		else
			messageID = 18;
		
		return messageID;
	}
}
