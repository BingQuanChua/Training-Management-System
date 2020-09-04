import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;

public class MainProgram extends JFrame {

	JTextField employeeIDField;
	JPasswordField passwordField;
	JPanel loginPage;
	JPanel mainPage;

	Font heading1 = new Font(Font.SERIF, Font.PLAIN, 30);
	Font f1 = new Font(Font.DIALOG, Font.PLAIN, 20);

	MainProgram() {
		super("MJ Traning Management System");


		//// login page panel ////
		loginPage = new JPanel(new BorderLayout());

		// top title bar
		JPanel tmsNameBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		try {
			Image originalIcon = ImageIO.read(getClass().getResource("/images/mj-icon.png"));
			Image resizedIcon = originalIcon.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
			ImageIcon icon = new ImageIcon(resizedIcon);
			tmsNameBar.add(new JLabel(icon));
		} catch(Exception ex) {
			System.out.println(ex);
		}	
		JLabel title = new JLabel("MJ Training Management System");
		title.setFont(heading1);
		tmsNameBar.add(title);


		// center login interface
		JPanel loginUI = new JPanel();
		loginUI.setLayout(null);
		JLabel employeeLabel = new JLabel("Employee ID ");
		employeeLabel.setFont(f1);
		employeeLabel.setBounds(100, 20, 220, 35);
		employeeLabel.setHorizontalAlignment(JLabel.RIGHT);
		loginUI.add(employeeLabel);

		employeeIDField = new JTextField(20);
		employeeIDField.setFont(f1);
		employeeIDField.setBounds(350, 20, 300, 35);
		loginUI.add(employeeIDField);

		JLabel passwordLabel = new JLabel("Password ");
		passwordLabel.setFont(f1);
		passwordLabel.setBounds(100, 60, 220, 35); 
		passwordLabel.setHorizontalAlignment(JLabel.RIGHT);
		loginUI.add(passwordLabel);

		passwordField = new JPasswordField(20);
		passwordField.setFont(f1);
		passwordField.setBounds(350, 60, 300, 35);
		loginUI.add(passwordField);	

		JButton loginButton = new JButton("Login");
		loginButton.setFont(f1);
		loginButton.setBounds(550, 100, 100, 35);
		loginUI.add(loginButton);
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(mainPage);
				setSize(1200, 600);
				revalidate();
			}
		});

		loginPage.add(tmsNameBar, BorderLayout.NORTH); 
		loginPage.add(loginUI, BorderLayout.CENTER);
		//// end of login page panel ////

		//// main page panel //// still in progress
		mainPage = new JPanel(new BorderLayout());

		JButton logOutButton = new JButton("Logout");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(mainPage);
				getContentPane().add(loginPage);
				setSize(800, 350);
				revalidate();
			}
		});

		mainPage.add(new JLabel("Hi"), BorderLayout.CENTER);
		mainPage.add(logOutButton, BorderLayout.SOUTH);

		add(loginPage, BorderLayout.CENTER);
		//// end of login page panel ////


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 350);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainProgram();
	}
}