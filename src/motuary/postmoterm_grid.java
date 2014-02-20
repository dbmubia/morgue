/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motuary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Range_Rover_Sport
 */
public class postmoterm_grid extends JInternalFrame {

    private JTabbedPane tabs ;
    private JPanel bio;
    private  JPanel Kin;

    public postmoterm_grid(){
        
     super("Admission", false, true, false, true);
        
    initial();
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();     
    
    setBackground(new Color(61, 96, 121));
    
    setBounds(screen.width - 1200, 50, 1000, screen.height - 270); 
    
    setClosable(true);
    getContentPane().add(tabs);
    setVisible(true);
    }
    
    private void initial(){

        
  
    String tabButtonCss = "margin:0;width:100px;height:10px;border-radius:3px;padding:10px;text-align:center;border:none;";   
        
    tabs = new JTabbedPane();
    
    bio = new komponenMakeOver.panelmakeOver();
    
    Kin = new JPanel();
    
    tabs.add(generateHtml("Bio Information",tabButtonCss),bio);
    tabs.add("   Kin Info    ",Kin);

   pack();
   
    }
    
   public static String  generateHtml(String tabButtonLabel,String style) {
        /*@@Generates HTML for the tab button when the button label is given*/
        String ret = "<html><body style = '"+style+"'>"+tabButtonLabel+"</body></html>";
        return ret;
    }
    
    
}