/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package motuary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Postmotermcontrol extends JInternalFrame implements ActionListener {

    public static JScrollPane CusTableJSP = new JScrollPane();
    public static JPanel JPContainer = new komponenMakeOver.panelmakeOver();
    public JLabel kpano;
    public static JTable JTCusTable;

    JTextField JHlptxt = new komponenMakeOver.textfieldMakeover();
    JLabel JLHelpText = new JLabel();

    JButton JBSearch = new komponenMakeOver.buttonMakeOver();
    JButton JBcheckjobcard = new JButton();
    JButton hd;
    JLabel hdimage;
    JButton JBReload = new JButton("Reload", new ImageIcon("src/images/reload.png"));
    JButton JBExit = new JButton("Exit", new ImageIcon("src/images/EXIT.png"));
    JButton JBApprove = new JButton("Approve", new ImageIcon("src/images/approve.png"));

    
    
    public static Statement stCus;
    public static Connection conne;

    public static ResultSet rsCus;

    private static String strSQL = "SELECT demo_admin.admin_no,demo_admin.names,demo_admin.admision_date,postmotermqueue.requester_name,postmotermqueue.requester_relation"
            + " FROM postmotermqueue,demo_admin"
            + " WHERE (postmotermqueue.admin_no = demo_admin.admin_no)";

    public JTextField enterdtxt;
    public static int rowNum = 0;
    public static int total = 0;

    public static String Content[][];

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    @SuppressWarnings("LeakingThisInConstructor")
    public Postmotermcontrol() throws SQLException {

        initial();
        setBackground(new Color(61, 96, 121));
        setBounds(screen.width - 1200, 50, 1000, screen.height - 270);
        setLayout(null);
        add(JPContainer);

        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        this.remove(titlePane);
    }

    private void initial() {
        //-- Add the CusTable
        Buttonswork listener = new Buttonswork();
        
        JTCusTable = CreateTable();
        CusTableJSP.getViewport().add(JTCusTable);
        CusTableJSP.setBounds(15, 100, 950, 250);

        //search place
        kpano = new JLabel("Enter Admin No. to locate");
        kpano.setBounds(220, 60, 170, 25);
        kpano.setFont(new Font("Candara", Font.BOLD, 14));
        kpano.setForeground(new Color(242, 242, 189));

        enterdtxt = new komponenMakeOver.textfieldMakeover();
        enterdtxt.setBounds(400, 60, 150, 25);

        //-- Add the JBSearch
        JBSearch.setText("Search");
        JBSearch.setIcon(new ImageIcon("src/images/search.png"));
        JBSearch.setBounds(590, 60, 120, 25);
        JBSearch.setFont(new Font("Dialog", Font.PLAIN, 12));
        JBSearch.setForeground(new Color(242, 242, 189));
        JBSearch.setMnemonic(KeyEvent.VK_S);
        JBSearch.addActionListener(listener);

        //-- Add the JBDelete
        JBcheckjobcard.setText("View Job Card");
        JBcheckjobcard.setIcon(new ImageIcon("src/images/c_report.png"));
        JBcheckjobcard.setBounds(100, 380, 140, 35);
        JBcheckjobcard.setFont(new Font("Dialog", Font.PLAIN, 12));
        JBcheckjobcard.setMnemonic(KeyEvent.VK_V);
        JBcheckjobcard.addActionListener(listener);

        //-- Add the JBReload
        JBReload.setBounds(350, 380, 150, 35);
        JBReload.setFont(new Font("Dialog", Font.PLAIN, 12));
        JBReload.setMnemonic(KeyEvent.VK_R);
        JBReload.addActionListener(listener);

        //Approve button
        JBApprove.setBounds(550, 380, 150, 35);
        JBApprove.setFont(new Font("Dialog", Font.PLAIN, 12));
        JBApprove.setMnemonic(KeyEvent.VK_R);
        JBApprove.addActionListener(listener);

        //-- Add the EXITBUTTON
        JBExit.setBounds(750, 380, 150, 35);
        JBExit.setFont(new Font("Dialog", Font.PLAIN, 12));
        JBExit.setMnemonic(KeyEvent.VK_R);
        JBExit.addActionListener(listener);

        hd = new komponenMakeOver.buttonMakeOverRectanglelogin();
        hd.setText("Click on any record to access the details in the buttons");
        hd.setForeground(new Color(242, 242, 189));
        hd.setBounds(0, 0, 1000, 32);

        //
        hdimage = new JLabel(new ImageIcon("src/images/Bimage.png"));
        hdimage.setBounds(2, 2, 32, 32);

        //End initialize variables
        //Start set the form properties     
        JPContainer.setLayout(null);
        JPContainer.setBounds(0, 0, 1000, 1000);
        JPContainer.add(hd);
        JPContainer.add(JBReload);
        JPContainer.add(JBcheckjobcard);
        JPContainer.add(JBSearch);
        JPContainer.add(hdimage);
        JPContainer.add(JBExit);
        JPContainer.add(kpano);
        JPContainer.add(CusTableJSP);
        JPContainer.add(enterdtxt);
        JPContainer.add(JBApprove);
    }

    private static JTable CreateTable() {
        String ColumnHeaderName[] = {"Admission", "Names", "Date", "Requester", "Relation"};

        try {
            ResultSet rs;
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement stCus = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rsCus = stCus.executeQuery(strSQL);

            total = 0;

            //Move to the last record
            rsCus.afterLast();

            //Get the current record position
            if (rsCus.previous()) {
                total = rsCus.getRow();
            }

            //Move back to the first record;
            rsCus.beforeFirst();

            if (total > 0) {
                Content = new String[total][5];
                while (rsCus.next()) {
                    Content[rowNum][0] = "" + rsCus.getString("admin_no");
                    Content[rowNum][1] = "" + rsCus.getString("names");
                    Content[rowNum][2] = "" + rsCus.getString("admision_date");      //
                    Content[rowNum][3] = "" + rsCus.getString("requester_name");
                    Content[rowNum][4] = "" + rsCus.getString("requester_relation");
                    rowNum++;
                }
            } else {
                Content = new String[0][5];
                Content[0][0] = " ";
                Content[0][1] = " ";
                Content[0][2] = " ";
                Content[0][3] = " ";
                Content[0][4] = " ";
            }

        } catch (Exception ee) {
            System.out.println(ee);
        }

        JTable NewTable = new JTable(Content, ColumnHeaderName) {
            public boolean isCellEditable(int iRows, int iCols) {
                return false;
            }
        };

        NewTable.setPreferredScrollableViewportSize(new Dimension(810, 480));
        NewTable.setBackground(new Color(147, 226, 213));

        //Start resize the table column
        NewTable.getColumnModel().getColumn(0).setMaxWidth(200);
        NewTable.getColumnModel().getColumn(0).setMinWidth(0);
        NewTable.getColumnModel().getColumn(0).setWidth(0);
        NewTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        NewTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        NewTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        NewTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        NewTable.getColumnModel().getColumn(4).setPreferredWidth(100);

        NewTable.setRowHeight(30);
        NewTable.setForeground(new Color(0, 51, 153));
		//End resize the table column

        //Disposed variables
        ColumnHeaderName = null;
        Content = null;

        rowNum = 0;

        return NewTable;
    }

    //
//        Object obb = e.getSource();
//        if (obb == JBcheckjobcard) {
//            dispose();
//            if (total != 0) {
//                try {
//                    if (JTCusTable.getValueAt(JTCusTable.getSelectedRow(), JTCusTable.getSelectedColumn()) != null) {
//                        String ObjButtons[] = {"Yes", "No"};
//                        int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to delete the selected record?", "Delete Record", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, ObjButtons, ObjButtons[1]);
//                        if (PromptResult == 0) {
//                            String del = "DELETE  FROM members_table WHERE k_p_a_id = " + JTCusTable.getValueAt(JTCusTable.getSelectedRow(), 1);
//                            System.out.println(del);
//                            stCus.execute(del);
//                            reloadRecord();
//                            JOptionPane.showMessageDialog(null, "Record has been successfully deleted.", "Comfirm Delete", JOptionPane.INFORMATION_MESSAGE);
//                        }
//                    }
//                } catch (Exception sqlE) {
//                    if (sqlE.getMessage() != null) {
//                        JOptionPane.showMessageDialog(null, "Please select a record in the list to deleted.", "No Record Selected", JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Please select a record in the list to deleted.", "No Record Selected", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                }
//
//            }
//        } 
//        else if (obb == JBReload) {
//            reloadRecord();
//        } //Close the Form
//        else if (obb == JBExit) {
//            close();
//            dispose();
//        }
//
//    }

    public static void reloadRecord(String srcSQL) {
        strSQL = srcSQL;
        CusTableJSP.getViewport().remove(JTCusTable);
        JTCusTable = CreateTable();
        CusTableJSP.getViewport().add(JTCusTable);
        JPContainer.repaint();
    }

    public static void reloadRecord() {

        CusTableJSP.getViewport().remove(JTCusTable);
        JTCusTable = CreateTable();
        CusTableJSP.getViewport().add(JTCusTable);
        JPContainer.repaint();
    }

    public void close() {
        setVisible(false);
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public class Buttonswork implements ActionListener{

          public void actionPerformed(ActionEvent e) {

            if (e.getSource() == JBSearch) {
                     if (total != 0) {
                try {
                    if (JTCusTable.getValueAt(JTCusTable.getSelectedRow(), JTCusTable.getSelectedColumn()) != null) {
                        String ObjButtons[] = {"Yes", "No"};
                        int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to delete the selected record?", "Delete Record", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, ObjButtons, ObjButtons[1]);
                        if (PromptResult == 0) {
                            String del = "DELETE  FROM members_table WHERE k_p_a_id = " + JTCusTable.getValueAt(JTCusTable.getSelectedRow(), 1);
                            System.out.println(del);
                            stCus.execute(del);
                            reloadRecord();
                            JOptionPane.showMessageDialog(null, "Record has been successfully deleted.", "Comfirm Delete", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (Exception sqlE) {
                    if (sqlE.getMessage() != null) {
                        JOptionPane.showMessageDialog(null, "Please select a record in the list to deleted.", "No Record Selected", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a record in the list to deleted.", "No Record Selected", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
            } else if (e.getSource() == JBcheckjobcard) {
                close();  
            } else if (e.getSource() == JBReload) {
               //reloadRecord();
            }
            else if (e.getSource() == JBApprove) {
               //reloadRecord();
            }
            else if (e.getSource() == JBExit) {
               close();
            }
        }
    }

}
