package luna.peril;

import javax.swing.*;
import java.awt.*;

/**
 * <p></p>
 *
 * @author Eric Rodriguez
 * @version 1.0
 */
public class MainRunner extends JPanel
{
//	public Map map = new Map();
	private Board board;
	
	MainRunner()
	{
		
	}
	
	public static void main(String[] args)
	{
		// Init the two frame and panel
		JFrame mainFrame = new JFrame("Peril");
		MainRunner panel = new MainRunner();
		panel.setPreferredSize(new Dimension(1600, 800));
		
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
		
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setContentPane(panel);
		mainFrame.pack();
		panel.init();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	void init()
	{
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		board = new Board(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		/*
		g.setColor(Color.GREEN);
		int[] xpoints = {160, 200, 300};
		int[] ypoints = {200, 100, 150};
		int npoints = 3;
		
		g.fillPolygon(xpoints, ypoints, npoints); //Venezuela Example
		 */
		
		board.draw(g);
	}
	
	/*
	public class Map
	{
		ArrayList<Territory> territories = new ArrayList<>();
		
		Map()
		{
			territories.add(new Territory(0, "Argentina"));
			territories.add(new Territory(1, "Brazil"));
			territories.add(new Territory(2, "Peru"));
			territories.add(new Territory(3, "Venezuela"));
			
		}
		
		
	}
	
	 */
}
