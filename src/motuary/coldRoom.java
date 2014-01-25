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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Njihia
 */
public class coldRoom extends JInternalFrame{
    
    
    private JPanel threeB;
    private JPanel threeA;
    private JPanel oneA;
    private JPanel oneB;
    private JPanel fiveA;
    private JPanel fiveB;
    private JPanel fiveC;
    private JPanel fourA;
    private JPanel fourB;
    private JPanel fourC;
    private JLabel anatomy;
    private JButton FthreeB;
    private JButton FthreeA;
    private JButton FOneB;
    private JButton FOneA;
    private JButton FfifthC;
    private JButton FfifthB;
    private JButton FfifthA;
    private JButton FfourthC;
    private JButton FfourthB;
    private JButton FfourthA;
    private JButton head;
    
    
    
    
    private JTextField B1,B2,B3,B4,B5,B6,B7,B8;
    private JTextField B9,B10,B11,B12,B13,B14,B15,B16;
    private JTextField B17,B18,B19,B20,B21,B22,B23,B24;
    private JTextField B25,B26,B27,B28,B29,B30,B31,B32;
    private JTextField B33,B34,B35,B36,B37,B38,B39,B40;
    private JTextField B41,B42,B43,B44,B45,B46,B47,B48;
    private JTextField B49,B50,B51,B52,B53,B54,B55,B56;
    private JTextField B57,B58,B59,B60,B61,B62,B63,B64;
    private JTextField B65,B66,B67,B68,B69,B70,B71,B72;
    private JTextField B73,B74,B75,B76,B77,B78,B79,B80;
    
    
    Dimension display=Toolkit.getDefaultToolkit().getScreenSize();

