import javax.swing.JFrame;

public class VoteDriver 
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Voting System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit when closed
		Vote vote = new Vote();
		
		frame.getContentPane().add(vote.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}