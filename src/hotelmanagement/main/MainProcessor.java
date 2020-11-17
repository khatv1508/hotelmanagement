package hotelmanagement.main;

import javax.swing.SwingUtilities;

import hotelmanagement.gui.LoginGUI;
import hotelmanagement.gui.MainGUI;

public class MainProcessor {
	// main processor
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	LoginGUI loginGUI = new LoginGUI();
            	loginGUI.setVisible(true);
            	
//            	MainGUI adminGUI = new MainGUI();
//            	adminGUI.setVisible(true);
            }
        });
	}
}
