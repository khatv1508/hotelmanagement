package hotelmanagement.gui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import hotelmanagement.service.AccountService;

public abstract class AbstractMainGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	/** ICON **/
	public static final String ICON_CHECK = "/icons/38.png";
	/** SERVICE **/
	public AccountService accountService;

	// Khoi tao
	public AbstractMainGUI(){
		this.accountService = new AccountService();
		initComponent();
	}
	
	// Khoi tao giao dien
	public abstract void initComponent();
	
	// Khoi tao icon tu resource
	public static ImageIcon getIcon(String resource){
		return new ImageIcon(AbstractMainGUI.class.getResource(resource));
	}
	
	// Khoi tao style button
	public static JButton genButton(String btnLabel, String resource) {
		JButton button = new JButton(btnLabel, getIcon(resource));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        Border line = new LineBorder(new Color(212, 212, 212));
        Border margin = new EmptyBorder(10, 10, 10, 10);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.RIGHT);
        button.setFocusPainted(false);
        return button;
	}
	
	// Hien thi dialog err
	public static void showErrDialog(){
		JOptionPane.showMessageDialog(null, ResultMessage.ERR_SELECT, ResultMessage.DIALOG_INFORM, JOptionPane.ERROR_MESSAGE);
	}
}
