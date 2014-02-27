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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Range_Rover_Sport
 */
public class Formadmin2 extends JInternalFrame implements ActionListener {

    private JTabbedPane tabs;
    private JPanel bio,deathinfo;
    private JPanel kins;
    private JPanel deceased;
    private JLabel official, Notification, burrialpermit, noticeOfDeath, policeLetter, policename, Pstation, Prank, Sno, policeheader;
    private JTextField PermitNo, NODeath, OB, PNAME, PoliceStation, RANK, SERVICENO;
    private JCheckBox Bp, NatureOD, POB;
    private JButton add;
    private JComboBox title, sexx,county;
    private String[] countylist = {" ","Meru", "Tharaka Nithi","Embu","Kitui","Machakos","Makueni","Nyandarua","Nyeri"
        + "Kirinyaga","Murang'a","Kiambu","Turkana.","West Pokot","Samburu","Trans Nzoia","Uasin Gishu","Elgeyo/Marakwet"
        + "Nandi","Baringo", "Laikipia","Nakuru","Narok."};
    private JButton next;
    private JLabel Title, First_Name, middlename, lastname, Did, kid, DOB, Tag, NOD, relation, residence, address, telephone, contactpersn,countyy;
    private JLabel knames, PONE, PTWO, dresidence, PME, BodyLocation, PMI, forensic, hasPM, Services, sexlabel;
    private ButtonGroup sex, contactperson;
    private JLabel DplaceofDeath, DdateOfDeath;
    private JTextArea TXTANOD;
    private JLabel DsexM, DsexF;
    private JTextField DNames, MNAme, LName, DID, DPLACE, Dresidencetxt, TagNo, KNAMES, KID, RELATION, RESIDENCE, ADDRESS, TELEPHONE, KNAMESTWO, KIDTWO, RELATIONTWO, RESIDENCETWO, ADDRESSTWO, TELEPHONETWO;
    private JXDatePicker DDATEDEATH, DateofBirth;
    private JRadioButton male, female, contct1, contact2;

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

        tabs.add(generateHtml("Bio Information", tabButtonCss), bio);
        tabs.add(generateHtml(" Kin Info ", tabButtonCss), kins);
        tabs.add(generateHtml(" Death Info ", tabButtonCss),deathinfo);

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
        TagNo.setText("namba here");

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

        DateofBirth = new JXDatePicker();
        DateofBirth.setBounds(350, 155, 200, 30);
        DateofBirth.setFont(new Font("Lucida Sans", Font.BOLD, 16));

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
       
        
       
        
        
//        DsexM = new JLabel();
//        DsexM.setText("Male :");
//        DsexM.setForeground(new Color(186, 190, 198));
//        DsexM.setFont(new Font("Lucida Sans", Font.BOLD, 17));
//        DsexM.setBounds(590, 125, 80, 30);
//
//        sex = new ButtonGroup();
//
//        male = new JRadioButton("male");
//        male.setBorder(null);
//        sex.add(male);
//        male.setSelected(true);
//        male.setBounds(665, 140, 12, 10);
//
//        DsexF = new JLabel();
//        DsexF.setText("Female :");
//        DsexF.setForeground(new Color(186, 190, 198));
//        DsexF.setFont(new Font("Lucida Sans", Font.BOLD, 17));
//        DsexF.setBounds(685, 125, 80, 30);
//
//        female = new JRadioButton("female");
//        sex.add(female);
//        female.setBorder(null);
//        female.setBounds(765, 140, 12, 10);
        DdateOfDeath = new JLabel();
        DdateOfDeath.setText("Date of death    :");
        DdateOfDeath.setForeground(new Color(186, 190, 198));
        DdateOfDeath.setFont(new Font("Lucida Sans", Font.BOLD, 17));
        DdateOfDeath.setBounds(120, 170, 200, 30);

        DDATEDEATH = new JXDatePicker();
        DDATEDEATH.setBounds(250, 170, 190, 30);
        DDATEDEATH.setFont(new Font("Lucida Sans", Font.BOLD, 16));

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
        bio.add(DateofBirth);
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

        knames = new JLabel();
        knames.setText("Full names :");
        knames.setForeground(new Color(186, 190, 198));
        knames.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        knames.setBounds(8, 60, 200, 30);

        KNAMES = new komponenMakeOver.textfieldMakeover();
        KNAMES.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KNAMES.setForeground(new Color(242, 242, 189));
        KNAMES.setBounds(115, 60, 220, 30);

