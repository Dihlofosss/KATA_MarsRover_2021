package com.kostyukov;

import java.util.HashMap;
import java.util.Map;

public class SystemMessages
{
	public static final Map<Integer, String> message = new HashMap<>();
	
	static
	{
		//rover
		message.put(-1, "");
		message.put(0, "messageID initialization error");
		message.put(1, "There is an empty space.");
		message.put(2, "Shoot in the hole? PEW-PEW! Eat this, hole!\nLooks like that even hole ignores you.");
		message.put(3, "Rock cracked successfully.");
		message.put(4, "O-o-o-o-ps, fossil samples are destroyed.");
		message.put(5, "Unknown obstacle type.");
		message.put(6, "Gather... The hole???");
		message.put(7, "I would do this if this rock would be smaller. Try to crack it with a laser shot.");
		message.put(8, "Samples collected successfully.");
		message.put(9, "Moved forwards.");
		message.put(10, "Moved backwards.");
		message.put(11, "Obstacle ahead, unable to move there.");
		message.put(12, "Turned left.");
		message.put(13, "Turned right.");
		message.put(14, "Rover turn error.");
		message.put(15, "Landing on a new planet.");
	}
}
