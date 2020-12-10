package hotelmanagement.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
	private static Room room = new Room();
	private List<Customer> lstResults;
	private DefaultTableModel model = new DefaultTableModel();
	
	private JPanel panel;
	private JPanel panel_room;
	
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

	private JTextField txtCheckOut;
	private JTextField txtCheckIn;
	private JTextField txtKhach;
	private JTextField txtTien;
	
	private JPanel contentPane;
	private JComboBox<String> cbbKH;
	
	private JButton btnKhachHang;
	private JButton btnAdd;
	private JButton btnExit;
	
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
	@SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
	public AddRoomGUI(Room room) {
		this.room = room;
		setTextField();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(10, 11, 408, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_room = new JPanel();
		panel_room.setBackground(new Color(255, 255, 255));
		panel_room.setBounds(10, 11, 386, 364);
		panel.add(panel_room);
		panel_room.setLayout(null);
		
		lblAddRoom = new JLabel("Đặt Phòng");
		lblAddRoom.setBounds(161, 11, 138, 32);
		lblAddRoom.setIcon(new ImageIcon("D:\\VinhKha\\image\\door-icon.png"));
		lblAddRoom.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_room.add(lblAddRoom);
		
		lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKhachHang.setBounds(23, 54, 98, 23);
		panel_room.add(lblKhachHang);
		
		lblCheckIn = new JLabel("Check-in");
		lblCheckIn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCheckIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckIn.setBounds(23, 88, 98, 23);
		panel_room.add(lblCheckIn);
		
		lblCheckOut = new JLabel("Check-out");
		lblCheckOut.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCheckOut.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckOut.setBounds(23, 122, 98, 23);
		panel_room.add(lblCheckOut);
		
		lblSoKhach = new JLabel("Số Khách");
		lblSoKhach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoKhach.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoKhach.setBounds(23, 156, 98, 23);
		panel_room.add(lblSoKhach);
		
		lblTien = new JLabel("Đặt Trước");
		lblTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblTien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTien.setBounds(23, 190, 98, 23);
		panel_room.add(lblTien);
		
		lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhong.setBounds(23, 224, 98, 23);
		panel_room.add(lblMaPhong);
		
		lblLoaiPhong = new JLabel("Loại Phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(23, 258, 98, 23);
		panel_room.add(lblLoaiPhong);
		
		lblMPhong = new JLabel("");
		lblMPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMPhong.setBounds(131, 224, 229, 23);
		panel_room.add(lblMPhong);
		
		lblLPhong = new JLabel("");
		lblLPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLPhong.setBounds(131, 258, 229, 23);
		panel_room.add(lblLPhong);
		
		this.lstResults = new ArrayList<>();
		cbbKH = new JComboBox();
		cbbKH.setBounds(131, 54, 229, 23);
		cbbKH.addItem(customer.getHoTen());
		panel_room.add(cbbKH);
		
		txtCheckOut = new JTextField();
		txtCheckOut.setBounds(131, 123, 229, 23);
		panel_room.add(txtCheckOut);
		txtCheckOut.setColumns(10);
		
		txtCheckIn = new JTextField();
		txtCheckIn.setColumns(10);
		txtCheckIn.setBounds(131, 89, 229, 23);
		panel_room.add(txtCheckIn);
		
		txtKhach = new JTextField();
		txtKhach.setColumns(10);
		txtKhach.setBounds(131, 157, 229, 23);
		panel_room.add(txtKhach);
		
		txtTien = new JTextField();
		txtTien.setColumns(10);
		txtTien.setBounds(131, 191, 229, 23);
		panel_room.add(txtTien);
		
		btnAdd = new JButton("Đặt Phòng");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdd.setBounds(138, 326, 105, 23);
		panel_room.add(btnAdd);
		
		btnExit = new JButton("Thoát");
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(253, 326, 105, 23);
		panel_room.add(btnExit);
		
		btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerGUI customerGUI = new CustomerGUI();
				customerGUI.setVisible(true);
			}
		});
		btnKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnKhachHang.setBounds(23, 326, 105, 23);
		panel_room.add(btnKhachHang);
		
	}
	private void setTextField() {
		lblMPhong.setText(room.getMaPhong());
		lblLPhong.setText(room.getTenLoai());
	}
	
	public void resetTable() {
		for (Customer customer : lstResults) {
			ArrayList<String> item = new ArrayList<String>();
			item.add(String.valueOf(customer.getHoTen()));
			model.addRow(item.toArray());
		}
//		cbbKH.setModel(model);
	}
}
