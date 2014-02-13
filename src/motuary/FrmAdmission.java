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
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Aladeen
 */
public class FrmAdmission extends JInternalFrame{
    
    private JPanel deceased;
    private JPanel kins;
    private JPanel postmotermEvent;
    private JPanel services;
    private JPanel others;
    private JLabel FullDnames,knames,PONE,PTWO,PME,BodyLocation,PMI,forensic,hasPM,Services;
    private JLabel Did,kid,Dage,Tag,NOD,relation,residence,address,telephone;
    private JLabel DsexM,DsexF;
    private JLabel DplaceofDeath;
    private JLabel DdateOfDeath;
    private JTextField DNames,DID,DPLACE,DAGE,TagNo,KNAMES,KID,RELATION,RESIDENCE,ADDRESS,TELEPHONE,KNAMESTWO,KIDTWO,RELATIONTWO,RESIDENCETWO,ADDRESSTWO,TELEPHONETWO;
    private JXDatePicker DDATEDEATH;
    private JRadioButton male,female;
    private JTextArea TXTANOD;
    private JTextField location,days;
    private JComboBox yesone,yestwo;
    
    private JLabel preservation,Pterm,recons,cosmesis,OtherS,dates;
    private JCheckBox PRESERVATION,POSMOTERM,RECONSTRUCTION,COSMESIS,OTHERS;
    private JTextArea OTHERSERVICES;
    
    private JLabel official,Notification,burrialpermit,noticeOfDeath,policeLetter,policename,Pstation,Prank,Sno,policeheader;
    private JTextField PermitNo,NODeath,OB,PNAME,PoliceStation,RANK,SERVICENO;
    private JCheckBox Bp,NatureOD,POB;
    private JButton add;
    
    private SimpleDateFormat formatter;

    
    
    
    Dimension display=Toolkit.getDefaultToolkit().getScreenSize();
    

