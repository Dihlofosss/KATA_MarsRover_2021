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
		
		MarsRover mRover = new MarsRover(new MarsMap(6, 6), CardinalPoints.N);
		
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.RIGHT);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.RIGHT);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.LEFT);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.FORWARDS);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Turn(TurnDirection.LEFT);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.BACKWARDS);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
		
		mRover.Move(MoveDirection.BACKWARDS);
		mRover.getMap().PrintMap();
		Thread.sleep(1000);
		ClrScr();
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
