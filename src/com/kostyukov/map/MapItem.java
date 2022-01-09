package com.kostyukov.map;

public class MapItem
{
	public enum ItemType
	{
		ROCK("\u0394"),
		HOLE("\u039F"),
		SAMPLE("\u2237");
		
		private String icon;
		
		ItemType(String icon)
		{
			this.icon = icon;
		}
		
		@Override
		public String toString()
		{
			return icon;
		}
	}
	
	public static MapItem getNewMapItem(ItemType type)
	{
		return new MapItem(type);
	}
	
	private ItemType itemType;
	
	private
	MapItem(ItemType itemType)
	{
		this.itemType = itemType;
	}
	
	public ItemType getItemType()
	{
		return itemType;
	}
	
	@Override
	public String toString()
	{
		return itemType.toString();
	}
}
