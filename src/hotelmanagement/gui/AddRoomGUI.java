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
import hotelmanagement.model.RoomManage;
import hotelmanagement.service.ContractService;

@SuppressWarnings("serial")
public class AddRoomGUI extends JFrame {
	
	private ContractService contractService = new ContractService();
	private ResultMessage resultMessage = new ResultMessage();
	private Customer customer = new Customer();
	private static RoomManage roomManage = new RoomManage();

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtPhone;
	private JTextField txtCMND;
	private JTextField txtQuocTich;
	private JTextField txtGioiTinh;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoomGUI frame = new AddRoomGUI(roomManage);
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
	public AddRoomGUI(RoomManage roomManage) {
		super();

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
		lblAddRoom.setIcon(new ImageIcon("D:\\VinhKha\\image\\door-icon.png"));
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
		
		JLabel lblMPhong = new JLabel("");
		lblMPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMPhong.setBounds(161, 225, 229, 23);
		lblMPhong.setText(roomManage.getMaPhong());
		panel_room.add(lblMPhong);
		
		JLabel lblLPhong = new JLabel("");
		lblLPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLPhong.setBounds(161, 259, 229, 23);
		lblLPhong.setText(roomManage.getTenLoai());
		panel_room.add(lblLPhong);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTen.setColumns(10);
		txtTen.setBounds(161, 54, 229, 23);
		panel_room.add(txtTen);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(161, 88, 229, 23);
		panel_room.add(txtGioiTinh);
		
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
		txtQuocTich.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtQuocTich.setBounds(161, 189, 229, 23);
		panel_room.add(txtQuocTich);
		txtQuocTich.setColumns(10);
		
		JButton btnAdd = new JButton("Đặt Phòng");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					Customer customer = contractService.getContractMount(contractCode);
					// set cac tham so cho cau SQL BORROWER
					customer.setHoTen(txtTen.getText());
					customer.setGioiTinh(txtGioiTinh.getText());
					customer.setSdt(txtPhone.getText());
					customer.setCmnd(txtCMND.getText());
					customer.setQuocTich(txtQuocTich.getText());
					
					// set cac tham so cho cau SQL CONTRACT
					roomManage.setMaPhong(lblMPhong.getText());
					roomManage.setHoTen(txtTen.getText());
					roomManage.setTenLoai(lblLPhong.getText());
					
					// check ket qua tra ve
					resultMessage = contractService.createContract(customer, roomManage);
					if(resultMessage.getMsgCode() == ResultMessage.MSG_CODE_SUCCESS) {
						AbstractMainGUI.showDialog(resultMessage);
					}
					
				} catch (SQLException ex) {
					DBHelper.printSQLException(ex);
					AbstractMainGUI.showErrDialog();
				}
			}
		});
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
