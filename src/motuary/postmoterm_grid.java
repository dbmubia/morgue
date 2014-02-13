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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 *
 * @author Range_Rover_Sport
 */
public class postmoterm_grid extends JInternalFrame {

    private JPanel container;
    private JButton hd;
    private JLabel topichd;
    private JLabel hdimage;
    public static JTable JTCusTable;
   public static JScrollPane CusTableJSP = new JScrollPane();    

  private static String querry="SELECT demo_admin.admin_no,demo_admin.names,demo_admin.admision_date,postmotermqueue.requester_name,postmotermqueue.requester_relation"
                                 + " FROM postmotermqueue,demo_admin"
                                 + " WHERE (postmotermqueue.admin_no = demo_admin.admin_no)";
  
  
  public static int rowNum = 0;
  public static int total = 0;
    

  Dimension display = Toolkit.getDefaultToolkit().getScreenSize();

    public static String Content[][];
    
    public postmoterm_grid() {

        super("POST MOTERM GRID");
        initial();

        Data userid = new Data();
     
        setBackground(new Color(61, 96, 121));
        
        
//        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).
//                getNorthPane();
//        this.remove(titlePane);
        

        this.setClosable(true);
        add(container);
    }

    private void initial() {
        
       
                     
       // container = new komponenMakeOver.tablepanelmakeover();
        
        container= new JPanel();
        container.setBounds(5, 200, 1200, 400);
        container.setBackground(new Color(255, 255, 255));
        
        
        
        hd = new komponenMakeOver.buttonMakeOverRectanglelogin();
        hd.setBounds(0, 0, 800, 32);

        hdimage = new JLabel(new ImageIcon("src/images/Bimage.png"));
        hdimage.setBounds(2, 2, 32, 32);

        topichd = new JLabel("POST MOTERM HUB");
        topichd.setForeground(new Color(242, 242, 189));
        topichd.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        topichd.setBounds(300, 0, 300, 30);
        
 		//-- Add the CusTable
        JTCusTable=CreateTable();
        CusTableJSP.setBackground(Color.red);
        CusTableJSP.getViewport().add(JTCusTable);
        CusTableJSP.setBounds(5,300,1000,400);
     
        
        container.add(topichd);
        container.add(CusTableJSP); 
       
        
    }
    
    
   private  static JTable CreateTable() {
   String ColumnHeaderName[] = {"Admission","Names","Requester","Relation","Autopsy Nature"};
      
          try{
            ResultSet rs;
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement stCus = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);       
            ResultSet rsCus = stCus.executeQuery(querry);
       
            total = 0;
        
        //Move to the last record
        rsCus.afterLast();
        
        //Get the current record position
        if(rsCus.previous())total = rsCus.getRow();
        
        //Move back to the first record;
        rsCus.beforeFirst();  
        
        if(total > 0){
            Content = new String[total][5];
            while(rsCus.next()){
                    Content[rowNum][0] = "" + rsCus.getString("admin_no");
                    Content[rowNum][1] = "" + rsCus.getString("names");
                    Content[rowNum][2] = "0" + rsCus.getString("admision_date");      //
                    Content[rowNum][3] = "" + rsCus.getString("requester_name");
                    Content[rowNum][4] = "" + rsCus.getString("requester_relation");
                    rowNum++;
            }
    }else{
            Content = new String[0][5];
            Content[0][0] = " ";
            Content[0][1] = " ";
            Content[0][2] = " ";
            Content[0][3] = " ";
            Content[0][4] = " ";
    }




       }
       catch(Exception ee)
       {
       System.out.println(ee);
       }
   
   JTable NewTable = new JTable (Content, ColumnHeaderName) {
			public boolean isCellEditable (int iRows, int iCols) {
				return false;
			}
		};

		NewTable.setPreferredScrollableViewportSize(new Dimension(720, 220));
		NewTable.setBackground(Color.lightGray);

		//Start resize the table column
		NewTable.getColumnModel().getColumn(0).setMaxWidth(200);
		NewTable.getColumnModel().getColumn(0).setMinWidth(0);
		NewTable.getColumnModel().getColumn(0).setWidth(0);
		NewTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		NewTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		NewTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		NewTable.getColumnModel().getColumn(3).setPreferredWidth(100);
                NewTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		//End resize the table column

		//Disposed variables
		ColumnHeaderName=null;
		Content=null;

		rowNum = 0;

		return NewTable;     
    }
   
    
}
