package comm;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	Font heading1 = new Font(Font.SERIF, Font.PLAIN, 30);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// Top header panel
		panelHeader.setBackground(new Color(102, 0, 153)); // Purple
		panelHeader.setPreferredSize(new Dimension(500, 60));

		GroupLayout panelHeaderLayout = new GroupLayout(panelHeader);
		panelHeader.setLayout(panelHeaderLayout);
		panelHeaderLayout.setHorizontalGroup(
				panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 855, Short.MAX_VALUE));
		panelHeaderLayout.setVerticalGroup(
				panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));
		getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

		// Left root panel
		panelMenu.setBackground(new Color(204, 204, 204));
		panelMenu.setPreferredSize(new Dimension(250, 384));

		// Able to scroll
		jScrollPane1.setBorder(null);

		// Left panel that store all submenu
		menus.setBackground(new Color(255, 255, 255)); // White
		menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
		jScrollPane1.setViewportView(menus);

		GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
		panelMenu.setLayout(panelMenuLayout);
		panelMenuLayout.setHorizontalGroup(panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE));
		panelMenuLayout.setVerticalGroup(panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE));

		getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

		panelBody.setBackground(new Color(255, 255, 200));
		panelBody.setLayout(new java.awt.BorderLayout());
		//panelBody.setPreferredSize(new Dimension(1920, 1080));
		getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

		setSize(new Dimension(1920, 1080));
		setLocationRelativeTo(null);
	}

	// This method is called from within the constructor to initialize the form.
	private void adminUI() {
		MenuItem menuANU = new MenuItem(" -- Add New User", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panelBody.removeAll();
				panelBody.add(new AddNewUser());
				panelBody.repaint();
				panelBody.revalidate();
			}
		});
		MenuItem menuMTR = new MenuItem(" -- Manage Trainer", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panelBody.removeAll();
				panelBody.add(new AllTrainerList());
				panelBody.repaint();
				panelBody.revalidate();
			}
		});
		MenuItem menuMTE = new MenuItem(" -- Manage Trainee", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panelBody.removeAll();
				panelBody.add(new AllTraineeList());
				panelBody.repaint();
				panelBody.revalidate();
			}
		});
		
		MenuItem menuMTC = new MenuItem(" -- Manage Training Course", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panelBody.removeAll();
				panelBody.add(new AllTrainingCourse());
				panelBody.repaint();
				panelBody.revalidate();
			}
		});
		
		MenuItem menuRpt = new MenuItem(" -- Report", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panelBody.removeAll();
				//panelBody.add(new TrainingProgressList());
				panelBody.repaint();
				panelBody.revalidate();
			}
		});

		MenuItem menuEmployee = new MenuItem("Employee", null, menuANU, menuMTR,menuMTE);
		MenuItem menuTraining = new MenuItem("Training", null, menuMTC, menuRpt);	
	    
		addMenu(menuEmployee);
		addMenu(menuTraining);
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

}
