package hotelmanagement.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import hotelmanagement.db.DBHelper;
import hotelmanagement.model.Customer;
import hotelmanagement.model.ResultMessage;
import hotelmanagement.model.Room;
import hotelmanagement.model.RoomManage;
import hotelmanagement.service.ContractService;
import javax.swing.JComboBox;

@SuppressWarnings({ "serial", "unused" })
public class AddRoomGUI extends JFrame {
	
	private ContractService contractService = new ContractService();
	private ResultMessage resultMessage = new ResultMessage();
	private Customer customer = new Customer();
	private static RoomManage roomManage = new RoomManage();
	
	private JLabel lblAddRoom;
	private JLabel lblKhachHang;
	private JLabel lblCheckIn;
	private JLabel lblCheckOut;
	private JLabel lblSoKhach;
	private JLabel lblTien;
	private JLabel lblMaPhong;
	private JLabel lblLoaiPhong;
	private JLabel lblMPhong;
	private JLabel lblLPhong;
	private JLabel lblCheck_in;
	private JLabel lblCheck_out;

	private JPanel contentPane;
	private JComboBox cbbKH;
	
	private JButton btnAdd;
	private JButton btnExit;
	private static Room room;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoomGUI frame = new AddRoomGUI(room);
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
	@SuppressWarnings("static-access")
	public AddRoomGUI(Room room) {
		this.room = room;
		
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
		
		lblAddRoom = new JLabel("Đặt Phòng");
		lblAddRoom.setBounds(161, 11, 138, 32);
		lblAddRoom.setIcon(new ImageIcon("D:\\VinhKha\\image\\door-icon.png"));
		lblAddRoom.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_room.add(lblAddRoom);
		
		lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKhachHang.setBounds(23, 54, 128, 23);
		panel_room.add(lblKhachHang);
		
		lblCheckIn = new JLabel("Check-in");
		lblCheckIn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCheckIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckIn.setBounds(23, 88, 128, 23);
		panel_room.add(lblCheckIn);
		
		lblCheckOut = new JLabel("Check-out");
		lblCheckOut.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCheckOut.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckOut.setBounds(23, 122, 128, 23);
		panel_room.add(lblCheckOut);
		
		lblSoKhach = new JLabel("Số Khách");
		lblSoKhach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoKhach.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoKhach.setBounds(23, 156, 128, 23);
		panel_room.add(lblSoKhach);
		
		lblTien = new JLabel("Đặt Trước");
		lblTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblTien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTien.setBounds(23, 190, 128, 23);
		panel_room.add(lblTien);
		
		lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhong.setBounds(23, 224, 128, 23);
		panel_room.add(lblMaPhong);
		
		lblLoaiPhong = new JLabel("Loại Phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(23, 258, 128, 23);
		panel_room.add(lblLoaiPhong);
		
		lblMPhong = new JLabel("");
		lblMPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMPhong.setBounds(161, 225, 229, 23);
		panel_room.add(lblMPhong);
		
		lblLPhong = new JLabel("");
		lblLPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLPhong.setBounds(161, 259, 229, 23);
		panel_room.add(lblLPhong);
		
		btnAdd = new JButton("Đặt Phòng");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAdd.setBounds(161, 326, 105, 23);
		panel_room.add(btnAdd);
		
		btnExit = new JButton("Thoát");
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(285, 326, 105, 23);
		panel_room.add(btnExit);
		
		@SuppressWarnings("rawtypes")
		JComboBox cbbKH = new JComboBox();
		cbbKH.setBounds(161, 54, 229, 23);
		panel_room.add(cbbKH);
		
		lblCheck_in = new JLabel("");
		lblCheck_in.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCheck_in.setBounds(161, 89, 229, 23);
		panel_room.add(lblCheck_in);
		
		lblCheck_out = new JLabel("");
		lblCheck_out.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCheck_out.setBounds(161, 123, 229, 23);
		panel_room.add(lblCheck_out);
		
		setTextField();
	}
	public void setTextField() {
		lblMPhong.setText(room.getMaPhong());
		lblLPhong.setText(room.getTenLoai());
	}
}
