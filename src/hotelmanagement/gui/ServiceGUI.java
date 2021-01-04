package hotelmanagement.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hotelmanagement.model.CreateRoom;
import hotelmanagement.model.ResultMessage;
import hotelmanagement.model.Service;
import hotelmanagement.service.ContractService;

@SuppressWarnings("serial")
public class ServiceGUI extends JFrame {
	
	private ContractService contractService = new ContractService();
	@SuppressWarnings("unused")
	private ResultMessage resultMessage = new ResultMessage();
	private static CreateRoom roomManage = new CreateRoom();
	
	private List<Service> list;
	@SuppressWarnings("unused")
	private DefaultTableModel model = new DefaultTableModel();
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelCombo = new DefaultComboBoxModel();

	private JPanel contentPane;
	
	private JPanel panel;
	private JPanel panel_service;
	
	private JLabel lblTitle;
	private JLabel lblid;
	private JLabel lblKhachHang;
	private JLabel lblMPhng;
	private JLabel lblTenDV;
	private JLabel lblSoLuong;
	private JLabel lblGiDV;
	private JLabel lblidQL;
	private JLabel lblTenKH;
	private JLabel lblMphong;
	
	private JTextField txtSoLuong;
	private JTextField txtGia;
	
	private JComboBox<String> cbbDV;
	
	private JButton btnAdd;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceGUI frame = new ServiceGUI(roomManage);
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
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public ServiceGUI(CreateRoom roomManage) {
		this.roomManage = roomManage;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 371, 302);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_service = new JPanel();
		panel_service.setBackground(new Color(255, 182, 193));
		panel_service.setBounds(10, 11, 351, 280);
		panel.add(panel_service);
		panel_service.setLayout(null);
		
		lblTitle = new JLabel("Dịch Vụ");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTitle.setBounds(154, 11, 85, 25);
		panel_service.add(lblTitle);
		
		lblid = new JLabel("ID Quản Lý Phòng");
		lblid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblid.setBounds(10, 46, 122, 20);
		panel_service.add(lblid);
		
		lblKhachHang = new JLabel("Khách hàng");
		lblKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKhachHang.setBounds(10, 77, 122, 20);
		panel_service.add(lblKhachHang);
		
		lblMPhng = new JLabel("Mã Phòng");
		lblMPhng.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMPhng.setBounds(10, 108, 122, 20);
		panel_service.add(lblMPhng);
		
		lblTenDV = new JLabel("Dịch Vụ");
		lblTenDV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTenDV.setBounds(10, 139, 122, 20);
		panel_service.add(lblTenDV);
		
		lblSoLuong = new JLabel("Số Lượng");
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoLuong.setBounds(10, 170, 122, 20);
		panel_service.add(lblSoLuong);
		
		lblGiDV = new JLabel("Giá Dịch Vụ");
		lblGiDV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGiDV.setBounds(10, 201, 122, 20);
		panel_service.add(lblGiDV);
		
		lblidQL = new JLabel("");
		lblidQL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblidQL.setBounds(164, 47, 171, 20);
		lblidQL.setText(String.valueOf(roomManage.getIdQLDPhong()));
		panel_service.add(lblidQL);
		
		
		lblTenKH = new JLabel("");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTenKH.setBounds(164, 77, 171, 20);
		lblTenKH.setText(String.valueOf(roomManage.getIdKhachHang()));
		panel_service.add(lblTenKH);
		
		lblMphong = new JLabel("");
		lblMphong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMphong.setBounds(164, 114, 171, 20);
		lblMphong.setText(String.valueOf(roomManage.getMaPhong()));
		panel_service.add(lblMphong);
		
		list = contractService.getListService();
		cbbDV = new JComboBox();
		cbbDV.setBounds(164, 140, 171, 20);
		modelCombo = new DefaultComboBoxModel();
		for (Service service : list) {
			modelCombo.addElement(service);
		}
		cbbDV.setModel(modelCombo);
		panel_service.add(cbbDV);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtSoLuong.setBounds(164, 170, 171, 20);
		panel_service.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		txtGia = new JTextField();
		txtGia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtGia.setColumns(10);
		txtGia.setBounds(164, 201, 171, 20);
		panel_service.add(txtGia);
		
		btnAdd = new JButton("Thêm ");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAdd.setBounds(164, 246, 85, 23);
		panel_service.add(btnAdd);
		
		btnExit = new JButton("Thoát");
		btnExit.setBackground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExit.setBounds(259, 246, 76, 23);
		panel_service.add(btnExit);
	}
}
