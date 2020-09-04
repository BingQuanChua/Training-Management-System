package mj;

import java.util.ArrayList;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class MenuItem extends JPanel{
	
    private JSeparator jSeparator1;
    private JLabel lbName;
    private final ArrayList<MenuItem> subMenu = new ArrayList<>();
    private ActionListener act;
      
	//To determine the subMenu is currently visible or not
    public void setShowing(boolean showing) {
	    this.showing = showing;
	}

    // <MenuItem> Arraylist getter
    public ArrayList<MenuItem> getSubMenu() {
        return subMenu;
    }

    // Parameterized Constructor, need icon/menuName/actionListenr 
    public MenuItem(String menuName, ActionListener act, MenuItem... subMenu) {
        initComponents();
        lbName.setText(menuName);
        if (act != null) {
            this.act = act;
        }
        this.setSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));
        for (int i = 0; i < subMenu.length; i++) {
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
    }


    // This method is called from within the constructor to initialize the form.
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jSeparator1 = new JSeparator();
        lbName = new JLabel();
        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lbName.setText("Menu Name Here ...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
	            .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }
    
    
    

    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {
        if (showing) {
            hideMenu();
        } else {
            showMenu();
        }
        if (act != null) {
            act.actionPerformed(null);
        }
    }

    private void showMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < subMenu.size(); i++) {
                    sleep();
                    subMenu.get(i).setVisible(true);
                }
                showing = true;
                getParent().repaint();
                getParent().revalidate();
            }
        }).start();
    }

    private void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = subMenu.size() - 1; i >= 0; i--) {
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                getParent().repaint();
                getParent().revalidate();
                showing = false;
            }
        }).start();
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
    }
}
