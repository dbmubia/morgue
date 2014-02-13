/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komponenMakeOver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Range_Rover_Sport
 */
public class tablepanelmakeover extends JScrollPane{
private Image gam;
   

    public tablepanelmakeover() {
        setOpaque(true);
        gam=new ImageIcon(getClass().getResource("/images/bluebg.jpg")).getImage();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D)g.create();
        gd.drawImage(gam, 0,0,getWidth(),getHeight(),null);
        gd.dispose();
    }

}
