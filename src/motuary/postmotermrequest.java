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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Range_Rover_Sport
 */
public class postmotermrequest extends JInternalFrame {

    private JPanel holder;
    public String namba2db;

    private JLabel topichd;
    private JLabel hdimage;
    private JLabel admin_search;
    private JLabel deceasedname;
    private JLabel admissionno;
    private JLabel date_of_arrival;
    private JLabel relation;
    private JLabel requesters_name;
    private JLabel requester_id;
    private JLabel requester_tel_no;
    private JLabel autopsy_date;
    private JLabel autopsy_time;
    private JLabel nature_of_autopsy;
    private JLabel name_of_pathologist;

    private JTextField dname_txt;
    private JTextField admin_txt;
    private JTextField doa_txt;
    private JTextField reltion_txt;
    private JTextField requester_txt;
    private JTextField reqid_txt;
    private JTextField admin_nosearchtxt;
    private JTextField req_tel_txt;
    private JXDatePicker autopsy_date_txt;
    private JTextField auto_time;
    private JTextField pathologist_txt;
    private JComboBox nature_of_auto;

    private JButton btnCancel;
    private JButton savebttn;
    private JButton searchbttn;
    private JButton hd;
    private JButton separator;

    Dimension display = Toolkit.getDefaultToolkit().getScreenSize();

    public postmotermrequest() {

        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).
                getNorthPane();
        this.remove(titlePane);

        initial();

        setBounds(display.width - 1050, 50, 800, display.height - 300);
        //setClosable(true);

