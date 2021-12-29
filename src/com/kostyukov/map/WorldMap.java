package com.kostyukov.map;

import java.util.Random;

public class WorldMap
{
	private int rocksAmount, samplesAmount;
	private final MapTile[][] tiles;
	public WorldMap(int sizeX, int sizeY)
	{
		tiles = new MapTile[sizeX][sizeY];
		
		for (int x = 0; x < sizeX; x++)
		{
			for (int y = 0; y < sizeY; y++)
			{
				tiles[x][y] = new MapTile(x, y);
				int rnd = new Random().nextInt(20);
				if (rnd <= 2)
				{
					MapItem.itemType itemType;
					if (rnd == 1)
						itemType = MapItem.itemType.HOLE;
					else
					{
						itemType = MapItem.itemType.ROCK;
						rocksAmount++;
					}
					tiles[x][y].setLocalObject(MapItem.getNewMapItem(itemType));
				}
			}
		}
		LinkTiles();
//		CheckLinks();
//		PrintMap();
	}
	
	public int getRocksAmount()
	{
		return rocksAmount;
	}
	
	public MapTile getFirstFreeTile()
	{
		for (MapTile[] row : tiles)
		{
			for (MapTile mapTile : row)
			{
				if (mapTile.getLocalObject() == null)
					return mapTile;
			}
		}
		return null;
	}
	
	
	private void LinkTiles()
	{
		int sizeX = tiles.length;
		int sizeY = tiles[0].length;
		
		int
				xLinkN, yLinkN,
				xLinkE, yLinkE,
				xLinkS, yLinkS,
				xLinkW, yLinkW;
		
		for (int x = 0; x < sizeX; x++)
		{
			for (int y = 0; y < sizeY; y++)
			{
				xLinkN = x - 1;
				if (xLinkN < 0)
				{
					xLinkN = sizeX - 1;
				}
				yLinkN = y;
				
				xLinkE = x;
				
				yLinkE = y + 1;
				if (yLinkE == sizeY)
				{
					yLinkE = 0;
				}
				
				xLinkS = x + 1;
				if (xLinkS == sizeX)
				{
					xLinkS = 0;
				}
				
				yLinkS = y;
				
				xLinkW = x;
				
				yLinkW = y - 1;
				if (yLinkW < 0)
				{
					yLinkW = sizeY - 1;
				}
				
				tiles[x][y].setTileLink(CardinalPoints.N, tiles[xLinkN][yLinkN]);
				tiles[x][y].setTileLink(CardinalPoints.E, tiles[xLinkE][yLinkE]);
				tiles[x][y].setTileLink(CardinalPoints.S, tiles[xLinkS][yLinkS]);
				tiles[x][y].setTileLink(CardinalPoints.W, tiles[xLinkW][yLinkW]);
			}
		}
	}
	
	@Deprecated
	public void CheckLinks()
	{
		int sizeX = tiles.length;
		int sizeY = tiles[0].length;
		
		for (int x = 0; x < sizeX; x++)
		{
			for (int y = 0; y < sizeY; y++)
			{
				System.out.println("Current tile x (" + x + ") y (" + y + ") North tile - " + tiles[x][y].getMapTile(CardinalPoints.N).getCoordinates());
				System.out.println("Current tile x (" + x + ") y (" + y + ") East tile - " + tiles[x][y].getMapTile(CardinalPoints.E).getCoordinates());
				System.out.println("Current tile x (" + x + ") y (" + y + ") South tile - " + tiles[x][y].getMapTile(CardinalPoints.S).getCoordinates());
				System.out.println("Current tile x (" + x + ") y (" + y + ") West tile - " + tiles[x][y].getMapTile(CardinalPoints.W).getCoordinates());
			}
		}
	}
	
	public void PrintMap()
	{
		for (MapTile[] row : tiles)
		{
			for (MapTile mapTile : row)
			{
				System.out.print("|" + mapTile);
			}
			System.out.print("|\n");
		}
	}
	
	public int getMapSizeX()
	{
		return tiles.length;
	}
	
	public int getMapSizeY()
	{
		return tiles[0].length;
	}
}