

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Njihia
 */
public class FrmChangeUserPassword extends JInternalFrame{
    
    private JLabel userid;
    private JLabel password;
    private JLabel confirmPass;
    private JPanel container;
    private JTextField txtUserID;
    private JPasswordField txtPassword;
    private JPasswordField txConfirmationPassword;
    private JButton save;
    private JButton cancel;
    private JLabel header;
    private JLabel hdimage;
    private JButton hd;
    private JLabel notification;
    private JLabel notificationimage;
    
    
    
    Dimension screen=new Dimension();
    Dimension display=Toolkit.getDefaultToolkit().getScreenSize();
    

    public FrmChangeUserPassword() {
        
      super("Change Password");
      initial();
      Data userid = new Data();
      txtUserID.setText(userid.getUserID());
      setBounds(display.width-900, 50,370,display.height-300);
      setBackground(new Color(61,96,121));
      add(container);
      
      BasicInternalFrameTitlePane titlePane =(BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this .getUI()).  
      getNorthPane();  
      this.remove(titlePane);
      
        
    }
    
    
    private void initial(){
        
        Data dt=new Data();
        ButtonListener listner=new ButtonListener();
        
        notification=new JLabel("The system will automatically exit !!!");
        notification.setBounds(50, 250, 300, 50);
        notification.setForeground(new Color(242,242,189));
        notification.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        
        notificationimage=new JLabel(new ImageIcon("src/images/HELPER.png"));
        notificationimage.setBounds(10, 260, 32, 32);
        
        
        hdimage=new JLabel(new ImageIcon("src/images/changepass.png"));
        hdimage.setBounds(2, 2, 32, 23);
        
        hd=new komponenMakeOver.buttonMakeOverRectanglelogin();
        hd.setBounds(0, 0, 380,30 );
        
        header=new JLabel();
        header.setText("Change Password");
        header.setForeground(new Color(242,242,189));
        header.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        header.setBounds(110, 0, 200, 30);
        
        
        
        userid=new JLabel();
        userid.setText("USER ID      :");
        userid.setForeground(new Color(186,190,198));
        userid.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        userid.setBounds(10, 50, 100, 50);
        
    
        txtUserID=new komponenMakeOver.textfieldMakeover();
        txtUserID.setBounds(115, 50, 230, 50);
        txtUserID.setForeground(new Color(186,190,198));
        txtUserID.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        txtUserID.setEditable(false);
       
        
        
        confirmPass=new JLabel();
        confirmPass.setText("CONFIRM P :");
        confirmPass.setForeground(new Color(186,190,198));
        confirmPass.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        confirmPass.setBounds(10, 180, 100, 50);
        
        
        txConfirmationPassword=new komponenMakeOver.passwordMakeOver();
        txConfirmationPassword.setBounds(115, 180, 230, 50);
        txConfirmationPassword.setForeground(new Color(186,190,198));
        txConfirmationPassword.setFont(new Font("Lucida Sans", Font.BOLD, 16));
      
        
        password=new JLabel();
        password.setText("PASSWORD :");
        password.setForeground(new Color(186,190,198));
        password.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        password.setBounds(10, 120, 100, 50);
       
    
        txtPassword=new komponenMakeOver.passwordMakeOver();
        txtPassword.setBounds(115, 120, 230, 50);
        txtPassword.setForeground(new Color(186,190,198));
        txtPassword.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        
        
        
        save=new komponenMakeOver.buttonMakeOverRectangle();
        save.setText("Save");
        save.setForeground(new Color(186,190,198));
        save.setIcon(new ImageIcon("src/images/save.png"));
        save.setBounds(118, 370, 115, 50);
        save.addActionListener(listner);
       
        
        cancel=new komponenMakeOver.buttonMakeOverRectangle();
        cancel.setText("Cancel");
        cancel.setForeground(new Color(186,190,198));
        cancel.setIcon(new ImageIcon("src/images/cancel.png"));
        cancel.setBounds(223, 370, 115, 50);
        cancel.addActionListener(listner);
        
        
        
        container=new komponenMakeOver.panelmakeOver();
        container.setBounds(0, 20,display.width-18 ,display.height-95);
        container.setLayout(null);
        container.add(userid);
        container.add(txtUserID);
        container.add(save);
        container.add(cancel);
        container.add(header);
        container.add(hd);
        container.add(confirmPass);
        container.add(txConfirmationPassword);
        container.add(password);
        container.add(txtPassword);
        container.add(hdimage);
        container.add(notification);
        container.add(notificationimage);
                
       
    
    
    }
    
    private class ButtonListener implements ActionListener{
        
       public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==save){ 
                            
                            save();}
				
			else if(e.getSource()==cancel){
                        
                        cancel();
                        }	
		}
    
    
    };
    
    
    public void save(){
    if(txtPassword.getText().trim().equals(""))
      {
          JOptionPane.showMessageDialog(this,"Password is still empty.", "Notification",JOptionPane.OK_OPTION);
          return;
      }      
      if(txConfirmationPassword.getText().trim().equals(""))
      {
          JOptionPane.showMessageDialog(this,"Confirmation password is still empty.", "Notification",JOptionPane.OK_OPTION);
          return;
      }
      if(!txtPassword.getText().trim().equals(txConfirmationPassword.getText().trim()))
      {
          JOptionPane.showMessageDialog(this,"Password and confirmation password is diffirent.", "Notification",JOptionPane.OK_OPTION);
          return;
      }
      int jwb = JOptionPane.showConfirmDialog(this,"Do you want to change password ?","Notification",JOptionPane.YES_NO_OPTION);
      if(jwb==JOptionPane.YES_OPTION)
      {
         String SQL = "UPDATE masteruser set Password = '" + txtPassword.getText().trim() + "' WHERE UserID = '" + txtUserID.getText().trim() + "'";
         Data data = new Data();
         data.ExecuteSQL(SQL);
         data = null;
         JOptionPane.showMessageDialog(this,"Password has been changed.", "Notification",JOptionPane.OK_OPTION);         
         dispose();
         System.exit(0);
        
         setVisible(false);
      }      
    }
    
    public void cancel(){
    
        setVisible(false);
        dispose();
    
    
    }
}