        setBackground(new Color(61, 96, 121));
        add(holder);

    }

    public void initial() {

        ButtonListener listener = new ButtonListener();

        hd = new komponenMakeOver.buttonMakeOverRectanglelogin();
        hd.setBounds(0, 0, 800, 32);

        hdimage = new JLabel(new ImageIcon("src/images/Bimage.png"));
        hdimage.setBounds(2, 2, 32, 32);

        topichd = new JLabel("BOOK A POST MOTERM");
        topichd.setForeground(new Color(242, 242, 189));
        topichd.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        topichd.setBounds(300, 0, 300, 30);

        admin_search = new JLabel();
        admin_search.setText("Enter Admin. No.");
        admin_search.setForeground(new Color(186, 190, 198));
        admin_search.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        admin_search.setBounds(200, 50, 150, 30);

        admin_nosearchtxt = new komponenMakeOver.textfieldMakeover();
        admin_nosearchtxt.requestFocusInWindow();
        admin_nosearchtxt.setForeground(new Color(186, 190, 198));
        admin_nosearchtxt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        admin_nosearchtxt.setBounds(350, 50, 150, 30);
        admin_nosearchtxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                nambatxtKeyTyped(e);
            }

        });

        searchbttn = new komponenMakeOver.buttonMakeOverRectangle();
        searchbttn.setText("search");
        searchbttn.setForeground(new Color(186, 190, 198));
        searchbttn.setIcon(new ImageIcon("src/images/SEARCH.png"));
        searchbttn.setBounds(530, 50, 100, 30);
        searchbttn.addActionListener(listener);

        deceasedname = new JLabel();
        deceasedname.setText("Deceased Name:");
        deceasedname.setForeground(new Color(186, 190, 198));
        deceasedname.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        deceasedname.setBounds(5, 100, 150, 30);

        dname_txt = new komponenMakeOver.textfieldMakeover();
        //dname_txt.requestFocusInWindow();
        dname_txt.setForeground(new Color(186, 190, 198));
        dname_txt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        dname_txt.setBounds(160, 100, 200, 30);

        admissionno = new JLabel();
        admissionno.setText("Admin. No:");
        admissionno.setForeground(new Color(186, 190, 198));
        admissionno.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        admissionno.setBounds(370, 100, 100, 30);

        admin_txt = new komponenMakeOver.textfieldMakeover();
        //dname_txt.requestFocusInWindow();
        admin_txt.setForeground(new Color(186, 190, 198));
        admin_txt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        admin_txt.setBounds(470, 100, 100, 30);

        date_of_arrival = new JLabel();
        date_of_arrival.setText("Date:");
        date_of_arrival.setForeground(new Color(186, 190, 198));
        date_of_arrival.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        date_of_arrival.setBounds(590, 100, 80, 30);

        doa_txt = new komponenMakeOver.textfieldMakeover();
        //dname_txt.requestFocusInWindow();
        doa_txt.setEditable(false);
        doa_txt.setForeground(new Color(186, 190, 198));
        doa_txt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        doa_txt.setBounds(660, 100, 110, 30);

        separator = new komponenMakeOver.buttonMakeOverRectanglelogin();
        separator.setBounds(0, 140, 800, 2);

        requesters_name = new JLabel();
        requesters_name.setText("Requester's Name:");
        requesters_name.setForeground(new Color(186, 190, 198));
        requesters_name.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        requesters_name.setBounds(5, 150, 150, 30);

        requester_txt = new komponenMakeOver.textfieldMakeover();
        //dname_txt.requestFocusInWindow();
        requester_txt.setForeground(new Color(186, 190, 198));
        requester_txt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        requester_txt.setBounds(160, 150, 200, 30);

        requester_id = new JLabel();
        requester_id.setText("I.D/P.P:");
        requester_id.setForeground(new Color(186, 190, 198));
        requester_id.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        requester_id.setBounds(365, 150, 80, 30);

        reqid_txt = new komponenMakeOver.textfieldMakeover();
        reqid_txt.setForeground(new Color(186, 190, 198));
        reqid_txt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        reqid_txt.setBounds(435, 150, 120, 30);

        relation = new JLabel();
        relation.setText("Relation:");
        relation.setForeground(new Color(186, 190, 198));
        relation.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        relation.setBounds(560, 150, 100, 30);

        reltion_txt = new komponenMakeOver.textfieldMakeover();
        reltion_txt.setForeground(new Color(186, 190, 198));
        reltion_txt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        reltion_txt.setBounds(650, 150, 120, 30);

        requester_tel_no = new JLabel();
        requester_tel_no.setText("Telephone No.:");
        requester_tel_no.setForeground(new Color(186, 190, 198));
        requester_tel_no.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        requester_tel_no.setBounds(5, 195, 130, 30);

        req_tel_txt = new komponenMakeOver.textfieldMakeover();
        req_tel_txt.setForeground(new Color(186, 190, 198));
        req_tel_txt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        req_tel_txt.setBounds(160, 195, 200, 30);

        autopsy_date = new JLabel();
        autopsy_date.setText("Autopsy Date:");
        autopsy_date.setForeground(new Color(186, 190, 198));
        autopsy_date.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        autopsy_date.setBounds(375, 195, 150, 30);

        autopsy_date_txt = new komponenMakeOver.DateChooserMakeOverFinal();
        autopsy_date_txt.setForeground(new Color(186, 190, 198));
        autopsy_date_txt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        autopsy_date_txt.setBounds(560, 195, 200, 30);

        autopsy_time = new JLabel();
        autopsy_time.setText("Autopsy Time:");
        autopsy_time.setForeground(new Color(186, 190, 198));
        autopsy_time.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        autopsy_time.setBounds(5, 250, 130, 30);

        auto_time = new komponenMakeOver.textfieldMakeover();
        auto_time.setForeground(new Color(186, 190, 198));
        auto_time.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        auto_time.setBounds(160, 240, 200, 30);

        nature_of_autopsy = new JLabel();
        nature_of_autopsy.setText("Nature of Autopsy :");
        nature_of_autopsy.setForeground(new Color(186, 190, 198));
        nature_of_autopsy.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        nature_of_autopsy.setBounds(365, 240, 170, 30);

        nature_of_auto = new komponenMakeOver.comboboxMakeOver();
        nature_of_auto.setForeground(new Color(186, 190, 198));
        nature_of_auto.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        nature_of_auto.setBounds(560, 240, 200, 30);
        nature_of_auto.addItem("POLICE CASE");
        nature_of_auto.addItem("PRIVATE CASE");

        name_of_pathologist = new JLabel();
        name_of_pathologist.setText("Pathologist's Name :");
        name_of_pathologist.setForeground(new Color(186, 190, 198));
        name_of_pathologist.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        name_of_pathologist.setBounds(5, 290, 200, 30);

        pathologist_txt = new komponenMakeOver.textfieldMakeover();
        pathologist_txt.setForeground(new Color(186, 190, 198));
        pathologist_txt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        pathologist_txt.setBounds(180, 290, 250, 30);

        btnCancel = new komponenMakeOver.buttonMakeOverRectangle();
        btnCancel.setText("Save");
        btnCancel.setForeground(new Color(186, 190, 198));
        btnCancel.setIcon(new ImageIcon("src/images/save16.png"));
        btnCancel.setBounds(260, 370, 115, 32);
        btnCancel.addActionListener(listener);

        savebttn = new komponenMakeOver.buttonMakeOverRectangle();
        savebttn.setText("Cancel");
        savebttn.setForeground(new Color(186, 190, 198));
        savebttn.setIcon(new ImageIcon("src/images/button_cancel.png"));
        savebttn.setBounds(450, 370, 115, 32);
        savebttn.addActionListener(listener);

        holder = new komponenMakeOver.panelmakeOver();
        holder.setLayout(null);
        holder.add(hd);
        holder.add(topichd);
        holder.add(hdimage);
        holder.add(admin_search);
        holder.add(admin_nosearchtxt);
        holder.add(searchbttn);
        holder.add(deceasedname);
        holder.add(dname_txt);
        holder.add(admissionno);
        holder.add(admin_txt);
        holder.add(date_of_arrival);
        holder.add(doa_txt);
        holder.add(separator);
        holder.add(requesters_name);
        holder.add(requester_txt);
        holder.add(requester_id);
        holder.add(reqid_txt);
        holder.add(relation);
        holder.add(reltion_txt);
        holder.add(requester_tel_no);
        holder.add(req_tel_txt);
        holder.add(autopsy_date);

        holder.add(autopsy_date_txt);
        holder.add(autopsy_time);
        holder.add(auto_time);
        holder.add(nature_of_autopsy);
        holder.add(nature_of_auto);
        holder.add(name_of_pathologist);
        holder.add(pathologist_txt);
        holder.add(btnCancel);
        holder.add(savebttn);
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnCancel) {

                cancel();
            } else if (e.getSource() == savebttn) {

                cancel();
            } else if (e.getSource() == searchbttn) {

                namba2db = admin_nosearchtxt.getText();
                checkout(namba2db);

            }
        }

    };

    public void cancel() {

        setVisible(false);
        dispose();

    }

    public void checkout(String admin) {

        clearall();

        String nammba = admin, jina, namba, date;
        ImageIcon alert = new ImageIcon("src/images/warning.png");
        String SQL = "";
        SQL = "SELECT * FROM demo_admin WHERE admin_no = '" + nammba + "'";

        try {
            ResultSet rs;
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            rs = st.executeQuery(SQL);

            int count = 0;

            while (rs.next()) {
                count = count + 1;

                namba = rs.getString(1);
                jina = rs.getString(2);
                date = rs.getString(3);

                dname_txt.setText(jina);
                admin_txt.setText(namba);
                doa_txt.setText(date);
            }
            if (count < 1) {
                JOptionPane.showMessageDialog(null, "          record not found", "alert", JOptionPane.WARNING_MESSAGE, null);
                clearall();
            } else if (count >1) {
                JOptionPane.showMessageDialog(null, "          record not found", "alert", JOptionPane.WARNING_MESSAGE, null);
                clearall();
            }
 
            Data close = new Data();
            close.closingConnection(cn, st, rs);
            close = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearall() {
        admin_nosearchtxt.setText(null);
        dname_txt.setText(null);
        admin_txt.setText(null);
        doa_txt.setText(null);
    }

    private void sendall() {

        String requesternme = requester_txt.getText();
        String requesterid = reqid_txt.getText();
        String relation = reltion_txt.getText();
        String requestertel = req_tel_txt.getText();
        String autopsydate = autopsy_date_txt.getDate().toString();
        String doatime = doa_txt.getText();
        String autotime = auto_time.getText();
        String pathologistname = pathologist_txt.getText();

    }

    private void nambatxtKeyTyped(KeyEvent ke) {
        char cr = ke.getKeyChar();
        if (!(Character.isDigit(ke.getKeyChar()) || (cr == KeyEvent.VK_BACK_SPACE) || (cr == KeyEvent.VK_ENTER))) {
            getToolkit().beep();
            ke.consume();
            JOptionPane.showMessageDialog(null, "Please enter digits only");
        }
    }

}
