package com.kostyukov.rover;

import com.kostyukov.map.CardinalPoints;
import com.kostyukov.map.MapTile;
import com.kostyukov.map.WorldMap;

public abstract class Rover
{
	MapTile currentPosition;
	CardinalPoints currentDirection;
	int capacitorLevel, maxCapacitorLevel;
	int movePowerConsumption, turnPowerConsumption;
	
	public abstract int Move(RoverCommands moveDirection);
	
	public int Turn(RoverCommands turnDirection)
	{
		int messageID;
		
		switch (turnDirection)
		{
			case LEFT ->
					{
						currentDirection = currentDirection.previousPoint();
						messageID = 12;
					}
			case RIGHT ->
					{
						currentDirection = currentDirection.nextPoint();
						messageID = 13;
					}
			default ->
					{
						return 14;
					}
		}
		
		updateCapacitor(-turnPowerConsumption);
		return messageID;
	}
	
	public void LandThisRover(WorldMap map)
	{
		currentPosition = map.getFirstFreeTile();
		currentPosition.addLocalObject(this);
	}
	
	public abstract int interact(RoverCommands interaction);
	
	public int getCapacitorLevel()
	{
		return capacitorLevel;
	}
	
	public int getMaxCapacitorLevel()
	{
		return maxCapacitorLevel;
	}
	
	boolean updateCapacitor(int value)
	{
		int updatedCapacitorLevel = capacitorLevel + value;
		//limit discharge level
		if (updatedCapacitorLevel < 0)
			return false;
		//limit charge level
		if (updatedCapacitorLevel > maxCapacitorLevel)
			updatedCapacitorLevel = maxCapacitorLevel;
		capacitorLevel = updatedCapacitorLevel;
		return true;
	}
	
	abstract int stayAndCharge();
	
	void setPowerConsumption(int... values)
	{
		movePowerConsumption = values[0];
		turnPowerConsumption = values[1];
	}
}