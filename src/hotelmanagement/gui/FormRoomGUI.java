package hotelmanagement.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FormRoomGUI extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public FormRoomGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 29, 504, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTang1 = new JLabel("Tang 1");
		lblTang1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTang1.setBounds(10, 11, 65, 20);
		panel.add(lblTang1);
		
		JButton btnRoom1_1 = new JButton("P101");
		btnRoom1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom1_1.setBounds(10, 42, 89, 23);
		panel.add(btnRoom1_1);
		
		JButton btnRoom1_2 = new JButton("P102");
		btnRoom1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom1_2.setBounds(109, 42, 89, 23);
		panel.add(btnRoom1_2);
		
		JButton btnRoom1_3 = new JButton("P103");
		btnRoom1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom1_3.setBounds(208, 42, 89, 23);
		panel.add(btnRoom1_3);
		
		JButton btnRoom1_4 = new JButton("P104");
		btnRoom1_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom1_4.setBounds(307, 42, 89, 23);
		panel.add(btnRoom1_4);
		
		JButton btnRoom1_5 = new JButton("P105");
		btnRoom1_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom1_5.setBounds(406, 42, 89, 23);
		panel.add(btnRoom1_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 116, 504, 76);
		contentPane.add(panel_1);
		
		JLabel lblTang2 = new JLabel("Tang 2");
		lblTang2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTang2.setBounds(10, 11, 62, 20);
		panel_1.add(lblTang2);
		
		JButton btnRoom2_1 = new JButton("P201");
		btnRoom2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom2_1.setBounds(10, 42, 89, 23);
		panel_1.add(btnRoom2_1);
		
		JButton btnRoom2_2 = new JButton("P202");
		btnRoom2_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom2_2.setBounds(109, 42, 89, 23);
		panel_1.add(btnRoom2_2);
		
		JButton btnRoom2_3 = new JButton("P203");
		btnRoom2_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom2_3.setBounds(208, 42, 89, 23);
		panel_1.add(btnRoom2_3);
		
		JButton btnRoom2_4 = new JButton("P204");
		btnRoom2_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom2_4.setBounds(307, 42, 89, 23);
		panel_1.add(btnRoom2_4);
		
		JButton btnRoom2_5 = new JButton("P205");
		btnRoom2_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom2_5.setBounds(406, 42, 89, 23);
		panel_1.add(btnRoom2_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 203, 504, 76);
		contentPane.add(panel_2);
		
		JLabel lblTang3 = new JLabel("Tang 3");
		lblTang3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTang3.setBounds(10, 11, 62, 20);
		panel_2.add(lblTang3);
		
		JButton btnRoom3_1 = new JButton("P301");
		btnRoom3_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom3_1.setBounds(10, 42, 89, 23);
		panel_2.add(btnRoom3_1);
		
		JButton btnRoom3_2 = new JButton("P302");
		btnRoom3_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom3_2.setBounds(109, 42, 89, 23);
		panel_2.add(btnRoom3_2);
		
		JButton btnRoom3_3 = new JButton("P303");
		btnRoom3_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom3_3.setBounds(208, 42, 89, 23);
		panel_2.add(btnRoom3_3);
		
		JButton btnRoom3_4 = new JButton("P304");
		btnRoom3_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom3_4.setBounds(307, 42, 89, 23);
		panel_2.add(btnRoom3_4);
		
		JButton btnRoom3_5 = new JButton("P305");
		btnRoom3_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRoom3_5.setBounds(406, 42, 89, 23);
		panel_2.add(btnRoom3_5);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExit.setBounds(416, 290, 89, 23);
		contentPane.add(btnExit);
	}
}
