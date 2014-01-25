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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Njihia
 */
public class FmasterUserFunctions extends JInternalFrame{
    
    DefaultTableModel tabMode;
    
    private JCheckBox chkAdd;
    private JCheckBox chkDelete;
    private JCheckBox chkModify;
    private JCheckBox chkView;
    private JButton cmdCancel;
    private JButton cmdExit;
    private JButton cmdLocateUser;
    private JButton cmdSave;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JTable tbFunction;
    public  JTextField txtUserID;
    public  JTextField txtUserName;
    private JPanel container;
    private JButton header;
    private JLabel head;
    private JLabel headImage;
    
     Dimension display=Toolkit.getDefaultToolkit().getScreenSize();
    

    public FmasterUserFunctions() {
        
         String[] strHeader = {"Function ID","Function Name","View","Add","Modify","Delete"};   
         tabMode = new DefaultTableModel(null,strHeader){
         public boolean isCellEditable(int row, int column)
         { 
             if(column <= 1)
             {
                 return false;
             }
             return true;
         }
         };
        initial();
        clearTextBox();
        
        setBackground(new Color(61,96,121));
        setBounds(300,30,display.width-800 ,display.height-300);
        add(container);
        
        //removing the tittlepane
      BasicInternalFrameTitlePane titlePane =(BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this .getUI()).  
      getNorthPane();  
      this.remove(titlePane);
        
    }
    
     void clearTextBox(){ 
        txtUserID.setText("");
        txtUserName.setText("");
    }
     
