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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author codebox
 */
public class servicedialog extends JDialog {

    DefaultTableModel tabMode;

    private JCheckBox chkAdd;
    private JButton cmdExit;
    private JButton cmdSave;
    private JScrollPane jScrollPane1;
    public ImageIcon tick = new ImageIcon("src/images/success.png");
    private JTable tbFunction;
    public JTextField txtUserID;
    private JPanel container;
    private JButton header;
    private JLabel head;
    private JLabel headImage;
    private int mtuwetu;
    
    private static java.util.Date bookdate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(bookdate.getTime());
    String dateservcebooked = sqlDate.toString();

    Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
    

    public servicedialog(java.awt.Frame parent, boolean modal, int namber) {
        super(parent, modal);
        mtuwetu = namber;

        String[] strHeader = {"Service Code", "Service Description ", "Service Cost (KSH)", "Select Servive"};
        tabMode = new DefaultTableModel(null, strHeader) {
            public boolean isCellEditable(int row, int column) {
                if (column <= 1) {
                    return false;
                }
                return true;
            }
        };
        initial();

        fillTable();

        setBackground(new Color(61, 96, 121));
        setBounds(300, 30, display.width - 780, display.height - 300);
        add(container);
    }

    void fillTable() {
        tabMode.setRowCount(0);
        Data User = new Data();
        String UserID;

        Object data01[] = {"101", "Body on transit (0-to-24HRS)", "3500.0",new Boolean(false)};
        Object data02[] = {"102", "Day 1(after 24HRS) to day 10", "6000.0",new Boolean(false)};
        Object data03[] = {"103", "From Day 11 onwards", "600.00",new Boolean(false)};
        Object data04[] = {"201", "Cases done by KUFH Pathologist", "10500.0",new Boolean(false)};
        Object data05[] = {"202", "Cases done by KUFH non-Pathologist", "0.0",new Boolean(false)};
        Object data06[] = {"301", "Removal of foetus ", "2000.00",new Boolean(false)};
        Object data07[] = {"302", "Removal and recovery of soft tissue implants", "2000.0",new Boolean(false)};
        Object data08[] = {"303", "Removal of skeletal implants ", "3000.0 ",new Boolean(false)};
        Object data09[] = {"401", "Viewing fee", "500.00 ",new Boolean(false)};
        Object data10[] = {"501", "Unbraiding of hair,blow drying and shampow", "1500.0",new Boolean(false)};
        Object data11[] = {"502", "Beard shaving,trimming,combing moustache", "500.0",new Boolean(false)};
        Object data12[] = {"600A", "Face and skin body injuries", "2000.0",new Boolean(false)};
        Object data13[] = {"600B", "Facial lacerations with comminuted skull fractures elevation involving one aspect only", "5000.0",new Boolean(false)};
        Object data14[] = {"600C", "Facial lacerations with comminuted skull fractures elevation involving both front and/or morethan one aspect of skull", "10000.0",new Boolean(false)};
        Object data15[] = {"600D", "Facial injuries and any other body regions requiring reconstruction", "15000.00",new Boolean(false)};
        Object data16[] = {"801", "Delays in delivery of coffins and cloth items", "1000.0",new Boolean(false)};
        Object data17[] = {"802", "Postponement of appointments without consultation,latenes BYD 1hr", "1000.0",new Boolean(false)};
        Object data18[] = {"803", "Retention administrative fees for money refunds claimed", "1000.0",new Boolean(false)};

        TableColumn chkTable = tbFunction.getColumnModel().getColumn(3);
        chkTable.setCellEditor(tbFunction.getDefaultEditor(Boolean.class));
        chkTable.setCellRenderer(tbFunction.getDefaultRenderer(Boolean.class));

        tbFunction.getColumnModel().getColumn(0).setPreferredWidth(70);
        tbFunction.getColumnModel().getColumn(1).setPreferredWidth(180);
        tbFunction.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbFunction.getColumnModel().getColumn(3).setPreferredWidth(100);

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
        tabMode.addRow(data15);
        tabMode.addRow(data16);
        tabMode.addRow(data17);
        tabMode.addRow(data18);
    }

