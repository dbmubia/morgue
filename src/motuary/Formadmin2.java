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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Range_Rover_Sport
 */
public class Formadmin2 extends JInternalFrame implements ActionListener {

    private JTabbedPane tabs;
    private JPanel bio, deathinfo;
    private JPanel kins;
    private JPanel deceased;
    private JLabel official, Notification, burrialpermit, noticeOfDeath, policeLetter, policename, policename1, Pstation, Prank, Sno, policeheader;
    private JTextField PermitNo, NODeath, OB, PNAME, PNAME2, PoliceStation, SERVICENO;
    private JCheckBox Bp, NatureOD, POB;
    private JButton add;
    private JComboBox title, sexx, county, causes_death, RANK, naturecombo;
    private String[] countylist = {" ", "Meru", "Tharaka Nithi", "Embu", "Kitui", "Machakos", "Makueni", "Nyandarua", "Nyeri"
        + "Kirinyaga", "Murang'a", "Kiambu", "Turkana.", "West Pokot", "Samburu", "Trans Nzoia", "Uasin Gishu", "Elgeyo/Marakwet"
        + "Nandi", "Baringo", "Laikipia", "Nakuru", "Narok."};

    private String[] deathcauses = {" ", "Illness", "Natural causes", "Murder", "poisoning", "Drowning", "Poisoning"};
    private String[] policeranks = {" ", "Coporal", "Sergeant", "Senior Sergeant", "Inspector", "Chief Inspector"};
    private JButton next, nextkin, netxdeath;
    private int present, contctbolean;
    private String namba, contact;
    private JLabel Title, First_Name, middlename, lastname, Did, kid,
            DOB, Tag, NOD, relation, residence, address, telephone, contactpersn, countyy, causes, natureofdeath;
    private JLabel kfname, klname, PONE, PTWO, dresidence, PME, BodyLocation, PMI, forensic, hasPM, Services, sexlabel;
    private String titletxt, fnmetxt, lnametxt, mnametxt, idtxt, dobtxt, sextxt, residencetxt, countytxt, todaysdate;
    private String fname1txt, fname2txt, lnametxt1, lnametxt2, id1txt, id2txt, relation1, relation2, residnce1, residence2, adress1, adress2, phone1, phone2;
    private ButtonGroup sex, contactperson;
    private JLabel DplaceofDeath, DdateOfDeath;
    private JTextArea TXTANOD;
    private JLabel DsexM, DsexF;
    private JTextField DNames, MNAme, LName, DID, DPLACE, Dresidencetxt, TagNo, KFNAME, KFNAME1, KLNAME, KLNAME2, KID, RELATION, RESIDENCE, ADDRESS, TELEPHONE, KNAMESTWO, KIDTWO, RELATIONTWO, RESIDENCETWO, ADDRESSTWO, TELEPHONETWO;
    private JXDatePicker DateofBirth;
    private JRadioButton male, female, contct1, contact2;
//    ImageIcon alert = new ImageIcon(getClass().getResource("images/success.png"));
    SqlDateModel model = new SqlDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
    JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel);
    java.sql.Date selectedDate, deathdet;

    public Formadmin2() {

        super("Admission", false, true, false, true);

        initial();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        setBackground(new Color(61, 96, 121));

        setBounds(screen.width - 1200, 50, 1000, screen.height - 270);

        setClosable(true);
        getContentPane().add(tabs);
        setVisible(true);
    }

    private void initial() {

        String tabButtonCss = "margin:0;width:100px;height:10px;border-radius:3px;padding:10px;text-align:center;border:none;a:hover {\n"
                + "	color: #ffffff;\n"
                + "	background-color: #000000;\n"
                + "	text-decoration: none;\n"
                + "}";

        tabs = new JTabbedPane();

        bioform();
        kininfo();
        deathinfo();
        getlast();
        tabs.add(generateHtml("Bio Information", tabButtonCss), bio);
        tabs.add(generateHtml(" Kin Info ", tabButtonCss), kins);
        tabs.add(generateHtml(" Death Info ", tabButtonCss), deathinfo);

        pack();

    }

    public static String generateHtml(String tabButtonLabel, String style) {
        /*@@Generates HTML for the tab button when the button label is given*/
        String ret = "<html><body style = '" + style + "'>" + tabButtonLabel + "</body></html>";
        return ret;
    }

    public void bioform() {
        bio = new komponenMakeOver.panelmakeOver();
        bio.setLayout(null);

        Tag = new JLabel();
        Tag.setText("TAG/ADMIN NO:");
        Tag.setForeground(new Color(255, 220, 35));
        Tag.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        Tag.setBounds(650, 10, 150, 30);

        TagNo = new komponenMakeOver.textfieldColdroomMakeover();
        TagNo.setBounds(810, 11, 150, 30);
        TagNo.setForeground(new Color(255, 220, 35));
        //TagNo.setText(getlast());

        Title = new JLabel();
        Title.setText("Title:");
        Title.setForeground(new Color(186, 190, 198));
        Title.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        Title.setBounds(150, 50, 100, 35);

        title = new JComboBox();
        title.addItem(" ");
        title.addItem("Master");
        title.addItem("Mr.");
        title.addItem("Mrs.");
        title.addItem("Ms.");
        title.setBounds(120, 80, 100, 30);

        First_Name = new JLabel();
        First_Name.setText("First Name:");
        First_Name.setForeground(new Color(186, 190, 198));
        First_Name.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        First_Name.setBounds(295, 50, 100, 30);

        DNames = new komponenMakeOver.textfieldMakeover();
        DNames.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        DNames.setForeground(new Color(242, 242, 189));
        DNames.setBounds(270, 80, 170, 30);

        middlename = new JLabel();
        middlename.setText("Middle Name:");
        middlename.setForeground(new Color(186, 190, 198));
        middlename.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        middlename.setBounds(510, 50, 150, 35);

        MNAme = new komponenMakeOver.textfieldMakeover();
        MNAme.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        MNAme.setForeground(new Color(242, 242, 189));
        MNAme.setBounds(470, 80, 170, 35);

        lastname = new JLabel();
        lastname.setText("Last Name:");
        lastname.setForeground(new Color(186, 190, 198));
        lastname.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        lastname.setBounds(700, 50, 100, 35);

        LName = new komponenMakeOver.textfieldMakeover();
        LName.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        LName.setForeground(new Color(242, 242, 189));
        LName.setBounds(680, 80, 170, 35);

        Did = new JLabel();
        Did.setText("I.D/PassPort No.");
        Did.setForeground(new Color(186, 190, 198));
        Did.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        Did.setBounds(130, 125, 150, 30);

        DID = new komponenMakeOver.textfieldMakeover();
        DID.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        DID.setForeground(new Color(242, 242, 189));
        DID.setBounds(110, 155, 200, 30);

        DOB = new JLabel();
        DOB.setText("Birth Date.");
        DOB.setForeground(new Color(186, 190, 198));
        DOB.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        DOB.setBounds(385, 115, 100, 50);

        //DateofBirth = new JXDatePicker();
        datePicker.setBounds(350, 155, 200, 30);
        datePicker.setFont(new Font("Lucida Sans", Font.BOLD, 16));

        sexlabel = new JLabel();
        sexlabel.setText("Sex.");
        sexlabel.setForeground(new Color(186, 190, 198));
        sexlabel.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        sexlabel.setBounds(600, 155, 100, 35);

        sexx = new JComboBox();
        sexx.addItem("Male");
        sexx.addItem("Female");
        sexx.setBounds(680, 155, 100, 30);

        dresidence = new JLabel();
        dresidence.setText("Residence.");
        dresidence.setBounds(130, 190, 100, 30);
        dresidence.setForeground(new Color(186, 190, 198));
        dresidence.setFont(new Font("Lucida Sans", Font.BOLD, 17));

        Dresidencetxt = new komponenMakeOver.textfieldMakeover();
        Dresidencetxt.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        Dresidencetxt.setForeground(new Color(242, 242, 189));
        Dresidencetxt.setBounds(100, 215, 200, 30);

        countyy = new JLabel();
        countyy.setText("County");
        countyy.setBounds(380, 190, 100, 30);
        countyy.setForeground(new Color(186, 190, 198));
        countyy.setFont(new Font("Lucida Sans", Font.BOLD, 17));

        county = new JComboBox(countylist);
        county.setBounds(350, 215, 180, 30);

        DdateOfDeath = new JLabel();
        DdateOfDeath.setText("Date of death    :");
        DdateOfDeath.setForeground(new Color(186, 190, 198));
        DdateOfDeath.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        DdateOfDeath.setBounds(120, 170, 200, 30);

        datePicker2.setBounds(250, 170, 190, 30);
        datePicker2.setFont(new Font("Lucida Sans", Font.BOLD, 16));

        DplaceofDeath = new JLabel();
        DplaceofDeath.setText("Place of death :");
        DplaceofDeath.setForeground(new Color(186, 190, 198));
        DplaceofDeath.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        DplaceofDeath.setBounds(460, 170, 200, 30);

        DPLACE = new komponenMakeOver.textfieldMakeover();
        DPLACE.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        DPLACE.setForeground(new Color(242, 242, 189));
        DPLACE.setBounds(620, 170, 200, 30);

        NOD = new JLabel();
        NOD.setText("Nature of death :");
        NOD.setForeground(new Color(186, 190, 198));
        NOD.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        NOD.setBounds(120, 225, 200, 30);

        TXTANOD = new JTextArea();
        TXTANOD.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        TXTANOD.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        TXTANOD.setForeground(Color.WHITE);
        TXTANOD.setWrapStyleWord(true);
        TXTANOD.setLineWrap(true);
        TXTANOD.setOpaque(false);
        TXTANOD.setCaretColor(Color.YELLOW);
        TXTANOD.setBounds(300, 225, 500, 50);

        next = new komponenMakeOver.buttonMakeOverRectangle();
        next.setBounds(750, 350, 150, 40);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        next.setIcon(new ImageIcon("src/images/tick.png"));
        next.setText("Submit");
        next.addActionListener(this);

        bio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARTICULARS OF DECEASED PERSON  (A)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16), Color.WHITE));
        bio.add(Title);
        bio.add(title);
        bio.add(First_Name);
        bio.add(middlename);
        bio.add(MNAme);
        bio.add(DNames);
        bio.add(lastname);
        bio.add(LName);
        bio.add(sexlabel);
        bio.add(sexx);
        bio.add(Did);
        bio.add(DID);
        bio.add(DOB);
        bio.add(datePicker);
        bio.add(countyy);
        bio.add(county);
        bio.add(dresidence);
        bio.add(Dresidencetxt);

