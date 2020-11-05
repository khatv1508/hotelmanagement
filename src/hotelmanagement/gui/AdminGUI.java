package hotelmanagement.gui;

import java.awt.Color;
import java.awt.EventQueue;
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
public class AdminGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI();
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
	@SuppressWarnings("rawtypes")
	public AdminGUI() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 322);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hotel Management");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(199, 6, 165, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAddRoomGUI addRoomGUI = new FormAddRoomGUI();
				addRoomGUI.setVisible(true);
			}
		});
		btnAdd.setBounds(6, 44, 117, 29);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(6, 72, 117, 29);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(6, 101, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnService = new JButton("SERVICE");
		btnService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnService.setBounds(6, 130, 117, 29);
		contentPane.add(btnService);
		
		JButton btnBill = new JButton("BILL");
		btnBill.setBounds(6, 159, 117, 29);
		contentPane.add(btnBill);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(452, 44, 117, 29);
		contentPane.add(btnSearch);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(6, 265, 117, 29);
		contentPane.add(btnExit);
		
		JList list = new JList();
		list.setBounds(135, 77, 434, 217);
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setBounds(135, 42, 303, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
}
