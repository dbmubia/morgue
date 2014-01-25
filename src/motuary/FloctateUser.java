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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Njihia
 */
public class FloctateUser extends JDialog{
    
    private JComboBox cmbSearch;
    private JButton cmdSearch;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;
    private JTable tbUser;
    private JTextField txtKeyword;
    
    
    
    Dimension display=Toolkit.getDefaultToolkit().getScreenSize();
    
    
    transMode mode = new transMode();    
    String[] strJdl = {"User ID","User name"};
    DefaultTableModel tabMode;   
    
    Object userID;
    Object userName;
    
        public String getUserID()
    {
        if(userID==null)
        {
           return "";   
        }
        else
        {
           return userID.toString().trim();            
        }         
    }
    
    public String getUserName()
    {
         if(userName==null)
         {
           return "";   
         }
         else
         {
           return userName.toString().trim();            
         }
    }

    public FloctateUser() {
        
       mode.setTransMode(transMode.typeOfTransMode.Wait);
       tabMode = new DefaultTableModel(null,strJdl)
       {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };    
       initial();
       fillTable("");
       setTitle("Locate User");
       setAlwaysOnTop(true);
       setModal(true);
       setResizable(false);
       setBounds(display.width-900, 50,370,display.height-300);
        add(jPanel2);
        setBackground(new Color(61,96,121));
       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      
    }
    
    void fillTable(String keyword)
    {
        String SQL = "";
        SQL = "SELECT UserID, UserName FROM masteruser ";
        if(!keyword.equals(""))
        {
            if(cmbSearch.getSelectedIndex()==0)
            {
                SQL += " WHERE UserID LIKE '%" + keyword + "%'";
            }
            else
            {
                SQL += " WHERE UserName LIKE '%" + keyword + "%'";
            }
        }
        SQL += " ORDER BY UserID";
        tabMode.setRowCount(0);
        try{
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next())
            {
                String ID = rs.getString(1);
                String Name = rs.getString(2);
                String[] data = {ID,Name};
                tabMode.addRow(data);
            }
            Data close = new Data();
            close.closingConnection (cn,st,rs);
            close = null;
        }
        catch(SQLException e)
        {
            
        }        
    }
      public void initial(){
          
          ButtonListener listener=new ButtonListener();
          
          
          txtKeyword=new komponenMakeOver.textfieldMakeover();
          txtKeyword.setBounds(100, 10, 150, 30);
          txtKeyword.setRequestFocusEnabled(true);
          txtKeyword.setForeground(new Color(186,190,198));
          txtKeyword.setFont(new Font("Lucida Sans", Font.BOLD, 14));
          
          tbUser=new JTable();
          tbUser.setModel(tabMode);
          tbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUserMouseClicked(evt);
            }
        });
          
          jScrollPane2=new JScrollPane();
          jScrollPane2.setBorder(null);
          jScrollPane2.setBounds(10, 100, 340, 320);
          jScrollPane2.setViewportView(tbUser);
          
          
          cmbSearch=new JComboBox();
          cmbSearch.setBorder(null);
          cmbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "User ID", "User Name" }));
          cmbSearch.setBounds(100, 50, 150, 30);
          
          cmdSearch=new komponenMakeOver.buttonMakeOverRectangle();
          cmdSearch.setText("Find");
          cmdSearch.setForeground(new Color(186,190,198));
          cmdSearch.setIcon(new ImageIcon("src/images/SEARCH.png"));
          cmdSearch.setBounds(260, 10, 100, 70);
          
        jLabel6=new JLabel();
        jLabel6.setText("Keyword :");
        jLabel6.setForeground(new Color(186,190,198));
        jLabel6.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        jLabel6.setBounds(10, 10, 100, 30);
        
        
        jLabel7=new JLabel();
        jLabel7.setText("Base on :");
        jLabel7.setForeground(new Color(186,190,198));
        jLabel7.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        jLabel7.setBounds(10, 40, 100, 50);
        
        
        jPanel2=new komponenMakeOver.panelmakeOver();
        jPanel2.setLayout(null);
        jPanel2.add(jLabel6);
        jPanel2.add(jLabel7);
        jPanel2.add(cmdSearch);
        jPanel2.add(cmbSearch);
        jPanel2.add(jScrollPane2);
        jPanel2.add(txtKeyword);
        
          
      
      
      
      
      
      }
      
      
      
    private class ButtonListener implements ActionListener{
        
       public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==cmdSearch){ 
                            
                    fillTable(txtKeyword.getText().trim());;}
				
		}
    
    
    };
   private void tbUserMouseClicked(java.awt.event.MouseEvent evt) {
        userID = tbUser.getModel().getValueAt(tbUser.getSelectedRow(), 0);
        userName = tbUser.getModel().getValueAt(tbUser.getSelectedRow(), 1);        
        setVisible (false);
        dispose();
}   
      
      
    
}
