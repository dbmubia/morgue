/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komponenMakeOver;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author Njihia
 */
public class textfieldColdroomMakeover extends JTextField{

    public textfieldColdroomMakeover() {
        
        
        setForeground(new Color(186,190,198));
        setBackground(new Color(56, 56, 56));
        setHorizontalAlignment(CENTER);
        setFont(new Font("Lucida Sans", Font.BOLD, 16));
        setBorder(null);
        setEditable(false);
        
        
        
    }
    
    
    
    
}
