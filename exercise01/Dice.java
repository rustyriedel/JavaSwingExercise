import javax.swing.*;  
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;      
import java.util.Random;

public class Dice 
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	
	public Dice()
	{
		panel = new JPanel();
		button = new JButton("Roll");
		text = new JTextField(3);
		label = new JLabel("Enter # of sides on dice");
		
		//load the listener for the button
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(text);
		panel.add(button);
		panel.add(label);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			    //get input string and convert to an int
				String input = text.getText();
				int inputNum = Integer.parseInt(input);
				
				//roll a random number between 1 and inputNum inclusively
				Random random = new Random();
				int result = (random.nextInt(inputNum) + 1);
				
				//convert the number back to a string and set it as the labels text
				String str = result + "";
                label.setText(str);
			}
		};
		
		return listener;
	}	
}