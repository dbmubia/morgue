/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motuary;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Aladeen
 */
public class authentification extends JFrame{
    
    //initiallization of components
    
    private JTextField uname;
    private  JPasswordField pass;
    private JButton logo2;
    private JButton log;
    private JButton can;
    private JLabel name;
    private JLabel password;
    private JLabel warning;
    private JLabel notice;
    private JPanel image;
    private JLabel noticeImage;
    private JLabel kufh;
    private JLabel p;
    private JButton trial;
   
    
    
    
   
    
    
     Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
     
     public authentification(){
     
      initial();
     
      setBounds(screen.width/3, screen.height/7, 430, 600);
      setUndecorated(true);
      setIconImage(new ImageIcon("src/images/coffin.png").getImage());
      setVisible(true);
     
      add(image);
     }
     public void initial(){
        ButtonListener listener=new ButtonListener();
        
        kufh=new JLabel(new ImageIcon("src/images/2.png"));
        kufh.setBounds(0,23,500,380 );
        
        
        p=new JLabel(new ImageIcon("src/images/logo.png"));
        p.setBounds(0,35, 408, 51);
        
        trial=new komponenMakeOver.buttonMakeOverRectanglelogin();
        trial.setBounds(0, 340, 500, 50);
        
        warning=new JLabel();
        warning.setBounds(80, 230, 32, 32);
        warning.setVisible(true);
        
        notice=new JLabel("Please enter correct username & password!!!!");
        notice.setForeground(new Color(186,190,198));
        notice.setBounds(45, 340, 400, 50);
        notice.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        
        noticeImage=new JLabel(new ImageIcon("src/images/helper.png"));
        noticeImage.setBounds(5, 355,32, 32);
        
        
        name=new JLabel();
        name.setText("User Id     :");
        name.setForeground(new Color(186,190,198));
        name.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        name.setBounds(30, 420, 150, 50);
        
        password=new JLabel();
        password.setText("Password :");
        password.setForeground(new Color(186,190,198));
        password.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        password.setBounds(30, 480, 150, 50);
        
        uname=new komponenMakeOver.textfieldMakeover();
        uname.requestFocusInWindow();
        uname.setForeground(new Color(186,190,198));
        uname.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        uname.setBounds(130, 420, 270, 50);
       
        
        
        pass=new komponenMakeOver.passwordMakeOver();
        pass.setForeground(new Color(186,190,198));
        pass.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        pass.setBounds(130, 480, 270, 50);
        
        
        log=new komponenMakeOver.buttonMakeOver();
        log.setForeground(new Color(186,190,198));
        log.setText("Login");
        log.setFont(new Font("Lucida Sans", Font.BOLD, 12));
        log.setBounds(130, 540, 130, 50);
        log.setIcon(new ImageIcon("src/images/male_user.png"));
        log.addActionListener(listener);
        
        
        can=new komponenMakeOver.buttonMakeOver();
        can.setForeground(new Color(186,190,198));
        can.setText("Cancel");
        can.setFont(new Font("Lucida Sans", Font.BOLD, 12));
        can.setIcon(new ImageIcon("src/images/cancel.png"));
        can.setBounds(270, 540, 130, 50);
        can.addActionListener(listener);
        
        image=new komponenMakeOver.panelmakeOver();
        image.setLayout(null);
        image.setBounds(0, 300, 500, 600);
        image.add(log);
        image.add(kufh);
        image.add(uname);
        image.add(pass);
        image.add(can);
        image.add(name);
        image.add(password);
        image.add(warning);
        image.add(p);
        image.add(notice);
        image.add(noticeImage);
        image.add(trial);
        
   
    
    
    }
       public void log(){
           Data login = new Data();
           String status = login.UserOK(uname.getText().trim(), pass.getText().trim());
           if (!status.equals("")) {
               
            
            JOptionPane.showMessageDialog(null,status,"Information",JOptionPane.OK_OPTION);
            
           
              } else {
            Data data = new Data();
            String UserName;
            data.setUserID(uname.getText().trim());
            
            UserName = data.getFieldStringValue("masteruser", "UserID", uname.getText().trim(), "UserName");
            data.setUserName(UserName);  
            data = null;
            
            dispose();
            
            MainForm menu = new MainForm();             
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();         
            menu.setBounds(0,0,screenSize.width, screenSize.height);
            menu.setVisible(true);
            
            //adding an icon into the tray
            
            final TrayIcon trayicon=new TrayIcon(new ImageIcon("src/images/home.png").getImage());
            final SystemTray tray = SystemTray.getSystemTray();
            try {
            tray.add(trayicon);
            } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            }

           
                  
        }
        }
       
       private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//LoginValidity();

			if(e.getSource()==log){ 
                            
                            log();}
				
			else if(e.getSource()==can){System.exit(0);}	
		}
	};
       
       
	
}
