/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komponenMakeOver;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComboBox;

/**
 *
 * @author Codesmith
 */
public class comboboxMakeOver extends JComboBox<Object>{
  public boolean over;
    public boolean press;

    public Paint paint;
    public Shape shape;

    public Paint glass;
    public Paint glass2;
    
    public comboboxMakeOver() {
        
        
     setOpaque(true);
     setBorder(null);
       
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gr=(Graphics2D)g.create();


          paint =new GradientPaint(0,0,new Color(1F,1F,1F,0.1F),0,getHeight(),new Color(1F,1F,1F,0.1F));
          shape = new Rectangle2D.Double(getX(), getY(), getWidth(),getHeight());
//

        gr.setPaint(paint);


        super.paintComponent(g);

//        gr.setPaint(glass);
        gr.fill(shape);

//        gr.setPaint(glass2);
//        gr.fill(shape);

        gr.dispose();
    }

    
    
    
}
