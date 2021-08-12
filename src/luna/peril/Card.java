package luna.peril;

public class Card
{
	
	final int           TERRITORY_ID;
	final Commons.Units UNIT;
	
	public Card(int territoryId, Commons.Units unit)
	{
		TERRITORY_ID = territoryId;
		UNIT = unit;
	}
}
