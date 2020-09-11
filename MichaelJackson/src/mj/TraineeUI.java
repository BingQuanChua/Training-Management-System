package mj;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;


public class TraineeUI extends JFrame {
	
	// Variables declaration
    private JScrollPane jScrollPane1;
    private JPanel menus;
    private JPanel panelBody;
    private JPanel panelHeader;
    private JPanel panelMenu;
    // End of variables declaration

 
    //Constructor
    public TraineeUI() {
    	super("MJ Training Management System");
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        traineeUI(); //Based on role
    }
    

	// This method is called from within the constructor to initialize the form.
    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelHeader = new JPanel();	//Top header panel
        panelMenu = new JPanel();	//Left root panel
        jScrollPane1 = new JScrollPane(); //Able to scroll
        menus = new JPanel();		//Left panel that store all submenu
        panelBody = new JPanel();	//Right root panel

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //Top header panel
        panelHeader.setBackground(new Color(102, 0, 153)); //Purple
        panelHeader.setPreferredSize(new Dimension(500, 60));

        GroupLayout panelHeaderLayout = new GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 855, Short.MAX_VALUE)
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        //Left root panel
        panelMenu.setBackground(new Color(204, 204, 204));
        panelMenu.setPreferredSize(new Dimension(250, 384));

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
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setSize(new Dimension(871, 473));
        setLocationRelativeTo(null);
    }
    
    //private void traineeUI()
    	//TraineeUI trainee = new TraineeUI(panelBody, menus);
   
    // This method is called from within the constructor to initialize the form.
    private void traineeUI() {
    	
        //  create subMenu Training
        MenuItem menuMTC = new MenuItem(" -- Manage Training Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	panelBody.removeAll();
                panelBody.add(new SubMenuMTC());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuTP = new MenuItem(" -- Training Progress", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	panelBody.removeAll();
                panelBody.add(new SubMenuTP());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });

        //  create submenu Demo menu 1 
        MenuItem menuDemo1 = new MenuItem(" -- Demo 001", null);
        MenuItem menuDemo2 = new MenuItem(" -- Demo 002", null);
        //  create submenu Demo menu 2
        MenuItem menuDemo3 = new MenuItem(" -- Demo 003", null);

        MenuItem menuTraining = new MenuItem("Training", null, menuMTC, menuTP);
        MenuItem menu2 = new MenuItem("Demo menu 1", null, menuDemo1, menuDemo2);
        MenuItem menu3 = new MenuItem("Demo menu 2", null, menuDemo3);
        addMenu(menuTraining, menu2, menu3);
    }

    // Add all subMenu into menus
    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }
}
