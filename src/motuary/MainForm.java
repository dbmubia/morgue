/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package motuary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.sql.*;
import java.sql.Statement;
import komponenMakeOver.FsetupBusiness;

/**
 * * @author Njihia
 */
public class MainForm extends JFrame implements WindowListener {

    //The form container variable
    JPanel Panel1;
    JDesktopPane Desk1 = new JDesktopPane();

    JLabel StatusLabel = new JLabel("Copyright © 2014 by Jeremy Njihia. All Rights Reserved. Visit http://njihiajeremy.com", JLabel.CENTER);

    JLabel user = new JLabel("USER", JLabel.LEFT);
    JLabel BusinessTitleLabel = new JLabel();
    private JPanel tools;
    private JTextField title;

    private static LookAndFeel nimbus;

    Dimension display = Toolkit.getDefaultToolkit().getScreenSize();

    Connection CN;
    Statement rst;
    //--Start variable the contains forms
    FrmChangeUserPassword FormChangePass;
    FmasterUserFunctions FormMasterFunctions;
    FMaserUser FormMaserUser;
    backup FormBackup;
    coldRoom FormColdRoom;
    FsetupBusiness FormBussinessSetup;
    postmotermrequest requestpm;
    Postmotermcontrol pcontrol;
    dispatching dsptch;
    Formadmin2 pm_grid;
    FrmAdmission FormAadmission;

    public MainForm() {
        //Set the main form title
        super("Funeral Home Management Information System");
        initial();
		//End set the main form title

        //connecting class of tha db
        Data user = new Data();

        //StatusLabel.setBorder(BorderFactory.createTitledBorder(""));
        StatusLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        StatusLabel.setForeground(new Color(51, 98, 140));

        title = new komponenMakeOver.textfieldMakeover();
        title.setText("Thika Road Funeral Home, Nairobi (00100-34480)");
        title.setForeground(new Color(242, 242, 189));
        title.setFont(new Font("Lucida Sans", Font.BOLD, 16));
        title.setEditable(false);
        //title.setEnabled(false);

        tools = new komponenMakeOver.PanelUserMakeover();
        tools.setBounds(0, 45, display.width, 25);

        //Set the main form properties
        addWindowListener(this);

        Desk1.setBackground(new Color(142, 143, 145));

        Desk1.setBorder(null);
        //Most fastest drag mode
        Desk1.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

        Panel1 = new JPanel(new BorderLayout());
        Panel1.setBackground(new Color(35, 35, 36));
        Panel1.setBorder(null);
        Panel1.add(new JScrollPane(Desk1), BorderLayout.CENTER);

        getContentPane().add(tools);
        getContentPane().add(CreateJToolBar(), BorderLayout.PAGE_START);
        getContentPane().add(Panel1, BorderLayout.CENTER);
        getContentPane().add(StatusLabel, BorderLayout.PAGE_END);

        setJMenuBar(CreateJMenuBar());
        setExtendedState(this.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon("src/images/coffin.png").getImage());
        setLocation(0, 0);
        setSize(display);
        setResizable(true);

        setVisible(true);
        show();

//		try{
//			Class.forName(DBDriver);
//			CN = DriverManager.getConnection(DBSource,DBUserName ,DBPassword);
//		}catch(ClassNotFoundException e)  {
// 			System.err.println("Failed to load driver");
// 			e.printStackTrace();
// 			System.exit(1);
// 		}
// 		catch(SQLException e){
// 			System.err.println("Unable to connect");
// 			e.printStackTrace();
// 			System.exit(1);
// 		}
        //End set the main form properties
    }

    /**
     * ******************** End MainForm constructor start *******************
     */
    /**
     * ********************* Custom class creation start *********************
     */
    private void initial() {

    }

