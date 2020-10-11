package viewtrainer;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Training extends JPanel {

	/**
	 * This panel holds a single training course panel.
	 */
	private static final long serialVersionUID = 1L;
	
	private String courseID;
	
	private JButton trainingButton;
	private JTextArea textArea;
	private JButton feedbackButton;
	private JButton traineeListButton;
	private JButton updateButton;
	
	private boolean extend = false;
	private int extendedHeight = 375;
	private int retractedHeight = 70;
	
	private String feedbackFormLink = "";
	private String description;
    
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
	Font heading3 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	
	public Training(String trainingName, String courseID) {
		this.courseID = courseID;
		
		setPreferredSize(new Dimension(800, 70));
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
	
		
		trainingButton = new JButton(trainingName);
		trainingButton.setFont(heading2);
		trainingButton.setBackground(Color.LIGHT_GRAY);
		trainingButton.setBounds(0, 0, 800, 70);
		add(trainingButton);
		
		textArea = new JTextArea();
		textArea.setFont(heading3);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(50, 75, 700, 125);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setSize(700, 125);
		scrollPane.setLocation(50, 75);
		add(scrollPane);
		textArea.setText("Description for " + trainingName + ".");
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		
		feedbackButton = new JButton("Feedback");
		feedbackButton.setFont(heading3);
		feedbackButton.setBounds(50, 315, 700, 50);
		// feedbackButton.setBackground(new Color(205,133,63));
		add(feedbackButton);
		
		updateButton = new JButton("Update Material");
		updateButton.setFont(heading3);
		updateButton.setBounds(50, 205, 700, 50);
		// updateButton.setBackground(new Color(205,133,63));
		add(updateButton);
		
		traineeListButton = new JButton("List of Trainees");
		traineeListButton.setFont(heading3);
		traineeListButton.setBounds(50, 260, 700, 50);
		// traineeListButton.setBackground(new Color(205,133,63));
		add(traineeListButton);
		
		trainingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!extend) { // not extended
					showMenu();
					extend = true; // become extended
				}
				else { // extended
					hideMenu();
					extend = false; // become not extended
				}
			}
		});		

	}
	
	public String getFeedbackFormLink() {
		return feedbackFormLink;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
		textArea.setText(description);
	}
	
	private void showMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                setPreferredSize(new Dimension(800, extendedHeight));
                getParent().revalidate();
                getParent().repaint();
            }
        }).start();
    }

    private void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                setPreferredSize(new Dimension(800, retractedHeight));
                getParent().revalidate();
                getParent().repaint();
            }
        }).start();
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
    }
    
    public String getCourseID() {
		return courseID;
	}
    
    public JTextArea getTextArea() {
    	return textArea;
    }
    
    public JButton getUpdateButton() {
		return updateButton;
	}
	
	public JButton getTraineeListButton() {
		return traineeListButton;
	}
	
	public JButton getFeedbackButton() {
		return feedbackButton;
	}
}
