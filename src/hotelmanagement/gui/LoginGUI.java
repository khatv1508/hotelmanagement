package hotelmanagement.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import hotelmanagement.db.DBHelper;
import hotelmanagement.model.Account;
import hotelmanagement.service.AccountService;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1;
	
	private static final String BTN_LOGIN = "Login";
	
	public AccountService accountService;
	public ResultMessage resultMessage;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("UserName");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblName.setBounds(23, 49, 78, 16);
		contentPane.add(lblName);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPass.setBounds(23, 92, 61, 16);
		contentPane.add(lblPass);
		
		txtName = new JTextField();
		txtName.setBounds(113, 44, 168, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(113, 87, 168, 26);
		contentPane.add(txtPass);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLogin.setBounds(121, 17, 78, 16);
		contentPane.add(lblLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					switch (e.getActionCommand()) {
					case BTN_LOGIN:
						Account account = new Account();
//						account.setAccountName(txtName.getText());
//						account.setAccountPass(txtPass.getText());
						account.setAccountName("vinhkha");
						account.setAccountPass("vinhkha1508");
						resultMessage = accountService.login(account);
						AbstractMainGUI.showDialog(resultMessage);
						if(resultMessage.getMsgCode() == ResultMessage.MSG_LOGIN_SUCCESS) {
							AdminGUI adminGUI = new AdminGUI();
							adminGUI.setVisible(true);
							dispose();
						}
						break;
					default:
						break;
					}
				} catch (SQLException ex) {
					DBHelper.printSQLException(ex);
					AbstractMainGUI.showErrDialog();
				}	
				
			}
		});
		btnLogin.setBounds(123, 125, 78, 29);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(203, 125, 78, 29);
		contentPane.add(btnExit);
	}
}
