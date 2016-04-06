import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.*;
import java.util.*;

public class Vote 
{
    //UI declarations
    private JPanel panel;
    private JButton button;
    private JTextField firstName;
    private JTextField lastName;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel warning;
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
        warning = new JLabel("");
        
        //Set up radio buttons for candidate selection
        //I used code from this site as an example for the radio buttons
        //http://www.java2s.com/Code/Java/Swing-JFC/GetselectedbuttonfromButtonGroup.htm
        JPanel radioPanel = new JPanel();
        group = new ButtonGroup();
        JRadioButton radioButton;
        radioPanel.add(radioButton = new JRadioButton("Can1", true));
        radioButton.setActionCommand("Can1");
        group.add(radioButton);
        radioPanel.add(radioButton = new JRadioButton("Can2"));
        radioButton.setActionCommand("Can2");
        group.add(radioButton);
        radioPanel.add(radioButton = new JRadioButton("Can3"));
        radioButton.setActionCommand("Can3");
        group.add(radioButton);
        radioPanel.add(radioButton = new JRadioButton("Can4"));
        radioButton.setActionCommand("Can4");
        group.add(radioButton);
        
        //Load the listener
        button.addActionListener(buttonListener()); 
        
        //load the panel
        panel.add(firstNameLabel);
        panel.add(firstName);
        panel.add(lastNameLabel);
        panel.add(lastName);
        panel.add(radioPanel);
        panel.add(button);
        panel.add(warning);
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

                //create the filename string from the user first and last name inputs
                String fileName = "" + lInput + "_" + fInput + "_ballot.txt";
                
                //determine which candidate was selected and set content string to write to the file
                String content = group.getSelection().getActionCommand();
                
                //create a new filepath
                File filePath = new File(fileName);
                
                //check if the file exists already, if so display that the user already voted
                if(filePath.exists()){
                    //display to user that they already voted
                    warning.setText("Already voted!");
                }
                else{//make a new file and write your candidate as the content
                    //remove warning string
                    warning.setText("");
                    
                    //open and write to the new file.
                    try{
                        OutputStream outStream = new FileOutputStream(filePath);
                        outStream.write(content.getBytes());
                        outStream.close();
                    }
                    catch(Exception m){
                        warning.setText("could not create file");
                    }
                    
                }
               
            }
        };
        
        return listener;
    }   
}