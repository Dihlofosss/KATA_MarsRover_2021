package com.kostyukov.map;

public class MapItem
{
	public enum itemType
	{
		ROCK("\u0394"),
		HOLE("\u039F"),
		SAMPLE("\u2237");
		
		private String icon;
		
		itemType(String icon)
		{
			this.icon = icon;
		}
		
		@Override
		public String toString()
		{
			return icon;
		}
	}
	
	public static MapItem getNewMapItem(itemType type)
	{
	return new MapItem(type);
	}
	
	private itemType itemType;
	
	private
	MapItem(itemType itemType)
	{
		this.itemType = itemType;
	}
	
	public itemType getItemType()
	{
		return itemType;
	}
	
	@Override
	public String toString()
	{
		return itemType.toString();
	}
}