//        bio.add(DsexM);
//        bio.add(male);
//        bio.add(female);
        bio.add(next);
        //       bio.add(DdateOfDeath);
        //       bio.add(DDATEDEATH);
        //       bio.add(DPLACE);
        //       bio.add(DplaceofDeath);
        bio.add(Tag);
        bio.add(TagNo);
        //     bio.add(NOD);
        //     bio.add(TXTANOD);
    }

    public void kininfo() {
        kins = new komponenMakeOver.panelmakeOver();
        kins.setLayout(null);

        PONE = new JLabel();
        PONE.setText("PERSON I");
        PONE.setForeground(new Color(255, 220, 35));
        PONE.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        PONE.setIcon(new ImageIcon(""));
        PONE.setBounds(165, 30, 200, 30);

        PTWO = new JLabel();
        PTWO.setText("PERSON II");
        PTWO.setForeground(new Color(255, 220, 35));
        PTWO.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        PTWO.setIcon(new ImageIcon(""));
        PTWO.setBounds(395, 30, 200, 30);

        kfname = new JLabel();
        kfname.setText("First Name :");
        kfname.setForeground(new Color(186, 190, 198));
        kfname.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        kfname.setBounds(8, 60, 200, 30);

        KFNAME = new komponenMakeOver.textfieldMakeover();
        KFNAME.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KFNAME.setForeground(new Color(242, 242, 189));
        KFNAME.setBounds(115, 60, 220, 30);

        KNAMESTWO = new komponenMakeOver.textfieldMakeover();
        KNAMESTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KNAMESTWO.setForeground(new Color(242, 242, 189));
        KNAMESTWO.setBounds(345, 60, 220, 30);

        klname = new JLabel();
        klname.setText("Last Name");
        klname.setForeground(new Color(186, 190, 198));
        klname.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        klname.setBounds(8, 100, 200, 30);

        KLNAME = new komponenMakeOver.textfieldMakeover();
        KLNAME.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KLNAME.setForeground(new Color(242, 242, 189));
        KLNAME.setBounds(115, 100, 220, 30);

        KLNAME2 = new komponenMakeOver.textfieldMakeover();
        KLNAME2.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KLNAME2.setForeground(new Color(242, 242, 189));
        KLNAME2.setBounds(345, 100, 220, 30);

        kid = new JLabel();
        kid.setText("ID/PPNO :");
        kid.setForeground(new Color(186, 190, 198));
        kid.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        kid.setBounds(8, 140, 200, 30);

        KID = new komponenMakeOver.textfieldMakeover();
        KID.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KID.setForeground(new Color(242, 242, 189));
        KID.setBounds(115, 140, 220, 30);

        KIDTWO = new komponenMakeOver.textfieldMakeover();
        KIDTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KIDTWO.setForeground(new Color(242, 242, 189));
        KIDTWO.setBounds(345, 140, 220, 30);

        relation = new JLabel();
        relation.setText("Relation :");
        relation.setForeground(new Color(186, 190, 198));
        relation.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        relation.setBounds(8, 180, 200, 30);

        RELATION = new komponenMakeOver.textfieldMakeover();
        RELATION.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RELATION.setForeground(new Color(242, 242, 189));
        RELATION.setBounds(115, 180, 220, 30);

        RELATIONTWO = new komponenMakeOver.textfieldMakeover();
        RELATIONTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RELATIONTWO.setForeground(new Color(242, 242, 189));
        RELATIONTWO.setBounds(345, 180, 220, 30);

        residence = new JLabel();
        residence.setText("Residence");
        residence.setForeground(new Color(186, 190, 198));
        residence.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        residence.setBounds(8, 220, 200, 30);

        RESIDENCE = new komponenMakeOver.textfieldMakeover();
        RESIDENCE.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RESIDENCE.setForeground(new Color(242, 242, 189));
        RESIDENCE.setBounds(115, 220, 220, 30);

        RESIDENCETWO = new komponenMakeOver.textfieldMakeover();
        RESIDENCETWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RESIDENCETWO.setForeground(new Color(242, 242, 189));
        RESIDENCETWO.setBounds(345, 220, 220, 30);

        address = new JLabel();
        address.setText("Address :");
        address.setForeground(new Color(186, 190, 198));
        address.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        address.setBounds(8, 260, 200, 30);

        ADDRESS = new komponenMakeOver.textfieldMakeover();
        ADDRESS.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        ADDRESS.setForeground(new Color(242, 242, 189));
        ADDRESS.setBounds(115, 260, 220, 30);

        ADDRESSTWO = new komponenMakeOver.textfieldMakeover();
        ADDRESSTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        ADDRESSTWO.setForeground(new Color(242, 242, 189));
        ADDRESSTWO.setBounds(345, 260, 220, 30);

        telephone = new JLabel();
        telephone.setText("Phone No :");
        telephone.setForeground(new Color(186, 190, 198));
        telephone.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        telephone.setBounds(8, 300, 200, 30);

        TELEPHONE = new komponenMakeOver.textfieldMakeover();
        TELEPHONE.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        TELEPHONE.setForeground(new Color(242, 242, 189));
        TELEPHONE.setBounds(115, 300, 220, 30);

        TELEPHONETWO = new komponenMakeOver.textfieldMakeover();
        TELEPHONETWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        TELEPHONETWO.setForeground(new Color(242, 242, 189));
        TELEPHONETWO.setBounds(345, 300, 220, 30);

        contactpersn = new JLabel();
        contactpersn.setText("Contact Person :");
        contactpersn.setForeground(new Color(186, 190, 198));
        contactpersn.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        contactpersn.setBounds(8, 335, 200, 30);

        contactperson = new ButtonGroup();

        contct1 = new JRadioButton();
        contactperson.add(contct1);
        contct1.setBorder(null);
        contct1.setBounds(145, 340, 20, 20);

        contact2 = new JRadioButton();
        contactperson.add(contact2);
        contact2.setBorder(null);
        contact2.setBounds(365, 340, 20, 20);

        nextkin = new komponenMakeOver.buttonMakeOverRectangle();
        nextkin.setBounds(750, 350, 180, 40);
        nextkin.setForeground(Color.WHITE);
        nextkin.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        nextkin.setIcon(new ImageIcon("src/images/tick.png"));
        nextkin.setText("Submit Kin");
        nextkin.addActionListener(this);

        kins.add(kfname);
        kins.add(KFNAME);
        kins.add(KNAMESTWO);
        kins.add(klname);
        kins.add(KLNAME);
        kins.add(KLNAME2);
        kins.add(KID);
        kins.add(kid);
        kins.add(relation);
        kins.add(RELATION);
        kins.add(RESIDENCE);
        kins.add(residence);
        kins.add(address);
        kins.add(ADDRESS);
        kins.add(TELEPHONE);
        kins.add(telephone);
        kins.add(KNAMESTWO);
        kins.add(KIDTWO);
        kins.add(RELATIONTWO);
        kins.add(RESIDENCETWO);
        kins.add(ADDRESSTWO);
        kins.add(TELEPHONETWO);
        kins.add(PONE);
        kins.add(PTWO);
        kins.add(contactpersn);
        kins.add(contct1);
        kins.add(contact2);
        kins.add(nextkin);

    }

    public void deathinfo() {

        deathinfo = new komponenMakeOver.panelmakeOver();
        deathinfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
                "Death Particulars and Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16), Color.WHITE));
        deathinfo.setLayout(null);

        DdateOfDeath = new JLabel();
        DdateOfDeath.setText("Date of death :");
        DdateOfDeath.setForeground(new Color(186, 190, 198));
        DdateOfDeath.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        DdateOfDeath.setBounds(20, 50, 150, 30);

        datePicker2.setBounds(180, 50, 200, 30);
        datePicker2.setFont(new Font("Lucida Sans", Font.BOLD, 16));

        DplaceofDeath = new JLabel();
        DplaceofDeath.setText("Place of death :");
        DplaceofDeath.setForeground(new Color(186, 190, 198));
        DplaceofDeath.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        DplaceofDeath.setBounds(460, 50, 200, 30);

        DPLACE = new komponenMakeOver.textfieldMakeover();
        DPLACE.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        DPLACE.setForeground(new Color(242, 242, 189));
        DPLACE.setBounds(620, 50, 200, 30);

        causes = new JLabel();
        causes.setText("Cause of Death");
        causes.setForeground(new Color(186, 190, 198));
        causes.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        causes.setBounds(20, 100, 150, 30);

        causes_death = new JComboBox(deathcauses);
        causes_death.setBounds(180, 100, 200, 30);

        natureofdeath = new JLabel();
        natureofdeath.setText("Nature of Death");
        natureofdeath.setForeground(new Color(186, 190, 198));
        natureofdeath.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        natureofdeath.setBounds(20, 135, 150, 30);

        naturecombo = new JComboBox();
        naturecombo.addItem(" ");
        naturecombo.addItem("NORMAL CASE");
        naturecombo.addItem("POLICE CASE");
        naturecombo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                ifcop();
            }
        });
        naturecombo.setBounds(180, 135, 200, 30);

        NOD = new JLabel();
        NOD.setText("Description: ");
        NOD.setForeground(new Color(186, 190, 198));
        NOD.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        NOD.setBounds(420, 100, 150, 60);

        TXTANOD = new JTextArea();
        TXTANOD.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        TXTANOD.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        TXTANOD.setForeground(Color.WHITE);
        TXTANOD.setWrapStyleWord(true);
        TXTANOD.setLineWrap(true);
        TXTANOD.setOpaque(false);
        TXTANOD.setCaretColor(Color.YELLOW);
        TXTANOD.setBounds(550, 100, 420, 70);

        Notification = new JLabel();
        Notification.setText("Notification through :");
        Notification.setForeground(new Color(186, 190, 198));
        Notification.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Notification.setBounds(10, 180, 200, 20);

        Bp = new JCheckBox();
        Bp.setBorderPainted(false);
        Bp.setBackground(new Color(57, 105, 138));
        Bp.setBounds(20, 215, 20, 15);

        burrialpermit = new JLabel();
        burrialpermit.setText("Burial permit No :");
        burrialpermit.setForeground(new Color(186, 190, 198));
        burrialpermit.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        burrialpermit.setBounds(45, 205, 150, 30);

        PermitNo = new komponenMakeOver.textfieldMakeover();
        PermitNo.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        PermitNo.setForeground(new Color(242, 242, 189));
        PermitNo.setBounds(200, 205, 200, 30);

        POB = new JCheckBox();
        POB.setBorderPainted(false);
        POB.setBackground(new Color(57, 105, 138));
        POB.setBounds(20, 245, 20, 15);

        policeLetter = new JLabel();
        policeLetter.setText("Police letter/OB NO :");
        policeLetter.setForeground(new Color(186, 190, 198));
        policeLetter.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        policeLetter.setBounds(45, 240, 200, 30);

        OB = new komponenMakeOver.textfieldMakeover();
        OB.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        OB.setForeground(new Color(242, 242, 189));
        OB.setEnabled(false);
        OB.setBounds(203, 240, 200, 30);

        NatureOD = new JCheckBox();
        NatureOD.setBorderPainted(false);
        NatureOD.setBackground(new Color(57, 105, 138));
        NatureOD.setBounds(20, 285, 20, 15);

        noticeOfDeath = new JLabel();
        noticeOfDeath.setText("Notice of death/No  :");
        noticeOfDeath.setForeground(new Color(186, 190, 198));
        noticeOfDeath.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        noticeOfDeath.setBounds(45, 275, 200, 30);

        NODeath = new komponenMakeOver.textfieldMakeover();
        NODeath.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        NODeath.setForeground(new Color(242, 242, 189));
        NODeath.setBounds(200, 275, 200, 30);

        policeheader = new JLabel();
        policeheader.setText(": : :Body accompanied by police: : : ");
        policeheader.setForeground(new Color(255, 220, 35));
        policeheader.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        policeheader.setBounds(420, 180, 300, 20);

        policename = new JLabel();
        policename.setText("First Names:");
        policename.setForeground(new Color(186, 190, 198));
        policename.setFont(new Font("Lucida Sans", Font.BOLD, 14));

        policename.setBounds(415, 210, 150, 30);

        PNAME = new komponenMakeOver.textfieldMakeover();
        PNAME.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        PNAME.setEnabled(false);
        PNAME.setForeground(new Color(242, 242, 189));
        PNAME.setBounds(545, 210, 150, 30);

        policename1 = new JLabel();
        policename1.setText("Last Names:");
        policename1.setForeground(new Color(186, 190, 198));
        policename1.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        policename1.setBounds(700, 210, 150, 30);

        PNAME2 = new komponenMakeOver.textfieldMakeover();
        PNAME2.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        PNAME2.setEnabled(false);
        PNAME2.setForeground(new Color(242, 242, 189));
        PNAME2.setBounds(820, 210, 150, 30);

        Pstation = new JLabel();
        Pstation.setText("Police station :");
        Pstation.setForeground(new Color(186, 190, 198));
        Pstation.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Pstation.setBounds(415, 245, 150, 30);

        PoliceStation = new komponenMakeOver.textfieldMakeover();
        PoliceStation.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        PoliceStation.setEnabled(false);
        PoliceStation.setForeground(new Color(242, 242, 189));
        PoliceStation.setBounds(545, 245, 150, 30);

        Prank = new JLabel();
        Prank.setText("Rank :");
        Prank.setForeground(new Color(186, 190, 198));
        Prank.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Prank.setBounds(700, 245, 100, 30);

        RANK = new JComboBox(policeranks);
        RANK.setEnabled(false);
        RANK.setBounds(820, 245, 130, 30);

        Sno = new JLabel();
        Sno.setText("Service No :");
        Sno.setForeground(new Color(186, 190, 198));
        Sno.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Sno.setBounds(415, 280, 150, 30);

        SERVICENO = new komponenMakeOver.textfieldMakeover();
        SERVICENO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        SERVICENO.setForeground(new Color(242, 242, 189));
        SERVICENO.setEnabled(false);
        SERVICENO.setBounds(545, 280, 150, 30);

        netxdeath = new komponenMakeOver.buttonMakeOverRectangle();
        netxdeath.setBounds(750, 350, 150, 40);
        netxdeath.setForeground(Color.WHITE);
        netxdeath.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        netxdeath.setIcon(new ImageIcon("src/images/tick.png"));
        netxdeath.setText("Submit");
        netxdeath.addActionListener(this);

        deathinfo.add(Notification);
        deathinfo.add(DdateOfDeath);
        deathinfo.add(datePicker2);
        deathinfo.add(causes);
        deathinfo.add(causes_death);
        deathinfo.add(Bp);
        deathinfo.add(burrialpermit);
        deathinfo.add(PermitNo);
        deathinfo.add(NatureOD);
        deathinfo.add(noticeOfDeath);
        deathinfo.add(natureofdeath);
        deathinfo.add(naturecombo);
        deathinfo.add(NODeath);
        deathinfo.add(POB);
        deathinfo.add(policeLetter);
        deathinfo.add(OB);
        deathinfo.add(policeheader);
        deathinfo.add(DplaceofDeath);
        deathinfo.add(DPLACE);
        deathinfo.add(NOD);
        deathinfo.add(TXTANOD);
        deathinfo.add(policename);
        deathinfo.add(PNAME);
        deathinfo.add(PNAME2);
        deathinfo.add(policename1);
        deathinfo.add(Pstation);
        deathinfo.add(PoliceStation);
        deathinfo.add(Prank);
        deathinfo.add(RANK);
        deathinfo.add(Sno);
        deathinfo.add(SERVICENO);
        deathinfo.add(netxdeath);

    }

    private void getlast() {

        try {
            ResultSet rs;
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            String SQL2 = "select MAX(AdminNo) from deceased_tb";
            rs = st.executeQuery(SQL2);

            int count = 0;

            while (rs.next()) {
                count = count + 1;
                namba = rs.getString(1);
                int caunt = Integer.parseInt(namba);
                present = caunt + 1;
                TagNo.setText("KUFH/" + present + "/2014");
            }

            Data close = new Data();
            close.closingConnection(cn, st, rs);
            close = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }

    public void pushbiodetails() {

        titletxt = title.getSelectedItem().toString();
        fnmetxt = DNames.getText();
        lnametxt = LName.getText();
        mnametxt = MNAme.getText();
        idtxt = DID.getText();
        // dobtxt = DateofBirth.getDate().toString();
        selectedDate = (java.sql.Date) datePicker.getModel().getValue();
        dobtxt = selectedDate.toString();
        sextxt = sexx.getSelectedItem().toString();
        residencetxt = Dresidencetxt.getText();
        countytxt = county.getSelectedItem().toString();
        todaysdate = komponenMakeOver.PanelUserMakeover.returndate();

        if ((fnmetxt.equals("")) || (lnametxt.equals("")) || (mnametxt.equals("")) || (idtxt.equals("")) || (dobtxt.equals(""))
                || (sextxt.equals("")) || (residencetxt.equals("")) || (countytxt.equals("")) || (todaysdate.equals(""))) {

            JOptionPane.showMessageDialog(this, "    Please fill in all the Fields.", "alert", JOptionPane.WARNING_MESSAGE, null);

        } else {

            String sql = "INSERT INTO deceased_tb (title,first_name,middle_name,last_name,deceased_id,d_o_b,sex,residence,county,arrival_date) "
                    + " VALUES ('" + titletxt + "','" + fnmetxt + "','" + lnametxt + "','" + mnametxt + "','" + idtxt + "',"
                    + "'" + dobtxt + "','" + sextxt + "','" + residencetxt + "','" + countytxt + "','" + todaysdate + "')";

            Data data = new Data();
            data.ExecuteSQL(sql);
            data = null;

            kins.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARTICULARS OF  " + fnmetxt + "  NEXT OF KIN (B)",
                    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.CENTER,
                    new java.awt.Font("Lucida Sans", 1, 16), Color.WHITE));

            JOptionPane.showMessageDialog(null, "Deceased successfully added, \n please fill in rest of the form as required", "SUCCESS", JOptionPane.PLAIN_MESSAGE, null);
            tabs.setSelectedIndex(1);
        }
    }

    public void submitkin() {
        //,name2txt,id1txt,id2txt,relation1,relation2,residnce1,residence2,adress1,adress2,phone1,phone2

        fname1txt = KFNAME.getText();
        fname2txt = KNAMESTWO.getText();
        lnametxt1 = KLNAME.getText();
        lnametxt2 = KLNAME2.getText();
        id1txt = KID.getText();
        id2txt = KIDTWO.getText();
        relation1 = RELATION.getText();
        relation2 = RELATIONTWO.getText();
        residnce1 = RESIDENCE.getText();
        residence2 = RESIDENCETWO.getText();
        adress1 = ADDRESS.getText();
        adress2 = ADDRESSTWO.getText();
        phone1 = TELEPHONE.getText();
        phone2 = TELEPHONETWO.getText();
        contact = getcontact();

        if (contact == "contact1") {
            contctbolean = 1;

        }
        if ((fname1txt.equals("")) || (lnametxt1.equals("")) || (id1txt.equals("")) || (relation1.equals("")) || (residnce1.equals(""))
                || (adress1.equals("")) || (phone1.equals(""))) {

            JOptionPane.showMessageDialog(this, "    Please fill in all the Fields.", "alert", JOptionPane.WARNING_MESSAGE, null);

        } else {

            String sql = "INSERT INTO nextkin (f_name,l_name,Id_nok,relationship,Residence,Postal_address,Telephone_no,Contact,Admin_no) "
                    + " VALUES ('" + fname1txt + "','" + lnametxt1 + "','" + id1txt + "','" + relation1 + "','" + residnce1 + "',"
                    + "'" + adress1 + "','" + phone1 + "','" + contctbolean + "','" + present + "')";

            Data data = new Data();
            data.ExecuteSQL(sql);
            data = null;

            JOptionPane.showMessageDialog(null, "Kin information succesfuly posted", "SUCCESS", JOptionPane.PLAIN_MESSAGE, null);

            tabs.setSelectedIndex(2);
        }
    }

    public void deathstuff() {

        String deathdyte, deathplace, causeofdeth, description, burial,polinrmalcse, police, notice, copfname, coplname, pstation, prank, pservce;

        deathdet = (java.sql.Date) datePicker2.getModel().getValue();
        deathdyte = deathdet.toString();
        //deathdyte = DDATEDEATH.getDate().toString();
        deathplace = DPLACE.getText();
        causeofdeth = causes_death.getSelectedItem().toString();
        polinrmalcse = naturecombo.getSelectedItem().toString();
        description = TXTANOD.getText();
        burial = PermitNo.getText();
        police = OB.getText();
        notice = NODeath.getText();
        copfname = PNAME.getText();
        coplname = PNAME2.getText();
        pstation = PoliceStation.getText();
        prank = RANK.getSelectedItem().toString();
        pservce = SERVICENO.getText();

        if ((deathdyte.equals("")) || (deathplace.equals("")) || (causeofdeth.equals("")) || (description.equals("")) && (burial.equals(""))
                && (police.equals("")) && (notice.equals(""))) {

            JOptionPane.showMessageDialog(this, "    Please fill in all the Fields.", "alert", JOptionPane.WARNING_MESSAGE, null);

        } else {

            String sql = "INSERT INTO deaths_info (admission_repo,deathdate,place_of_death,cause_of_death,death_nature,poli_norm_case,burial_perm_no,notice_o_death,"
                    + "police_letter,service_no,police_fname,police_lname,station_police,p_rank) "
                    + " VALUES ('" + 9 + "','" + deathdyte + "','" + deathplace + "','" + causeofdeth + "','" + description + "','"+polinrmalcse+"','" + burial + "',"
                    + "'" + notice + "','" + police + "','" + pservce + "','" + copfname + "','" + coplname + "','" + pstation + "','" + prank + "')";

            Data data = new Data();
            data.ExecuteSQL(sql);
            data = null;

            JOptionPane.showMessageDialog(null, "Deceased successfully added, \n please fill in rest of the form as required", "SUCCESS", JOptionPane.PLAIN_MESSAGE, null);
            Servicesdialog dia = new Servicesdialog(null,closable);
            dia.show();
            dispose();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obbj = e.getSource();

        if (obbj == next) {
            pushbiodetails();
        } else if (obbj == nextkin) {

            submitkin();
        } else if (obbj == netxdeath) {

            deathstuff();
        }

    }

    private void ifcop() {
        if (naturecombo.getSelectedItem() == "POLICE CASE") {
            OB.setEnabled(true);
            PoliceStation.setEnabled(true);
            PNAME.setEnabled(true);
            PNAME2.setEnabled(true);
            RANK.setEnabled(true);
            SERVICENO.setEnabled(true);
        } else if (naturecombo.getSelectedItem() == "NORMAL CASE") {
            OB.setEnabled(false);
            PoliceStation.setEnabled(false);
            PNAME.setEnabled(false);
            PNAME2.setEnabled(false);
            RANK.setEnabled(false);
            SERVICENO.setEnabled(false);

        } else if (naturecombo.getSelectedItem() == " ") {
            OB.setEnabled(false);
            PoliceStation.setEnabled(false);
            PNAME.setEnabled(false);
            PNAME2.setEnabled(false);
            RANK.setEnabled(false);
            SERVICENO.setEnabled(false);

        }
    }

    private String getcontact() {
        Enumeration<AbstractButton> allRadioButton = contactperson.getElements();
        while (allRadioButton.hasMoreElements()) {
            JRadioButton temp = (JRadioButton) allRadioButton.nextElement();
            if (temp.isSelected()) {
                contact = temp.getText();
            }
        }
        return contact;
    }

}
