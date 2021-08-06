package luna.peril;

import java.util.ArrayList;

/**
 * <p></p>
 *
 * @author Eric Rodriguez
 * @version 1.0
 */
public class Territory
{
	private final int    ID;
	private final String NAME;
	
	private int owner;
	private int troopCount;
	
	private final ArrayList<Integer> adjacentTerritories;
	
	/**
	 * <p>Initializes a territory.</p>
	 *
	 * @param ID   The territory ID
	 * @param Name The name of the territory
	 */
	public Territory(int ID, String Name)
	{
		this.ID = ID;
		this.NAME = Name;
		
		owner = -1;
		troopCount = 0;
		
		adjacentTerritories = new ArrayList<>();
	}
	
	/**
	 * <p>Get the territory ID.</p>
	 *
	 * @return Territory ID
	 */
	public int getID()
	{
		return ID;
	}
	
	/**
	 * <p>Get the name of the territory.</p>
	 *
	 * @return Territory Name
	 */
	public String getNAME()
	{
		return NAME;
	}
	
	/**
	 * <p>Get's the ID of the current territory owner.</p>
	 *
	 * @return Owner's Player ID
	 */
	public int getOwner()
	{
		return owner;
	}
	
	/**
	 * <p>Sets the owner of the territory.</p>
	 *
	 * @param playerId The player ID that is the new owner
	 */
	public void setOwner(int playerId)
	{
		owner = playerId;
	}
	
	/**
	 * <p>Add troops to the territory.</p>
	 *
	 * @param incrementVal Amount of troops to add
	 */
	public void incrementTroops(int incrementVal)
	{
		troopCount += incrementVal;
	}
	
	/**
	 * <p>Remove troops from the territory.</p>
	 *
	 * @param decrementVal Amount of troops to remove
	 */
	public void decrementTroops(int decrementVal)
	{
		troopCount -= decrementVal;
		
		if (troopCount < 0)
		{
			troopCount = 0;
		}
	}
	
	/**
	 * <p>Add the ID's of adjacent territories</p>
	 *
	 * @param territoryId The adjacent territory's ID
	 */
	public void addAdjacentTerritory(int territoryId)
	{
		// Check if territory already exists in list
		for (int territory : adjacentTerritories)
		{
			// If exists, do nothing
			if (territory == territoryId)
			{
				return;
			}
		}
		
		adjacentTerritories.add(territoryId);
	}
	
	/**
	 * <p>Get's the ID's of the adjacent territories</p>
	 *
	 * @return Array List of territory IDs
	 */
	public ArrayList<Integer> getAdjacentTerritories()
	{
		return adjacentTerritories;
	}
}
