package hotelmanagement.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHotel = new JLabel("Hotel Management");
		lblHotel.setBounds(176, 11, 181, 27);
		lblHotel.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		contentPane.add(lblHotel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 42, 512, 243);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormRoomGUI roomGUI = new FormRoomGUI();
				roomGUI.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdd.setBounds(10, 11, 89, 23);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnUpdate.setBounds(10, 45, 89, 23);
		panel_1.add(btnUpdate);
		
		JButton btnService = new JButton("Service");
		btnService.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnService.setBounds(10, 79, 89, 23);
		panel_1.add(btnService);
		
		JButton btnBill = new JButton("Bill");
		btnBill.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnBill.setBounds(10, 113, 89, 23);
		panel_1.add(btnBill);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnExit.setBounds(10, 209, 89, 23);
		panel_1.add(btnExit);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSearch.setBounds(413, 11, 89, 23);
		panel_1.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(109, 12, 294, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setBounds(109, 45, 393, 187);
		panel_1.add(list);
	}
}
