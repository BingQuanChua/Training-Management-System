package controllertrainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modeltraining.ManageTrainingCourseMaterial;
import modeltraining.TrainingProgressTrigger;

import view.ListPanel;

import viewtrainer.TrainingMaterial;

public class TrainingCourseMaterialController {
	
	private ManageTrainingCourseMaterial trainingCourseMaterialModel;
	private TrainingProgressTrigger progressTableTrigger; 
	
	public TrainingCourseMaterialController() {
		
		trainingCourseMaterialModel = new ManageTrainingCourseMaterial();
		progressTableTrigger = new TrainingProgressTrigger();

	}
	
	// Initialize view
	public void showMaterial(String courseID, ListPanel materialList) {
		ArrayList<String> allTrainingCourseMaterialList = new ArrayList<>();
		trainingCourseMaterialModel.getAllCourseMaterialID(courseID, allTrainingCourseMaterialList);
		try {
			for(int i = 0;  i < allTrainingCourseMaterialList.size(); i++) {
				String materialID = allTrainingCourseMaterialList.get(i);
				String materialTitle = trainingCourseMaterialModel.getMaterialTitle(materialID);
				String materialDesc = trainingCourseMaterialModel.getMaterialDescription(materialID);
				
				TrainingMaterial material = new TrainingMaterial(materialID, courseID, materialTitle, materialDesc);
				addEditButtonListener(material);
				addDeleteButtonListener(material, materialList);
				materialList.addItem(material);
			}
		} catch (Exception e) {
			System.out.println("showTrainingList Fail");
		}
	}
	
	// Add one new material
	public boolean addNewMaterial(String courseID, ListPanel materialList) {
		try {
			String lastID = trainingCourseMaterialModel.getLastMaterialID();
			int id = Integer.parseInt(lastID.substring(3, 8))+1;
			String newID = String.format("mtr%05d", id);
			System.out.println("Next MATERIAL_ID: " + newID);
			
			boolean success = trainingCourseMaterialModel.addNewMaterial(newID, courseID, "Title", "Material description");
			if (success) {
				
				TrainingMaterial material = new TrainingMaterial(newID, courseID, "Title", "Material description");
				addEditButtonListener(material);
				addDeleteButtonListener(material, materialList);
				materialList.addItem(material);
				
				// Add trigger
				progressTableTrigger.addMaterialTrigger(courseID, newID);
				
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("Failed to get last available material ID");
		}
		return false;
	}
	
	// Edit button listener
	public void addEditButtonListener(TrainingMaterial material) {
		material.getEditButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!material.getIsEditing()) {
					// click to edit
					material.getTitleField().setEditable(true);
					material.getTxtrDescription().setEditable(true);
					material.getEditButton().setText("Save");
					material.setIsEditing(true);
				}
				else {
					// click to save
					String title = material.getTitleField().getText();
					String desc = material.getTxtrDescription().getText();
					trainingCourseMaterialModel.setMaterialDetails(material.getMaterialID(), title, 1);
					trainingCourseMaterialModel.setMaterialDetails(material.getMaterialID(), desc, 2);
					
					material.getTitleField().setEditable(false);
					material.getTxtrDescription().setEditable(false);
					material.getEditButton().setText("Edit");
					material.setIsEditing(false);
					
					System.out.println("Override course materail details success");
					JOptionPane.showConfirmDialog (null, "Training course material details overwritten successfully","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	
	// Delete button listener
	public void addDeleteButtonListener(TrainingMaterial material, ListPanel materialList) {
		material.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to delete this training course material?", "Delete This Material", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					
					try {
						// Delete from database
						trainingCourseMaterialModel.deleteMaterial(material.getMaterialID());
						progressTableTrigger.deleteMaterialTrigger(material.getMaterialID());
					} catch (Exception e1) {
						System.out.println("Unable to delete material");
					}
					
					// Wipe from view
					materialList.getListOfPanel().remove(material);
					materialList.getContainerPanel().removeAll();
					for (JPanel temp : materialList.getListOfPanel()) {
						materialList.getContainerPanel().add(temp);
					}
					materialList.getContainerPanel().repaint();
					materialList.getContainerPanel().revalidate();
					
					JOptionPane.showConfirmDialog (null, "Successfully deleted training course material","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
}
