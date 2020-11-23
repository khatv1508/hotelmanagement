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
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import hotelmanagement.model.RoomManage;
import hotelmanagement.service.ContractService;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	private JPanel contentPane;
	private ContractService contractService = new ContractService();

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
		
		JPanel panel_Top = new JPanel();
		panel_Top.setBackground(new Color(255, 182, 193));
		panel_Top.setBounds(10, 11, 1088, 72);
		panel.add(panel_Top);
		panel_Top.setLayout(null);
		
		JLabel lblTitle = new JLabel("Hotel Management");
		lblTitle.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\hotel-icon (1).png"));
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTitle.setBounds(10, 0, 288, 72);
		panel_Top.add(lblTitle);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnKhachHang.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\customer.png"));
		btnKhachHang.setBounds(10, 94, 173, 41);
		panel.add(btnKhachHang);
		
		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNhanVien.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\staff.png"));
		btnNhanVien.setBounds(193, 94, 173, 41);
		panel.add(btnNhanVien);
		
		JButton btnQuanLy = new JButton(" Đặt phòng");
		btnQuanLy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAddRoom addRoom = new FormAddRoom();
				addRoom.setVisible(true);
			}
		});
		btnQuanLy.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnQuanLy.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\door-icon.png"));
		btnQuanLy.setBounds(376, 94, 173, 41);
		panel.add(btnQuanLy);
		
		JButton btnDichVu = new JButton("Dịch vụ");
		btnDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDichVu.setIcon(new ImageIcon("C:\\Users\\nhant\\Downloads\\service.png"));
		btnDichVu.setBounds(559, 94, 173, 41);
		panel.add(btnDichVu);
		
		JButton btnThanhToan = new JButton("Thanh toán");
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
		
		JPanel panel_Center = new JPanel();
		panel_Center.setBounds(10, 146, 1088, 532);
		panel.add(panel_Center);
		panel_Center.setLayout(null);
		
		JTree treeRoom = new JTree();
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
		treeRoom.setBounds(10, 11, 163, 510);
		panel_Center.add(treeRoom);
		
		
		List<RoomManage> lstResults = new ArrayList<>();
		try {
			lstResults = contractService.lstRoom(0);
			String[] tblHead = {"asd","2asd","3asd","4asd", "5asd", "6asd"};
			DefaultTableModel model = new DefaultTableModel(tblHead,1);
			JTable tblRoom = new JTable(model);
			tblRoom.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			tblRoom.setBounds(183, 11, 895, 510);
			for (RoomManage roomManage : lstResults) {
				ArrayList<String> item = new ArrayList<String>();
				item.add(String.valueOf(roomManage.getIdQLDPhong()));
				item.add(String.valueOf(roomManage.getTang()));
				item.add(roomManage.getMaPhong());
				item.add(roomManage.getHoTen());
				item.add(roomManage.getTenLoai());
				item.add(String.valueOf(roomManage.getDonGia()));
				model.addRow(item.toArray());
			}
			tblRoom.setModel(model);
			panel_Center.add(tblRoom);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}
