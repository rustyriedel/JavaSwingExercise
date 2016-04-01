import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.File;

public class Vote 
{
    //UI declarations
    private JPanel panel;
    private JButton button;
    private JTextField firstName;
    private JTextField lastName;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JRadioButton can1;
    private JRadioButton can2;
    private JRadioButton can3;
    private JRadioButton can4;
    private ButtonGroup group;
    
    public Vote()
    {
        panel = new JPanel();
        button = new JButton("Vote!");
        
        //initialize the text fields
        firstName = new JTextField(15);
        lastName = new JTextField(15);
        
        //initialize the labels
        firstNameLabel = new JLabel("FirstName");
        lastNameLabel = new JLabel("LastName");
        
        //initialize the radio buttons and add to button group
        JRadioButton can1 = new JRadioButton("can1");
        JRadioButton can2 = new JRadioButton("can2");
        JRadioButton can3 = new JRadioButton("can3");
        JRadioButton can4 = new JRadioButton("can4");
        ButtonGroup group = new ButtonGroup();
        group.add(can1);
        group.add(can2);
        group.add(can3);
        group.add(can4);
        
        //Load the listener
        button.addActionListener(buttonListener()); 
        
        //load the panel
        panel.add(firstNameLabel);
        panel.add(firstName);
        panel.add(lastNameLabel);
        panel.add(lastName);
        panel.add(can1);
        panel.add(can2);
        panel.add(can3);
        panel.add(can4);
        panel.add(button);
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
                //get the input from the text boxes
                String fInput = firstName.getText();
                String lInput = lastName.getText();
                
                if(can1.isSelected() == true){
                    lastName.setText("can1");
                }
                
                //create a filename from the users inputs
                String filepath = "C:/" + lInput + "_" + fInput + "_ballot.txt";
                
                //check if the file exists already, if so display that the user already voted
                //I borrowed this code from a stack overflow thread.
                //http://stackoverflow.com/questions/1816673/how-do-i-check-if-a-file-exists-in-java
                File f = new File(filepath);
                if(f.isFile()) { 
                    firstName.setText("Already Exists");
                }else{
                    //f.createNewFile();
                }
                
               
                
  
            }
        };
        
        return listener;
    }   
}