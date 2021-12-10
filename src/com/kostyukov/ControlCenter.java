package com.kostyukov;

import com.kostyukov.map.WorldMap;
import com.kostyukov.rover.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ControlCenter
{
	private Enum roverCommand;
	private Rover rover;
	private WorldMap map;
	
	public ControlCenter(WorldMap map, Rover rover)
	{
		this.map = map;
		this.rover = rover;
		
		this.map.PrintMap();
		Pause(3000);
	}
	
	private void TravelToTheNextMap()
	{
		map = new WorldMap(map.getMapSizeX(), map.getMapSizeY());
		rover.LandThisRover(map);
	}
	
	private boolean DecodeAndExecuteCommand(@NotNull String s)
	{
		switch(s)
		{
			case "f" -> rover.ExecuteCommand(RoverCommands.FORWARDS);
			case "b" -> rover.ExecuteCommand(RoverCommands.BACKWARDS);
			case "l" -> rover.ExecuteCommand(RoverCommands.LEFT);
			case "r" -> rover.ExecuteCommand(RoverCommands.RIGHT);
			case "s" -> rover.ExecuteCommand(RoverCommands.SHOT);
			case "g" -> rover.ExecuteCommand(RoverCommands.GATHER);
			case "n" -> TravelToTheNextMap();
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
			ClrScr();
			DecodeAndExecuteCommand(s);
			map.PrintMap();
			Pause(1000);
		}
	}
	
	private void ClrScr()
	{
		try
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (IOException | InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
	
	private void Pause(int millis)
	{
		try
		{
			Thread.sleep(millis);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}