        KNAMESTWO = new komponenMakeOver.textfieldMakeover();
        KNAMESTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KNAMESTWO.setForeground(new Color(242, 242, 189));
        KNAMESTWO.setBounds(345, 60, 220, 30);

        kid = new JLabel();
        kid.setText("ID/PPNO :");
        kid.setForeground(new Color(186, 190, 198));
        kid.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        kid.setBounds(8, 100, 200, 30);

        KID = new komponenMakeOver.textfieldMakeover();
        KID.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KID.setForeground(new Color(242, 242, 189));
        KID.setBounds(115, 100, 220, 30);

        KIDTWO = new komponenMakeOver.textfieldMakeover();
        KIDTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KIDTWO.setForeground(new Color(242, 242, 189));
        KIDTWO.setBounds(345, 100, 220, 30);

        relation = new JLabel();
        relation.setText("Relation :");
        relation.setForeground(new Color(186, 190, 198));
        relation.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        relation.setBounds(8, 140, 200, 30);

        RELATION = new komponenMakeOver.textfieldMakeover();
        RELATION.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RELATION.setForeground(new Color(242, 242, 189));
        RELATION.setBounds(115, 140, 220, 30);

        RELATIONTWO = new komponenMakeOver.textfieldMakeover();
        RELATIONTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RELATIONTWO.setForeground(new Color(242, 242, 189));
        RELATIONTWO.setBounds(345, 140, 220, 30);

        residence = new JLabel();
        residence.setText("Residence");
        residence.setForeground(new Color(186, 190, 198));
        residence.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        residence.setBounds(8, 180, 200, 30);

        RESIDENCE = new komponenMakeOver.textfieldMakeover();
        RESIDENCE.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RESIDENCE.setForeground(new Color(242, 242, 189));
        RESIDENCE.setBounds(115, 180, 220, 30);

        RESIDENCETWO = new komponenMakeOver.textfieldMakeover();
        RESIDENCETWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RESIDENCETWO.setForeground(new Color(242, 242, 189));
        RESIDENCETWO.setBounds(345, 180, 220, 30);

        address = new JLabel();
        address.setText("Address :");
        address.setForeground(new Color(186, 190, 198));
        address.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        address.setBounds(8, 220, 200, 30);

        ADDRESS = new komponenMakeOver.textfieldMakeover();
        ADDRESS.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        ADDRESS.setForeground(new Color(242, 242, 189));
        ADDRESS.setBounds(115, 220, 220, 30);

        ADDRESSTWO = new komponenMakeOver.textfieldMakeover();
        ADDRESSTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        ADDRESSTWO.setForeground(new Color(242, 242, 189));
        ADDRESSTWO.setBounds(345, 220, 220, 30);

        telephone = new JLabel();
        telephone.setText("Phone No :");
        telephone.setForeground(new Color(186, 190, 198));
        telephone.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        telephone.setBounds(8, 260, 200, 30);

        TELEPHONE = new komponenMakeOver.textfieldMakeover();
        TELEPHONE.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        TELEPHONE.setForeground(new Color(242, 242, 189));
        TELEPHONE.setBounds(115, 260, 220, 30);

        TELEPHONETWO = new komponenMakeOver.textfieldMakeover();
        TELEPHONETWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        TELEPHONETWO.setForeground(new Color(242, 242, 189));
        TELEPHONETWO.setBounds(345, 260, 220, 30);

        contactpersn = new JLabel();
        contactpersn.setText("Contact Person :");
        contactpersn.setForeground(new Color(186, 190, 198));
        contactpersn.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        contactpersn.setBounds(8, 300, 200, 30);

        contactperson = new ButtonGroup();

        contct1 = new JRadioButton();
        contactperson.add(contct1);
        contct1.setBorder(null);
        contct1.setBounds(145, 310, 20, 20);

        contact2 = new JRadioButton();
        contactperson.add(contact2);
        contact2.setBorder(null);
        contact2.setBounds(365, 310, 20, 20);