    void fillTable()
    {       
          tabMode.setRowCount(0);           
          Data User = new Data();
          String UserID;
          UserID = txtUserID.getText();          
          Object data01[] = {"MST-001","Master User", new Boolean(User.UserRight(UserID, "MST-001",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-001",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-001",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-001",Data.typeOfAction.Delete))};
          Object data02[] = {"MST-002","Master Function", new Boolean(User.UserRight(UserID, "MST-002",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-002",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-002",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-002",Data.typeOfAction.Delete))};
          Object data03[] = {"MST-003","Master Budget Group", new Boolean(User.UserRight(UserID, "MST-003",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-003",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-003",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-003",Data.typeOfAction.Delete))};
          Object data04[] = {"MST-004","Master Budget", new Boolean(User.UserRight(UserID, "MST-004",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-004",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-004",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-004",Data.typeOfAction.Delete))};
          Object data05[] = {"MST-005","Master Title", new Boolean(User.UserRight(UserID, "MST-005",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-005",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-005",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-005",Data.typeOfAction.Delete))};
          Object data06[] = {"MST-006","Master Employee", new Boolean(User.UserRight(UserID, "MST-006",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-006",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-006",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-006",Data.typeOfAction.Delete))};
          Object data07[] = {"TSK-001","Trx. Beginning Balance Budget", new Boolean(User.UserRight(UserID, "TSK-001",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "TSK-001",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "TSK-001",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "TSK-001",Data.typeOfAction.Delete))};
          Object data08[] = {"TSK-002","Trx. Budget Usage", new Boolean(User.UserRight(UserID, "TSK-002",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "TSK-002",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "TSK-002",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "TSK-002",Data.typeOfAction.Delete))};
          Object data09[] = {"TSK-003","Trx. Budget Transfer", new Boolean(User.UserRight(UserID, "TSK-003",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "TSK-003",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "TSK-003",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "TSK-003",Data.typeOfAction.Delete))};
          Object data10[] = {"TSK-004","Trx. End of Year", new Boolean(User.UserRight(UserID, "TSK-004",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "TSK-004",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "TSK-004",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "TSK-004",Data.typeOfAction.Delete))};
          Object data11[] = {"RPT-001","Report Master Budget", new Boolean(User.UserRight(UserID, "RPT-001",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "RPT-001",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "RPT-001",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "RPT-001",Data.typeOfAction.Delete))};
          Object data12[] = {"RPT-002","Report Budget Per Month", new Boolean(User.UserRight(UserID, "RPT-002",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "RPT-002",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "RPT-002",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "RPT-002",Data.typeOfAction.Delete))};
          Object data13[] = {"RPT-003","Report Budget Usage", new Boolean(User.UserRight(UserID, "RPT-003",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "RPT-003",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "RPT-003",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "RPT-003",Data.typeOfAction.Delete))};
          Object data14[] = {"RPT-004","Report Budget Transfer", new Boolean(User.UserRight(UserID, "RPT-004",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "RPT-004",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "RPT-004",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "RPT-004",Data.typeOfAction.Delete))};
          
          TableColumn chkLihat = tbFunction.getColumnModel().getColumn(2);    
          chkLihat.setCellEditor(tbFunction.getDefaultEditor(Boolean.class));  
          chkLihat.setCellRenderer(tbFunction.getDefaultRenderer(Boolean.class));          
                   
          TableColumn chkTambah = tbFunction.getColumnModel().getColumn(3);    
          chkTambah.setCellEditor(tbFunction.getDefaultEditor(Boolean.class));  
          chkTambah.setCellRenderer(tbFunction.getDefaultRenderer(Boolean.class));
          
          TableColumn chkUbah = tbFunction.getColumnModel().getColumn(4);    
          chkUbah.setCellEditor(tbFunction.getDefaultEditor(Boolean.class));  
          chkUbah.setCellRenderer(tbFunction.getDefaultRenderer(Boolean.class));
          
          TableColumn chkHapus = tbFunction.getColumnModel().getColumn(5);    
          chkHapus.setCellEditor(tbFunction.getDefaultEditor(Boolean.class));  
          chkHapus.setCellRenderer(tbFunction.getDefaultRenderer(Boolean.class));
            
          tbFunction.getColumnModel().getColumn(0).setPreferredWidth(70); 
          tbFunction.getColumnModel().getColumn(1).setPreferredWidth(180); 
          tbFunction.getColumnModel().getColumn(2).setPreferredWidth(55); 
          tbFunction.getColumnModel().getColumn(3).setPreferredWidth(55); 
          tbFunction.getColumnModel().getColumn(4).setPreferredWidth(55); 
          tbFunction.getColumnModel().getColumn(5).setPreferredWidth(55); 
                              
          tabMode.addRow(data01);
          tabMode.addRow(data02);
          tabMode.addRow(data03);
          tabMode.addRow(data04);
          tabMode.addRow(data05);
          tabMode.addRow(data06);
          tabMode.addRow(data07);
          tabMode.addRow(data08);
          tabMode.addRow(data09);
          tabMode.addRow(data10);
          tabMode.addRow(data11);  
          tabMode.addRow(data12);
          tabMode.addRow(data13);  
          tabMode.addRow(data14);
    }
      
    
    
   public void initial(){
       
       ButtonListener listener=new ButtonListener();
       
       header=new komponenMakeOver.buttonMakeOverRectanglelogin();
       header.setBounds(0, 0, 600, 32);
       
       
       head=new JLabel("Master Function Detail");
       head.setForeground(new Color(242,242,189));
       head.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       head.setBounds(150, 0, 300, 32);
       
       headImage=new JLabel(new ImageIcon("src/images/secur.png"));
       headImage.setBounds(0, 0, 32, 32);
       
       
       tbFunction=new JTable();
       tbFunction.setBorder(null);
       tbFunction.setModel(tabMode);
      
       
       jScrollPane1=new JScrollPane();
       jScrollPane1.setViewportView(tbFunction);
       jScrollPane1.setBorder(null);
       jScrollPane1.setBounds(10, 170, 540, 250);
       
       
       
       
       jLabel6=new JLabel();
       jLabel6.setText("User ID :");
       jLabel6.setForeground(new Color(186,190,198));
       jLabel6.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       jLabel6.setBounds(10, 40, 100, 50);
       
       
       txtUserID=new komponenMakeOver.textfieldMakeover();
       txtUserID.setEditable(false);
//       txtUserID.requestFocusInWindow();
       txtUserID.setForeground(new Color(186,190,198));
       txtUserID.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       txtUserID.setBounds(90, 50, 150, 30);
       
       txtUserName=new komponenMakeOver.textfieldMakeover();
       txtUserName.setEditable(false);
//       txtUserName.requestFocusInWindow();
       txtUserName.setForeground(new Color(186,190,198));
       txtUserName.setFont(new Font("Lucida Sans", Font.BOLD, 16));
       txtUserName.setBounds(370, 50, 180, 30);
       
       
       chkAdd=new JCheckBox();
       chkAdd.setText("Add");
       chkAdd.setBounds(10, 130, 100, 30);
       chkAdd.setBackground(new Color(74, 112, 139));
       chkAdd.setForeground(new Color(242,242,189));
       chkAdd.addActionListener(listener);
       
       chkDelete=new JCheckBox();
       chkDelete.setText("Delete");
       chkDelete.setBounds(110, 130, 100, 30);
       chkDelete.setBackground(new Color(74, 112, 139));
       chkDelete.setForeground(new Color(242,242,189));
       chkDelete.addActionListener(listener);
       
       chkModify=new JCheckBox();
       chkModify.setText("Modify");
       chkModify.setBounds(210, 130, 100, 30);
       chkModify.setBackground(new Color(74, 112, 139));
       chkModify.setForeground(new Color(242,242,189));
       chkModify.addActionListener(listener);
       
       chkView=new JCheckBox();
       chkView.setText("View");
       chkView.setBounds(310, 130, 100, 30);
       chkView.setBackground(new Color(74, 112, 139));
       chkView.setForeground(new Color(242,242,189));
       chkView.addActionListener(listener);
       
       cmdSave=new komponenMakeOver.buttonMakeOverRectangle();
       cmdSave.setText("Save");
       cmdSave.setForeground(new Color(186,190,198));
       cmdSave.setIcon(new ImageIcon("src/images/save.png"));
       cmdSave.setBounds(10, 90, 150, 30);
       cmdSave.addActionListener(listener);
       
       
       cmdCancel=new komponenMakeOver.buttonMakeOverRectangle();
       cmdCancel.setText("Cancel");
       cmdCancel.setForeground(new Color(186,190,198));
       cmdCancel.setIcon(new ImageIcon("src/images/cancel.png"));
       cmdCancel.setBounds(160,90, 150, 30);
       cmdCancel.addActionListener(listener);
       
       cmdExit=new komponenMakeOver.buttonMakeOverRectangle();
       cmdExit.setText("Exit");
       cmdExit.setForeground(new Color(186,190,198));
       cmdExit.setIcon(new ImageIcon("src/images/exit.png"));
       cmdExit.setBounds(310, 90, 150, 30);
       cmdExit.addActionListener(listener);
       
       cmdLocateUser=new komponenMakeOver.buttonMakeOverRectangle();
       cmdLocateUser.setText("search");
       cmdLocateUser.setForeground(new Color(186,190,198));
       cmdLocateUser.setIcon(new ImageIcon("src/images/SEARCH.png"));
       cmdLocateUser.setBounds(250, 50, 100, 30);
       cmdLocateUser.addActionListener(listener);
       
       container=new komponenMakeOver.panelmakeOver();
       container.setLayout(null);
       container.add(cmdExit);
       container.add(cmdLocateUser);
       container.add(cmdSave);
       container.add(cmdCancel);
       container.add(chkAdd);
       container.add(chkDelete);
       container.add(chkModify);
       container.add(chkView);
       container.add(jScrollPane1);
       container.add(jLabel6);
       container.add(txtUserID);
       container.add(txtUserName);
       container.add(head);
       container.add(headImage);
       container.add(header);
  
    } 
   
   public void locateUser(){
       
        FloctateUser frmOpen = new FloctateUser();       
        frmOpen.setBounds(display.width-900, 50,370,display.height-300);
        frmOpen.setVisible(true);         
        String pUserID = "";
        String pUserName = "";
        pUserID = frmOpen.getUserID();
        pUserName = frmOpen.getUserName();
        txtUserID.setText(pUserID.toString());
        txtUserName.setText(pUserName.toString());   
        if(!txtUserID.getText().equals("") || txtUserID.getText()!=null)
        {
            fillTable();
        }
   
   
   }
   
   public void chkViewActionPerformed(){
       
          int row = tabMode.getRowCount();                
          for(byte i=0; i<row; i++)
          {   
              tabMode.setValueAt(chkView.isSelected(),i, 2); 
          }
   
   }
   public void chkAddActionPerformed(){
       
          int row = tabMode.getRowCount();                
          for(byte i=0; i<row; i++)
          {   
              tabMode.setValueAt(chkAdd.isSelected(),i, 3); 
          }
   
   }
   
   public void chkModifyActionPerformed(){
       
       int row = tabMode.getRowCount();                
          for(byte i=0; i<row; i++)
          {   
              tabMode.setValueAt(chkModify.isSelected(),i, 4); 
          }
   
   
   }
   
   public void chkDeleteActionPerformed(){
   
       int row = tabMode.getRowCount();                
          for(byte i=0; i<row; i++)
          {   
              tabMode.setValueAt(chkDelete.isSelected(),i,5); 
          }
   
   
   }
    private boolean isDataCorrect()
    { 
        if(txtUserID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "User ID is still empty.","Warning",JOptionPane.OK_OPTION);            
            return false;
        }         
        return true;
    }  
   
   public void save(){
       
        Data data = new Data(); 
        String UserID;    
        UserID = data.getUserID().trim();       
        if(data.UserRight(UserID, "MST-002",Data.typeOfAction.Modify)==false)
        {
             JOptionPane.showMessageDialog(this, "You dont have right to add data.","Informasi",JOptionPane.OK_OPTION);
             return ;
        }
        ArrayList<String> SQLArray = new ArrayList<String>(); 
        int result = JOptionPane.showConfirmDialog(this,"Do you want to save ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION)
        {
            if(isDataCorrect()==true)
            {   
                String SQL = "DELETE FROM masterfunctiondetail WHERE UserID = '" + txtUserID.getText().trim() + "'";
                SQLArray.add(SQL);             
                double row = tabMode.getRowCount();                                    
                for(int i=0; i<row; i++)
                {                    
                    String functionID = (String)tabMode.getValueAt(i, 0);
                    Boolean canView = (Boolean)tabMode.getValueAt(i,2);
                    Boolean canAdd = (Boolean)tabMode.getValueAt(i,3);
                    Boolean canModify = (Boolean)tabMode.getValueAt(i,4);
                    Boolean canDelete = (Boolean)tabMode.getValueAt(i,5); 
                    
                    int canViewValue = canView==true ? 1 : 0;
                    int canAddValue = canAdd==true ? 1 : 0;
                    int canModifyValue = canModify==true ? 1 : 0;
                    int canDeleteValue = canDelete==true ? 1 : 0;                    
                    SQL = "INSERT INTO masterfunctiondetail VALUES('" + txtUserID.getText().trim() + "', '" + functionID.trim() + "', " + canViewValue + "," + canAddValue + "," + canModifyValue + ", " + canDeleteValue + ")";
                    SQLArray.add(SQL); 
                }
                data.ExecuteSQL(SQLArray);
                data = null;
                clearTextBox();
                tabMode.setRowCount(0); 
           }  
        }          
   
   }
   
   
   
   private class ButtonListener implements ActionListener{
       
       
       public void actionPerformed(ActionEvent e){
       
       if(e.getSource()==cmdSave){ 
                            
                            save();}
				
			    else if(e.getSource()==cmdLocateUser){
                        
                           locateUser();}
                           
                            else if(e.getSource()==cmdExit){
                            
                            
                            dispose();
                            setVisible(false);}
       
                            else if(e.getSource()==cmdCancel){
                            
                            clearTextBox();
                            tabMode.setRowCount(0);}
                            
                            else if(e.getSource()==chkAdd){
                            
                            
                            chkAddActionPerformed();}
                            
                            else if(e.getSource()==chkDelete){
                            
                            chkDeleteActionPerformed();}
       
                            else if(e.getSource()==chkModify){
                            
                            chkModifyActionPerformed();}
       
                            else if(e.getSource()==chkView){
                            
                            chkViewActionPerformed();}
       
       
       
       }
   
   
   
   
   
   
   };
    
}
