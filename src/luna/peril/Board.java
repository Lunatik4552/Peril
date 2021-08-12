package luna.peril;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board
{
	private final Font DEFAULT_FONT = new Font("Tahoma", Font.PLAIN, 16);
	
	private Territory[]                TERRITORIES = new Territory[Commons.TERRITORY_COUNT];
	private ArrayList<luna.peril.Card> CARDS;
	private JPanel                     panel;
	private SpringLayout layout;
	
	public Board(JPanel panel)
	{
		this.panel = panel;
		layout = (SpringLayout) panel.getLayout();
		createTerritories();
		createCards();
		addUI();
	}
	
	private void addUI()
	{
		// NA
		addButtonsAtLocation(0, 90, 80);
		addButtonsAtLocation(1, 280, 80);
		addButtonsAtLocation(2, 460, 40);
		addButtonsAtLocation(3, 160, 180);
		addButtonsAtLocation(4, 290, 180);
		addButtonsAtLocation(5, 420, 180);
		addButtonsAtLocation(6, 170, 280);
		addButtonsAtLocation(7, 340, 280);
		addButtonsAtLocation(8, 200, 380);
		
		//SA
		addButtonsAtLocation(9, 340, 480);
		addButtonsAtLocation(10, 320, 590);
		addButtonsAtLocation(11, 450, 580);
		addButtonsAtLocation(12, 380, 700);
	}
	
	private void addButtonsAtLocation(int territoryID, int x, int y)
	{
		Territory territory = TERRITORIES[territoryID];
		
		// Labels
		JLabel nameLabel = new JLabel(territory.getName());
		nameLabel.setFont(DEFAULT_FONT);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nameLabel, x, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, nameLabel, y, SpringLayout.NORTH, panel);
		panel.add(nameLabel);
		
		JLabel ownerLabelInfo = new JLabel("Owner:");
		layout.putConstraint(SpringLayout.SOUTH, ownerLabelInfo, -5, SpringLayout.NORTH, nameLabel);
		layout.putConstraint(SpringLayout.EAST, ownerLabelInfo, -15, SpringLayout.HORIZONTAL_CENTER, nameLabel);
		panel.add(ownerLabelInfo);
		
		JLabel ownerLabelVal = new JLabel("" + territory.getOwner());
		ownerLabelVal.setName("ownerLabelVal t:" + territoryID);
		layout.putConstraint(SpringLayout.BASELINE, ownerLabelVal, 0, SpringLayout.BASELINE, ownerLabelInfo);
		layout.putConstraint(SpringLayout.WEST, ownerLabelVal, 2, SpringLayout.EAST, ownerLabelInfo);
		panel.add(ownerLabelVal);
		
		JLabel troopLabelInfo = new JLabel("Troops:");
		layout.putConstraint(SpringLayout.WEST, troopLabelInfo, 2, SpringLayout.HORIZONTAL_CENTER, nameLabel);
		layout.putConstraint(SpringLayout.BASELINE, troopLabelInfo, 0, SpringLayout.BASELINE, ownerLabelInfo);
		panel.add(troopLabelInfo);
		
		JLabel troopLabelVal = new JLabel("" + territory.getTroopCount());
		troopLabelVal.setName("troopLabelVal t:" + territoryID);
		layout.putConstraint(SpringLayout.BASELINE, troopLabelVal, 0, SpringLayout.BASELINE, troopLabelInfo);
		layout.putConstraint(SpringLayout.WEST, troopLabelVal, 2, SpringLayout.EAST, troopLabelInfo);
		panel.add(troopLabelVal);
		
		// Reinforcement phase
		String reinforceUpID = "reinforceUp t:" + territoryID + " o:null";
		JButton reinforceUp = new JButton("Add");
		reinforceUp.setName(reinforceUpID);
		reinforceUp.setActionCommand(reinforceUpID);
		layout.putConstraint(SpringLayout.NORTH, reinforceUp, 5, SpringLayout.SOUTH, nameLabel);
		layout.putConstraint(SpringLayout.EAST, reinforceUp, -9, SpringLayout.HORIZONTAL_CENTER, nameLabel);
		panel.add(reinforceUp);
		
		String reinforceDownID = "reinforceDown t:" + territoryID + " o:null";
		JButton reinforceDown = new JButton("Remove");
		reinforceDown.setName(reinforceDownID);
		reinforceDown.setActionCommand(reinforceDownID);
		layout.putConstraint(SpringLayout.BASELINE, reinforceDown, 0, SpringLayout.BASELINE, reinforceUp);
		layout.putConstraint(SpringLayout.WEST, reinforceDown, 2, SpringLayout.EAST, reinforceUp);
		panel.add(reinforceDown);
		
		
	}
	
	public void draw(Graphics g)
	{
		Color defaultColor = g.getColor();
		g.setColor(Color.green);
		for (int i = 0; i < panel.getPreferredSize().width; i += 100)
		{
			g.drawLine(i, 0, i, panel.getPreferredSize().height);
		}

		for (int i = 0; i < panel.getPreferredSize().height; i += 100)
		{
			g.drawLine(0, i, panel.getPreferredSize().width, i);
		}
		g.setColor(defaultColor);
	}
	
	private void createTerritories()
	{
		for (Commons.TerritoryList territory : Commons.TerritoryList.values())
		{
			TERRITORIES[territory.ID] = new Territory(territory.ID, territory.NAME, territory.ADJACENT_IDS);
		}
	}
	
	private void createCards()
	{
		ArrayList<Territory> territories = new ArrayList<>(Arrays.asList(TERRITORIES));
		ArrayList<Card> cards = new ArrayList<>();
		
		// 3 units, loop 3 times
		for (int i = 0; i < 3; i++)
		{
			// use infantry on first, calvary on second, cannon on third
			Commons.Units unit = i == 0 ?
			                     Commons.Units.INFANTRY : (i == 1 ? Commons.Units.CALVARY : Commons.Units.CANNON);
			
			// Assign that unit 14 times
			// Random territory assignment for more fun
			int temp = 14;
			while (temp-- > 0)
			{
				Random rand = new Random(System.currentTimeMillis());
				int index = rand.nextInt(territories.size());
				cards.add(new Card(territories.get(index).getID(), unit));
				territories.remove(index);
			}
		}
		
		CARDS = new ArrayList<>(cards);
	}
	
	public Card getRandomCard()
	{
		if (CARDS.isEmpty())
		{
			return null;
		}
		
		int index = (new Random(System.currentTimeMillis())).nextInt(CARDS.size());
		Card card = CARDS.get(index);
		CARDS.remove(index);
		return card;
	}
	
	public boolean cardsAvailable()
	{
		return !CARDS.isEmpty();
	}
}
