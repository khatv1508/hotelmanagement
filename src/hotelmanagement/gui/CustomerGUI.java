package hotelmanagement.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import hotelmanagement.model.Customer;
import hotelmanagement.model.ResultMessage;
import hotelmanagement.service.ContractService;
import java.awt.Color;

@SuppressWarnings("serial")
public class CustomerGUI extends JFrame {
	
	private ContractService contractService = new ContractService();
	private ResultMessage resultMessage = new ResultMessage();
	private Customer customer = new Customer();

	private JPanel contentPane;
	
	private JPanel panel;
	
	private JLabel lblTen;
	private JLabel lblGiiTnh;
	private JLabel lblinThoi;
	private JLabel lblCmnd;
	private JLabel lblQucTch;
	
	private JTextField txtTen;
	private JTextField txtDienThoai;
	private JTextField txtCMND;
	private JTextField txtQuocTich;
	
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnExit;
	
	private JTable table;
	private ButtonGroup bg;
	private JScrollPane scrollPane;
	
	private ArrayList<Customer> list;
	DefaultTableModel model;
	int selectedRow = 0;
	JRadioButton nam, nu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGUI frame = new CustomerGUI();
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
	public CustomerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel.setBounds(10, 11, 515, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTen = new JLabel("Họ tên");
		lblTen.setBounds(10, 27, 73, 14);
		lblTen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblTen);
		
		txtTen = new JTextField();
		txtTen.setBounds(93, 24, 155, 20);
		txtTen.setColumns(10);
		panel.add(txtTen);
		
		lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setBounds(10, 55, 73, 14);
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblGiiTnh);
		
		lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(10, 83, 73, 14);
		lblinThoi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblinThoi);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setBounds(93, 80, 155, 20);
		txtDienThoai.setColumns(10);
		panel.add(txtDienThoai);
		
		lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(10, 111, 73, 14);
		lblCmnd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblCmnd);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(93, 108, 155, 20);
		txtCMND.setColumns(10);
		panel.add(txtCMND);
		
		lblQucTch = new JLabel("Quốc tịch");
		lblQucTch.setBounds(10, 139, 73, 14);
		lblQucTch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblQucTch);
		
		txtQuocTich = new JTextField();
		txtQuocTich.setBounds(93, 136, 155, 20);
		txtQuocTich.setColumns(10);
		panel.add(txtQuocTich);
		
		nam = new JRadioButton("Nam");
		nam.setBounds(93, 51, 60, 23);
		nam.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(nam);
		
		nu = new JRadioButton("Nữ");
		nu.setBounds(188, 51, 60, 23);
		nu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(nu);
		
		bg = new ButtonGroup();
		bg.add(nam);
		bg.add(nu);
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(416, 30, 89, 23);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customer.setHoTen(txtTen.getText());
				String gioitinh;
			    if (nam.isSelected()) gioitinh=nam.getText() ;
				else gioitinh=nu.getText();
			    customer.setGioiTinh(gioitinh);
			    customer.setSdt(txtDienThoai.getText());
			    customer.setCmnd(txtCMND.getText());
			    customer.setQuocTich(txtQuocTich.getText());
				if(contractService.addCustomer(customer))
			        	list.add(customer);
			    showResult();
				AbstractMainGUI.showDialog(resultMessage);
			    if(resultMessage.getMsgCode() == ResultMessage.MSG_CUSTOMER) {
			    	AbstractMainGUI.showDialog(resultMessage);
				}	
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.WHITE);
		btnSua.setBounds(416, 62, 89, 23);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customer.setHoTen(txtTen.getText());
				String gioitinh;
			    if (nam.isSelected()) gioitinh=nam.getText() ;
				else gioitinh=nu.getText();
			    customer.setGioiTinh(gioitinh);
			    customer.setSdt(txtDienThoai.getText());
			    customer.setCmnd(txtCMND.getText());
			    customer.setQuocTich(txtQuocTich.getText());
				 if (new ContractService().updateCustomer(customer))
			        {
						--i;
						showdeleteResult();
						list.add(customer);
						showResult();
					}
				 if(resultMessage.getMsgCode() == ResultMessage.MSG_UPDATE_CUSTOMER) {
						AbstractMainGUI.showDialog(resultMessage);
					}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(416, 96, 89, 23);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customer.setHoTen(txtTen.getText());
				String gioitinh;
			    if (nam.isSelected()) gioitinh=nam.getText() ;
				else gioitinh=nu.getText();
			    customer.setGioiTinh(gioitinh);
			    customer.setSdt(txtDienThoai.getText());
			    customer.setCmnd(txtCMND.getText());
			    customer.setQuocTich(txtQuocTich.getText());
				if (new ContractService().deleteCustomer(customer)) 
					{
						i--;
						showdeleteResult();
					}	
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnXoa);
		
		btnExit = new JButton("Thoát");
		btnExit.setBackground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnExit.setBounds(416, 130, 89, 23);
		panel.add(btnExit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 199, 515, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				chonhang();
			}
		});
		
		list = new ContractService().getListCustomer();
        model = (DefaultTableModel) table.getModel();
      
        model.setColumnIdentifiers(new Object[]{
            "Họ tên", "Giới tính", "Điện thoại", "CMND", "Quốc tịch"     
        });
        showTable();
	}
	
	public void chonhang()
	{
		selectedRow = table.getSelectedRow();
		txtTen.setText((String)table.getValueAt(selectedRow, 0));
		if(String.valueOf(table.getValueAt(selectedRow, 1)).equals("Nam")) {
			nam.setSelected(true);
		} else {
			nu.setSelected(true);
		}
		txtDienThoai.setText((String)table.getValueAt(selectedRow, 2));
		txtCMND.setText((String)(table.getValueAt(selectedRow, 3)));
		txtQuocTich.setText((String)(table.getValueAt(selectedRow, 4)));
		
	}
	public void showTable() {
		
        for (Customer customer : list) {
            model.addRow(new Object[]{
        		customer.getHoTen(), customer.getGioiTinh(), customer.getSdt(), customer.getCmnd(), customer.getQuocTich()
            });
        }
    }
	int i = 1;
	public void showResult() {
		Customer customer = list.get(list.size() - 1);
        model.addRow(new Object[]{
    		customer.getHoTen(), customer.getGioiTinh(), customer.getSdt(), customer.getCmnd(), customer.getQuocTich()
        });
        model.setRowCount(0);
        i = 1;
        list = new ContractService().getListCustomer();
        showTable();
        
    }
	public void showdeleteResult() {
		selectedRow = table.getSelectedRow();
	    model.removeRow(selectedRow);
	    model.setRowCount(0);
	    i=1;
	    list = new ContractService().getListCustomer();
	    showTable();
	}
}
