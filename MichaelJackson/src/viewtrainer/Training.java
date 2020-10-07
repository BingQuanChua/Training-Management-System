package viewtrainer;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JOptionPane;

public class Training extends JPanel {

	/**
	 * This panel holds a single training course panel.
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton trainingButton;
	private JButton editButton;
	private JTextArea textArea;
	private JButton feedbackButton;
	private JButton requestButton;
	private JButton traineeListButton;
	private JButton updateButton;
	
	private boolean extend = false;
	private int extendedHeight = 430;
	private int retractedHeight = 70;
	
	private String feedbackFormLink = "";
	private String description;
	private boolean isTextAreaEditable = false;
	
	private TrainingMaterialDetails trainingMaterialDetails; 
    private TrainingRequestList trainingRequestList;
    private TrainingTraineeList trainingTraineeList;
    
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
	Font heading3 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	
	public Training(String trainingName) {
		
		setPreferredSize(new Dimension(800, retractedHeight));
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		
		// for dummy program
        trainingMaterialDetails = new TrainingMaterialDetails(trainingName); 
        trainingRequestList = new TrainingRequestList();
        trainingTraineeList = new TrainingTraineeList(); 
		
		trainingButton = new JButton(trainingName);
		trainingButton.setFont(heading2);
		trainingButton.setBackground(Color.LIGHT_GRAY);
		trainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		trainingButton.setBounds(0, 0, 800, 70);
		add(trainingButton);
		
		textArea = new JTextArea();
		textArea.setFont(heading3);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(50, 75, 620, 125);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setSize(620, 125);
		scrollPane.setLocation(50, 75);
		add(scrollPane);
		textArea.setText("Description for " + trainingName + ".");
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		
		editButton = new JButton("Edit");
		editButton.setFont(heading3);
		editButton.setBackground(new Color(205,133,63));
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isTextAreaEditable) {
					textArea.setEditable(true);
					editButton.setText("Save");
					isTextAreaEditable = true;
				}
				else {
					textArea.setEditable(false);
					editButton.setText("Edit");
					description = textArea.getText();
					isTextAreaEditable = false;
				}
			}
		});
		editButton.setBounds(675, 75, 75, 125);
		add(editButton);
		
		feedbackButton = new JButton("Feedback");
		feedbackButton.setFont(heading3);
		feedbackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (feedbackFormLink == "") {
					feedbackFormLink = JOptionPane.showInputDialog("Enter Google Form link");
				}
				else {
					feedbackFormLink = JOptionPane.showInputDialog("Existing Google Form link:\n" + feedbackFormLink + "\n\nEnter new Google Form link");
				}
			}
		});
		feedbackButton.setBounds(50, 370, 700, 50);
		add(feedbackButton);
		
		updateButton = new JButton("Update Material");
		updateButton.setFont(heading3);
		updateButton.setBounds(50, 205, 700, 50);
		add(updateButton);
		
		requestButton = new JButton("Training Requests");
		requestButton.setFont(heading3);
		requestButton.setBounds(50, 260, 700, 50);
		add(requestButton);
		
		traineeListButton = new JButton("List of Trainees");
		traineeListButton.setFont(heading3);
		traineeListButton.setBounds(50, 315, 700, 50);
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
	
	public TrainingRequestList getTrainingRequestList() {
		return trainingRequestList;
	}
	
	public TrainingTraineeList getTrainingTraineeList() {
		return trainingTraineeList;
	}
	
	public TrainingMaterialDetails getTrainingMaterialDetails() {
		return trainingMaterialDetails;
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

	// more to come above
	public JButton getRequestButton() {
		return requestButton;
	}
	
	public JButton getTraineeListButton() {
		return traineeListButton;
	}
	
	public JButton getUpdateButton() {
		return updateButton;
	}
}
