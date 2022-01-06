package com.kostyukov;

import com.kostyukov.map.WorldMap;
import com.kostyukov.rover.*;

import java.io.IOException;

public class ControlCenter
{
	private static int initialRocksAmount, currentRocksAmount, samplesAmount, samplesGathered, currentCapacitor, maxCapacitor;
	public static boolean gameOver;
	private MarsRover rover;
	private WorldMap map;
	
	public ControlCenter(WorldMap map, MarsRover rover)
	{
		this.map = map;
		this.rover = rover;
		gameOver = false;
		currentRocksAmount = initialRocksAmount = map.getRocksAmount();
		maxCapacitor = rover.getMaxCapacitorLevel();
		getRoverCapasitor();
	}
	
	private int TravelToTheNextMap()
	{
		map = new WorldMap(map.getMapSizeX(), map.getMapSizeY());
		currentRocksAmount = initialRocksAmount = map.getRocksAmount();
		rover.LandThisRover(map);
		return 15;
	}
	
	public void CommandsInput(String commandsString)
	{
		int messageID = -1;
		String[] commands = commandsString.
				toLowerCase().
				replaceAll("[,.\\s+]","").
				split("");
		for (String s : commands)
		{
			ClrScr();
			switch(s)
			{
				case "f" -> messageID = rover.Move(RoverCommands.FORWARDS);
				case "b" -> messageID = rover.Move(RoverCommands.BACKWARDS);
				case "l" -> messageID = rover.Turn(RoverCommands.LEFT);
				case "r" -> messageID = rover.Turn(RoverCommands.RIGHT);
				case "s" ->
						{
							messageID = rover.interact(RoverCommands.SHOT);
							if (messageID == 3)
								currentRocksAmount--;
						}
				case "g" -> messageID = rover.interact(RoverCommands.GATHER);
				case "n" -> messageID = TravelToTheNextMap();
				case "w" -> messageID = rover.stayAndCharge();
			}
			getRoverCapasitor();
			printStats();
			map.PrintMap();
			printLastMessage(messageID);
			Pause(1000);
		}
	}
	
	public static void printStats()
	{
		System.out.print("Rocks: " + currentRocksAmount + "/" + initialRocksAmount + "\tSamples gathered: " + samplesGathered + "\t");
		System.out.println("Capacitor: " + currentCapacitor + "/" + maxCapacitor + "\n");
	}
	
	public static void printLastMessage(int messageID)
	{
		System.out.println(SystemMessages.message.get(messageID));
	}
	
	public static void ClrScr()
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
	
	public static void sampleGathered()
	{
		samplesGathered++;
	}
	
	private void getRoverCapasitor()
	{
		currentCapacitor = rover.getCapacitorLevel();
	}
}