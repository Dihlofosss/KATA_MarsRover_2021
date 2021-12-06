# KATA_MarsRover_2021

You’re part of the team that explores Mars by sending remotely controlled vehicles to the surface of the planet. Develop an API that translates the commands sent from earth to instructions that are understood by the rover.
Requirements

    You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
    The rover receives a character array of commands.
    Implement commands that move the rover forward/backward (f,b).
    Implement commands that turn the rover left/right (l,r).
    Implement wrapping at edges. But be careful, planets are spheres. Connect the x edge to the other x edge, so (1,1) for x-1 to (5,1), but connect vertical edges towards themselves in inverted coordinates, so (1,1) for y-1 connects to (5,1).
    Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point, aborts the sequence and reports the obstacle.
```
|_|_|Δ|_|_|_|
|_|_|_|▲---------Rover facing north
|_|Ο|_|_|_|_|
|_|_|_|_|_|_|
|Δ|Ο|Δ|_|_|_|
|_|_|_|_|_|Ο-----Obstacles
```

To enable unicode chars in console type "chcp 65001" before execute.

You have to control the rover with set of commands\
You can use "," or "." or space " " to separate commands, or just type all of them in one line\
F - move forwards\
B - move backwards\
R - turn right\
L - turn left\
S - shoot the rock with a laser to crack it\
G - gather samples after rock being cracked\
N - travel to the new map\
Q - quit

Not implemented:\
[ ] - points for gathered samples\
[ ] - rover's charge as well as day/night charge/discharge mechanic\
[ ] - rover's fall into the hole\
[ ] - gameover conditions

Known issue:\
gather and shoot command executing same function, and it's able to gather samples by shooting them

