package hotelmanagement.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setBackground(Color.WHITE);
		setTitle("Hotel management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1143,750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 1107, 689);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(10, 11, 1088, 72);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTitle = new JLabel("Hotel Management");
		lblTitle.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\hotel-icon (1).png"));
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTitle.setBounds(10, 0, 288, 72);
		panel_1.add(lblTitle);
		
		JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnKhachHang.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\customer.png"));
		btnKhachHang.setBounds(10, 94, 173, 41);
		panel.add(btnKhachHang);
		
		JButton btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNhanVien.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\staff.png"));
		btnNhanVien.setBounds(193, 94, 173, 41);
		panel.add(btnNhanVien);
		
		JButton btnQuanLy = new JButton("Quản Lý Đặt Phòng");
		btnQuanLy.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnQuanLy.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\room_manage.png"));
		btnQuanLy.setBounds(376, 94, 173, 41);
		panel.add(btnQuanLy);
		
		JButton btnDichVu = new JButton("Dịch Vụ");
		btnDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDichVu.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\service.png"));
		btnDichVu.setBounds(559, 94, 173, 41);
		panel.add(btnDichVu);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThanhToan.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\pay.png"));
		btnThanhToan.setBounds(742, 94, 173, 41);
		panel.add(btnThanhToan);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnExit.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\close-icon.png"));
		btnExit.setBounds(925, 94, 173, 41);
		panel.add(btnExit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 146, 1088, 532);
		panel.add(panel_2);
	}
}
