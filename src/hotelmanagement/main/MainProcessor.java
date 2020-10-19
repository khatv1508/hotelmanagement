package hotelmanagement.main;

import javax.swing.SwingUtilities;

import hotelmanagement.gui.AdminGUI;

public class MainProcessor {
	// main processor
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	AdminGUI adminGUI = new AdminGUI();
            	adminGUI.setVisible(true);
            }
        });
	}
}
