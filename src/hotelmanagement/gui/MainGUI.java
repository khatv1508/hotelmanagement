package hotelmanagement.gui;

import java.awt.Color;
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
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import hotelmanagement.model.Room;
import hotelmanagement.model.RoomManage;
import hotelmanagement.service.ContractService;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	
	private ContractService contractService = new ContractService();
//	private RoomManage roomManage;
	private Room room;
	private DefaultTableModel model = new DefaultTableModel();
	private String[] tblHead = {"Tầng","Mã Phòng","Tên Khách Hàng", "Loại Phòng", "Ngày Đến", "Ngày Đi", "Giá Phòng", "Trạng Thái"};
	
	//
	@SuppressWarnings("unused")
	private String maPhong, tenLoai, giaPhong;
	private List<RoomManage> lstResults;
	
	//
	private JPanel contentPane;
	
	private JPanel panel;
	private JPanel panel_Top;
	private JPanel panel_Center;
	
	private JLabel lblTitle;
	
	private JButton btnKhachHang;
	private JButton btnNhanVien;
	private JButton btnPhong;
	private JButton btnQuanLy;
	private JButton btnDichVu;
	private JButton btnThanhToan;
	private JButton btnThoat;
	
	private JTree treeRoom;
	private JTable tblRoom;

	/**
	 * Create the frame. 
	 */
	public MainGUI() {
		setBackground(Color.WHITE);
		setTitle("Hotel management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1332,759);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 1297, 699);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//
		panel_Top = new JPanel();
		panel_Top.setBackground(new Color(255, 182, 193));
		panel_Top.setBounds(10, 11, 1273, 70);
		panel.add(panel_Top);
		panel_Top.setLayout(null);
		
		lblTitle = new JLabel("Hotel Management");
		lblTitle.setIcon(new ImageIcon("D:\\VinhKha\\image\\hotel-icon (1).png"));
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTitle.setBounds(10, 0, 288, 72);
		panel_Top.add(lblTitle);
		
		btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerGUI customerGUI = new CustomerGUI();
				customerGUI.setVisible(true);
			}
		});
		btnKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnKhachHang.setIcon(new ImageIcon("D:\\VinhKha\\image\\customer.png"));
		btnKhachHang.setBounds(10, 94, 173, 41);
		panel.add(btnKhachHang);
		
		btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNhanVien.setIcon(new ImageIcon("D:\\VinhKha\\image\\staff.png"));
		btnNhanVien.setBounds(193, 94, 173, 41);
		panel.add(btnNhanVien);
		
		btnPhong = new JButton("Phòng");
		btnPhong.setIcon(new ImageIcon("D:\\VinhKha\\image\\House-icon.png"));
		btnPhong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnPhong.setBounds(378, 94, 173, 41);
		panel.add(btnPhong);
		
		btnQuanLy = new JButton(" Đặt phòng");
		btnQuanLy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					room = contractService.getRoom(maPhong);
					AddRoomGUI addRoom = new AddRoomGUI(room);
					addRoom.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnQuanLy.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnQuanLy.setIcon(new ImageIcon("D:\\VinhKha\\image\\door-icon.png"));
		btnQuanLy.setBounds(561, 94, 173, 41);
		panel.add(btnQuanLy);
		
		btnDichVu = new JButton("Dịch vụ");
		btnDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDichVu.setIcon(new ImageIcon("D:\\VinhKha\\image\\service.png"));
		btnDichVu.setBounds(744, 94, 173, 41);
		panel.add(btnDichVu);
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThanhToan.setIcon(new ImageIcon("D:\\VinhKha\\image\\pay.png"));
		btnThanhToan.setBounds(927, 94, 173, 41);
		panel.add(btnThanhToan);
		
		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThoat.setIcon(new ImageIcon("D:\\VinhKha\\image\\close-icon.png"));
		btnThoat.setBounds(1110, 94, 173, 41);
		panel.add(btnThoat);
		
		//
		panel_Center = new JPanel();
		panel_Center.setBounds(10, 146, 1273, 542);
		panel.add(panel_Center);
		panel_Center.setLayout(null);
		
		this.lstResults = new ArrayList<>();
		treeRoom = new JTree();
		treeRoom.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		treeRoom.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Khu vực") {
				{
					add(new DefaultMutableTreeNode("Tâng 1"));
					add(new DefaultMutableTreeNode("Tầng 2"));
					add(new DefaultMutableTreeNode("Tầng 3"));
				}
			}
		));
		treeRoom.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		treeRoom.addTreeSelectionListener(new TreeSelectionListener() {
		    public void valueChanged(TreeSelectionEvent e) {
		        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
		        		treeRoom.getLastSelectedPathComponent();

		    /* if nothing is selected */ 
		        if (node == null) return;

		    /* retrieve the node that was selected */ 
		        Object nodeInfo = node.getUserObject();
		        try {
		        	switch (nodeInfo.toString()) {
					case "Tâng 1":
						lstResults = contractService.lstRoom(1);
						resetTable();
						break;
					case "Tầng 2":
						lstResults = contractService.lstRoom(2);
						resetTable();
						break;
					case "Tầng 3":
						lstResults = contractService.lstRoom(3);
						resetTable();
						break;

					default:
						lstResults = contractService.lstRoom(0);
						resetTable();
						break;
					}
				} catch (Exception e2) {
				}
		        
		    }
		});
		treeRoom.setBounds(10, 11, 163, 520);
		panel_Center.add(treeRoom);
		
		try {
			lstResults = contractService.lstRoom(0);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		tblRoom = new JTable();
		tblRoom.setBackground(Color.WHITE);
		tblRoom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tblRoom.setBounds(183, 11, 1078, 520);;
		resetTable();
		getTableData();
		tblRoom.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	maPhong = tblRoom.getValueAt(tblRoom.getSelectedRow(), 1).toString();
	        	tenLoai = tblRoom.getValueAt(tblRoom.getSelectedRow(), 3).toString();
	        	giaPhong = tblRoom.getValueAt(tblRoom.getSelectedRow(), 6).toString();
	        }
	    });
		panel_Center.add(tblRoom);
	}
	public void resetTable() {
		model = new DefaultTableModel(tblHead, 0);
		model.addRow(tblHead);
		for (RoomManage roomManage : lstResults) {
			ArrayList<String> item = new ArrayList<String>();
			item.add(String.valueOf(roomManage.getTang()));
			item.add(roomManage.getMaPhong());
			item.add(roomManage.getHoTen());
			item.add(roomManage.getTenLoai());
			item.add(String.valueOf(roomManage.getCheckIn()));
			item.add(String.valueOf(roomManage.getCheckOut()));
			item.add(String.valueOf(roomManage.getDonGia()));
			item.add(roomManage.getTrangThai());
			model.addRow(item.toArray());
		}
		tblRoom.setModel(model);
	}
	
	private void getTableData(){
		tblRoom.clearSelection();
		tblRoom.getSelectionModel().clearSelection();
		tblRoom.removeAll();
		tblRoom.setModel(model);
	}
}
