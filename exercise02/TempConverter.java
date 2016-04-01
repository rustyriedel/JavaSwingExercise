import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;

public class TempConverter 
{
    //UI declarations
    private JPanel panel;
    private JButton button;
    private JTextField fText;
    private JTextField cText;
    private JTextField kText;
    private JLabel fLabel;
    private JLabel cLabel;
    private JLabel kLabel;
    private JLabel warning;
    
    //conversion variable declarations
    private double oldF = -1.0;
    private double oldC = -1.0;
    private double oldK = -1.0;
    
    public TempConverter()
    {
        panel = new JPanel();
        button = new JButton("Convert");
        JLabel warning = new JLabel("Only enter one temp at a time!");
        
        //initialize the text fields
        fText = new JTextField(5);
        cText = new JTextField(5);
        kText = new JTextField(5);
        fText.setText("0.00");
        cText.setText("0.00");
        kText.setText("0.00");
        
        //initialize the labels
        fLabel = new JLabel("Fahrenheit");
        cLabel = new JLabel("Celsius");
        kLabel = new JLabel("Kelvin");
        
        //Load the listener
        button.addActionListener(buttonListener()); 
        
        //load the panel
        panel.add(warning);
        panel.add(fLabel);
        panel.add(fText);
        panel.add(cLabel);
        panel.add(cText);
        panel.add(kLabel);
        panel.add(kText);
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
                String fInput = fText.getText();
                String cInput = cText.getText();
                String kInput = kText.getText();
                   
                //test if any of the inputs were not numbers
                try {
                    Double.parseDouble(fInput);
                } catch (Exception m) {
                    fText.setText("ERROR");
                }
                try {
                    Double.parseDouble(cInput);
                } catch (Exception m) {
                    cText.setText("ERROR");
                }
                try {
                    Double.parseDouble(kInput);
                } catch (Exception m) {
                    kText.setText("ERROR");
                }
                
                //convert input strings to doubles
                double fTemp = Double.parseDouble(fInput);
                double cTemp = Double.parseDouble(cInput);
                double kTemp = Double.parseDouble(kInput);
                
                //compare to old value, if it has changed, calculate the new value
                //if result = 0 they are equal, otherwise 
                //set the old value to the new value and convert the other temp systems.
                //If multiple entries are made at once, it will give results based on which
                //is caught first in the conditional block, F -> C -> K. Entering more than one per 
                //conversion won't be detremental, but you may not get the results you expect.
                if (Double.compare(oldF, fTemp) != 0){
                    oldF = fTemp; 
                    oldC = (fTemp - 32.0) * (5.0 / 9.0); //convert F to C
                    oldK = (fTemp + 459.67) * (5.0 / 9.0); //convert F to K
                }//if Celsius has changed, calculate its conversions
                else if(Double.compare(oldC, cTemp) != 0){
                    oldF = (cTemp * (9.0 / 5.0)) + 32.0 ; //convert C to F
                    oldC = cTemp;
                    oldK = cTemp + 273.15; //convert C to K
                }//if Kelvin has changed, calculate its conversions
                else if(Double.compare(oldK, kTemp) != 0){
                    oldF = (kTemp * (9.0 / 5.0)) - 459.67; //convert K to F
                    oldC = kTemp - 273.15; //convert K to C
                    oldK = kTemp;
                }
                
                //create strings out of temps to display
                String fStr = String.format("%.2f", oldF);
                String cStr = String.format("%.2f", oldC);
                String kStr = String.format("%.2f", oldK);
                
                //change the text fields to display the new converted values
                fText.setText(fStr);
                cText.setText(cStr);
                kText.setText(kStr);
            }
        };
        
        return listener;
    }   
}