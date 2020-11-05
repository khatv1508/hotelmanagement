package hotelmanagement.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FormAddRoomGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAddRoomGUI frame = new FormAddRoomGUI();
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
	public FormAddRoomGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 16, 507, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTang1 = new JLabel("Tang1");
		lblTang1.setBounds(6, 6, 61, 16);
		panel.add(lblTang1);
		
		JButton btnRoom1_1 = new JButton("P101");
		btnRoom1_1.setBounds(6, 34, 89, 29);
		panel.add(btnRoom1_1);
		
		JButton btnRoom1_2 = new JButton("P102");
		btnRoom1_2.setBounds(107, 34, 89, 29);
		panel.add(btnRoom1_2);
		
		JButton btnRoom1_3 = new JButton("P103");
		btnRoom1_3.setBounds(208, 34, 89, 29);
		panel.add(btnRoom1_3);
		
		JButton btnRoom1_4 = new JButton("P104");
		btnRoom1_4.setBounds(309, 34, 89, 29);
		panel.add(btnRoom1_4);
		
		JButton btnRoom1_5 = new JButton("P105");
		btnRoom1_5.setBounds(410, 34, 89, 29);
		panel.add(btnRoom1_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 96, 507, 68);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTang2 = new JLabel("Tang 2");
		lblTang2.setBounds(6, 6, 61, 16);
		panel_1.add(lblTang2);
		
		JButton btnRoom2_1 = new JButton("P201");
		btnRoom2_1.setBounds(6, 34, 88, 29);
		panel_1.add(btnRoom2_1);
		
		JButton btnRoom2_2 = new JButton("P202");
		btnRoom2_2.setBounds(106, 34, 93, 29);
		panel_1.add(btnRoom2_2);
		
		JButton btnRoom2_3 = new JButton("P203");
		btnRoom2_3.setBounds(211, 34, 88, 29);
		panel_1.add(btnRoom2_3);
		
		JButton btnRoom2_4 = new JButton("P204");
		btnRoom2_4.setBounds(311, 34, 88, 29);
		panel_1.add(btnRoom2_4);
		
		JButton btnRoom2_5 = new JButton("P205");
		btnRoom2_5.setBounds(411, 34, 88, 29);
		panel_1.add(btnRoom2_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 176, 507, 68);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTang3 = new JLabel("Tang 3");
		lblTang3.setBounds(6, 6, 61, 16);
		panel_2.add(lblTang3);
		
		JButton btnRoom3_1 = new JButton("P301");
		btnRoom3_1.setBounds(6, 33, 87, 29);
		panel_2.add(btnRoom3_1);
		
		JButton btnRoom3_2 = new JButton("P302");
		btnRoom3_2.setBounds(105, 33, 95, 29);
		panel_2.add(btnRoom3_2);
		
		JButton btnRoom3_3 = new JButton("P303");
		btnRoom3_3.setBounds(212, 33, 87, 29);
		panel_2.add(btnRoom3_3);
		
		JButton btnRoom3_4 = new JButton("P304");
		btnRoom3_4.setBounds(311, 33, 87, 29);
		panel_2.add(btnRoom3_4);
		
		JButton btnRoom3_5 = new JButton("P305");
		btnRoom3_5.setBounds(410, 33, 87, 29);
		panel_2.add(btnRoom3_5);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(418, 256, 85, 29);
		contentPane.add(btnExit);
	}

}
