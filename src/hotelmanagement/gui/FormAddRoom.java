package hotelmanagement.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class FormAddRoom extends JFrame {

	private JPanel contentPane;
	private JTextField txtKhachHang;
	private JTextField txtPhone;
	private JTextField txtCMND;
	private JTextField txtMaPhong;
	private JTextField txtQuocTich;
	private JTextField txtLoaiPhong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAddRoom frame = new FormAddRoom();
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
	public FormAddRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(10, 11, 437, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_room = new JPanel();
		panel_room.setBackground(new Color(255, 255, 255));
		panel_room.setBounds(10, 11, 417, 364);
		panel.add(panel_room);
		panel_room.setLayout(null);
		
		JLabel lblAddRoom = new JLabel("Đặt Phòng");
		lblAddRoom.setBounds(161, 11, 138, 32);
		lblAddRoom.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\door-icon.png"));
		lblAddRoom.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_room.add(lblAddRoom);
		
		JLabel lblKhachHang = new JLabel("Tên Khách Hàng");
		lblKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKhachHang.setBounds(23, 54, 128, 23);
		panel_room.add(lblKhachHang);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblGioiTinh.setBounds(23, 88, 128, 23);
		panel_room.add(lblGioiTinh);
		
		JLabel lblPhone = new JLabel("Số ĐT");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setBounds(23, 122, 128, 23);
		panel_room.add(lblPhone);
		
		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCMND.setHorizontalAlignment(SwingConstants.LEFT);
		lblCMND.setBounds(23, 156, 128, 23);
		panel_room.add(lblCMND);
		
		JLabel lblQuocTich = new JLabel("Quốc Tịch");
		lblQuocTich.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuocTich.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblQuocTich.setBounds(23, 190, 128, 23);
		panel_room.add(lblQuocTich);
		
		JLabel lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhong.setBounds(23, 224, 128, 23);
		panel_room.add(lblMaPhong);
		
		JLabel lblLoaiPhong = new JLabel("Loại Phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(23, 258, 128, 23);
		panel_room.add(lblLoaiPhong);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(161, 54, 229, 23);
		panel_room.add(txtKhachHang);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPhone.setColumns(10);
		txtPhone.setBounds(161, 121, 229, 23);
		panel_room.add(txtPhone);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCMND.setColumns(10);
		txtCMND.setBounds(161, 155, 229, 23);
		panel_room.add(txtCMND);
		
		txtQuocTich = new JTextField();
		txtQuocTich.setBounds(161, 189, 229, 23);
		panel_room.add(txtQuocTich);
		txtQuocTich.setColumns(10);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(161, 223, 229, 23);
		panel_room.add(txtMaPhong);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(161, 258, 229, 23);
		panel_room.add(txtLoaiPhong);
		
		JComboBox cbbGioiTinh = new JComboBox();
		cbbGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbbGioiTinh.setBounds(161, 88, 229, 23);
		panel_room.add(cbbGioiTinh);
		
		JButton btnAdd = new JButton("Đặt Phòng");
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAdd.setBounds(161, 326, 105, 23);
		panel_room.add(btnAdd);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(285, 326, 105, 23);
		panel_room.add(btnExit);
	}
}
