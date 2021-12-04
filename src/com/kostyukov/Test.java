package com.kostyukov;

import com.kostyukov.map.CardinalPoints;
import com.kostyukov.map.MarsMap;
import com.kostyukov.rover.MarsRover;
import com.kostyukov.rover.MoveDirection;
import com.kostyukov.rover.TurnDirection;

import java.io.IOException;

public class Test
{
	public static void main(String[] args) throws InterruptedException
	{
//		SetUnicodeOn();
		ClrScr();
		
		MarsMap map = new MarsMap(6, 6);
		
		MarsRover mRover = new MarsRover(map, CardinalPoints.N);
		
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.RIGHT);
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.RIGHT);
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.LEFT);
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.LEFT);
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.BACKWARDS);
		map.PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.BACKWARDS);
		map.PrintMap();
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
