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
				int rnd = new Random().nextInt(10);
				if (rnd <= 2)
				{
					if (rnd == 0)
						rocksAmount++;
					
					tiles[x][y].addLocalObject(MapItem.getNewMapItem(MapItem.ItemType.values()[rnd]));
				}
			}
		}
		linkTiles();
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
	
	//after generating all map tiles lets connect them
	//south links with north links and west with east
	private void linkTiles()
	{
		int sizeX = tiles.length;
		int sizeY = tiles[0].length;
		
		int linkX, linkY;
		
		for (int x = 0; x < sizeX; x++)
		{
			for (int y = 0; y < sizeY; y++)
			{
				//get coordinates of the North map tile
				linkX = x - 1;
				//all if statements used to stitch map seams, N with S and E with W;
				if (linkX < 0)
				{
					linkX = sizeX - 1;
				}
				linkY = y;
				tiles[x][y].setTileLink(CardinalPoints.N, tiles[linkX][linkY]);
				
				//get coordinates of the East map tile
				linkX = x;
				
				linkY = y + 1;
				if (linkY == sizeY)
				{
					linkY = 0;
				}
				tiles[x][y].setTileLink(CardinalPoints.E, tiles[linkX][linkY]);
				
				//get coordinates of the South map tile
				linkX = x + 1;
				if (linkX == sizeX)
				{
					linkX = 0;
				}
				linkY = y;
				tiles[x][y].setTileLink(CardinalPoints.S, tiles[linkX][linkY]);
				
				//get coordinates of the West map tile
				linkX = x;
				linkY = y - 1;
				if (linkY < 0)
				{
					linkY = sizeY - 1;
				}
				tiles[x][y].setTileLink(CardinalPoints.W, tiles[linkX][linkY]);
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