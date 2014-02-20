/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motuary;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Range_Rover_Sport
 */
public class postmoterm_grid extends JFrame {

    private JTabbedPane tabs ;
    private JPanel bio;
    private  JPanel Kin;

    public postmoterm_grid(){
        
     super("tabbed pane sample");
        
    initial();
    setBounds(200, 200, 500, 300);
    setSize( 800, 600 );
    setBackground( Color.gray );
    
    getContentPane().add(tabs);
    setVisible(true);
    }
    
    private void initial(){

    tabs = new JTabbedPane();
    bio = new JPanel();
    this.setTitle("DRAG AND DROP SHIT");
    
    
    Kin = new JPanel();
    
    tabs.add("TAB MOJA",bio);
    tabs.add("TAB PILI",Kin);

   pack();
   
}
    
    public static void main (String [] args){
    postmoterm_grid triall = new postmoterm_grid();
    }
}