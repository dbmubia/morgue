/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komponenMakeOver;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author njihia
 */
public class LabelMakeOver extends JLabel{

    public LabelMakeOver() {
        
       
        setForeground(new Color(186,190,198));
        setFont(new Font("Lucida Sans", Font.BOLD, 16));
        setBounds(getX(), getY(), 150, 50);
        
        
        
    }
    
    
    
}
