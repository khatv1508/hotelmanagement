package hotelmanagement.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import hotelmanagement.model.ResultMessage;
import hotelmanagement.model.Staff;
import hotelmanagement.service.ContractService;

@SuppressWarnings("serial")
public class StaffGUI extends JFrame {
	
	@SuppressWarnings("unused")
	private ContractService contractService = new ContractService();
	private ResultMessage resultMessage = new ResultMessage();
	@SuppressWarnings("unused")
	private Staff staff = new Staff();

	private JPanel contentPane;
	private JPanel panel;
	
	private JLabel lblHoTen;
	private JLabel lblinThoi;
	private JLabel lblTiKhon;
	private JLabel lblMtKhu;
	private JLabel lblLoiNhnVin;
	
	private JTextField txtTen;
	private JTextField txtDienThoai;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;
	private JTextField txtLoaiNhanVien;
	
	private JTable table;
	private JScrollPane scrollPane;
	
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnClear;
	
	private ArrayList<Staff> list;
	DefaultTableModel model;
	int selectedRow = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffGUI frame = new StaffGUI();
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
	public StaffGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBorder(new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel.setBounds(10, 11, 569, 202);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblHoTen = new JLabel("Họ tên");
		lblHoTen.setBounds(31, 30, 85, 20);
		lblHoTen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblHoTen);
		
		txtTen = new JTextField();
		txtTen.setBounds(126, 30, 160, 20);
		panel.add(txtTen);
		txtTen.setColumns(10);
		
		lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(31, 61, 85, 20);
		lblinThoi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblinThoi);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setBounds(126, 61, 160, 20);
		txtDienThoai.setColumns(10);
		panel.add(txtDienThoai);
		
		lblTiKhon = new JLabel("Tài khoản");
		lblTiKhon.setBounds(31, 92, 85, 20);
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblTiKhon);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(126, 92, 160, 20);
		txtTaiKhoan.setColumns(10);
		panel.add(txtTaiKhoan);
		
		lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(31, 123, 85, 20);
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblMtKhu);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setBounds(126, 123, 160, 20);
		txtMatKhau.setColumns(10);
		panel.add(txtMatKhau);
		
		lblLoiNhnVin = new JLabel("Loại nhân viên");
		lblLoiNhnVin.setBounds(31, 154, 85, 20);
		lblLoiNhnVin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblLoiNhnVin);
		
		txtLoaiNhanVien = new JTextField();
		txtLoaiNhanVien.setBounds(126, 154, 160, 20);
		txtLoaiNhanVien.setColumns(10);
		panel.add(txtLoaiNhanVien);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(447, 30, 89, 23);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Staff s = new Staff();
				s.setHoTen(txtTen.getText());
				s.setSdThoai(txtDienThoai.getText());
				s.setTaiKhoan(txtTaiKhoan.getText());
				s.setMatKhau(txtMatKhau.getText());
				s.setChucVu(Integer.parseInt(txtLoaiNhanVien.getText()));
				if(new ContractService().addStaff(s))
		        	list.add(s);
			    showResult();
			    AbstractMainGUI.showDialog(resultMessage);
			    if(resultMessage.getMsgCode() == ResultMessage.MSG_STAFF) {
			    	AbstractMainGUI.showDialog(resultMessage);
				}	
			}
		});
		btnThem.setBackground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(447, 61, 89, 23);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff s = new Staff();
				s.setHoTen(txtTen.getText());
				s.setSdThoai(txtDienThoai.getText());
				s.setTaiKhoan(txtTaiKhoan.getText());
				s.setMatKhau(txtMatKhau.getText());
				s.setChucVu(Integer.parseInt(txtLoaiNhanVien.getText()));
				if (new ContractService().updateStaff(s))
		        {
					--i;
					showdeleteResult();
					list.add(s);
					showResult();
				}
				AbstractMainGUI.showDialog(resultMessage);
			    if(resultMessage.getMsgCode() == ResultMessage.MSG_UPDATE_STAFF) {
			    	AbstractMainGUI.showDialog(resultMessage);
				}	
			}
		});
		btnSua.setBackground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(447, 95, 89, 23);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff s = new Staff();
				s.setHoTen(txtTen.getText());
				s.setSdThoai(txtDienThoai.getText());
				s.setTaiKhoan(txtTaiKhoan.getText());
				s.setMatKhau(txtMatKhau.getText());
				s.setChucVu(Integer.parseInt(txtLoaiNhanVien.getText()));
				if (new ContractService().deleteStaff(s)) 
				{
					i--;
					showdeleteResult();
				}	
				AbstractMainGUI.showDialog(resultMessage);
			    if(resultMessage.getMsgCode() == ResultMessage.MSG_DELETE_STAFF) {
			    	AbstractMainGUI.showDialog(resultMessage);
				}	
			}
		});
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnXoa);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(447, 129, 89, 23);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTen.setText("");
				txtDienThoai.setText("");
				txtTaiKhoan.setText("");
				txtMatKhau.setText("");
				txtLoaiNhanVien.setText("");
			}
		});
		btnClear.setBackground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnClear);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.setBounds(447, 163, 89, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnExit.setBackground(Color.WHITE);
		panel.add(btnExit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 224, 573, 137);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.addMouseListener(new MouseAdapter() {		
			public void mouseClicked(MouseEvent e) {
				chonhang();
			}
		});
		model = (DefaultTableModel) table.getModel();
		
		list = new ContractService().getListStaff();
      
        model.setColumnIdentifiers(new Object[]{
            "Họ tên", "Điện thoại", "Tài khoản", "Mật khẩu", "Loại nhân viên"     
        });
        showTable();
	}

	public void chonhang() {
		selectedRow = table.getSelectedRow();
		txtTen.setText((String)table.getValueAt(selectedRow, 0));
		txtDienThoai.setText((String)table.getValueAt(selectedRow, 1));
		txtTaiKhoan.setText((String)(table.getValueAt(selectedRow, 2)));
		txtMatKhau.setText((String)(table.getValueAt(selectedRow, 3)));
		txtLoaiNhanVien.setText((String)(table.getValueAt(selectedRow, 4)));
		
	}
	public void showTable() {
		
        for (Staff staff : list) {
            model.addRow(new Object[]{
            		staff.getHoTen(), staff.getSdThoai(), staff.getTaiKhoan(), staff.getMatKhau(), staff.getChucVu()
            });
        }
    }
	int i = 1;
	public void showResult() {
		Staff staff = list.get(list.size() - 1);
        model.addRow(new Object[]{
        		staff.getHoTen(), staff.getSdThoai(), staff.getTaiKhoan(), staff.getMatKhau(), staff.getChucVu()
        });
        model.setRowCount(0);
        i = 1;
        list = new ContractService().getListStaff();
        showTable();
        
    }
	public void showdeleteResult() {
		selectedRow = table.getSelectedRow();
	    model.removeRow(selectedRow);
	    model.setRowCount(0);
	    i=1;
	    list = new ContractService().getListStaff();
	    showTable();
	}
}
