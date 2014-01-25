/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motuary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static motuary.backup.getBackUpPath;

/**
 *
 * @author Range_Rover_Sport
 */
public class postmotermrequest extends JInternalFrame {
    
    private JPanel holder;

    private JLabel topichd;   
    private JLabel hdimage;
    private JLabel admin_search;
    private JLabel deceasedname;
    private JLabel admissionno;
    private JLabel  date_of_arrival;
    private JLabel  time_o_a;
    private JLabel  requesters_name;
    private JLabel  requester_id;
    private JLabel  requester_tel_no;
    private JLabel  autopsy_date;
    private JLabel  autopsy_time;
    private JLabel nature_of_autopsy;
    private JLabel name_of_pathologist;
    
    
    

    private JTextField name_txt;
    private JTextField admin_txt;
    private JTextField doa_txt;
    private JTextField time_txt;
    private JTextField requester_txt;
    private JTextField reqid_txt;
    private JTextField admin_nosearchtxt;
    private JTextField req_tel_txt;
    private JTextField autopsy_date_txt;
    private JTextField auto_time;
    private JTextField pathologist_txt;
    
    private JButton btnCancel;
    private JButton btnbackup;
    private JButton searchbttn;
    private JButton hd;
    
     Dimension display=Toolkit.getDefaultToolkit().getScreenSize();
    
    public postmotermrequest(){
        
        initial();
        
     
     setBounds(display.width-1050, 50,800,display.height-300);
     setClosable(true);
     setBackground(new Color(61,96,121));
      add(holder);
    
    }
    
    public void initial(){
    
     ButtonListener listener=new ButtonListener();
     
     hd=new komponenMakeOver.buttonMakeOverRectanglelogin();
     hd.setBounds(0, 0, 800,32 ); 
     
     
     
     hdimage=new JLabel(new ImageIcon("src/images/Bimage.png"));
     hdimage.setBounds(2, 2, 32, 32);
     
     
     
     topichd = new JLabel("BOOK A POST MOTERM");
     topichd.setForeground(new Color(242,242,189));
     topichd.setFont(new Font("Lucida Sans", Font.BOLD, 16));
     topichd.setBounds(300, 0, 300, 30);
     
    admin_search=new JLabel();
    admin_search.setText("Enter Admin. No.");
    admin_search.setForeground(new Color(186,190,198));
    admin_search.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    admin_search.setBounds(200, 50, 150, 30);
    
    admin_nosearchtxt = new komponenMakeOver.textfieldMakeover();
    admin_nosearchtxt.requestFocusInWindow();
    admin_nosearchtxt.setForeground(new Color(186,190,198));
    admin_nosearchtxt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    admin_nosearchtxt.setBounds(350, 50, 150, 30);
    
    
       searchbttn=new komponenMakeOver.buttonMakeOverRectangle();
       searchbttn.setText("search");
       searchbttn.setForeground(new Color(186,190,198));
       searchbttn.setIcon(new ImageIcon("src/images/SEARCH.png"));
       searchbttn.setBounds(530, 50, 100, 30);
       searchbttn.addActionListener(listener);
    
     
    holder=new komponenMakeOver.panelmakeOver();
    holder.setLayout(null);
    holder.add(hd);
    holder.add(topichd);
    holder.add(hdimage);
    holder.add(admin_search);
    holder.add(admin_nosearchtxt);
    holder.add(searchbttn);
    
    
    
    
    }
    
    
    
      private class ButtonListener implements ActionListener{
        
       public void actionPerformed(ActionEvent e)
		{

    
    
    };
    
 }

}

