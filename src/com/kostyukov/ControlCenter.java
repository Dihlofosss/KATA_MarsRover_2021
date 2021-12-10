package com.kostyukov;

import com.kostyukov.map.WorldMap;
import com.kostyukov.rover.*;

import java.io.IOException;

public class ControlCenter
{
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
	
	public void CommandsInput(String commandsString)
	{
		String[] commands = commandsString.
				toLowerCase().
				replaceAll("[,.\\s+]","").
				split("");
		for (String s : commands)
		{
			ClrScr();
			switch(s)
			{
				case "f" -> rover.Move(RoverCommands.FORWARDS);
				case "b" -> rover.Move(RoverCommands.BACKWARDS);
				case "l" -> rover.Turn(RoverCommands.LEFT);
				case "r" -> rover.Turn(RoverCommands.RIGHT);
				case "s" -> rover.interact(RoverCommands.SHOT);
				case "g" -> rover.interact(RoverCommands.GATHER);
				case "n" -> TravelToTheNextMap();
			}
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