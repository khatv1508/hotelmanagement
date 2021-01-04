package hotelmanagement.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
import hotelmanagement.model.CreateRoom;
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
	private static Room room = new Room();
	private CreateRoom createRoom = new CreateRoom();
	
	private List<Customer> list;
	private DefaultTableModel model = new DefaultTableModel();
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelCombo = new DefaultComboBoxModel();
	
	private JPanel panel;
	private JPanel panel_room;
	
	private JLabel lblAddRoom;
	private JLabel lblKhachHang;
	private JLabel lblCheckIn;
	private JLabel lblCheckOut;
	private JLabel lblSoKhach;
	private JLabel lblTien;
	private JLabel lblTragThai;
	private JLabel lblMaPhong;
	private JLabel lblLoaiPhong;
	private JLabel lblMPhong;
	private JLabel lblLPhong;
	private JLabel lblGiaPhong;
	private JLabel lblNam;
	private JLabel lblTreEm;
	private JLabel lblGPhong;

	private JTextField txtCheckOut;
	private JTextField txtCheckIn;
	private JTextField txtSKhach;
	private JTextField txtTien;
	
	private JPanel contentPane;
	private JComboBox<String> cbbKH;
	
	private JButton btnKhachHang;
	private JButton btnAdd;
	private JButton btnExit;
	private JTextField txtNam;
	private JTextField txtTreEm;
	private JTextField txtTrangThai;
	
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 408, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_room = new JPanel();
		panel_room.setBackground(new Color(255, 182, 193));
		panel_room.setBounds(10, 11, 386, 467);
		panel.add(panel_room);
		panel_room.setLayout(null);
		
		lblAddRoom = new JLabel("Đặt Phòng");
		lblAddRoom.setBounds(140, 11, 138, 32);
		lblAddRoom.setIcon(new ImageIcon("D:\\VinhKha\\image\\door-icon.png"));
		lblAddRoom.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_room.add(lblAddRoom);
		
		lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKhachHang.setBounds(23, 155, 98, 23);
		panel_room.add(lblKhachHang);
		
		lblCheckIn = new JLabel("Check-in");
		lblCheckIn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCheckIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckIn.setBounds(23, 189, 98, 23);
		panel_room.add(lblCheckIn);
		
		lblCheckOut = new JLabel("Check-out");
		lblCheckOut.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCheckOut.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckOut.setBounds(23, 223, 98, 23);
		panel_room.add(lblCheckOut);
		
		lblSoKhach = new JLabel("Số Khách");
		lblSoKhach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoKhach.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoKhach.setBounds(23, 257, 98, 23);
		panel_room.add(lblSoKhach);
		
		lblNam = new JLabel("Nam");
		lblNam.setHorizontalAlignment(SwingConstants.LEFT);
		lblNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNam.setBounds(23, 291, 98, 23);
		panel_room.add(lblNam);
		
		lblTreEm = new JLabel("Trẻ Em");
		lblTreEm.setHorizontalAlignment(SwingConstants.LEFT);
		lblTreEm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTreEm.setBounds(23, 325, 98, 23);
		panel_room.add(lblTreEm);
		
		lblTien = new JLabel("Đặt Trước");
		lblTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblTien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTien.setBounds(23, 360, 98, 23);
		panel_room.add(lblTien);
		
		lblTragThai = new JLabel("Trạng Thái");
		lblTragThai.setHorizontalAlignment(SwingConstants.LEFT);
		lblTragThai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTragThai.setBounds(23, 394, 98, 23);
		panel_room.add(lblTragThai);
		
		lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhong.setBounds(23, 54, 98, 23);
		panel_room.add(lblMaPhong);
		
		lblLoaiPhong = new JLabel("Loại Phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(23, 88, 98, 23);
		panel_room.add(lblLoaiPhong);
		
		lblGiaPhong = new JLabel("Giá Phòng");
		lblGiaPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGiaPhong.setBounds(23, 121, 98, 23);
		panel_room.add(lblGiaPhong);
		
		lblMPhong = new JLabel("");
		lblMPhong.setBackground(new Color(255, 182, 193));
		lblMPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMPhong.setBounds(131, 54, 229, 23);
		lblMPhong.setText(room.getMaPhong());
		panel_room.add(lblMPhong);
		
		lblLPhong = new JLabel("");
		lblLPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLPhong.setBounds(131, 88, 229, 23);
		lblLPhong.setText(room.getTenLoai());
		panel_room.add(lblLPhong);
		
		lblGPhong = new JLabel((String) null);
		lblGPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGPhong.setBounds(131, 121, 229, 23);
		lblGPhong.setText(String.valueOf(room.getGiaPhong()));
		panel_room.add(lblGPhong);
		
		list = contractService.getListCustomer();
		cbbKH = new JComboBox();
		cbbKH.setBounds(131, 155, 229, 23);
		modelCombo = new DefaultComboBoxModel();
		for (Customer customer : list) {
			modelCombo.addElement(customer);
		}
		cbbKH.setModel(modelCombo);
		panel_room.add(cbbKH);
		
		txtCheckOut = new JTextField();
		txtCheckOut.setBounds(131, 224, 229, 23);
		panel_room.add(txtCheckOut);
		txtCheckOut.setColumns(10);
		
		txtCheckIn = new JTextField();
		txtCheckIn.setColumns(10);
		txtCheckIn.setBounds(131, 190, 229, 23);
		panel_room.add(txtCheckIn);
		
		txtSKhach = new JTextField();
		txtSKhach.setColumns(10);
		txtSKhach.setBounds(131, 258, 229, 23);
		panel_room.add(txtSKhach);
		
		txtTien = new JTextField();
		txtTien.setColumns(10);
		txtTien.setBounds(131, 361, 229, 23);
		panel_room.add(txtTien);
		
		txtNam = new JTextField();
		txtNam.setColumns(10);
		txtNam.setBounds(131, 292, 229, 23);
		panel_room.add(txtNam);
		
		txtTreEm = new JTextField();
		txtTreEm.setColumns(10);
		txtTreEm.setBounds(131, 326, 229, 23);
		panel_room.add(txtTreEm);
		
		txtTrangThai = new JTextField();
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(131, 395, 229, 23);
		panel_room.add(txtTrangThai);
		
		btnAdd = new JButton("Đặt Phòng");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Customer customer = list.get(cbbKH.getSelectedIndex());
//					Date date = Calendar.getInstance().getTime();  
//					DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
//					String strDate = dateFormat.format(date);
					createRoom.setMaPhong(room.getMaPhong());
					createRoom.setKhachHang(customer.getIdKhachHang());
					createRoom.setCheckIn(txtCheckIn.getText());
					createRoom.setCheckOut(txtCheckOut.getText());
					createRoom.setSoKhach(Integer.parseInt(txtSKhach.getText()));
					createRoom.setNam(Integer.parseInt(txtNam.getText()));
					createRoom.setTreEm(Integer.parseInt(txtTreEm.getText()));
					createRoom.setDonGia(room.getGiaPhong());
					createRoom.setTienCoc(Long.valueOf(txtTien.getText()));
					createRoom.setTrangThai(txtTrangThai.getText());
					
					resultMessage = contractService.createRoom(createRoom);
					if(resultMessage.getMsgCode() == ResultMessage.MSG_ADD_ROOM) {
						AbstractMainGUI.showDialog(resultMessage);
					}
				} catch (SQLException e1) {
					DBHelper.printSQLException(e1);
					AbstractMainGUI.showErrDialog();
				}
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdd.setBounds(140, 433, 105, 23);
		panel_room.add(btnAdd);
		
		btnExit = new JButton("Thoát");
		btnExit.setBackground(Color.WHITE);
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(255, 433, 105, 23);
		panel_room.add(btnExit);
		
		btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.setBackground(Color.WHITE);
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerGUI customerGUI = new CustomerGUI();
				customerGUI.setVisible(true);
			}
		});
		btnKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnKhachHang.setBounds(23, 433, 105, 23);
		panel_room.add(btnKhachHang);
	}
}
