package com.kostyukov;

import com.kostyukov.map.CardinalPoints;
import com.kostyukov.map.WorldMap;
import com.kostyukov.rover.MarsRover;
import com.kostyukov.rover.MoveDirection;
import com.kostyukov.rover.Rover;
import com.kostyukov.rover.TurnDirection;

import java.io.IOException;

public class Test
{
	public static void main(String[] args) throws InterruptedException
	{
//		SetUnicodeOn();
		ClrScr();
		
		WorldMap marsMap = new WorldMap(6, 6);
		
		Rover mRover = new MarsRover(marsMap, CardinalPoints.N);
		
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.RIGHT);
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.RIGHT);
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.LEFT);
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.LEFT);
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.BACKWARDS);
		marsMap.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.BACKWARDS);
		marsMap.PrintMap();
		Thread.sleep(1000);
	}
	
	static void ClrScr()
	{
		try
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (IOException | InterruptedException ex) {}
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
