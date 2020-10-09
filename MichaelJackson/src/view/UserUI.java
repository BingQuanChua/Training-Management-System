package view;

import mj.UserProfileController;

import java.util.ArrayList;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import login.Login;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UserUI extends JFrame {
	
	// Variables declaration
	private static final long serialVersionUID = 1L;	
	
	// Right side panel body
    private JScrollPane jScrollPane1;
    private JPanel panelBody;
    
    // Navigation bar menu
    private JPanel menus;
    private JPanel panelMenu;
    
    // Top Horizontal Header
    private JPanel panelHeader;
    private JButton logoButton;
    private JButton signOutButton;
    
    // Profile
    private JPanel panelMenuHeader;
    private JButton profileButton;
    private JButton accountSettingButton;
    private ChangePassword changePassword;
    private UserProfile profile;
    private UserProfileController profileController;  
    
    // Other
    private Icon icon;
    private Font heading1 = new Font(Font.SERIF, Font.PLAIN, 30);
    private String userID;
 
 
    //Constructor
    public UserUI(String userID) {
    	super("MJ Training Management System");
    	this.userID = userID;
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    

	// This method is called from within the constructor to initialize the form.
    protected void initComponents() {

        panelHeader = new JPanel();			//Top header panel
        panelMenu = new JPanel();			//Left root panel that store menus
        menus = new JPanel();				//Left panel that store all submenu
        panelBody = new JPanel();			//Right root panel
        jScrollPane1 = new JScrollPane(); 	//Able to scroll
        panelMenuHeader = new JPanel(); 	//Left header panel inside panelMenu for profile
        changePassword = new ChangePassword();// Change password panel
        icon = new Icon();					//Set image
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        
        /**************************************************************
         * Top header panel
         **************************************************************/
        panelHeader.setBackground(new Color(233, 150, 122));
        panelHeader.setPreferredSize(new Dimension(500, 120));
        
        //Clickable logo in the top left header panel
        logoButton = new JButton();
        logoButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		home();
        	}
        });
        //logoButton.setBackground(null);
        logoButton.setBorder(null);
        logoButton.setOpaque(false);
        logoButton.setContentAreaFilled(false);
        logoButton.setBorderPainted(false);
        
        // Sign out button in the top header pane;
        signOutButton = new JButton("Sign Out");
        // signOutButton.setForeground(Color.WHITE);
        signOutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Login login = new Login();
        		login.setVisible(true);
        		dispose();
        		JOptionPane.showConfirmDialog (null, "You have logged out successfully.","Sign Out",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        signOutButton.setBackground(Color.white);
        signOutButton.setBorder(null);

        
		/**************************************************************
         * Profile (Show profile and profile setting)
         **************************************************************/      
        panelMenuHeader.setBackground(new Color(255,218,185)); //
        panelMenuHeader.setLayout(new javax.swing.BoxLayout(panelMenuHeader, javax.swing.BoxLayout.Y_AXIS));
        panelMenuHeader.setSize(new Dimension(Integer.MAX_VALUE, 130));
        panelMenuHeader.setMaximumSize(new Dimension(Integer.MAX_VALUE, 130));
        panelMenuHeader.setMinimumSize(new Dimension(Integer.MAX_VALUE, 130));
        
        //Profile setting (change password)
        profile = new UserProfile();
        SubMenu subProfile = new SubMenu("Profile", profile);
        profileButton = new JButton("User Profile");
        profileButton.setOpaque(false);
        profileButton.setContentAreaFilled(false);
        profileButton.setBorderPainted(false);
        profileButton.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        		  panelBody.removeAll();
                  panelBody.add(subProfile);
                  panelBody.repaint();
                  panelBody.revalidate();
        	  } 
        	} );
        profileController =  new UserProfileController(profile,userID);
        profileButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        profileButton.setBackground(null);
        accountSettingButton = new JButton("Change Password");
        accountSettingButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 panelBody.removeAll();
                 panelBody.add(new SubMenu("Change Password",changePassword));
                 panelBody.repaint();
                 panelBody.revalidate();
        	}
        });
        accountSettingButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        accountSettingButton.setBackground(null);
        panelMenuHeader.add(profileButton);
        panelMenuHeader.add(Box.createRigidArea(new Dimension(10,10)));
        panelMenuHeader.add(accountSettingButton);
        menus.add(panelMenuHeader);

        
		/**************************************************************
         * Set Icon Image
         **************************************************************/
        try {
        	/**MJ logoButton****************************************************************/
        	File logoPath = new File("src/images/logo.png");
			Image originalLogo = ImageIO.read(logoPath);
        	Image logo = originalLogo.getScaledInstance(370, 120, Image.SCALE_DEFAULT);
        	logoButton.setIcon(new ImageIcon(logo));
        	
        	/**Profile**********************************************************************/
        	File profIconPath = new File("src/images/profileLogo.png");
			Image profIcon = ImageIO.read(profIconPath);
        	Image profileIcon = profIcon.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        	profileButton.setIcon(new ImageIcon(profileIcon));
        	
        	/*******************************************************************************/
        } catch (Exception ex) {
        	System.out.println("UserUI Image not found");
        }
        
		/**************************************************************
         * Set panelHeader layout
         **************************************************************/
        GroupLayout panelHeaderLayout = new GroupLayout(panelHeader);
        panelHeaderLayout.setHorizontalGroup(
        	panelHeaderLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelHeaderLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(logoButton, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
        			.addComponent(signOutButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        panelHeaderLayout.setVerticalGroup(
        	panelHeaderLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(panelHeaderLayout.createSequentialGroup()
        			.addComponent(logoButton, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(panelHeaderLayout.createSequentialGroup()
        			.addContainerGap(72, Short.MAX_VALUE)
        			.addComponent(signOutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(8))
        );
        panelHeader.setLayout(panelHeaderLayout);
        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        /**************************************************************
         * panelMenu and panelBody
         **************************************************************/
        //Left root panel
        panelMenu.setBackground(new Color(204, 204, 204));
        panelMenu.setPreferredSize(new Dimension(300, 384));

        //Able to scroll
        jScrollPane1.setBorder(null);

        //Left panel that store all submenu
        menus.setBackground(new Color(255, 255, 255)); //White
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new Color(255, 255, 200));
        panelBody.setLayout(new java.awt.BorderLayout());
        JScrollPane scrollPane = new JScrollPane(panelBody);
        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

        setSize(new Dimension(871, 473));
        setLocationRelativeTo(null);
    }
    
   
    // Return for child class
   protected JPanel getPanelBody() {
	   return panelBody;
   }

    // Add all subMenu into menus
    protected void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }
    
    // Setting the panelBody (Home menu)
    protected void home() {
    	panelBody.removeAll();
    	panelBody.add(icon);
        panelBody.repaint();
        panelBody.revalidate();
    }
}
