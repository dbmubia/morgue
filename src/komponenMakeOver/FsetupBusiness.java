/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komponenMakeOver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Aladeen
 */
public class FsetupBusiness extends JInternalFrame{
    
    private JLabel bussnesstitle;
    private JLabel location;
    private JTextField bussines;
    private JTextField local;
    private JButton save;
    private JButton modify;
    private JButton cancel;
    private JButton exit;
    private JPanel container;
    private JLabel box;
    private JTextField po;
    private JLabel town;
    private JTextField twn;
    
    Dimension display=Toolkit.getDefaultToolkit().getScreenSize();
    
    public FsetupBusiness() {
        
        
        initial();
        setBackground(new Color(61,96,121));
        setBounds(400,50,display.width-800 ,display.height-300);
        setLayout(null);
        add(container);
        
          //removing the tittlepane
      BasicInternalFrameTitlePane titlePane =(BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this .getUI()).  
      getNorthPane();  
      this.remove(titlePane);
        
    }
    
    public  void initial(){
        
    bussnesstitle=new JLabel();
    bussnesstitle.setText("Bussiness Tittle :");
    bussnesstitle.setForeground(new Color(186,190,198));
    bussnesstitle.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    bussnesstitle.setBounds(10, 50, 170, 50);
    
    
    location=new JLabel();
    location.setText("County :");
    location.setForeground(new Color(186,190,198));
    location.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    location.setBounds(10, 120, 100, 50);
    
    bussines=new komponenMakeOver.textfieldMakeover();
    bussines.setBounds(160, 50, 280, 50);
    bussines.setForeground(new Color(186,190,198));
    bussines.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    
    
    local=new komponenMakeOver.textfieldMakeover();
    local.setBounds(160, 120, 280, 50);
    local.setForeground(new Color(186,190,198));
    local.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    
    box=new JLabel();
    box.setText("P.O Box :");
    box.setForeground(new Color(186,190,198));
    box.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    box.setBounds(10, 190, 100, 50);
    
    town=new JLabel();
    town.setText("Town/City :");
    town.setForeground(new Color(186,190,198));
    town.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    town.setBounds(10, 260, 100, 50);
    
    po=new komponenMakeOver.textfieldMakeover();
    po.setBounds(160, 190, 280, 50);
    po.setForeground(new Color(186,190,198));
    po.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    
    twn=new komponenMakeOver.textfieldMakeover();
    twn.setBounds(160, 260, 280, 50);
    twn.setForeground(new Color(186,190,198));
    twn.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    
    
    
    modify=new komponenMakeOver.buttonMakeOverRectangle();
    modify.setText("Modify");
    modify.setForeground(new Color(186,190,198));
    modify.setIcon(new ImageIcon("src/images/modify.png"));
    modify.setBounds(140, 360, 130, 50);
    
    save=new komponenMakeOver.buttonMakeOverRectangle();
    save.setText("Save");
    save.setForeground(new Color(186,190,198));
    save.setIcon(new ImageIcon("src/images/save.png"));
    save.setBounds(10, 360, 130, 50);
    
    cancel=new komponenMakeOver.buttonMakeOverRectangle();
    cancel.setText("Cancel");
    cancel.setForeground(new Color(186,190,198));
    cancel.setIcon(new ImageIcon("src/images/cancel.png"));
    cancel.setBounds(270, 360, 130, 50);
    
    exit=new komponenMakeOver.buttonMakeOverRectangle();
    exit.setText("exit");
    exit.setForeground(new Color(186,190,198));
    exit.setIcon(new ImageIcon("src/images/exit.png"));
    exit.setBounds(400, 360, 130, 50);
    
    
    
    
    container=new  komponenMakeOver.panelmakeOver();
    container.setLayout(null);
    container.setBounds(0, 0, 1000, 1000);
    container.add(exit);
    container.add(cancel);
    container.add(save);
    container.add(modify);
    container.add(bussines);
    container.add(bussnesstitle);
    container.add(local);
    container.add(location);
    container.add(po);
    container.add(box);
    container.add(twn);
    container.add(town);
    
    
    
}
}