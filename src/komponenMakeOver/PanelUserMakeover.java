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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Njihia
 */
public class PanelUserMakeover extends JPanel{
    
    
    private static java.util.Date activeDate = new java.util.Date();
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
    public static String date = sdf.format(activeDate) ;
    private Image gam;
    private JTextField txtUserID=new JTextField();
    private JTextField txtUserName=new JTextField();
        JLabel dates=new JLabel();
        JLabel year=new JLabel();
        JLabel lbhour=new JLabel();
        JLabel userid;
        JLabel username;
        JLabel period;
        
    public PanelUserMakeover() {
        motuary.Data user=new motuary.Data();
        setOpaque(true);
        
         String UserID;
         String UserName;       
         UserID = user.getUserID().trim();
         UserName = user.getUserName().trim(); 
                
                
                txtUserID.setText(UserID.toString().trim());
                txtUserName.setText(UserName.toString().trim());             
                dates.setText(date);    
                setTime();
              
                year.setText(user.getActivePeriod());
                
                
                txtUserID.setBounds(60, 1, 100, 25);
                txtUserID.setBorder(null);
                txtUserID.setMargin(new Insets(4, 1, 1, 1));
                txtUserID.setBackground(Color.DARK_GRAY);
                txtUserID.setForeground(Color.BLACK);
                txtUserID.setHorizontalAlignment(txtUserID.CENTER);
      
                txtUserID.setEnabled(false);
                
                txtUserName.setBounds(630, 1, 200, 25);
                txtUserName.setBorder(null);
                txtUserName.setMargin(new Insets(1, 4, 1, 1));
                txtUserName.setBackground(Color.DARK_GRAY);
                txtUserName.setForeground(Color.BLACK);
                txtUserName.setHorizontalAlignment(txtUserName.CENTER);
                txtUserName.setEnabled(false);
                
                
                dates.setBounds(1160, 1, 100, 25);
                dates.setBorder(null);
                dates.setForeground(Color.DARK_GRAY);
                dates.setEnabled(false);
                
                userid=new JLabel();
                userid.setText("User ID :");
                userid.setForeground(Color.LIGHT_GRAY);
                userid.setBounds(5, 1,50, 25);
                
                username=new JLabel();
                username.setText("Username :");
                username.setForeground(Color.LIGHT_GRAY);
                username.setBounds(550, 1,70, 25);
                
                period=new JLabel();
                period.setText("Date :");
                period.setForeground(Color.LIGHT_GRAY);
                period.setBounds(1090, 1,100, 25);
                
                lbhour=new JLabel();
                lbhour.setBounds(1290, 1, 100, 25);
                lbhour.setForeground(Color.lightGray);
                lbhour.setBackground(Color.LIGHT_GRAY);
                
                
                
               
                setLayout(null);
                setBorder(null);
                add(txtUserName);
                add(dates);
                add(lbhour);
                add(txtUserID);
                add(userid);
                add(username);
                add(period);
                
              
        gam=new ImageIcon(getClass().getResource("/images/background.png")).getImage();
    }
 
    void setTime(){
	ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            String zero_hour = "", zero_minute = "", zero_second = "";    	   
            java.util.Date dateTime = new java.util.Date();
            int int_hour = dateTime.getHours();
            int int_minute = dateTime.getMinutes();
	    int int_second = dateTime.getSeconds();    	    
            if (int_hour <= 9) zero_hour = "0";
            if (int_minute <= 9) zero_minute = "0";     
            if (int_second <= 9) zero_second = "0";        
	    String hour = zero_hour + Integer.toString(int_hour);
            String minute = zero_minute + Integer.toString(int_minute);
            String second = zero_second + Integer.toString(int_second);        
            lbhour.setText(hour + ":" + minute + ":" + second + " ");
            }
   	};
    	new Timer(1000, taskPerformer).start();
    }
    
    public static String returndate(){
    
    return date;
    }
     

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D)g.create();
        gd.drawImage(gam, 0,0,getWidth(),getHeight(),null);
        gd.dispose();
    }

    
}
