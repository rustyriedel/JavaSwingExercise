import javax.swing.JFrame;


public class DiceDriver 
{
	private static void createAndDisplayGUI()
	{
	    //create the frame to display
		JFrame frame = new JFrame("Dice program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit when closed
		Dice dice = new Dice();
		
		//add content to the frame
		frame.getContentPane().add(dice.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
