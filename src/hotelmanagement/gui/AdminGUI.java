package hotelmanagement.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import hotelmanagement.db.DBHelper;

public class AdminGUI extends AbstractMainGUI {
	private static final long serialVersionUID = 1L;
	// Ten cac button
	private static final String BTN_SHOWME = "Show me";
	// Cac component noi bo
	private JButton btnShowMe;
	private JTextArea area;

	// Khoi tao
	public AdminGUI(){
		super();
	}
	// override abtract method
	public void initComponent(){
		setTitle("AdminGUI");
		setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
		JPanel panel = new JPanel();
        area = new JTextArea();
        area.setPreferredSize(new Dimension(300, 300));
        btnShowMe = genButton(BTN_SHOWME, ICON_CHECK);
        btnShowMe.addActionListener(this);
        panel.add(btnShowMe);
        panel.add(area);
        add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			switch (e.getActionCommand()) {
			case BTN_SHOWME:
				area.append(accountService.selectAuthor());
				break;
			default:
				break;
			}
		} catch (SQLException ex) {
			DBHelper.printSQLException(ex);
			AbstractMainGUI.showErrDialog();
		}
	}
}
