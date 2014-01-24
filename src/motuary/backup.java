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
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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
 * @author Aladeen
 */
public class backup extends JInternalFrame{
    
    private JButton btnCancel;
    private JButton btnbackup;
    private JButton btnchoose;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField txtbackuppath;
    private JTextField txtdatabase;
    private JTextField txtpassword;
    private JTextField txtusername;
    private JLabel header;
    private JLabel hdimage;
    private JButton hd;
    
    
    
    
    private JPanel container;
    
    
    
    Dimension display=Toolkit.getDefaultToolkit().getScreenSize();
    
    

    public backup() {
        
        
      initial();
      
      setBounds(display.width-900, 50,370,display.height-300);
      setBackground(new Color(61,96,121));
      add(container);
      
      BasicInternalFrameTitlePane titlePane =(BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this .getUI()).  
      getNorthPane();  
      this.remove(titlePane);
        
        
        
        
    }
    
    public void initial(){
        
        
        
    ButtonListener listner=new ButtonListener();
    
     hdimage=new JLabel(new ImageIcon("src/images/Bimage.png"));
     hdimage.setBounds(2, 2, 32, 32);
        
     hd=new komponenMakeOver.buttonMakeOverRectanglelogin();
     hd.setBounds(0, 0, 380,32 );
        
     header=new JLabel();
     header.setText("Perfom Backup Operations");
     header.setForeground(new Color(242,242,189));
     header.setFont(new Font("Lucida Sans", Font.BOLD, 16));
     header.setBounds(70, 0, 300, 30);
    
 
        
    jLabel1=new JLabel();
    jLabel1.setText("UserName :");
    jLabel1.setForeground(new Color(186,190,198));
    jLabel1.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    jLabel1.setBounds(10, 40, 100, 50);
    
    txtusername=new komponenMakeOver.textfieldMakeover();
    txtusername.setBounds(115, 40,230, 50);
    txtusername.setForeground(new Color(186,190,198));
    txtusername.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    
    
    
    jLabel2=new JLabel();
    jLabel2.setText("Password :");
    jLabel2.setForeground(new Color(186,190,198));
    jLabel2.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    jLabel2.setBounds(10, 100, 200, 50);
    
    
    txtpassword=new komponenMakeOver.passwordMakeOver();
    txtpassword.setBounds(115, 100, 230, 50);
    txtpassword.setForeground(new Color(186,190,198));
    txtpassword.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    
    
    
    jLabel3=new JLabel();
    jLabel3.setText("Database :");
    jLabel3.setForeground(new Color(186,190,198));
    jLabel3.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    jLabel3.setBounds(10, 170, 100, 50);
    
    txtdatabase=new komponenMakeOver.textfieldMakeover();
    txtdatabase.setBounds(115, 170, 230, 50);
    txtdatabase.setForeground(new Color(186,190,198));
    txtdatabase.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    
    
    
    jLabel4=new JLabel();
    jLabel4.setText("Backup to :");
    jLabel4.setForeground(new Color(186,190,198));
    jLabel4.setFont(new Font("Lucida Sans", Font.BOLD, 16));
    jLabel4.setBounds(10, 230, 200, 50);
    
    
    txtbackuppath=new komponenMakeOver.textfieldMakeover();
    txtbackuppath.setBounds(115, 230, 120, 50);
    txtbackuppath.setForeground(new Color(186,190,198));
    txtbackuppath.setFont(new Font("Lucida Sans", Font.BOLD, 16));
   
    
    btnchoose=new komponenMakeOver.buttonMakeOverRectangle();
    btnchoose.setText("Path");
    btnchoose.setForeground(new Color(186,190,198));
    btnchoose.setIcon(new ImageIcon("src/images/SEARCH.png"));
    btnchoose.setBounds(245, 230, 100, 50);
    btnchoose.addActionListener(listner);
    
    
    
    
    btnbackup=new komponenMakeOver.buttonMakeOverRectangle();
    btnbackup.setText("Backup");
    btnbackup.setForeground(new Color(186,190,198));
    btnbackup.setIcon(new ImageIcon("src/images/Bimage.png"));
    btnbackup.setBounds(115, 300, 115, 50);
    btnbackup.addActionListener(listner);
    
    
    btnCancel=new komponenMakeOver.buttonMakeOverRectangle();
    btnCancel.setText("Cancel");
    btnCancel.setForeground(new Color(186,190,198));
    btnCancel.setIcon(new ImageIcon("src/images/cancelB.png"));
    btnCancel.setBounds(230, 300, 115, 50);
    btnCancel.addActionListener(listner);
    
    
    
    container=new komponenMakeOver.panelmakeOver();
    container.setLayout(null);
    container.add(txtbackuppath);
    container.add(txtdatabase);
    container.add(txtusername);
    container.add(txtpassword);
    container.add(jLabel1);
    container.add(jLabel2);
    container.add(jLabel3);
    container.add(jLabel4);
    container.add(btnCancel);
    container.add(btnbackup);
    container.add(btnchoose);
    container.add(hd);
    container.add(hdimage);
    container.add(header);
    
    
    }
    
    
    private class ButtonListener implements ActionListener{
        
       public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==btnbackup){ 
                            
                            btnbackupActionPerformed(e);}
				
			else if(e.getSource()==btnCancel){
                        
                        setVisible(false);
                        dispose();;
                        }
                
                        else if(e.getSource()==btnchoose){
                        
                        txtbackuppath.setText(getBackUpPath());
                        }
		}
    
    
    };
    
    private void btnbackupActionPerformed(java.awt.event.ActionEvent evt) { 
        
        String backuppath=txtbackuppath.getText();
        String Database =txtdatabase.getText();
        String Password =txtpassword.getText();
        String user=txtusername.getText();
        BackupCon b = new BackupCon();
   try
  {
       byte[] data = b.getData("localhost", "3306", user,   Password, Database).getBytes();
       File filedst = new File(backuppath+"\\"+Database+".zip");
       FileOutputStream dest = new FileOutputStream(filedst);
       ZipOutputStream zip = new ZipOutputStream(
       new BufferedOutputStream(dest));
       zip.setMethod(ZipOutputStream.DEFLATED);
       zip.setLevel(Deflater.BEST_COMPRESSION);
       zip.putNextEntry(new ZipEntry("data.sql"));
       zip.write(data);
       zip.close();
       dest.close();
      JOptionPane.showMessageDialog(null, "Back Up Successfully."+"\n"+"For Database: "+Database+"\n        "+"On Dated: ","Database BackUp Wizard",JOptionPane.INFORMATION_MESSAGE);

   }catch (Exception ex){
    JOptionPane.showMessageDialog(null, "Back Up Failed."+"\n"+"For Database: "+Database+"\n "+"On     Dated: ","Database BackUp Wizard",JOptionPane.INFORMATION_MESSAGE);
    ex.printStackTrace();
  }

    }    
        public static String getBackUpPath() {

         String backUpPath = "";
         JFileChooser fc = null;
         if (fc == null) {
                fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setAcceptAllFileFilterUsed(false);
        }
        int returnVal = fc.showDialog(null, "Open");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            backUpPath = file.getAbsolutePath();
        }
       return backUpPath;
}
}
