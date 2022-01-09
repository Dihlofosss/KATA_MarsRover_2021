package com.kostyukov;

import com.kostyukov.map.CardinalPoints;
import com.kostyukov.map.WorldMap;
import com.kostyukov.rover.MarsRover;

import java.io.IOException;
import java.util.Scanner;
public class Test
{
	public static void main(String[] args)
	{
//		SetUnicodeOn();
		ControlCenter.ClrScr();
		
		int x,y;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Generating world map\nPlease enter amount of tile along the \"X\" axis: ");
		x = scanner.nextInt();
		System.out.print("And along \"Y\" axis: ");
		y = scanner.nextInt();
		
		WorldMap marsMap = new WorldMap(x, y);
		MarsRover mRover = new MarsRover(marsMap, CardinalPoints.N, 10);
		mRover.setPowerConsumption(3,1,5,1);//power consumption - move, turn, shoot, gather
		
		ControlCenter controlCenter = new ControlCenter(marsMap,mRover);
		
		ControlCenter.printStats();
		marsMap.PrintMap();
		
		while (!ControlCenter.gameOver)
		{
			System.out.println("Enter command or list of commands: ");
			String commands = scanner.nextLine();
			if (commands.equals("q"))
				break;
			controlCenter.CommandsInput(commands);
		}
	}
	
	static void SetUnicodeOn()
	{
		try
		{
			new ProcessBuilder("cmd", "/K", "chcp 65001").inheritIO().start().waitFor();
		}
		catch (IOException | InterruptedException ex) {}
	}
}
