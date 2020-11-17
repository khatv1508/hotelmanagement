package hotelmanagement.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import hotelmanagement.db.DBHelper;
import hotelmanagement.model.Account;
import hotelmanagement.service.AccountService;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static final String BTN_LOGIN = "Login";
	
	public ResultMessage resultMessage;
	public AccountService accountService = new AccountService();
	
	private JPanel contentPane;
	private JTextField txtName;
	private JPasswordField Password;

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLogin.setBounds(114, 11, 68, 24);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsername.setBounds(21, 50, 79, 18);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(21, 75, 79, 24);
		contentPane.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtName.setBounds(114, 46, 156, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					switch (e.getActionCommand()) {
					case BTN_LOGIN:
						Account account = new Account();
//						ResultMessage resultMessage = new ResultMessage();
//						AccountService accountService = new AccountService();
//						account.setAccountName(txtName.getText());
//						account.setAccountPass(Password.getText());
						account.setAccountName("admin");
						account.setAccountPass("12345");
						resultMessage = accountService.login(account);
						AbstractMainGUI.showDialog(resultMessage);
						if(resultMessage.getMsgCode() == ResultMessage.MSG_LOGIN_SUCCESS) {
							MainGUI mainGUI = new MainGUI();
							mainGUI.setVisible(true);
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
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLogin.setBounds(114, 110, 73, 23);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExit.setBounds(197, 110, 73, 23);
		contentPane.add(btnExit);
		
		Password = new JPasswordField();
		Password.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Password.setBounds(114, 76, 156, 20);
		contentPane.add(Password);
	}
}
