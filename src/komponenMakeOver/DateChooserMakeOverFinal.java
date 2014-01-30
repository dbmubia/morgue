/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komponenMakeOver;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author kogie
 */
public class DateChooserMakeOverFinal extends JXDatePicker{
    
   
    public Paint paint;
    public Shape shape;

    public Paint glass;
    public Paint glass2;
    private Image gam;

    public DateChooserMakeOverFinal() {
        
     this.addActionListener(new ActionListener(){
    
    public void actionPerformed(ActionEvent e) {

    getDate();
    SimpleDateFormat sdf = new
    SimpleDateFormat("dd/MM/yy");
    String st = sdf.format(getDate());
    setFormats(new
    SimpleDateFormat("dd/MM/yy"));

    }
    });   
     
  
     setOpaque(true);
     setBorder(null);
     setBackground(new Color(61,96,121));
     setFont(new Font("Lucida Sans", Font.BOLD, 14));
     setForeground(new Color(61,96,121));
     

     
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gr=(Graphics2D)g.create();


          paint =new GradientPaint(0,0,new Color(1F,1F,1F,0.1F),0,getHeight(),new Color(1F,1F,1F,0.1F));
          shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10);
//

        gr.setPaint(paint);


        super.paintComponent(g);


        gr.fill(shape);


        gr.dispose();
    }
    
    
    
    
}
