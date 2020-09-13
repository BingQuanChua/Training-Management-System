package mj;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

public class AdminUI extends JFrame {

	/**
	 * Admin interface (currently extends JFrame, will change to JPanel later)
	 */

	private static final long serialVersionUID = 1L;
	// private JPanel contentPane;
	private JScrollPane jScrollPane1;
	private JPanel menus;
	private JPanel panelBody;
	private JPanel panelHeader;
	private JPanel panelMenu;
	
	private JButton logoButton;
	private JButton signOutButton;
	
	private AddNewUser addNewUser;
	private AllTrainerList allTrainerList;
	private AllTraineeList allTraineeList;
	private AllTrainingList allTrainingList;
	// private ?report
	private Icon icon;
	
    //Profile
    private JPanel panelMenuHeader;
    private JButton profileButton;
    private JButton accountSettingButton;
    private Icon profileIcon;
	
	Font heading1 = new Font(Font.SERIF, Font.PLAIN, 30);

	/**
	 * Create the frame.
	 */
	public AdminUI() {
		super("MJ Training Management System");
		initComponents();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		adminUI(); // Based on role


	}

	private void initComponents() {

		panelHeader = new JPanel(); // Top header panel
		panelMenu = new JPanel(); // Left root panel
		jScrollPane1 = new JScrollPane(); // Able to scroll
		menus = new JPanel(); // Left panel that store all submenu
		panelBody = new JPanel(); // Right root panel
		
		addNewUser = new AddNewUser();
		allTrainerList = new AllTrainerList();
		allTraineeList = new AllTraineeList();
		allTrainingList = new AllTrainingList();
		icon = new Icon();
		icon.setBackground(new Color(255, 255, 200));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// Top header panel
		panelHeader.setBackground(new Color(233, 150, 122));//peach
		panelHeader.setPreferredSize(new Dimension(500, 120));
		
		/**************************************************************
         * Profile (Show profile and profile setting)
         **************************************************************/
        panelMenuHeader = new JPanel(); //Left header panel for profile
        profileIcon = new Icon();		//Set Icon in button
      
        panelMenuHeader.setBackground(new Color(233, 150, 122)); //
        panelMenuHeader.setLayout(new javax.swing.BoxLayout(panelMenuHeader, javax.swing.BoxLayout.Y_AXIS));
        panelMenuHeader.setSize(new Dimension(Integer.MAX_VALUE, 130));
        panelMenuHeader.setMaximumSize(new Dimension(Integer.MAX_VALUE, 130));
        panelMenuHeader.setMinimumSize(new Dimension(Integer.MAX_VALUE, 130));
        //Profile setting
        UserProfile profile = new UserProfile();
        SubMenu subProfile = new SubMenu("Profile", profile);
        profileButton = new JButton("Admin Profile");
        profileButton.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        		  panelBody.removeAll();
                  panelBody.add(subProfile);
                  panelBody.repaint();
                  panelBody.revalidate();
        	  } 
        	} );
        profileButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        profileButton.setBackground(null);
        accountSettingButton = new JButton("account setting");
        accountSettingButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        accountSettingButton.setBackground(Color.WHITE);
        panelMenuHeader.add(profileButton);
        panelMenuHeader.add(Box.createRigidArea(new Dimension(10,10)));
        panelMenuHeader.add(accountSettingButton);
        menus.add(panelMenuHeader);
        /**************************************************************
         * Profile 
         **************************************************************/
		
		// Clickable logo in the top header panel
        logoButton = new JButton();
        logoButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		home();
        	}
        });
        logoButton.setBackground(null);
        logoButton.setBorder(null);
        logoButton.setFocusable(false);
        try {
        	Image originalLogo = ImageIO.read(getClass().getResource("images/logo.PNG"));
        	Image logo = originalLogo.getScaledInstance(370, 120, Image.SCALE_DEFAULT);
        	logoButton.setIcon(new ImageIcon(logo));
        	
        	/**profile**********************************************************************/
        	Image profLogo = ImageIO.read(getClass().getResource("images/profileLogo.PNG"));
        	Image profileLogo = profLogo.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        	profileButton.setIcon(new ImageIcon(profileLogo));
        	/*******************************************************************************/
        }
        catch (Exception ex) {
        	System.out.println("Image not found");
        }
        
        // Sign out button in the top header panel
        signOutButton = new JButton("Sign Out");
        signOutButton.setForeground(Color.WHITE);
        signOutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Need to handle this later
        		System.exit(0); 
        	}
        });
        signOutButton.setBackground(null);
        signOutButton.setBorder(null);
        signOutButton.setFocusable(false);
		
        GroupLayout panelHeaderLayout = new GroupLayout(panelHeader);
        panelHeaderLayout.setHorizontalGroup(
        	panelHeaderLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelHeaderLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(logoButton, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
        			.addComponent(signOutButton)
        			.addGap(37))
        );
        panelHeaderLayout.setVerticalGroup(
        	panelHeaderLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(panelHeaderLayout.createSequentialGroup()
        			.addComponent(logoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(panelHeaderLayout.createSequentialGroup()
        			.addContainerGap(93, Short.MAX_VALUE)
        			.addComponent(signOutButton)
        			.addGap(24))
        );
        panelHeader.setLayout(panelHeaderLayout);
        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

		// Left root panel
		panelMenu.setBackground(new Color(204, 204, 204));
		panelMenu.setPreferredSize(new Dimension(300, 384));

		// Able to scroll
		jScrollPane1.setBorder(null);

		// Left panel that store all submenu
		menus.setBackground(new Color(255, 250, 250)); // White
		menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
		jScrollPane1.setViewportView(menus);

		GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
		panelMenu.setLayout(panelMenuLayout);
		panelMenuLayout.setHorizontalGroup(panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE));
		panelMenuLayout.setVerticalGroup(panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE));

		getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

		panelBody.setBackground(new Color(255, 255, 224));
		panelBody.setLayout(new java.awt.BorderLayout());
		JScrollPane scrollPane = new JScrollPane(panelBody);
		//scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//panelBody.setPreferredSize(new Dimension(1920, 1080));
		
	        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

	        setSize(new Dimension(1920,1080));
	        setLocationRelativeTo(null);
	
	}

	// This method is called from within the constructor to initialize the form.
	private void adminUI() {
		MenuItem menuANU = new MenuItem(" -- Add New User", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panelBody.removeAll();
				panelBody.add(new SubMenu("Add New User",addNewUser));
				panelBody.repaint();
				panelBody.revalidate();
			}
		});
		MenuItem menuMTR = new MenuItem(" -- Manage Trainer", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panelBody.removeAll();
				panelBody.add(new SubMenu("Manage Trainer",allTrainerList));
				panelBody.repaint();
				panelBody.revalidate();
			}
		});
		MenuItem menuMTE = new MenuItem(" -- Manage Trainee", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panelBody.removeAll();
				panelBody.add(new SubMenu("Manage Trainee",allTraineeList));
				panelBody.repaint();
				panelBody.revalidate();
			}
		});
		
		MenuItem menuMTC = new MenuItem(" -- Manage Training Course", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panelBody.removeAll();
				panelBody.add(new SubMenu("Manage Training Course",allTrainingList));
				panelBody.repaint();
				panelBody.revalidate();
			}
		});
		
		MenuItem menuRpt = new MenuItem(" -- Report", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panelBody.removeAll();
				panelBody.add(new SubMenu("Report",new Report()));
				panelBody.repaint();
				panelBody.revalidate();
			}
		});

		MenuItem menuEmployee = new MenuItem("Employee", null, menuANU, menuMTR,menuMTE);
		menuEmployee.setBackground(new Color(250, 240, 230));
		MenuItem menuTraining = new MenuItem("Training", null, menuMTC, menuRpt);	
		menuTraining.setBackground(new Color(250, 240, 230));
		addMenu(menuEmployee);
		addMenu(menuTraining);
		home(); //show home menu initially
	}

	// Add all subMenu into menus
	private void addMenu(MenuItem menu) {

		menus.add(menu);
		ArrayList<MenuItem> subMenu = menu.getSubMenu();
		for (MenuItem m : subMenu) {
			addMenu(m);
		}

		menus.revalidate();
	}
	
	// Setting the panelBody (Home menu)
    private void home() {
    	panelBody.removeAll();
    	panelBody.add(icon);
        panelBody.repaint();
        panelBody.revalidate();
    }

}
