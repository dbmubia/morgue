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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Njihia
 */
public class FMaserUser extends JInternalFrame{
    
    
    private JComboBox cmbSearch;
    private JComboBox cmbStatus;
    private JButton cmdCancel;
    private JButton cmdDelete;
    private JButton cmdEdit;
    private JButton cmdExit;
    private JButton cmdNew;
    private JButton cmdSave;
    private JButton cmdSearch;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable tbUser;
    private JTextField txtKeyword;
    private JPasswordField txtPassword;
    private JTextField txtUserID;
    private JTextField txtUserName;
    private JPanel container;
    private JLabel hdimage;
    private JLabel header;
    private JButton hd;
    
    
    
    transMode mode = new transMode();    
    String[] strHeader = {"User ID","Nama User", "Status"};
    DefaultTableModel tabMode;
    Data user = new Data(); 
    String UserID;
    
    Dimension display=Toolkit.getDefaultToolkit().getScreenSize();

    public FMaserUser() {
        
         mode.setTransMode(transMode.typeOfTransMode.Wait);
        tabMode = new DefaultTableModel(null,strHeader) {
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
    };
       initial();
       UserID = user.getUserID().trim();
       clearTextBox();
       enableControls();
       fillTable("");
       setFrameIcon(new ImageIcon("src/images/admin.png"));
       setResizable(false);
       setBackground(new Color(61,96,121));
       setBounds(450,30,display.width-850 ,display.height-300);
       add(jPanel1);
        
        //removing the tittlepane
      BasicInternalFrameTitlePane titlePane =(BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this .getUI()).  
      getNorthPane();  
      this.remove(titlePane);
        
        
    }
    
   void clearTextBox(){
        txtUserID.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        cmbStatus.setSelectedIndex(0);
    }
    