    //Create menu bar
    public JMenuBar CreateJMenuBar() {
        JMenuBar NewJMenuBar = new JMenuBar();

        //Setup file menu
        JMenu MnuFile = new JMenu("File");
        MnuFile.setFont(new Font("Dialog", Font.PLAIN, 12));
        MnuFile.setMnemonic('F');
        MnuFile.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(MnuFile);
		//End setup file menu

        //Set file sub menu
        JMenuItem ItmLockApp = new JMenuItem("lock Application");
        ItmLockApp.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmLockApp.setMnemonic('L');
        ItmLockApp.setIcon(new ImageIcon("src/images/lock.png"));
        ItmLockApp.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_L, ActionEvent.CTRL_MASK
                )
        );
        ItmLockApp.setActionCommand("lockapp");
        //ItmLockApp.addActionListener(JMenuActionListener);
        ItmLockApp.setBackground(new Color(255, 255, 255));

        JMenuItem ItmLoggOff = new JMenuItem("Logg Off");
        ItmLoggOff.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmLoggOff.setMnemonic('O');
        ItmLoggOff.setIcon(new ImageIcon("src/images/logof.png"));
        ItmLoggOff.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_O, ActionEvent.CTRL_MASK
                )
        );
        ItmLoggOff.setActionCommand("loggoff");
        //ItmLoggOff.addActionListener(JMenuActionListener);
        ItmLoggOff.setBackground(new Color(255, 255, 255));

        JMenuItem ItmExit = new JMenuItem("Exit");
        ItmExit.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmExit.setMnemonic('E');
        ItmExit.setIcon(new ImageIcon("src/images/exit.png"));
        ItmExit.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_E, ActionEvent.CTRL_MASK
                )
        );
        ItmExit.setActionCommand("exit");
        //ItmExit.addActionListener(JMenuActionListener);
        ItmExit.setBackground(new Color(255, 255, 255));

        MnuFile.add(ItmLockApp);
        MnuFile.addSeparator();
        MnuFile.add(ItmLoggOff);
        MnuFile.add(ItmExit);
			//End set file sub menu

        //Setup operation menu        
        JMenu operations = new JMenu("Operations");
        operations.setFont(new Font("Dialog", Font.PLAIN, 12));
        operations.setMnemonic('O');
        operations.setBackground(new Color(255, 255, 255));

        NewJMenuBar.add(operations);

        JMenuItem coldroom = new JMenuItem("Cold Room");
        coldroom.setFont(new Font("Dialog", Font.PLAIN, 12));
        coldroom.setMnemonic('C');
        coldroom.setIcon(new ImageIcon("src/images/BKup.png"));
        coldroom.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_L, ActionEvent.CTRL_MASK
                )
        );
        coldroom.setActionCommand("room");
        coldroom.addActionListener(JMenuActionListener);
        coldroom.setBackground(new Color(255, 255, 255));

        operations.add(coldroom);

        //settup Accounts
        JMenu Accounts = new JMenu("Accounts");
        Accounts.setFont(new Font("Dialog", Font.PLAIN, 12));
        Accounts.setMnemonic('A');
        Accounts.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(Accounts);

        //settup menu
        JMenu settup = new JMenu("Setup Business");
        settup.setFont(new Font("Dialog", Font.PLAIN, 12));
        settup.setMnemonic('S');
        settup.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(settup);

        JMenuItem businesSetup = new JMenuItem("Business Setup");
        businesSetup.setFont(new Font("Dialog", Font.PLAIN, 12));
        businesSetup.setMnemonic('B');
        businesSetup.setIcon(new ImageIcon("src/images/setup1.png"));
        businesSetup.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_L, ActionEvent.CTRL_MASK
                )
        );
        businesSetup.setActionCommand("setup");
        businesSetup.addActionListener(JMenuActionListener);
        businesSetup.setBackground(new Color(255, 255, 255));

        settup.add(businesSetup);

        //backup menu
        JMenu backup = new JMenu("Backup");
        backup.setFont(new Font("Dialog", Font.PLAIN, 12));
        backup.setMnemonic('B');
        backup.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(backup);

        JMenuItem Backup = new JMenuItem("Perfom Backup");
        Backup.setFont(new Font("Dialog", Font.PLAIN, 12));
        Backup.setMnemonic('C');
        Backup.setIcon(new ImageIcon("src/images/BKup.png"));
        Backup.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_L, ActionEvent.CTRL_MASK
                )
        );
        Backup.setActionCommand("backup");
        Backup.addActionListener(JMenuActionListener);
        Backup.setBackground(new Color(255, 255, 255));

        backup.add(Backup);

        //usermanagement
        JMenu userman = new JMenu("User management");
        userman.setFont(new Font("Dialog", Font.PLAIN, 12));
        userman.setMnemonic('U');
        userman.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(userman);

        JMenuItem ChangePass = new JMenuItem("Change Passord");
        ChangePass.setFont(new Font("Dialog", Font.PLAIN, 12));
        ChangePass.setMnemonic('C');
        ChangePass.setIcon(new ImageIcon("src/images/lock.png"));
        ChangePass.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_L, ActionEvent.CTRL_MASK
                )
        );
        ChangePass.setActionCommand("changepass");
        ChangePass.addActionListener(JMenuActionListener);
        ChangePass.setBackground(new Color(255, 255, 255));

        userman.add(ChangePass);

        JMenuItem masterfunction = new JMenuItem("User Function");
        masterfunction.setFont(new Font("Dialog", Font.PLAIN, 12));
        masterfunction.setMnemonic('U');
        masterfunction.setIcon(new ImageIcon("src/images/lock.png"));
        masterfunction.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_L, ActionEvent.CTRL_MASK
                )
        );
        masterfunction.setActionCommand("functions");
        masterfunction.addActionListener(JMenuActionListener);
        masterfunction.setBackground(new Color(255, 255, 255));

        userman.add(masterfunction);

        JMenuItem MasterUser = new JMenuItem("Master User");
        MasterUser.setFont(new Font("Dialog", Font.PLAIN, 12));
        MasterUser.setMnemonic('U');
        MasterUser.setIcon(new ImageIcon("src/images/lock.png"));
        MasterUser.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_L, ActionEvent.CTRL_MASK
                )
        );
        MasterUser.setActionCommand("master");
        MasterUser.addActionListener(JMenuActionListener);
        MasterUser.setBackground(new Color(255, 255, 255));

        userman.add(MasterUser);

        //Feedback menu
        JMenu feedback = new JMenu("Feedback");
        feedback.setFont(new Font("Dialog", Font.PLAIN, 12));
        feedback.setMnemonic('F');
        feedback.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(feedback);

        JMenuItem feedbackk = new JMenuItem("Feedback");
        feedbackk.setFont(new Font("Dialog", Font.PLAIN, 12));
        feedbackk.setMnemonic('U');
        feedbackk.setIcon(new ImageIcon("src/images/feedback16.png"));
        feedbackk.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_L, ActionEvent.CTRL_MASK
                )
        );
        feedbackk.setActionCommand("pmrequest");
        feedbackk.addActionListener(JMenuActionListener);
        feedbackk.setBackground(new Color(255, 255, 255));

        feedback.add(feedbackk);

        //Setup records menu
        JMenu MnuRec = new JMenu("Reports");
        MnuRec.setFont(new Font("Dialog", Font.PLAIN, 12));
        MnuRec.setMnemonic('R');
        MnuRec.setBackground(new Color(255, 255, 255));
        NewJMenuBar.add(MnuRec);
		//End records menu

        //Set records sub menu
        //-- For Customer
        JMenuItem ItmCustomer = new JMenuItem("P.M Grid");
        ItmCustomer.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmCustomer.setMnemonic('S');
        ItmCustomer.setIcon(new ImageIcon("src/images/repp.png"));
        ItmCustomer.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_S, ActionEvent.CTRL_MASK
                )
        );
        ItmCustomer.setActionCommand("pmgrid");
        ItmCustomer.addActionListener(JMenuActionListener);
        ItmCustomer.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmCustomer);

        //-- For Supplier
        JMenuItem ItmSupplier = new JMenuItem("Employee");
        ItmSupplier.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmSupplier.setMnemonic('O');
        ItmSupplier.setIcon(new ImageIcon("src/images/repp.png"));
        ItmSupplier.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_E, ActionEvent.CTRL_MASK
                )
        );
        ItmSupplier.setActionCommand("emp");
        //ItmSupplier.addActionListener(JMenuActionListener);
        ItmSupplier.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmSupplier);

        //-- For SalesRep
        JMenuItem ItmSalesRep = new JMenuItem("Assets");
        ItmSalesRep.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmSalesRep.setMnemonic('R');
        ItmSalesRep.setIcon(new ImageIcon("src/images/repp.png"));
        ItmSalesRep.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_A, ActionEvent.CTRL_MASK
                )
        );
        ItmSalesRep.setActionCommand("ass");
        //ItmSalesRep.addActionListener(JMenuActionListener);
        ItmSalesRep.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmSalesRep);

        //-- For Warehouse
        JMenuItem ItmWarehouse = new JMenuItem("Hostel");
        ItmWarehouse.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmWarehouse.setMnemonic('W');
        ItmWarehouse.setIcon(new ImageIcon("src/images/repp.png"));
        ItmWarehouse.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_B, ActionEvent.CTRL_MASK
                )
        );
        ItmWarehouse.setActionCommand("hostel");
        //ItmWarehouse.addActionListener(JMenuActionListener);
        ItmWarehouse.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmWarehouse);
        MnuRec.addSeparator();

        //-- For Stock Adjustment
        JMenuItem ItmStockAdj = new JMenuItem("Transfers");
        ItmStockAdj.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmStockAdj.setMnemonic('T');
        ItmStockAdj.setIcon(new ImageIcon("src/images/repp.png"));
        ItmStockAdj.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_T, ActionEvent.CTRL_MASK
                )
        );
        ItmStockAdj.setActionCommand("Trans");
        //ItmStockAdj.addActionListener(JMenuActionListener);
        ItmStockAdj.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmStockAdj);
        MnuRec.addSeparator();

			//-- For Invoices
        //-- For Purchase Orders
        //-- For Purchase Receipt
        //-- For Expenses
        JMenuItem ItmExpense = new JMenuItem("Expenses");
        ItmExpense.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmExpense.setMnemonic('E');
        ItmExpense.setIcon(new ImageIcon("src/images/repp.png"));
        ItmExpense.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_E, ActionEvent.CTRL_MASK
                )
        );
        ItmExpense.setActionCommand("expense");
        //ItmExpense.addActionListener(JMenuActionListener);
        ItmExpense.setBackground(new Color(255, 255, 255));

        MnuRec.add(ItmExpense);

			//End records sub menu
        //Setup proccess menu
        //Setup reports menu
        //End records menu
        //Setup system menu
        //Setup help menu
        JMenu MnuHelp = new JMenu("Help");
        MnuHelp.setFont(new Font("Dialog", Font.PLAIN, 12));
        MnuHelp.setMnemonic('H');
        MnuHelp.setBackground(new Color(255, 255, 255));
        // MnuHelp.addActionListener(JMenuActionListener);
        NewJMenuBar.add(MnuHelp);

        //End records menu
        JMenuItem ItmMenHp = new JMenuItem("Help on HIMS");
        ItmMenHp.setFont(new Font("Dialog", Font.PLAIN, 12));
        ItmMenHp.setMnemonic('I');
        ItmMenHp.setIcon(new ImageIcon("src/images/help.png"));
        ItmMenHp.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_F11, ActionEvent.CTRL_MASK
                )
        );
        ItmMenHp.setActionCommand("hp");
        //ItmMenHp.addActionListener(JMenuActionListener);
        ItmMenHp.setBackground(new Color(255, 255, 255));

        MnuHelp.add(ItmMenHp);

        NewJMenuBar.setBackground(new Color(255, 255, 255));
        return NewJMenuBar;

    }
    //End create menu bar

    void checkUserAuthorization() {
//        Data User = new Data();         
//        MnuUser.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-001",Data.typeOfAction.View));
//        MnuRec.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-002",Data.typeOfAction.View));
//        MnuRpt.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-003",Data.typeOfAction.View));
//        Mnustp.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-004",Data.typeOfAction.View));
//        MnuFile.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-005",Data.typeOfAction.View));
//        MnuBkp.setEnabled(User.UserRight(txtUserID.getText().trim(), "MST-006",Data.typeOfAction.View));
//        
//        ItmUserFunction.setEnabled(User.UserRight(txtUserID.getText().trim(), "TSK-001",Data.typeOfAction.View));
//        ItmExpense.setEnabled(User.UserRight(txtUserID.getText().trim(), "TSK-002",Data.typeOfAction.View));
//        ItmLockApp.setEnabled(User.UserRight(txtUserID.getText().trim(), "TSK-003",Data.typeOfAction.View));               
//        ItmSalesRep.setEnabled(User.UserRight(txtUserID.getText().trim(), "TSK-004",Data.typeOfAction.View));               
//        
//        ItmSupplier.setEnabled(User.UserRight(txtUserID.getText().trim(), "RPT-001",Data.typeOfAction.View));
//        Itmbkp.setEnabled(User.UserRight(txtUserID.getText().trim(), "RPT-002",Data.typeOfAction.View));
//        ItmStockAdj.setEnabled(User.UserRight(txtUserID.getText().trim(), "RPT-003",Data.typeOfAction.View));               
//        ItmNewUser.setEnabled(User.UserRight(txtUserID.getText().trim(), "RPT-004",Data.typeOfAction.View));                               
    }

    //Create a tool bar
    protected JToolBar CreateJToolBar() {
        JToolBar NewJToolBar = new JToolBar("Toolbar");
        NewJToolBar.setBackground(new Color(57, 105, 138));
        NewJToolBar.setBorderPainted(false);
        NewJToolBar.setFloatable(false);
        NewJToolBar.setRollover(true);

        NewJToolBar.setMargin(new Insets(0, 0, 0, 0));

        //Create a toolbar button
        NewJToolBar.add(CreateJToolbarButton("Add new corpse details", "src/images/Add_new.png", "tooladdtrial"));

        NewJToolBar.add(CreateJToolbarButton("Dispatch", "src/images/dispatch.png", "dispatch"));
        NewJToolBar.add(CreateJToolbarButton("Body Viewing Bookings", "src/images/book.png", "toolEmp"));
        NewJToolBar.add(CreateJToolbarButton("Hearse Services", "src/images/hearse.png", "toolAss"));
        NewJToolBar.add(CreateJToolbarButton("Job card Record", "src/images/card.png", "toolHostel"));
        NewJToolBar.addSeparator();

        NewJToolBar.add(CreateJToolbarButton("Invoice Records", "src/images/invoice.png", "toolTrans"));
        NewJToolBar.add(CreateJToolbarButton("Petty Cash Record", "src/images/petty.png", "toolExpense"));

        NewJToolBar.addSeparator();
        NewJToolBar.add(CreateJToolbarButton("Business Setup", "src/images/setup.png", "toolBussSet"));
        NewJToolBar.add(CreateJToolbarButton("Security Option", "src/images/secur.png", "toolSecOpt"));
        NewJToolBar.add(CreateJToolbarButton("Log off Application", "src/images/lock1.png", "toolLockApp"));
        NewJToolBar.addSeparator();
        NewJToolBar.add(title);
        NewJToolBar.addSeparator();
        //End create a toolbar button

        return NewJToolBar;
    }
    //End create a tool bar

    protected JButton CreateJToolbarButton(String srcToolTipText, String srcImageLocation, String srcActionCommand) {
        JButton NewJButton = new komponenMakeOver.buttonMakeOverRectangle();
        NewJButton.setIcon(new ImageIcon(srcImageLocation));
        NewJButton.setActionCommand(srcActionCommand);
        NewJButton.setToolTipText(srcToolTipText);
        NewJButton.addActionListener(JToolBarActionListener);

        return NewJButton;

    }

    /**
     * ******************* End custom class creation start *******************
     */
    /**
     * ******************** Method for loading form start ********************
     */
    //Create customer form
    protected void loadChangePasswordForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Change Password");
        if (AlreadyLoaded == false) {
            FormChangePass = new FrmChangeUserPassword();
            Desk1.add(FormChangePass);

            //Load the FormCustomer
            FormChangePass.setVisible(true);
            FormChangePass.show();
            try {
                FormChangePass.setIcon(false);
                FormChangePass.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
            //End load the FormCustomer
        } else {
            try {
                FormChangePass.setIcon(false);
                FormChangePass.setSelected(true);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }

        //End verify if the form is already loaded
    }

    protected void loadAdmissionForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Admission Form");
        if (AlreadyLoaded == false) {
            FormAadmission = new FrmAdmission();
            Desk1.add(FormAadmission);

            //Load the FormCustomer
            FormAadmission.setVisible(true);
            FormAadmission.show();
            try {
                FormAadmission.setIcon(false);
                FormAadmission.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                FormAadmission.setIcon(false);
                FormAadmission.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }

    protected void loadtabsform() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("tabbed grid");
        if (AlreadyLoaded == false) {
            pm_grid = new Formadmin2();
            Desk1.add(pm_grid);

            //Load the FormCustomer
            pm_grid.setVisible(true);
            pm_grid.show();
            try {
                FormAadmission.setIcon(true);
                FormAadmission.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                pm_grid.setIcon(false);
                pm_grid.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }

    
    protected void loadUserFuntionForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("User Function");
        if (AlreadyLoaded == false) {
            FormMasterFunctions = new FmasterUserFunctions();
            Desk1.add(FormMasterFunctions);

            //Load the FormCustomer
            FormMasterFunctions.setVisible(true);
            FormMasterFunctions.show();
            try {
                FormMasterFunctions.setIcon(false);
                FormMasterFunctions.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                FormMasterFunctions.setIcon(false);
                FormMasterFunctions.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }

    protected void loadMasterUserForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Master User");
        if (AlreadyLoaded == false) {
            FormMaserUser = new FMaserUser();
            Desk1.add(FormMaserUser);

            //Load the FormCustomer
            FormMaserUser.setVisible(true);
            FormMaserUser.show();
            try {
                FormMaserUser.setIcon(false);
                FormMaserUser.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                FormMaserUser.setIcon(false);
                FormMaserUser.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }

    protected void loadBackupForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("");
        if (AlreadyLoaded == false) {
            FormBackup = new backup();
            Desk1.add(FormBackup);

            //Load the FormCustomer
            FormBackup.setVisible(true);
            FormBackup.show();
            try {
                FormBackup.setIcon(false);
                FormBackup.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                FormBackup.setIcon(false);
                FormBackup.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }

    protected void loadColdRoomForm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Cold Room");
        if (AlreadyLoaded == false) {
            FormColdRoom = new coldRoom();
            Desk1.add(FormColdRoom);

            //Load the FormCustomer
            FormColdRoom.setVisible(true);
            FormColdRoom.show();
            try {
                FormColdRoom.setIcon(false);
                FormColdRoom.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                FormColdRoom.setIcon(false);
                FormColdRoom.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }

    protected void loadBusinessSetup() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Business Setup");
        if (AlreadyLoaded == false) {
            FormBussinessSetup = new FsetupBusiness();
            Desk1.add(FormBussinessSetup);

            //Load the FormCustomer
            FormBussinessSetup.setVisible(true);
            FormBussinessSetup.show();
            try {
                FormBussinessSetup.setIcon(false);
                FormBussinessSetup.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                FormBussinessSetup.setIcon(false);
                FormBussinessSetup.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
    }

    protected void loadpostmoterm() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("Business Setup");
        if (AlreadyLoaded == false) {
            requestpm = new postmotermrequest();
            Desk1.add(requestpm);

            //Load the FormCustomer
            requestpm.setVisible(true);
            requestpm.show();
            try {
                requestpm.setIcon(false);
                requestpm.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                requestpm.setIcon(false);
                requestpm.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }

    protected void pmgridload() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("P.M");
        if (AlreadyLoaded == false) {
            pcontrol = new Postmotermcontrol();
            Desk1.add(pcontrol);

            //Load the p.m grid form
            pcontrol.setVisible(true);
            pcontrol.show();
            try {
                pcontrol.setIcon(false);
                pcontrol.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                pcontrol.setIcon(false);
                pcontrol.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }
    protected void loaddispatch() throws SQLException {
        //Verify if the form is already loaded
        boolean AlreadyLoaded = isLoaded("dispatchfrm");
        if (AlreadyLoaded == false) {
            dsptch = new dispatching();
            Desk1.add(dsptch);

            //Load the p.m grid form
            dsptch.setVisible(true);
            dsptch.show();
            try {
                dsptch.setIcon(false);
                dsptch.setSelected(true);
            } catch (PropertyVetoException e) {
            }
            //End load the FormCustomer
        } else {
            try {
                dsptch.setIcon(false);
                dsptch.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }

        //End verify if the form is already loaded
    }

    //Create action listener for JMenu
    ActionListener JMenuActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String srcObject = e.getActionCommand();
            if (srcObject == "P.M") {
                try {
                    loadChangePasswordForm();

                } catch (SQLException sqle) {
                }

            } else if (srcObject == "functions") {

                try {

                    loadUserFuntionForm();
                } catch (SQLException sqle) {
                }

            } else if (srcObject == "master") {

                try {

                    loadMasterUserForm();
                } catch (SQLException sqle) {
                }

            } else if (srcObject == "backup") {

                try {

                    loadBackupForm();
                } catch (SQLException sqle) {
                }

            } else if (srcObject == "room") {

                try {

                    loadColdRoomForm();
                } catch (SQLException sqle) {
                }

            } else if (srcObject == "setup") {

                try {

                    loadBusinessSetup();
                } catch (SQLException sqle) {
                }

            } else if (srcObject == "pmrequest") {

                try {

                    loadpostmoterm();
                } catch (SQLException sqle) {
                }

            } else if (srcObject == "pmgrid") {

                try {

                    pmgridload();
                } catch (SQLException sqle) {
                }

            } else if (srcObject == "changepass") {

                try {
                    loadChangePasswordForm();

                } catch (SQLException sqle) {
                }

            }//"changepass"

        }
    };

    //End create action listener for JMenu
    //Create action Listerner for JToolBar Button
    ActionListener JToolBarActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String srcObject = e.getActionCommand();
            if (srcObject == "dispatch") {
                try {
                    loaddispatch();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            } else if (srcObject == "tooladdtrial") {
                try {
                    loadtabsform();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
//
//            } else if (srcObject == "toolAss") {
//
//                try {
//
//                    loadAssetForm();
//
//                } catch (SQLException sqle) {
//                }
//
//            } else if (srcObject == "toolTrans") {
//
//                try {
//                    loadTransferForm();
//                } catch (Exception sqle) {
//                }
//            } else if (srcObject == "toolInv") {
//
//                try {
//                    loadMessForm();
//                } catch (Exception sqle) {
//                }
//            } else if (srcObject == "toolExpense") {
//
//                try {
//                    loadExpenseForm();
//                } catch (Exception sqle) {
//                }
//
//            } else if (srcObject == "toolHostel") {
//
//                try {
//                    loadHostelForm();
//                } catch (Exception sqle) {
//                }
//
//            } else if (srcObject == "toolLockApp") {
//
//                try {
//
//                } catch (Exception evt) {
//                }
//
            }

        }
    };
	//End create action Listerner for JToolBar Button

    //Interface event from WindowListener start
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        UnloadWindow();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    //End interface event from WindowListener start

    /**
     * ********************** End event handling start ***********************
     */
    /**
     * ************************ Custom method start **************************
     */
    protected void UnloadWindow() {
        String ObjButtons[] = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Thika Funeral Home System", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {

            System.exit(0);
        }
    }

    protected boolean isLoaded(String FormTitle) {

        JInternalFrame Form[] = Desk1.getAllFrames();
        for (int i = 0; i < Form.length; i++) {
            if (Form[i].getTitle().equalsIgnoreCase(FormTitle)) {
                Form[i].show();
                try {
                    Form[i].setIcon(false);
                    Form[i].setSelected(true);
                } catch (PropertyVetoException e) {
                }
                return true;
            }
        }
        return false; 

    }

}