    public void initial() {

       

        ButtonListener listener = new ButtonListener();

        header = new komponenMakeOver.buttonMakeOverRectanglelogin();
        header.setBounds(0, 0, 600, 32);

        txtUserID = new komponenMakeOver.textfieldMakeover();
        txtUserID.setBounds(300, 50, 250, 30);

        head = new JLabel("KUFH SERVICE LIST");
        head.setForeground(new Color(242, 242, 189));
        head.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        head.setBounds(150, 0, 300, 32);

        headImage = new JLabel(new ImageIcon("src/images/secur.png"));
        headImage.setBounds(0, 0, 32, 32);

        tbFunction = new JTable();
        tbFunction.setBorder(null);
        tbFunction.setModel(tabMode);

        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(tbFunction);
        jScrollPane1.setBorder(null);
        jScrollPane1.setBounds(10, 100, 540, 320);

        chkAdd = new JCheckBox();
        chkAdd.setText("Add");
        chkAdd.setBounds(10, 50, 100, 30);
        chkAdd.setBackground(new Color(74, 112, 139));
        chkAdd.setForeground(new Color(242, 242, 189));
        chkAdd.addActionListener(listener);

        cmdSave = new komponenMakeOver.buttonMakeOverRectangle();
        cmdSave.setText("Save");
        cmdSave.setForeground(new Color(186, 190, 198));
        cmdSave.setIcon(new ImageIcon("src/images/save.png"));
        cmdSave.setBounds(110, 50, 100, 30);
        cmdSave.addActionListener(listener);

        cmdExit = new komponenMakeOver.buttonMakeOverRectangle();
        cmdExit.setText("Exit");
        cmdExit.setForeground(new Color(186, 190, 198));
        cmdExit.setIcon(new ImageIcon("src/images/exit.png"));
        cmdExit.setBounds(200, 50, 100, 30);
        cmdExit.addActionListener(listener);

        container = new komponenMakeOver.panelmakeOver();

        container.setLayout(null);
        container.add(cmdExit);

        container.add(cmdSave);

        container.add(chkAdd);

        container.add(jScrollPane1);
        container.add(txtUserID);
        container.add(head);
        container.add(headImage);
        container.add(header);

    }

    public void chkAddActionPerformed() {

        int row = tabMode.getRowCount();
        for (byte i = 0; i < row; i++) {
            tabMode.setValueAt(chkAdd.isSelected(), i, 3);
        }

    }

    public void save() {

        Data data = new Data();
        
        ArrayList<String> SQLArray = new ArrayList<String>();
        int result = JOptionPane.showConfirmDialog(this, "Do you want to save ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {

            String SQL;
            double row = tabMode.getRowCount();
            for (int i = 0; i < row; i++) {
                
                
                String code = (String) tabMode.getValueAt(i,0);
                String cost =   (String) tabMode.getValueAt(i,2);
                double costt = Double.parseDouble(cost);
                Boolean canAdd = (Boolean) tabMode.getValueAt(i,3);

                if(canAdd==true){
                    System.out.println(dateservcebooked);
                      System.out.println(mtuwetu);
                SQL = "INSERT INTO invoice_tb (admin_no_finance,service_code_finance,cost_of_service,date) VALUES('" + mtuwetu + "', '" + code.trim() + "', " + costt + ",'" + dateservcebooked + "')";
                SQLArray.add(SQL);
                }
            }
            data.ExecuteSQL(SQLArray);
            JOptionPane.showMessageDialog(null, "successfully registered", "SUCCESS", JOptionPane.PLAIN_MESSAGE,tick);
            data = null;
            tabMode.setRowCount(0);
            dispose();
        }
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == cmdSave) {

                save();
            } else if (e.getSource() == cmdExit) {

                dispose();
                setVisible(false);
            } else if (e.getSource() == chkAdd) {

                chkAddActionPerformed();
            }

        }

    };

}