    void fillTable(String kataKunci)
    {
        String SQL = "";
        SQL = "SELECT UserID, UserName, Status FROM masteruser ";
        if(!kataKunci.equals(""))
        {
            if(cmbSearch.getSelectedIndex()==0)
            {
                SQL += " WHERE userid LIKE '%" + kataKunci + "%'";
            }
            else
            {
                SQL += " WHERE username LIKE '%" + kataKunci + "%'";
            }
        }
        SQL += " ORDER BY UserID";
        tabMode.setRowCount(0);
        try
        {
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next())
            {
                String ID = rs.getString(1);
                String Name = rs.getString(2);
                String Status = rs.getString(3);
                String[] data = {ID,Name,Status};
                tabMode.addRow(data);
            }           
            Data close = new Data();
            close.closingConnection (cn,st,rs);        
        }
        catch(SQLException e)
        {
            
        }        
    }
     
    void enableControls()
    {
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
            txtUserID.setEnabled(false);
            txtUserName.setEnabled(false);
            txtPassword.setEnabled(false);
            cmbStatus.setEnabled(false);
            cmdNew.setEnabled(true);
            cmdExit.setEnabled(true);
            cmdEdit.setEnabled(false);
            cmdSave.setEnabled(false);
            cmdCancel.setEnabled(false);
            cmdDelete.setEnabled(false);
        }else            
            {
                 txtUserID.setEnabled(true);
                 txtUserName.setEnabled(true);
                 txtPassword.setEnabled(true);
                 cmbStatus.setEnabled(false);
                 cmdNew.setEnabled(false);
                 cmdExit.setEnabled(false);
                 cmdEdit.setEnabled(false);
                 cmdSave.setEnabled(true);
                 cmdCancel.setEnabled(true);
                 cmdDelete.setEnabled(false);
                 txtUserID.setFocusable(true);
                 if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
                 {
                      txtUserID.setEnabled(false);
                      cmdDelete.setEnabled(true);
                      cmbStatus.setEnabled(true);
                      txtUserName.requestFocus();
                 }
            }
    }
     
    
    public void initial(){
        
        
        ButtonListener listener=new ButtonListener();
        
        
        hd=new komponenMakeOver.buttonMakeOverRectanglelogin();
        hd.setBounds(0, 0, 510, 32);
        
        header=new JLabel("Add User");
        header.setForeground(new Color(242,242,189));
        header.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        header.setBounds(200, 0, 300, 32);
        
        hdimage=new JLabel(new ImageIcon("src/images/admin.png"));
        hdimage.setBounds(0, 0, 32, 32);
        
        
       txtUserID=new komponenMakeOver.textfieldMakeover();
       txtUserID.setEditable(false);
//       txtUserID.requestFocusInWindow();
       txtUserID.setForeground(new Color(186,190,198));
       txtUserID.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       txtUserID.setBounds(110, 40, 180, 30);
       
       txtUserName=new komponenMakeOver.textfieldMakeover();
       txtUserName.setEditable(false);
//       txtUserName.requestFocusInWindow();
       txtUserName.setForeground(new Color(186,190,198));
       txtUserName.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       txtUserName.setBounds(110, 80, 180, 30);
       
       txtPassword=new komponenMakeOver.passwordMakeOver();
       txtPassword.setBounds(110, 120, 180, 30);
       txtPassword.setForeground(new Color(186,190,198));
       txtPassword.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       
       txtKeyword=new komponenMakeOver.textfieldMakeover();
       txtKeyword.setForeground(new Color(186,190,198));
       txtKeyword.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       txtKeyword.setBounds(110, 240, 80, 30);
       
       cmbSearch=new JComboBox();
       cmbSearch.setBorder(null);
       cmbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "User ID", "User Name" }));
       cmbSearch.setSelectedIndex(1);
       cmbSearch.setBounds(380, 240, 100, 30);
       
       cmbStatus=new JComboBox();
       cmbStatus.setBorder(null);
       cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "In-Active" }));
       cmbStatus.setAlignmentX(CENTER_ALIGNMENT);
       cmbStatus.setAlignmentY(CENTER_ALIGNMENT);
       cmbStatus.setBounds(110, 160, 180, 30);
       
       jLabel2=new JLabel();
       jLabel2.setText("User name :");
       jLabel2.setForeground(new Color(186,190,198));
       jLabel2.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       jLabel2.setBounds(10, 70, 100, 50);
       
       jLabel3=new JLabel();
       jLabel3.setText("User id :");
       jLabel3.setForeground(new Color(186,190,198));
       jLabel3.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       jLabel3.setBounds(10, 30, 100, 50);
       
       jLabel4=new JLabel();
       jLabel4.setText("Keyword :");
       jLabel4.setForeground(new Color(186,190,198));
       jLabel4.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       jLabel4.setBounds(10, 230, 100, 50);
       
       jLabel5=new JLabel();
       jLabel5.setText("Based on :");
       jLabel5.setForeground(new Color(186,190,198));
       jLabel5.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       jLabel5.setBounds(290, 230, 100, 50);
       
       jLabel6=new JLabel();
       jLabel6.setText("Password :");
       jLabel6.setForeground(new Color(186,190,198));
       jLabel6.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       jLabel6.setBounds(10, 110, 100, 50);
       
       jLabel7=new JLabel();
       jLabel7.setText("Status :");
       jLabel7.setForeground(new Color(186,190,198));
       jLabel7.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       jLabel7.setBounds(10, 150, 100, 50);
       
       cmdSearch=new komponenMakeOver.buttonMakeOverRectangle();
       cmdSearch.setText("Find");
       cmdSearch.setForeground(new Color(186,190,198));
       cmdSearch.setIcon(new ImageIcon("src/images/SEARCH.png"));
       cmdSearch.setBounds(200, 240, 80,30);
       
       cmdSave=new komponenMakeOver.buttonMakeOverRectangle();
       cmdSave.setText("Save");
       cmdSave.setForeground(new Color(186,190,198));
       //cmdSave.setIcon(new ImageIcon("src/images/save.png"));
       cmdSave.setBounds(160, 200, 80, 30);
       cmdSave.addActionListener(listener);
       
       
       cmdCancel=new komponenMakeOver.buttonMakeOverRectangle();
       cmdCancel.setText("Cancel");
       cmdCancel.setForeground(new Color(186,190,198));
       //cmdCancel.setIcon(new ImageIcon("src/images/cancel.png"));
       cmdCancel.setBounds(240,200, 80, 30);
       cmdCancel.addActionListener(listener);
       
       cmdExit=new komponenMakeOver.buttonMakeOverRectangle();
       cmdExit.setText("Exit");
       cmdExit.setForeground(new Color(186,190,198));
       cmdExit.setIcon(new ImageIcon("src/images/exit.png"));
       cmdExit.setBounds(400, 200, 80, 30);
       cmdExit.addActionListener(listener);
       
       
       cmdEdit=new komponenMakeOver.buttonMakeOverRectangle();
       cmdEdit.setText("Modify");
       cmdEdit.setForeground(new Color(186,190,198));
       //cmdEdit.setIcon(new ImageIcon("src/images/exit.png"));
       cmdEdit.setBounds(80, 200, 80, 30);
       cmdEdit.addActionListener(listener);
       
       
       cmdNew=new komponenMakeOver.buttonMakeOverRectangle();
       cmdNew.setText("Add");
       cmdNew.setForeground(new Color(186,190,198));
       cmdNew.setIcon(new ImageIcon("src/images/exit.png"));
       cmdNew.setBounds(0, 200, 80, 30);
       cmdNew.addActionListener(listener);
       
       
       
       cmdDelete=new komponenMakeOver.buttonMakeOverRectangle();
       cmdDelete.setText("Delete");
       cmdDelete.setForeground(new Color(186,190,198));
      // cmdDelete.setIcon(new ImageIcon("src/images/exit.png"));
       cmdDelete.setBounds(320, 200, 80, 30);
       cmdDelete.addActionListener(listener);
       
       
       tbUser=new JTable();
          tbUser.setModel(tabMode);
          tbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUserMouseClicked(evt);
            }
        });
          
          jScrollPane1=new JScrollPane();
          jScrollPane1.setBorder(null);
          jScrollPane1.setBounds(10, 300, 480, 130);
          jScrollPane1.setViewportView(tbUser);
       
       
       
        
        
       container=new JPanel(null);
       container.setBorder(null);
       container.setBounds(0, 200, 480, 50);
        
        
        
        
        jPanel1=new komponenMakeOver.panelmakeOver();
        jPanel1.setLayout(null);
        jPanel1.add(jScrollPane1);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel5);
        jPanel1.add(jLabel6);
        jPanel1.add(jLabel7);
        jPanel1.add(cmbSearch);
        jPanel1.add(cmbStatus);
        jPanel1.add(cmdCancel);
        jPanel1.add(cmdDelete);
        jPanel1.add(cmdEdit);
        jPanel1.add(cmdSearch);
        jPanel1.add(cmdExit);
        jPanel1.add(cmdNew);
        jPanel1.add(cmdSave);
        jPanel1.add(txtKeyword);
        jPanel1.add(txtPassword);
        jPanel1.add(txtUserID);
        jPanel1.add(txtUserName);
        jPanel1.add(hd);
        jPanel1.add(hdimage);
        jPanel1.add(header);
    
    
    
    }
    private class ButtonListener implements ActionListener{
        
       public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==cmdExit){ 
                            
                            dispose();
                       setVisible(false);}
				
			else if(e.getSource()==cmdNew){
                        
                        cmdNewActionPerformed(e);}
                        
                
                        else if(e.getSource()==cmdSave){
                        
                        cmdSaveActionPerformed(e);}
                
                        else if(e.getSource()==cmdDelete){
                        
                        cmdDeleteActionPerformed(e);}
                
                        else if(e.getSource()==cmdEdit){
                        
                        cmdEditActionPerformed(e);}
                
                
                        else if(e.getSource()==cmdCancel){
                        
                        mode.setTransMode(transMode.typeOfTransMode.Wait);
                        enableControls();        
                        clearTextBox();}
                
                       else if(e.getSource()==cmdSearch){
                        
                         fillTable(txtKeyword.getText().trim());}
                        
                        
		}
    
    
    };
    
  private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {
        if(!txtUserID.getText().equals(""))
        {
           mode.setTransMode(transMode.typeOfTransMode.EditRecord);
           enableControls();              
        }        
    }
  private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {
        Data User = new Data(); 
        if(User.UserRight(UserID, "MST-001",Data.typeOfAction.Add)==false)
        {
             JOptionPane.showMessageDialog(this, "You dont have righ to add data.","Information",JOptionPane.OK_OPTION);
             return;
        }
        user = null;
        mode.setTransMode(transMode.typeOfTransMode.AddRecord);
        clearTextBox();
        enableControls();
        txtUserID.requestFocus();
    }
  private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        int result = JOptionPane.showConfirmDialog(this,"Do you want to save data ?","Confirmation",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION)
        {
            if(isValidate()==true)
            {
                Data clsData = new Data();
                String SQL = "";
                if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
                {                    
                    SQL = "INSERT INTO masteruser VALUES('" + txtUserID.getText().trim() + "', '" + txtPassword.getText().trim() + "','" + txtUserName.getText().trim() + "', 'A')";
                    clsData.ExecuteSQL(SQL);                          
                }    
                else
                {
                     char status ='I';
                     if(cmbStatus.getSelectedIndex()==0)
                     {
                         status ='A';
                     }
                     SQL = "UPDATE masteruser SET UserName = '" + txtUserName.getText().trim() + "', Password = '" + txtPassword.getText().trim() + "', Status = '" + status + "' WHERE UserID = '" + txtUserID.getText().trim() + "'";
                     clsData.ExecuteSQL(SQL);    
                }
                clsData = null;
                mode.setTransMode(transMode.typeOfTransMode.Wait);
                enableControls(); 
                clearTextBox();
                fillTable("");
           }  
        }                  
    }
  private void tbUserMouseClicked(java.awt.event.MouseEvent evt) {
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
            Object userID = tbUser.getModel().getValueAt(tbUser.getSelectedRow(), 0);
            Object userName = tbUser.getModel().getValueAt(tbUser.getSelectedRow(), 1);
            Object status = tbUser.getModel().getValueAt(tbUser.getSelectedRow(), 2);

            Data clsData = new Data();
            String password = "";
            password = clsData.getFieldStringValue("masteruser", "UserID",userID.toString(),"Password");                  
            System.out.println(password);
            txtUserID.setText(userID.toString().trim());
            txtUserID.setForeground(new Color(186,190,198));
            txtUserName.setText(userName.toString().trim());
            txtUserName.setForeground(new Color(186,190,198));
            txtPassword.setText(password);
            txtPassword.setForeground(new Color(186,190,198));
            if(status.equals("A"))
            {
                cmbStatus.setSelectedIndex(0);
            }
            else
            {
                cmbStatus.setSelectedIndex(1);
            }           
            cmdEdit.setEnabled(true);
            clsData = null;
        }          
}
  private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {
            Data data = new Data(); 
            if(data.UserRight(UserID, "MST-001",Data.typeOfAction.Delete)==false)
            {
                JOptionPane.showMessageDialog(this, "You dont have right to delete data.","Information",JOptionPane.OK_OPTION);
                return;
            }        
            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete this User ID ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION)
            {           
                String SQL = "DELETE FROM masteruser WHERE UserID = '" + txtUserID.getText().trim() + "'"; 
                data.ExecuteSQL(SQL);             
                SQL = "DELETE FROM masterfunctiondetail WHERE UserID = '" + txtUserID.getText().trim() + "'";                
                data.ExecuteSQL(SQL);             
                data = null;
                mode.setTransMode(transMode.typeOfTransMode.Wait);
                enableControls(); 
                clearTextBox();
                fillTable("");                
            }         
    }
  private boolean isValidate()
    { 
        if(txtUserID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "User ID is still empty.","Warning",JOptionPane.OK_OPTION);            
            return false;
        } 
        if(txtUserName.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "User name is still empty.","Warning",JOptionPane.OK_OPTION);
            return false;
        } 
        if(txtPassword.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Password is still empty.","Warning",JOptionPane.OK_OPTION);
            return false;
        }
        
        if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
        {
             Data clsData = new Data();
             String Kode = "";
             Kode = clsData.getFieldStringValue("masteruser", "UserID",txtUserID.getText().trim(),"UserID");
             if(!Kode.equals(""))
             {
                JOptionPane.showMessageDialog(this, "User ID is already exists.","Warning",JOptionPane.OK_OPTION);                        
                return false;
             } 
             
             Kode = clsData.getFieldStringValue("masteruser", "UserName",txtUserName.getText().trim(),"UserName");
             if(!Kode.equals(""))
             {
                JOptionPane.showMessageDialog(this, "User name is already exists.","Peringatan",JOptionPane.OK_OPTION);                        
                return false;
             } 
        } 
        else
        {
            Data User = new Data(); 
            if(User.UserRight(UserID, "MST-001",Data.typeOfAction.Modify)==false)
            {
                JOptionPane.showMessageDialog(this, "You dont have right to modify data.","Information",JOptionPane.OK_OPTION);
                return false;
            }        
        }
        return true;
    }     
}
