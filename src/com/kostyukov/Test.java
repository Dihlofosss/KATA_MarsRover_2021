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
		MarsRover mRover = new MarsRover(marsMap, CardinalPoints.N, 30);
		
		ControlCenter controlCenter = new ControlCenter(marsMap,mRover);
		
		ControlCenter.printStats();
		marsMap.PrintMap();
		
		while (true)
		{
			System.out.println("Enter command or commands list: ");
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