    public coldRoom() {
        
        super("COLD ROOM CATALOGUE");
        initial();
        setBounds(5, 20,display.width-15 ,display.height-95);
        setFrameIcon(new ImageIcon("src/images/headercld.png"));
        setBackground(new Color(41, 41, 41));
        setClosable(true);
        setLayout(null);
        add(threeB);
        add(threeA);
        add(fiveC);
        add(fiveB);
        add(fiveA);
        add(oneA);
        add(oneB);
        add(fourA);
        add(fourB);
        add(fourC);
        add(anatomy);
        add(head);
        
    }
    public void initial(){
        
        anatomy=new JLabel();
        anatomy.setText("ANATOMY CADAVERS");
        anatomy.setBounds(580, 0, 300, 50);
        anatomy.setForeground(new Color(242,242,189));
        anatomy.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        
        head=new komponenMakeOver.buttonMakeOverRectanglelogin();
        head.setBounds(500, 0, 340, 60);
        
        ///Frezzer F.NO.3B
        
        B1=new komponenMakeOver.textfieldColdroomMakeover();
        B1.setText("B1");
        B1.setBounds(3, 25, 120, 50);
        
        B2=new komponenMakeOver.textfieldColdroomMakeover();
        B2.setText("B2");
        B2.setBounds(127, 25, 120, 50);
        
        B3=new komponenMakeOver.textfieldColdroomMakeover();
        B3.setText("B3");
        B3.setBounds(3, 76, 120, 50);
        
        B4=new komponenMakeOver.textfieldColdroomMakeover();
        B4.setText("B4");
        B4.setBounds(127, 76, 120, 50);
        
        B5=new komponenMakeOver.textfieldColdroomMakeover();
        B5.setText("B5");
        B5.setBounds(3, 127, 120, 50);
        
        B6=new komponenMakeOver.textfieldColdroomMakeover();
        B6.setText("B6");
        B6.setBounds(127, 127, 120, 50);
        
        B7=new komponenMakeOver.textfieldColdroomMakeover();
        B7.setText("B7");
        B7.setBounds(3, 178, 120, 50);
        
        B8=new komponenMakeOver.textfieldColdroomMakeover();
        B8.setText("B8");
        B8.setBounds(127, 178, 120, 50);
        
        FthreeB=new komponenMakeOver.buttonMakeOverRectangle();
        FthreeB.setText("Quick Peek F.NO.3B");
        FthreeB.setForeground(new Color(242,242,189));
        FthreeB.setIcon(new ImageIcon("src/images/eye.png"));
        FthreeB.setBounds(3, 235, 243, 50);
        //FthreeB.addActionListener(listner);
        
        ///Frezer F.NO.3A
        
        B9=new komponenMakeOver.textfieldColdroomMakeover();
        B9.setText("B9");
        B9.setBounds(3, 25, 120, 50);
        
        B10=new komponenMakeOver.textfieldColdroomMakeover();
        B10.setText("B10");
        B10.setBounds(127, 25, 120, 50);
        
        B11=new komponenMakeOver.textfieldColdroomMakeover();
        B11.setText("B11");
        B11.setBounds(3, 76, 120, 50);
        
        B12=new komponenMakeOver.textfieldColdroomMakeover();
        B12.setText("B12");
        B12.setBounds(127, 76, 120, 50);
        
        B13=new komponenMakeOver.textfieldColdroomMakeover();
        B13.setText("B13");
        B13.setBounds(3, 127, 120, 50);
        
        B14=new komponenMakeOver.textfieldColdroomMakeover();
        B14.setText("B14");
        B14.setBounds(127, 127, 120, 50);
        
        B15=new komponenMakeOver.textfieldColdroomMakeover();
        B15.setText("B15");
        B15.setBounds(3, 178, 120, 50);
        
        B16=new komponenMakeOver.textfieldColdroomMakeover();
        B16.setText("B16");
        B16.setBounds(127, 178, 120, 50);
        
        FthreeA=new komponenMakeOver.buttonMakeOverRectangle();
        FthreeA.setText("Quick Peek F.NO.3A");
        FthreeA.setForeground(new Color(242,242,189));
        FthreeA.setIcon(new ImageIcon("src/images/eye.png"));
        FthreeA.setBounds(3, 235, 243, 50);
        //FthreeB.addActionListener(listner);
        
        ///Frezer F.NO.1B
        
        B17=new komponenMakeOver.textfieldColdroomMakeover();
        B17.setText("B17");
        B17.setBounds(3, 25, 120, 50);
        
        B18=new komponenMakeOver.textfieldColdroomMakeover();
        B18.setText("B18");
        B18.setBounds(127, 25, 120, 50);
        
        B19=new komponenMakeOver.textfieldColdroomMakeover();
        B19.setText("B9");
        B19.setBounds(3, 76, 120, 50);
        
        B20=new komponenMakeOver.textfieldColdroomMakeover();
        B20.setText("B20");
        B20.setBounds(127, 76, 120, 50);
        
        B21=new komponenMakeOver.textfieldColdroomMakeover();
        B21.setText("B21");
        B21.setBounds(3, 127, 120, 50);
        
        B22=new komponenMakeOver.textfieldColdroomMakeover();
        B22.setText("B22");
        B22.setBounds(127, 127, 120, 50);
        
        B23=new komponenMakeOver.textfieldColdroomMakeover();
        B23.setText("B23");
        B23.setBounds(3, 178, 120, 50);
        
        B24=new komponenMakeOver.textfieldColdroomMakeover();
        B24.setText("B24");
        B24.setBounds(127, 178, 120, 50);
        
        FOneB=new komponenMakeOver.buttonMakeOverRectangle();
        FOneB.setText("Quick Peek F.NO.1B");
        FOneB.setForeground(new Color(242,242,189));
        FOneB.setIcon(new ImageIcon("src/images/eye.png"));
        FOneB.setBounds(3, 235, 243, 50);
        //FthreeB.addActionListener(listner);
        
         ///Frezer F.NO.1B
        
        
        B25=new komponenMakeOver.textfieldColdroomMakeover();
        B25.setText("B25");
        B25.setBounds(3, 25, 120, 50);
        
        B26=new komponenMakeOver.textfieldColdroomMakeover();
        B26.setText("B26");
        B26.setBounds(127, 25, 120, 50);
        
        B27=new komponenMakeOver.textfieldColdroomMakeover();
        B27.setText("B27");
        B27.setBounds(3, 76, 120, 50);
        
        B28=new komponenMakeOver.textfieldColdroomMakeover();
        B28.setText("B28");
        B28.setBounds(127, 76, 120, 50);
        
        B29=new komponenMakeOver.textfieldColdroomMakeover();
        B29.setText("B29");
        B29.setBounds(3, 127, 120, 50);
        
        B30=new komponenMakeOver.textfieldColdroomMakeover();
        B30.setText("B30");
        B30.setBounds(127, 127, 120, 50);
        
        B31=new komponenMakeOver.textfieldColdroomMakeover();
        B31.setText("B31");
        B31.setBounds(3, 178, 120, 50);
        
        B32=new komponenMakeOver.textfieldColdroomMakeover();
        B32.setText("B32");
        B32.setBounds(127, 178, 120, 50);
        
        FOneA=new komponenMakeOver.buttonMakeOverRectangle();
        FOneA.setText("Quick Peek F.NO.1A");
        FOneA.setForeground(new Color(242,242,189));
        FOneA.setIcon(new ImageIcon("src/images/eye.png"));
        FOneA.setBounds(3, 235, 243, 50);
        //FthreeB.addActionListener(listner);
        
        
        
        B33=new komponenMakeOver.textfieldColdroomMakeover();
        B33.setText("B33");
        B33.setBounds(3, 25, 105, 50);
        
        B34=new komponenMakeOver.textfieldColdroomMakeover();
        B34.setText("B34");
        B34.setBounds(112, 25, 105, 50);
        
        B35=new komponenMakeOver.textfieldColdroomMakeover();
        B35.setText("B35");
        B35.setBounds(3, 76, 105, 50);
        
        B36=new komponenMakeOver.textfieldColdroomMakeover();
        B36.setText("B36");
        B36.setBounds(112, 76, 105, 50);
        
        B37=new komponenMakeOver.textfieldColdroomMakeover();
        B37.setText("B37");
        B37.setBounds(3, 127, 105, 50);
        
        B38=new komponenMakeOver.textfieldColdroomMakeover();
        B38.setText("B38");
        B38.setBounds(112, 127, 105, 50);
        
        B39=new komponenMakeOver.textfieldColdroomMakeover();
        B39.setText("B39");
        B39.setBounds(3, 178, 105, 50);
        
        B40=new komponenMakeOver.textfieldColdroomMakeover();
        B40.setText("B40");
        B40.setBounds(112, 178, 105, 50);
        
        
        FfifthC=new komponenMakeOver.buttonMakeOverRectangle();
        FfifthC.setText("Quick Peek F.NO.5C");
        FfifthC.setForeground(new Color(242,242,189));
        FfifthC.setIcon(new ImageIcon("src/images/eye.png"));
        FfifthC.setBounds(3, 235, 215, 50);
        //FthreeB.addActionListener(listner);
        
        B41=new komponenMakeOver.textfieldColdroomMakeover();
        B41.setText("B41");
        B41.setBounds(3, 25, 105, 50);
        
        B42=new komponenMakeOver.textfieldColdroomMakeover();
        B42.setText("B42");
        B42.setBounds(112, 25, 105, 50);
        
        B43=new komponenMakeOver.textfieldColdroomMakeover();
        B43.setText("B43");
        B43.setBounds(3, 76, 105, 50);
        
        B44=new komponenMakeOver.textfieldColdroomMakeover();
        B44.setText("B44");
        B44.setBounds(112, 76, 105, 50);
        
        B45=new komponenMakeOver.textfieldColdroomMakeover();
        B45.setText("B45");
        B45.setBounds(3, 127, 105, 50);
        
        B46=new komponenMakeOver.textfieldColdroomMakeover();
        B46.setText("B46");
        B46.setBounds(112, 127, 105, 50);
        
        B47=new komponenMakeOver.textfieldColdroomMakeover();
        B47.setText("B47");
        B47.setBounds(3, 178, 105, 50);
        
        B48=new komponenMakeOver.textfieldColdroomMakeover();
        B48.setText("B48");
        B48.setBounds(112, 178, 105, 50);
        
        
        FfifthB=new komponenMakeOver.buttonMakeOverRectangle();
        FfifthB.setText("Quick Peek F.NO.5B");
        FfifthB.setForeground(new Color(242,242,189));
        FfifthB.setIcon(new ImageIcon("src/images/eye.png"));
        FfifthB.setBounds(3, 235, 215, 50);
        //FthreeB.addActionListener(listner);
        
        
        
        B49=new komponenMakeOver.textfieldColdroomMakeover();
        B49.setText("B49");
        B49.setBounds(3, 25, 105, 50);
        
        B50=new komponenMakeOver.textfieldColdroomMakeover();
        B50.setText("B50");
        B50.setBounds(112, 25, 105, 50);
        
        B51=new komponenMakeOver.textfieldColdroomMakeover();
        B51.setText("B51");
        B51.setBounds(3, 76, 105, 50);
        
        B52=new komponenMakeOver.textfieldColdroomMakeover();
        B52.setText("B52");
        B52.setBounds(112, 76, 105, 50);
        
        B53=new komponenMakeOver.textfieldColdroomMakeover();
        B53.setText("B53");
        B53.setBounds(3, 127, 105, 50);
        
        B54=new komponenMakeOver.textfieldColdroomMakeover();
        B54.setText("B54");
        B54.setBounds(112, 127, 105, 50);
        
        B55=new komponenMakeOver.textfieldColdroomMakeover();
        B55.setText("B55");
        B55.setBounds(3, 178, 105, 50);
        
        B56=new komponenMakeOver.textfieldColdroomMakeover();
        B56.setText("B56");
        B56.setBounds(112, 178, 105, 50);
        
        
        FfifthA=new komponenMakeOver.buttonMakeOverRectangle();
        FfifthA.setText("Quick Peek F.NO.5A");
        FfifthA.setForeground(new Color(242,242,189));
        FfifthA.setIcon(new ImageIcon("src/images/eye.png"));
        FfifthA.setBounds(3, 235, 215, 50);
        //FthreeB.addActionListener(listner);
        
        
        B57=new komponenMakeOver.textfieldColdroomMakeover();
        B57.setText("B57");
        B57.setBounds(3, 25, 105, 50);
        
        B58=new komponenMakeOver.textfieldColdroomMakeover();
        B58.setText("B58");
        B58.setBounds(112, 25, 105, 50);
        
        B59=new komponenMakeOver.textfieldColdroomMakeover();
        B59.setText("B59");
        B59.setBounds(3, 76, 105, 50);
        
        B60=new komponenMakeOver.textfieldColdroomMakeover();
        B60.setText("B60");
        B60.setBounds(112, 76, 105, 50);
        
        B61=new komponenMakeOver.textfieldColdroomMakeover();
        B61.setText("B61");
        B61.setBounds(3, 127, 105, 50);
        
        B62=new komponenMakeOver.textfieldColdroomMakeover();
        B62.setText("B62");
        B62.setBounds(112, 127, 105, 50);
        
        B63=new komponenMakeOver.textfieldColdroomMakeover();
        B63.setText("B63");
        B63.setBounds(3, 178, 105, 50);
        
        B64=new komponenMakeOver.textfieldColdroomMakeover();
        B64.setText("B64");
        B64.setBounds(112, 178, 105, 50);
        
        
        FfourthC=new komponenMakeOver.buttonMakeOverRectangle();
        FfourthC.setText("Quick Peek F.NO.4C");
        FfourthC.setForeground(new Color(242,242,189));
        FfourthC.setIcon(new ImageIcon("src/images/eye.png"));
        FfourthC.setBounds(3, 235, 215, 50);
        //FthreeB.addActionListener(listner);
        
        
        B65=new komponenMakeOver.textfieldColdroomMakeover();
        B65.setText("B65");
        B65.setBounds(3, 25, 105, 50);
        
        B66=new komponenMakeOver.textfieldColdroomMakeover();
        B66.setText("B66");
        B66.setBounds(112, 25, 105, 50);
        
        B67=new komponenMakeOver.textfieldColdroomMakeover();
        B67.setText("B67");
        B67.setBounds(3, 76, 105, 50);
        
        B68=new komponenMakeOver.textfieldColdroomMakeover();
        B68.setText("B68");
        B68.setBounds(112, 76, 105, 50);
        
        B69=new komponenMakeOver.textfieldColdroomMakeover();
        B69.setText("B69");
        B69.setBounds(3, 127, 105, 50);
        
        B70=new komponenMakeOver.textfieldColdroomMakeover();
        B70.setText("B70");
        B70.setBounds(112, 127, 105, 50);
        
        B71=new komponenMakeOver.textfieldColdroomMakeover();
        B71.setText("B71");
        B71.setBounds(3, 178, 105, 50);
        
        B72=new komponenMakeOver.textfieldColdroomMakeover();
        B72.setText("B72");
        B72.setBounds(112, 178, 105, 50);
        
        
        FfourthB=new komponenMakeOver.buttonMakeOverRectangle();
        FfourthB.setText("Quick Peek F.NO.4B");
        FfourthB.setForeground(new Color(242,242,189));
        FfourthB.setIcon(new ImageIcon("src/images/eye.png"));
        FfourthB.setBounds(3, 235, 215, 50);
        //FthreeB.addActionListener(listner);
        
        
          
        B73=new komponenMakeOver.textfieldColdroomMakeover();
        B73.setText("B73");
        B73.setBounds(3, 25, 105, 50);
        
        B74=new komponenMakeOver.textfieldColdroomMakeover();
        B74.setText("B73");
        B74.setBounds(112, 25, 105, 50);
        
        B75=new komponenMakeOver.textfieldColdroomMakeover();
        B75.setText("B75");
        B75.setBounds(3, 76, 105, 50);
        
        B76=new komponenMakeOver.textfieldColdroomMakeover();
        B76.setText("B76");
        B76.setBounds(112, 76, 105, 50);
        
        B77=new komponenMakeOver.textfieldColdroomMakeover();
        B77.setText("B77");
        B77.setBounds(3, 127, 105, 50);
        
        B78=new komponenMakeOver.textfieldColdroomMakeover();
        B78.setText("B78");
        B78.setBounds(112, 127, 105, 50);
        
        B79=new komponenMakeOver.textfieldColdroomMakeover();
        B79.setText("B79");
        B79.setBounds(3, 178, 105, 50);
        
        B80=new komponenMakeOver.textfieldColdroomMakeover();
        B80.setText("B80");
        B80.setBounds(112, 178, 105, 50);
        
        
        FfourthA=new komponenMakeOver.buttonMakeOverRectangle();
        FfourthA.setText("Quick Peek F.NO.4A");
        FfourthA.setForeground(new Color(242,242,189));
        FfourthA.setIcon(new ImageIcon("src/images/eye.png"));
        FfourthA.setBounds(3, 235, 215, 50);
        //FthreeB.addActionListener(listner);
        
    
        
        threeB=new komponenMakeOver.panelmakeOver();
        threeB.setLayout(null);
        threeB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "F.NO.3A", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
        threeB.setBackground(Color.yellow);
        threeB.setBounds(0, 0, 250, 300);
        threeB.add(B1);
        threeB.add(B2);
        threeB.add(B3);
        threeB.add(B4);
        threeB.add(B5);
        threeB.add(B6);
        threeB.add(B7);
        threeB.add(B8);
        threeB.add(FthreeB);
        
        threeA=new komponenMakeOver.panelmakeOver();
        threeA.setLayout(null);
        threeA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "F.NO.3A", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
        threeA.setBackground(Color.GREEN);
        threeA.setBounds(250, 0, 250, 300);
        threeA.add(B9);
        threeA.add(B10);
        threeA.add(B11);
        threeA.add(B12);
        threeA.add(B13);
        threeA.add(B14);
        threeA.add(B15);
        threeA.add(B16);
        threeA.add(FthreeA);
        
        oneB=new komponenMakeOver.panelmakeOver();
        oneB.setLayout(null);
        oneB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "F.NO.1B", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
        oneB.setBackground(Color.PINK);
        oneB.setBounds(840, 0, 250, 300);
        oneB.add(B17);
        oneB.add(B18);
        oneB.add(B19);
        oneB.add(B20);
        oneB.add(B21);
        oneB.add(B22);
        oneB.add(B23);
        oneB.add(B24);
        oneB.add(FOneB);
        
        oneA=new komponenMakeOver.panelmakeOver();
        oneA.setLayout(null);
        oneA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "F.NO.1A", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
        oneA.setBackground(Color.RED);
        oneA.setBounds(1090, 0, 250, 300);
        oneA.add(B25);
        oneA.add(B26);
        oneA.add(B27);
        oneA.add(B28);
        oneA.add(B29);
        oneA.add(B30);
        oneA.add(B31);
        oneA.add(B32);
        oneA.add(FOneA);
        
        fiveC=new komponenMakeOver.panelmakeOver();
        fiveC.setLayout(null);
        fiveC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "F.NO.5C", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
        fiveC.setBackground(Color.blue);
        fiveC.setBounds(0, 300, 222, 300);
        fiveC.add(B33);
        fiveC.add(B34);
        fiveC.add(B35);
        fiveC.add(B36);
        fiveC.add(B37);
        fiveC.add(B38);
        fiveC.add(B39);
        fiveC.add(B40);
        fiveC.add(FfifthC);
        
        fiveB=new komponenMakeOver.panelmakeOver();
        fiveB.setLayout(null);
        fiveB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "F.NO.5C", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
        fiveB.setBackground(Color.ORANGE);
        fiveB.setBounds(222, 300, 222, 300);
        fiveB.add(B41);
        fiveB.add(B42);
        fiveB.add(B43);
        fiveB.add(B44);
        fiveB.add(B45);
        fiveB.add(B46);
        fiveB.add(B47);
        fiveB.add(B48);
        fiveB.add(FfifthB);
        
        fiveA=new komponenMakeOver.panelmakeOver();
        fiveA.setLayout(null);
        fiveA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "F.NO.5A", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
        fiveA.setBackground(Color.GRAY);
        fiveA.setBounds(444, 300, 222, 300);
        fiveA.add(B49);
        fiveA.add(B50);
        fiveA.add(B51);
        fiveA.add(B52);
        fiveA.add(B53);
        fiveA.add(B54);
        fiveA.add(B55);
        fiveA.add(B56);
        fiveA.add(FfifthA);
        
        fourC=new komponenMakeOver.panelmakeOver();
        fourC.setLayout(null);
        fourC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "F.NO.4C", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
        fourC.setBackground(Color.WHITE);
        fourC.setBounds(668, 300, 222, 300);
        fourC.add(B57);
        fourC.add(B58);
        fourC.add(B59);
        fourC.add(B60);
        fourC.add(B61);
        fourC.add(B62);
        fourC.add(B63);
        fourC.add(B64);
        fourC.add(FfourthC);
        
        fourB=new komponenMakeOver.panelmakeOver();
        fourB.setLayout(null);
        fourB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "F.NO.4B", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
        fourB.setBackground(Color.darkGray);
        fourB.setBounds(890, 300, 222, 300);
        fourB.add(B65);
        fourB.add(B66);
        fourB.add(B67);
        fourB.add(B68);
        fourB.add(B69);
        fourB.add(B70);
        fourB.add(B71);
        fourB.add(B72);
        fourB.add(FfourthB);
        
        fourA=new komponenMakeOver.panelmakeOver();
        fourA.setLayout(null);
        fourA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "F.NO.4A", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.CENTER, new java.awt.Font("Lucida Sans", 1, 16),Color.WHITE));
        fourA.setBackground(Color.MAGENTA);
        fourA.setBounds(1112, 300, 230, 300);
        fourA.add(B73);
        fourA.add(B74);
        fourA.add(B75);
        fourA.add(B76);
        fourA.add(B77);
        fourA.add(B78);
        fourA.add(B79);
        fourA.add(B80);
        fourA.add(FfourthA);
        
        
        
        
        
        
    
        
    }
    
    
    
    
    
    
    
    
    
}
