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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JToolBar;

/**
 *
 * @author Njihia
 */
public class toolbarMakeOver extends JToolBar{

    public boolean over;
    public boolean press;

    public Paint paint;
    public Shape shape;

    public Paint glass;
    public Paint glass2;
    public toolbarMakeOver() {
        
        setOpaque(true);
        setBorderPainted(false);
        setBackground(new Color(61,96,121));

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                 setOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOver(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setPress(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setPress(false);
            }
        });

    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
	 this.over = over;
	 repaint();
    }

    public boolean estPress() {
	 return press;
    }

    public void setPress(boolean tekan) {
	 this.press = press;
	 repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gr=(Graphics2D)g.create();


        paint =new GradientPaint(0,0,new Color(1F,1F,1F,0F),0,getHeight(),new Color(1F,1F,1F,0.2F));
        shape =new Rectangle2D.Double(0, 0, getWidth(), getHeight());

        if(isOver()){
            glass =new GradientPaint(0,0,new Color(1F,1F,1F,0.3F),0,getHeight(),new Color(1F,1F,1F,0.3F));

        }
        else{
            glass =new GradientPaint(0,0,new Color(1F,1F,1F,0.3F),0,getHeight(),new Color(1F,1F,1F,0.3F));
        }

        if(estPress()){
            glass2 =new GradientPaint(0,0,new Color(1F,1F,1F,0.3F),0,getHeight(),new Color(1F,1F,1F,0.3F));
        }
        else{
            glass2 =new GradientPaint(0,0,new Color(1F,1F,1F,0.2F),0,getHeight(),new Color(1F,1F,1F,0F));
        }

        gr.setPaint(paint);


        super.paintComponent(g);

        gr.setPaint(glass);
        gr.fill(shape);

        gr.setPaint(glass2);
        gr.fill(shape);

        gr.dispose();
    }


        
        
        
    }
    
    
 