        kins.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARTICULARS OF NEXT OF KIN PERSON/FAMILY (B)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16), Color.WHITE));
        kins.add(knames);
        kins.add(KNAMES);
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

    }
    
    public void deathinfo(){
    
        deathinfo = new komponenMakeOver.panelmakeOver();
        deathinfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, 
                "Death Particulars and Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16), Color.WHITE));
        deathinfo.setLayout(null);
        
        Notification = new JLabel();
        Notification.setText("Notification of death was through :");
        Notification.setForeground(new Color(186, 190, 198));
        Notification.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Notification.setBounds(4, 360, 350, 30);

        Bp = new JCheckBox();
        Bp.setBorderPainted(false);
        Bp.setBackground(new Color(57, 105, 138));
        Bp.setBounds(260, 370, 20, 15);

        burrialpermit = new JLabel();
        burrialpermit.setText("Burial permit No      :");
        burrialpermit.setForeground(new Color(186, 190, 198));
        burrialpermit.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        burrialpermit.setBounds(290, 360, 200, 30);

        PermitNo = new komponenMakeOver.textfieldMakeover();
        PermitNo.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        PermitNo.setForeground(new Color(242, 242, 189));
        PermitNo.setBounds(450, 360, 200, 30);

        NatureOD = new JCheckBox();
        NatureOD.setBorderPainted(false);
        NatureOD.setBackground(new Color(57, 105, 138));
        NatureOD.setBounds(260, 410, 20, 15);

        noticeOfDeath = new JLabel();
        noticeOfDeath.setText("Notice of death/No  :");
        noticeOfDeath.setForeground(new Color(186, 190, 198));
        noticeOfDeath.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        noticeOfDeath.setBounds(290, 400, 200, 30);

        NODeath = new komponenMakeOver.textfieldMakeover();
        NODeath.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        NODeath.setForeground(new Color(242, 242, 189));

        NODeath.setBounds(450, 400, 200, 30);

        POB = new JCheckBox();
        POB.setBorderPainted(false);
        POB.setBackground(new Color(57, 105, 138));
        POB.setBounds(260, 450, 20, 15);

        policeLetter = new JLabel();
        policeLetter.setText("Police letter/OB NO :");
        policeLetter.setForeground(new Color(186, 190, 198));
        policeLetter.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        policeLetter.setBounds(290, 440, 200, 30);

        OB = new komponenMakeOver.textfieldMakeover();
        OB.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        OB.setForeground(new Color(242, 242, 189));
        OB.setBounds(450, 440, 200, 30);

        policeheader = new JLabel();
        policeheader.setText(": : :Body accompanied by police: : : ");
        policeheader.setForeground(new Color(255, 220, 35));
        policeheader.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        policeheader.setBounds(8, 460, 300, 30);

        policename = new JLabel();
        policename.setText("Names :");
        policename.setForeground(new Color(186, 190, 198));
        policename.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        policename.setBounds(4, 500, 200, 30);

        PNAME = new komponenMakeOver.textfieldMakeover();
        PNAME.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        PNAME.setForeground(new Color(242, 242, 189));
        PNAME.setBounds(70, 500, 130, 30);

        Pstation = new JLabel();
        Pstation.setText("Police station :");
        Pstation.setForeground(new Color(186, 190, 198));
        Pstation.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Pstation.setBounds(210, 500, 200, 30);

        PoliceStation = new komponenMakeOver.textfieldMakeover();
        PoliceStation.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        PoliceStation.setForeground(new Color(242, 242, 189));
        PoliceStation.setBounds(330, 500, 130, 30);

        Prank = new JLabel();
        Prank.setText("Rank :");
        Prank.setForeground(new Color(186, 190, 198));
        Prank.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Prank.setBounds(4, 540, 200, 30);

        RANK = new komponenMakeOver.textfieldMakeover();
        RANK.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RANK.setForeground(new Color(242, 242, 189));
        RANK.setBounds(70, 540, 130, 30);

        Sno = new JLabel();
        Sno.setText("Service No :");
        Sno.setForeground(new Color(186, 190, 198));
        Sno.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Sno.setBounds(210, 540, 200, 30);

        SERVICENO = new komponenMakeOver.textfieldMakeover();
        SERVICENO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        SERVICENO.setForeground(new Color(242, 242, 189));
        SERVICENO.setBounds(330, 540, 130, 30);

        add = new komponenMakeOver.buttonMakeOverRectangle();
        add.setText("Add");
        add.setForeground(new Color(242, 242, 189));
        add.setIcon(new ImageIcon("src/images/male.png"));
        add.setBounds(470, 500, 215, 80);
       // add.addActionListener(listener);
        
        deathinfo.add(Notification);
        deathinfo.add(Bp);
        deathinfo.add(burrialpermit);
        deathinfo.add(PermitNo);
        deathinfo.add(NatureOD);
        deathinfo.add(noticeOfDeath);
        deathinfo.add(NODeath);
        deathinfo.add(POB);
        deathinfo.add(policeLetter);
        deathinfo.add(OB);
        deathinfo.add(policeheader);
        
        
    
    
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obbj = e.getSource();

        if (obbj == next) {

            tabs.setSelectedIndex(1);
        }
    }

}
