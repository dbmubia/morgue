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


public class Postmotermcontrol  extends JInternalFrame implements ActionListener {

  	public static JScrollPane CusTableJSP = new JScrollPane();
       

	public static JPanel JPContainer= new komponenMakeOver.panelmakeOver();
        
        public JLabel kpano;

	public static JTable JTCusTable;
        
        
        
	JLabel JLPicture1 = new JLabel(new ImageIcon("src/images/adm.png"));
        
        JTextField JHlptxt = new komponenMakeOver.textfieldMakeover();
	JLabel JLHelpText = new JLabel();
       

	JFrame JFParentFrame;

        ImageIcon chap = new ImageIcon("src/images/NEW.PNG");
        
        
        JButton JBSearch = new komponenMakeOver.buttonMakeOver();
        
	JButton JBcheckjobcard = new JButton();
	JButton JBReload = new JButton("Reload",new ImageIcon("src/images/reload.png"));
        JButton JBExit = new JButton("Exit",new ImageIcon("src/images/EXIT.png"));
        

	public static Statement stCus;
        public static Connection conne;

	public static ResultSet rsCus;
        
          private static String strSQL="SELECT demo_admin.admin_no,demo_admin.names,demo_admin.admision_date,postmotermqueue.requester_name,postmotermqueue.requester_relation"
                                 + " FROM postmotermqueue,demo_admin"
                                 + " WHERE (postmotermqueue.admin_no = demo_admin.admin_no)";
        
        public  JTextField enterdtxt;    
        public static int rowNum = 0;
        public static int total = 0;
        
        
        
        
	public static String Content[][];

	Dimension screen  = Toolkit.getDefaultToolkit().getScreenSize();
        
    @SuppressWarnings("LeakingThisInConstructor")
        public Postmotermcontrol() throws SQLException {
            
            
            
        super("Delete Member",false,true,false,true);
        
        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).
        getNorthPane();
        this.remove(titlePane);
        
                JPContainer.setLayout(null);

                
		//-- Add the JLHelpText
		JHlptxt.setBounds(55,5,727,48);
                JHlptxt.setText("To display the member you want to delete,fill in the kpa number and search the record");
		JHlptxt.setFont(new Font("Candara", Font.BOLD, 13));
                JHlptxt.setEditable(false);
                JHlptxt.setForeground(new Color(242, 242, 189));
                JHlptxt.setBackground(Color.WHITE);
		JPContainer.add(JHlptxt);
                

		//-- Add the CusTable
		JTCusTable=CreateTable();
		CusTableJSP.getViewport().add(JTCusTable);
		CusTableJSP.setBounds(15,100,950,250);
		JPContainer.add(CusTableJSP);
                

               //search place
               kpano = new JLabel("Enter KPA No."); 
               kpano.setBounds(120,60, 100, 25);
               kpano.setFont(new Font("Candara", Font.BOLD, 14));
               JPContainer.add(kpano);
               
               
               enterdtxt = new JTextField();
               enterdtxt.setBounds(250, 60, 100, 25);
               JPContainer.add(enterdtxt);
               
                
		//-- Add the JBSearch
                JBSearch.setText("Search");
                JBSearch.setIcon(new ImageIcon("src/images/search.png"));
		JBSearch.setBounds(370,60,99,25);
		JBSearch.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBSearch.setMnemonic(KeyEvent.VK_S);
		JBSearch.addActionListener(this);
		JPContainer.add(JBSearch);


		//-- Add the JBDelete
                JBcheckjobcard.setText("View Job Card");
                JBcheckjobcard.setIcon(new ImageIcon("src/images/c_report.png"));
		JBcheckjobcard.setBounds(100,380,140,35);
		JBcheckjobcard.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBcheckjobcard.setMnemonic(KeyEvent.VK_V);
		JBcheckjobcard.addActionListener(this);
		JPContainer.add(JBcheckjobcard);

		//-- Add the JBReload
		JBReload.setBounds(350,380,150,35);
		JBReload.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBReload.setMnemonic(KeyEvent.VK_R);
		JBReload.addActionListener(this);
		JPContainer.add(JBReload);
                
                
		//-- Add the EXITBUTTON
		JBExit.setBounds(550,380,150,35);
		JBExit.setFont(new Font("Dialog", Font.PLAIN, 12));
		JBExit.setMnemonic(KeyEvent.VK_R);
		JBExit.addActionListener(this);
		JPContainer.add(JBExit);                
		//End initialize variables

		//Start set the form properties
		getContentPane().add(JPContainer);
                setBounds(screen.width - 1200, 50, 1000, screen.height - 270);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        }
  

    


    private  static JTable CreateTable() {
    String ColumnHeaderName[] = {"Admission","Names","Requester","Relation","Autopsy Nature"};
      
          try{
            ResultSet rs;
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement stCus = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);       
            ResultSet rsCus = stCus.executeQuery(strSQL);
       
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
                    Content[rowNum][2] = "" + rsCus.getString("admision_date");      //
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

		NewTable.setPreferredScrollableViewportSize(new Dimension(810, 480));
		NewTable.setBackground(new Color(0, 153, 204));

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
		ColumnHeaderName=null;
		Content=null;

		rowNum = 0;

		return NewTable;         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object obb=e.getSource();
       if(obb==JBcheckjobcard){
	if(total != 0){
					try{
						if(JTCusTable.getValueAt(JTCusTable.getSelectedRow(),JTCusTable.getSelectedColumn()) != null){
							String ObjButtons[] = {"Yes","No"};
							int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to delete the selected record?","Delete Record",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE,null,ObjButtons,ObjButtons[1]);
							if(PromptResult==0){
                                                                String del="DELETE  FROM members_table WHERE k_p_a_id = "+ JTCusTable.getValueAt(JTCusTable.getSelectedRow(),1);
                                                                System.out.println(del);
								stCus.execute(del);
								reloadRecord();
								JOptionPane.showMessageDialog(null,"Record has been successfully deleted.","Comfirm Delete",JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}catch(Exception sqlE){
						if(sqlE.getMessage()!=null){
							JOptionPane.showMessageDialog(null,"Please select a record in the list to deleted.","No Record Selected",JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null,"Please select a record in the list to deleted.","No Record Selected",JOptionPane.INFORMATION_MESSAGE);
						}
					}
        
                    }
       }
      else if(obb==JBReload)
      {reloadRecord();}
        //Close the Form
      else if(obb==JBExit)
      {
       setVisible(false);
       dispose();
      }
                            
    }
    public static void reloadRecord(String srcSQL){
			strSQL = srcSQL;
			CusTableJSP.getViewport().remove(JTCusTable);
			JTCusTable=CreateTable();
			CusTableJSP.getViewport().add(JTCusTable);
			JPContainer.repaint();
	}
    public static void reloadRecord(){
                                
				CusTableJSP.getViewport().remove(JTCusTable);
				JTCusTable=CreateTable();
				CusTableJSP.getViewport().add(JTCusTable);
				JPContainer.repaint();
	}

    
}
