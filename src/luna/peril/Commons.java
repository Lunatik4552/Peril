package luna.peril;

import java.util.List;

public class Commons
{
	public static final int STARTING_UNIT_AMOUNT = 35;
	public static final int TERRITORY_COUNT      = 42;
	
	/**
	 * <p>An enum for units. Intended to be easier when referencing units in visual form.</p>
	 */
	public enum Units
	{
		INFANTRY, CALVARY, CANNON
	}
	
	/**
	 * <p>Sets a default starting unit count for multiple players</p>
	 */
	public enum StartingUnits
	{
		THREE(35), FOUR(30), FIVE(25), SIX(20);
		
		public final int UNIT_COUNT;
		
		StartingUnits(int x)
		{
			UNIT_COUNT = x;
		}
	}
	
	/**
	 * <p>An enum of continents with the bonus troops.</p>
	 */
	public enum Continents
	{
		NA("North America", 9, 5),
		SA("South America", 4, 2),
		EU("Europe", 7, 5),
		AF("Africa", 6, 3),
		AS("Asia", 12, 7),
		AU("Australia", 4, 2);
		
		public final String NAME;
		public final int    BONUS;
		
		Continents(String name, int territories, int bonus)
		{
			NAME = name;
			BONUS = bonus;
		}
	}
	
	/**
	 * <p>A complete list of all territories and default info. Since this info will never change in game, set it in
	 * commons and allow the other classes handle variable info like troop count and ownership</p>
	 */
	public enum TerritoryList
	{
		// North America
		ALASKA(0, "Alaska", List.of(1, 3, 29), Continents.NA),
		NORTHWEST(1, "Northwest Territory", List.of(0, 2, 3, 4), Continents.NA),
		GREENLAND(2, "Greenland", List.of(1, 4, 5, 13), Continents.NA),
		ALBERTA(3, "Alberta", List.of(0, 1, 4, 6), Continents.NA),
		ONTARIO(4, "Ontario", List.of(1, 2, 3, 5, 6, 7), Continents.NA),
		EASTERN_CAN(5, "Eastern Canada", List.of(2, 4, 7), Continents.NA),
		WESTERN_US(6, "Western United States", List.of(3, 4, 7, 8), Continents.NA),
		EASTERN_US(7, "Eastern United States", List.of(4, 5, 6, 8), Continents.NA),
		CENTRAL_AM(8, "Central America", List.of(6, 7, 9), Continents.NA),
		
		// South America
		VENEZUELA(9, "Venezuela", List.of(8, 10, 11), Continents.SA),
		PERU(10, "Peru", List.of(9, 11, 12), Continents.SA),
		BRAZIL(11, "Brazil", List.of(9, 10, 12, 20), Continents.SA),
		ARGENTINA(12, "Argentina", List.of(10, 11), Continents.SA),
		
		// Europe
		ICELAND(13, "Iceland", List.of(2, 14, 16), Continents.EU),
		SCANDINAVIA(14, "Scandinavia", List.of(13, 15, 16, 17), Continents.EU),
		RUSSIA(15, "Russia", List.of(14, 17, 19, 26, 33, 35), Continents.EU),
		BRITAIN(16, "Great Britain", List.of(13, 14, 17), Continents.EU),
		NORTHERN_EU(17, "Northern Europe", List.of(14, 15, 16, 18, 19), Continents.EU),
		WESTERN_EU(18, "Western Europe", List.of(17, 19, 20), Continents.EU),
		SOUTHERN_EU(19, "Southern Europe", List.of(15, 17, 18, 20, 21, 35), Continents.EU),
		
		// Africa
		NORTH_AF(20, "Northern Africa", List.of(), Continents.AF),
		EGYPT(21, "Egypt", List.of(19, 20, 22, 35), Continents.AF),
		EAST_AF(22, "East Africa", List.of(20, 21, 23, 24, 25, 35), Continents.AF),
		CENTRAL_AF(23, "Central Africa", List.of(20, 22, 24), Continents.AF),
		SOUTH_AF(24, "South Africa", List.of(22, 23, 25), Continents.AF),
		MADAGASCAR(25, "Madagascar", List.of(22, 24), Continents.AF),
		
		// Asia
		URAL(26, "Ural", List.of(15, 27, 33, 34), Continents.AS),
		SIBERIA(27, "Siberia", List.of(26, 28, 30, 31, 34), Continents.AS),
		YAKUTSK(28, "Yakutsk", List.of(27, 29, 30), Continents.AS),
		KAMCHATKA(29, "Kamchatka", List.of(0, 28, 30, 31, 32), Continents.AS),
		IRKUTSK(30, "Irkutsk", List.of(27, 28, 29, 31), Continents.AS),
		MONGOLIA(31, "Mongolia", List.of(27, 29, 30, 32, 34), Continents.AS),
		JAPAN(32, "Japan", List.of(29, 31), Continents.AS),
		AFGHANISTAN(33, "Afghanistan", List.of(15, 26, 34, 35, 36), Continents.AS),
		CHINA(34, "China", List.of(26, 27, 31, 33, 36, 37), Continents.AS),
		MIDDLE_EAST(35, "Middle East", List.of(15, 19, 21, 22, 33, 36), Continents.AS),
		INDIA(36, "India", List.of(33, 34, 35, 37), Continents.AS),
		SOUTHERN_AS(37, "Southern Asia", List.of(34, 36, 38), Continents.AS),
		
		// Australia
		INDONESIA(38, "Indonesia", List.of(37, 39, 40), Continents.AU),
		NEW_GUINEA(39, "New Guinea", List.of(38, 40, 41), Continents.AU),
		WESTERN_AU(40, "Western Australia", List.of(38, 39, 41), Continents.AU),
		EASTERN_AU(41, "Eastern Australia", List.of(39, 40), Continents.AU);
		
		public final int           ID;
		public final String        NAME;
		public final List<Integer> ADJACENT_IDS;
		public final Continents    CONTINENT;
		
		TerritoryList(int id, String name, List<Integer> adj, Continents continent)
		{
			ID = id;
			NAME = name;
			ADJACENT_IDS = adj;
			CONTINENT = continent;
		}
	}
}
