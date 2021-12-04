package com.kostyukov.rover;


public interface Rover
{
	void Move(MoveDirection direction);
	void Turn(TurnDirection direction);
}