    public FrmAdmission() {
       
        super("Admission Form");
        initial();
        
        setBounds(5, 20,display.width-15 ,display.height-95);
        setFrameIcon(new ImageIcon("src/images/add.png"));
        setClosable(true);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        add(deceased);
        add(kins);
        add(services);
        
        
        
        
    }
    public void  initial(){
        
        ButtonListener listener=new ButtonListener();
        
       
        Tag=new JLabel();
        Tag.setText("TAG/ADMIN NO:");
        Tag.setForeground(new Color(255,220,35));
        Tag.setFont(new Font("Lucida Sans", Font.BOLD, 12));
        Tag.setBounds(385, 10, 150, 30);
        
        TagNo=new komponenMakeOver.textfieldColdroomMakeover();
        TagNo.setBounds(495, 11, 150, 30);
        
        FullDnames=new JLabel();
        FullDnames.setText("Full Names       :");
        FullDnames.setForeground(new Color(186,190,198));
        FullDnames.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        FullDnames.setBounds(4, 60, 200, 30);
        
        
        DNames=new komponenMakeOver.textfieldMakeover();
        DNames.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        DNames.setForeground(new Color(242,242,189));
        DNames.setBounds(130, 60, 504, 30);
        
        Did=new JLabel();
        Did.setText("ID/PP No          :");
        Did.setForeground(new Color(186,190,198));
        Did.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Did.setBounds(4, 110, 200, 30);
        
        DID=new komponenMakeOver.textfieldMakeover();
        DID.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        DID.setForeground(new Color(242,242,189));
        DID.setBounds(130, 110, 100, 30);
        
        Dage=new JLabel();
        Dage.setText("Age :");
        Dage.setForeground(new Color(186,190,198));
        Dage.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Dage.setBounds( 236,110, 80, 30);
        
        DAGE=new komponenMakeOver.textfieldMakeover();
        DAGE.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        DAGE.setForeground(new Color(242,242,189));
        DAGE.setBounds(286,110, 50, 30);
        
        DsexM=new JLabel();
        DsexM.setText("Male :");
        DsexM.setForeground(new Color(186,190,198));
        DsexM.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        DsexM.setBounds( 346, 110, 80, 30);
        
        male=new JRadioButton("male");
        male.setBorder(null);
        male.setBounds(400, 123, 12, 10);
        
        DsexF=new JLabel();
        DsexF.setText("Female :");
        DsexF.setForeground(new Color(186,190,198));
        DsexF.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        DsexF.setBounds( 436, 110, 80, 30);
        
        female=new JRadioButton("female");
        female.setBorder(null);
        female.setBounds(506, 123, 12, 10);
        
        DdateOfDeath=new JLabel();
        DdateOfDeath.setText("Date of death    :");
        DdateOfDeath.setForeground(new Color(186,190,198));
        DdateOfDeath.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        DdateOfDeath.setBounds(4, 150, 200, 30);
       
        DDATEDEATH=new JXDatePicker();
        DDATEDEATH.setBounds(130, 150,190, 30);
        DDATEDEATH.setFont(new Font("Lucida Sans", Font.BOLD, 16));
  
        
        DplaceofDeath=new JLabel();
        DplaceofDeath.setText("Place of death :");
        DplaceofDeath.setForeground(new Color(186,190,198));
        DplaceofDeath.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        DplaceofDeath.setBounds(330, 150, 200, 30);
        
        DPLACE=new komponenMakeOver.textfieldMakeover();
        DPLACE.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        DPLACE.setForeground(new Color(242,242,189));
        DPLACE.setBounds(450, 150, 180, 30);
        
        
        NOD=new JLabel();
        NOD.setText("Nature of death :");
        NOD.setForeground(new Color(186,190,198));
        NOD.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        NOD.setBounds(4, 190, 200, 30);
        
        TXTANOD=new JTextArea();
        TXTANOD.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        TXTANOD.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        TXTANOD.setForeground(Color.WHITE);
        TXTANOD.setWrapStyleWord(true);
        TXTANOD.setLineWrap(true);
        TXTANOD.setOpaque(false);
        TXTANOD.setCaretColor(Color.YELLOW);
        TXTANOD.setBounds(130, 200, 500, 50);
        
        
        PONE=new JLabel();
        PONE.setText("PERSON I");
        PONE.setForeground(new Color(255,220,35));
        PONE.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        PONE.setIcon(new ImageIcon(""));
        PONE.setBounds(165, 30, 200, 30);
        
        PTWO=new JLabel();
        PTWO.setText("PERSON II");
        PTWO.setForeground(new Color(255,220,35));
        PTWO.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        PTWO.setIcon(new ImageIcon(""));
        PTWO.setBounds(395, 30, 200, 30);
        
        knames=new JLabel();
        knames.setText("Full names :");
        knames.setForeground(new Color(186,190,198));
        knames.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        knames.setBounds(8, 60, 200, 30);
        
        
        KNAMES=new komponenMakeOver.textfieldMakeover();
        KNAMES.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KNAMES.setForeground(new Color(242,242,189));
        KNAMES.setBounds(115, 60, 220, 30);
        
        KNAMESTWO=new komponenMakeOver.textfieldMakeover();
        KNAMESTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KNAMESTWO.setForeground(new Color(242,242,189));
        KNAMESTWO.setBounds(345, 60, 220, 30);
        
        kid=new JLabel();
        kid.setText("ID/PPNO :");
        kid.setForeground(new Color(186,190,198));
        kid.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        kid.setBounds(8, 100, 200, 30);
        
                
        KID=new komponenMakeOver.textfieldMakeover();
        KID.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KID.setForeground(new Color(242,242,189));
        KID.setBounds(115, 100, 220, 30);
        
        KIDTWO=new komponenMakeOver.textfieldMakeover();
        KIDTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        KIDTWO.setForeground(new Color(242,242,189));
        KIDTWO.setBounds(345, 100, 220, 30);
        
        
        
        relation=new JLabel();
        relation.setText("Relation :");
        relation.setForeground(new Color(186,190,198));
        relation.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        relation.setBounds(8, 140, 200, 30);
        
        RELATION=new komponenMakeOver.textfieldMakeover();
        RELATION.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RELATION.setForeground(new Color(242,242,189));
        RELATION.setBounds(115, 140, 220, 30);
        
        
        RELATIONTWO=new komponenMakeOver.textfieldMakeover();
        RELATIONTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RELATIONTWO.setForeground(new Color(242,242,189));
        RELATIONTWO.setBounds(345, 140, 220, 30);
        
        
        residence=new JLabel();
        residence.setText("Residence :");
        residence.setForeground(new Color(186,190,198));
        residence.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        residence.setBounds(8, 180, 200, 30);
        
       
        RESIDENCE=new komponenMakeOver.textfieldMakeover();
        RESIDENCE.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RESIDENCE.setForeground(new Color(242,242,189));
        RESIDENCE.setBounds(115, 180, 220, 30);
        
        RESIDENCETWO=new komponenMakeOver.textfieldMakeover();
        RESIDENCETWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RESIDENCETWO.setForeground(new Color(242,242,189));
        RESIDENCETWO.setBounds(345, 180, 220, 30);
        
        
        address=new JLabel();
        address.setText("Address :");
        address.setForeground(new Color(186,190,198));
        address.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        address.setBounds(8, 220, 200, 30);
        
        
        
        ADDRESS=new komponenMakeOver.textfieldMakeover();
        ADDRESS.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        ADDRESS.setForeground(new Color(242,242,189));
        ADDRESS.setBounds(115, 220, 220, 30);
        
        ADDRESSTWO=new komponenMakeOver.textfieldMakeover();
        ADDRESSTWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        ADDRESSTWO.setForeground(new Color(242,242,189));
        ADDRESSTWO.setBounds(345, 220, 220, 30);
        
        telephone=new JLabel();
        telephone.setText("Phone No :");
        telephone.setForeground(new Color(186,190,198));
        telephone.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        telephone.setBounds(8, 260, 200, 30);
        
        TELEPHONE=new komponenMakeOver.textfieldMakeover();
        TELEPHONE.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        TELEPHONE.setForeground(new Color(242,242,189));
        TELEPHONE.setBounds(115, 260, 220, 30);
        
        TELEPHONETWO=new komponenMakeOver.textfieldMakeover();
        TELEPHONETWO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        TELEPHONETWO.setForeground(new Color(242,242,189));
        TELEPHONETWO.setBounds(345, 260, 220, 30);
        
        
        PME=new JLabel();
        PME.setText(": : : :POSTMORTEM EVENTS (C1): : : : ");
        PME.setForeground(new Color(255,220,35));
        PME.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        PME.setBounds(8, 30, 300, 30);
        
        BodyLocation=new JLabel();
        BodyLocation.setText("Name of the place the body was brought from  :");
        BodyLocation.setForeground(new Color(186,190,198));
        BodyLocation.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        BodyLocation.setBounds(4, 70, 350, 30);
        
        location=new komponenMakeOver.textfieldMakeover();
        location.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        location.setForeground(new Color(242,242,189));
        location.setBounds(360, 70, 250, 30);
        
        PMI=new JLabel();
        PMI.setText("Postmortem Intervals(Days)  :");
        PMI.setForeground(new Color(186,190,198));
        PMI.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        PMI.setBounds(4, 110, 300, 30);
        
        days=new komponenMakeOver.textfieldMakeover();
        days.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        days.setForeground(new Color(242,242,189));
        days.setBounds(230, 110, 50, 30);
        
        hasPM=new JLabel();
        hasPM.setText("Has a Postmortem been done? :");
        hasPM.setForeground(new Color(186,190,198));
        hasPM.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        hasPM.setBounds(290, 110, 300, 30);
        
        yesone=new komponenMakeOver.comboboxMakeOver();
        yesone.addItem("YES");
        yesone.addItem("NO");
        yesone.setAlignmentY(CENTER_ALIGNMENT);
        yesone.setAlignmentX(CENTER_ALIGNMENT);
        yesone.setBounds(530, 110, 100, 30);
        
        forensic=new JLabel();
        forensic.setText("Is this a forensic(POLICE)case? :");
        forensic.setForeground(new Color(186,190,198));
        forensic.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        forensic.setBounds(4, 150, 300, 30);
        
        yestwo=new komponenMakeOver.comboboxMakeOver();
        yestwo.addItem("YES");
        yestwo.addItem("NO");
        yestwo.setAlignmentY(CENTER_ALIGNMENT);
        yestwo.setAlignmentX(CENTER_ALIGNMENT);
        yestwo.setBounds(240, 150, 100, 30);
        
        
        
        Services=new JLabel();
        Services.setText(": : : :SERVICES (C2): : : : ");
        Services.setForeground(new Color(255,220,35));
        Services.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Services.setBounds(8, 200, 300, 30);
        
        preservation=new JLabel();
        preservation.setText("Preservation & Storage :");
        preservation.setForeground(new Color(186,190,198));
        preservation.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        preservation.setBounds(4, 240, 250, 30);
        
        PRESERVATION=new JCheckBox();
        PRESERVATION.setBorderPainted(false);
        PRESERVATION.setBackground(new Color(57,105,138));
        PRESERVATION.setBounds(180, 250, 20, 15);
        
        recons=new JLabel();
        recons.setText("Reconstruction :");
        recons.setForeground(new Color(186,190,198));
        recons.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        recons.setBounds(210, 240, 250, 30);
        
        RECONSTRUCTION=new JCheckBox();
        RECONSTRUCTION.setBorderPainted(false);
        RECONSTRUCTION.setBackground(new Color(57,105,138));
        RECONSTRUCTION.setBounds(325, 250, 20, 15);
        
        Pterm=new JLabel();
        Pterm.setText("Postmortem :");
        Pterm.setForeground(new Color(186,190,198));
        Pterm.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Pterm.setBounds(4, 280, 250, 30);
        
        POSMOTERM=new JCheckBox();
        POSMOTERM.setBorderPainted(false);
        POSMOTERM.setBackground(new Color(57,105,138));
        POSMOTERM.setBounds(110, 290, 20, 15);
        
        cosmesis=new JLabel();
        cosmesis.setText("Cosmesis :");
        cosmesis.setForeground(new Color(186,190,198));
        cosmesis.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        cosmesis.setBounds(150, 280, 250, 30);
        
        COSMESIS=new JCheckBox();
        COSMESIS.setBorderPainted(false);
        COSMESIS.setBackground(new Color(57,105,138));
        COSMESIS.setBounds(230, 290, 20, 15);
        
        OtherS=new JLabel();
        OtherS.setText("Other Services(Specify) :");
        OtherS.setForeground(new Color(186,190,198));
        OtherS.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        OtherS.setBounds(260, 280, 300, 30);
        
        OTHERSERVICES=new JTextArea();
        OTHERSERVICES.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        OTHERSERVICES.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        OTHERSERVICES.setForeground(Color.WHITE);
        OTHERSERVICES.setWrapStyleWord(true);
        OTHERSERVICES.setLineWrap(true);
        OTHERSERVICES.setOpaque(false);
        OTHERSERVICES.setCaretColor(Color.YELLOW);
        OTHERSERVICES.setBounds(450, 250, 230, 50);
        
        official=new JLabel();
        official.setText(": : : :NOTIFICATION OF DEATH (C3): : : : ");
        official.setForeground(new Color(255,220,35));
        official.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        official.setBounds(8, 320, 350, 30);
        
        Notification=new JLabel();
        Notification.setText("Notification of death was through :");
        Notification.setForeground(new Color(186,190,198));
        Notification.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Notification.setBounds(4, 360, 350, 30);
        
        Bp=new JCheckBox();
        Bp.setBorderPainted(false);
        Bp.setBackground(new Color(57,105,138));
        Bp.setBounds(260, 370, 20, 15);
        
        burrialpermit=new JLabel();
        burrialpermit.setText("Burial permit No      :");
        burrialpermit.setForeground(new Color(186,190,198));
        burrialpermit.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        burrialpermit.setBounds(290, 360, 200, 30);
        
        PermitNo=new komponenMakeOver.textfieldMakeover();
        PermitNo.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        PermitNo.setForeground(new Color(242,242,189));
        PermitNo.setBounds(450,360, 200, 30);
        
                
        NatureOD=new JCheckBox();
        NatureOD.setBorderPainted(false);
        NatureOD.setBackground(new Color(57,105,138));
        NatureOD.setBounds(260, 410, 20, 15);
        
        noticeOfDeath=new JLabel();
        noticeOfDeath.setText("Notice of death/No  :");
        noticeOfDeath.setForeground(new Color(186,190,198));
        noticeOfDeath.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        noticeOfDeath.setBounds(290, 400, 200, 30);
        
        NODeath=new komponenMakeOver.textfieldMakeover();
        NODeath.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        NODeath.setForeground(new Color(242,242,189));
        NODeath.setBounds(450,400, 200, 30);
        
        POB=new JCheckBox();
        POB.setBorderPainted(false);
        POB.setBackground(new Color(57,105,138));
        POB.setBounds(260, 450, 20, 15);
        
        policeLetter=new JLabel();
        policeLetter.setText("Police letter/OB NO :");
        policeLetter.setForeground(new Color(186,190,198));
        policeLetter.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        policeLetter.setBounds(290, 440, 200, 30);
        
        OB=new komponenMakeOver.textfieldMakeover();
        OB.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        OB.setForeground(new Color(242,242,189));
        OB.setBounds(450,440, 200, 30);
        
        policeheader=new JLabel();
        policeheader.setText(": : :Body accompanied by police: : : ");
        policeheader.setForeground(new Color(255,220,35));
        policeheader.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        policeheader.setBounds(8, 460, 300, 30);
        
        policename=new JLabel();
        policename.setText("Names :");
        policename.setForeground(new Color(186,190,198));
        policename.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        policename.setBounds(4, 500, 200, 30);
        
        PNAME=new komponenMakeOver.textfieldMakeover();
        PNAME.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        PNAME.setForeground(new Color(242,242,189));
        PNAME.setBounds(70,500, 130, 30);
        
        Pstation=new JLabel();
        Pstation.setText("Police station :");
        Pstation.setForeground(new Color(186,190,198));
        Pstation.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Pstation.setBounds(210, 500, 200, 30);
        
        PoliceStation=new komponenMakeOver.textfieldMakeover();
        PoliceStation.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        PoliceStation.setForeground(new Color(242,242,189));
        PoliceStation.setBounds(330,500, 130, 30);
        
        Prank=new JLabel();
        Prank.setText("Rank :");
        Prank.setForeground(new Color(186,190,198));
        Prank.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Prank.setBounds(4, 540, 200, 30);
        
        RANK=new komponenMakeOver.textfieldMakeover();
        RANK.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        RANK.setForeground(new Color(242,242,189));
        RANK.setBounds(70,540, 130, 30);
        
        Sno=new JLabel();
        Sno.setText("Service No :");
        Sno.setForeground(new Color(186,190,198));
        Sno.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        Sno.setBounds(210, 540, 200, 30);
        
        SERVICENO=new komponenMakeOver.textfieldMakeover();
        SERVICENO.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        SERVICENO.setForeground(new Color(242,242,189));
        SERVICENO.setBounds(330,540, 130, 30);
        
        
        
        
        add=new komponenMakeOver.buttonMakeOverRectangle();
        add.setText("Add");
        add.setForeground(new Color(242,242,189));
        add.setIcon(new ImageIcon("src/images/male.png"));
        add.setBounds(470, 500, 215, 80);
        add.addActionListener(listener);
        
        
    deceased=new komponenMakeOver.panelmakeOver();
    deceased.setBounds(0, 0,650, 270);
    deceased.setLayout(null);
    deceased.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARTICULARS OF DECEASED PERSON  (A)" , javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
    deceased.add(FullDnames);
    deceased.add(DNames);
    deceased.add(Did);
    deceased.add(DID);
    deceased.add(Dage);
    deceased.add(DAGE);
    deceased.add(DsexF);
    deceased.add(DsexM);
    deceased.add(male);
    deceased.add(female);
    deceased.add(DdateOfDeath);
    deceased.add(DDATEDEATH);
    deceased.add(DPLACE);
    deceased.add(DplaceofDeath);
    deceased.add(Tag);
    deceased.add(TagNo);
    deceased.add(NOD);
    deceased.add(TXTANOD);
    
    
    kins=new komponenMakeOver.panelmakeOver();
    kins.setBounds(0, 275,650, 310);
    kins.setLayout(null);
    kins.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARTICULARS OF NEXT OF KIN PERSON/FAMILY (B)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
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
    
    
    services=new komponenMakeOver.panelmakeOver();
    services.setBounds(650, 0,690, 800);
    services.setLayout(null);
    services.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARTICULARS OF PME/SERVICES/OFFICIAL USE (C)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
    services.add(PME);
    services.add(BodyLocation);
    services.add(location);
    services.add(PMI);
    services.add(days);
    services.add(hasPM);
    services.add(yesone);
    services.add(forensic);
    services.add(yestwo);
    services.add(Services);
    services.add(preservation);
    services.add(PRESERVATION);
    services.add(recons);
    services.add(RECONSTRUCTION);
    services.add(Pterm);
    services.add(POSMOTERM);
    services.add(COSMESIS);
    services.add(cosmesis);
    services.add(OTHERSERVICES);
    services.add(OtherS);
    services.add(official);
    services.add(Notification);
    services.add(Bp);
    services.add(burrialpermit);
    services.add(PermitNo);
    services.add(NODeath);
    services.add(NatureOD);
    services.add(noticeOfDeath);
    services.add(POB);
    services.add(OB);
    services.add(policeLetter);
    services.add(policename);
    services.add(PNAME);
    services.add(PoliceStation);
    services.add(Pstation);
    services.add(RANK);
    services.add(Prank);
    services.add(Sno);
    services.add(SERVICENO);
    services.add(add);
    services.add(policeheader);
    
    }
    private class ButtonListener implements ActionListener{
        
       public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==add){ 
                            
                            btnAddBody(e);}
				
                }
    
    
    };
    
    
 

    private void btnAddBody(java.awt.event.ActionEvent evt) { 
        
        
        String sql="INSERT INTO `mortury`.`admission` ( `B.NAMES`, `B.ID`, `B.AGE`,  `B.DOD`, `B.POD`, `B.NOD`) VALUES ('"+ DNames.getText().trim()+"','"+DID.getText().trim()+"','"+DAGE.getText().trim()+"','"+ DDATEDEATH.getDate() +"','"+DPLACE.getText().trim()+"','"+TXTANOD.getText()+"')";
        Data data = new Data();
        data.ExecuteSQL(sql);
        data = null;

    }    
    
    
}
