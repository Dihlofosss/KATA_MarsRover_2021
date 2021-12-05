package com.kostyukov;

import com.kostyukov.map.WorldMap;
import com.kostyukov.rover.*;
import org.jetbrains.annotations.NotNull;

public class ControlCenter
{
	private Enum roverCommand;
	private Rover rover;
	private WorldMap map;
	
	public ControlCenter(WorldMap map, Rover rover)
	{
		this.map = map;
		this.rover = rover;
	}
	
	private boolean DecodeCommand(@NotNull String s)
	{
		switch(s)
		{
			case "f" -> roverCommand = MoveDirection.FORWARDS;
			case "b" -> roverCommand = MoveDirection.BACKWARDS;
			case "l" -> roverCommand = TurnDirection.LEFT;
			case "r" -> roverCommand = TurnDirection.RIGHT;
			case "s" -> roverCommand = CustomCommands.SHOT;
			case "g" -> roverCommand = CustomCommands.GATHER;
			default -> {
				roverCommand = null;
				return false;
			}
		}
		return true;
	}
	
	public void CommandsInput(String commandsString)
	{
		String[] commands = commandsString.
				toLowerCase().
				replaceAll("[,.\\s+]","").
				split("");
		for (String s : commands)
		{
			if (DecodeCommand(s))
			{
				if (roverCommand instanceof MoveDirection)
					rover.Move((MoveDirection)roverCommand);
				else if (roverCommand instanceof TurnDirection)
					rover.Turn((TurnDirection) roverCommand);
				else if (roverCommand instanceof CustomCommands)
					rover.interact();
			}
		}
	}
}
