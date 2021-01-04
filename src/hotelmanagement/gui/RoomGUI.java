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
import hotelmanagement.model.Room;
import hotelmanagement.service.ContractService;

@SuppressWarnings("serial")
public class RoomGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	
	private JLabel lblMaPhong;
	private JLabel lblTang;
	private JLabel lblIdLoai;
	private JLabel lblSoGiuong;
	private JLabel lblGiaPhong;
	
	private JTextField txtMaPhong;
	private JTextField txtTang;
	private JTextField txtIdLoai;
	private JTextField txtSoGiuong;
	private JTextField txtGiaPhong;
	
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnClear;
	private JButton btnThoat;
	
	private JScrollPane scrollPane;
	private JTable table;
	
	private ContractService contractService = new ContractService();
	private ResultMessage resultMessage = new ResultMessage();
	private Room room = new Room();
	private ArrayList<Room> list;
	int selectedRow = 0;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomGUI frame = new RoomGUI();
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
	public RoomGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBorder(new TitledBorder(null, "Thông tin phòng", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel.setBounds(10, 11, 540, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setBounds(28, 26, 60, 20);
		lblMaPhong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(98, 26, 160, 20);
		panel.add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		lblTang = new JLabel("Tầng");
		lblTang.setBounds(28, 59, 60, 20);
		lblTang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblTang);
		
		txtTang = new JTextField();
		txtTang.setBounds(98, 59, 160, 20);
		panel.add(txtTang);
		txtTang.setColumns(10);
		
		lblIdLoai = new JLabel("ID Loại");
		lblIdLoai.setBounds(28, 87, 60, 20);
		lblIdLoai.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblIdLoai);
		
		txtIdLoai = new JTextField();
		txtIdLoai.setBounds(98, 87, 160, 20);
		txtIdLoai.setColumns(10);
		panel.add(txtIdLoai);
		
		lblSoGiuong = new JLabel("Số giường");
		lblSoGiuong.setBounds(28, 118, 60, 20);
		lblSoGiuong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblSoGiuong);
		
		txtSoGiuong = new JTextField();
		txtSoGiuong.setBounds(98, 118, 160, 20);
		txtSoGiuong.setColumns(10);
		panel.add(txtSoGiuong);
		
		lblGiaPhong = new JLabel("Giá phòng");
		lblGiaPhong.setBounds(28, 149, 60, 20);
		lblGiaPhong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(lblGiaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setBounds(98, 149, 160, 20);
		txtGiaPhong.setColumns(10);
		panel.add(txtGiaPhong);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(411, 25, 89, 23);
		btnThem.setBackground(Color.WHITE);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Room r = new Room();
				r.setMaPhong(txtMaPhong.getText());
				r.setTang(Integer.parseInt(txtTang.getText()));
				r.setTenLoai(txtIdLoai.getText());
				r.setGiuong(Integer.parseInt(txtSoGiuong.getText()));
				r.setGiaPhong(Long.parseLong(txtGiaPhong.getText()));
				if(new ContractService().addRoom(r))
		        	list.add(r);
			    showResult();
			    AbstractMainGUI.showDialog(resultMessage);
			    if(resultMessage.getMsgCode() == ResultMessage.MSG_ROOM) {
			    	AbstractMainGUI.showDialog(resultMessage);
				}	
				
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(411, 58, 89, 23);
		btnSua.setBackground(Color.WHITE);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				room.setMaPhong(txtMaPhong.getText());
				room.setTang(Integer.parseInt(txtTang.getText()));
				room.setTenLoai(txtIdLoai.getText());
				room.setGiuong(Integer.parseInt(txtSoGiuong.getText()));
				room.setGiaPhong(Long.parseLong(txtGiaPhong.getText()));
				 if (new ContractService().updateRoom(room))
			        {
						--i;
						showdeleteResult();
						list.add(room);
						showResult();
					}
				 AbstractMainGUI.showDialog(resultMessage);
				if(resultMessage.getMsgCode() == ResultMessage.MSG_UPDATE_ROOM) {
					AbstractMainGUI.showDialog(resultMessage);
}	
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(411, 92, 89, 23);
		btnXoa.setBackground(Color.WHITE);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				room.setMaPhong(txtMaPhong.getText());
				room.setTang(Integer.parseInt(txtTang.getText()));
				room.setTenLoai(txtIdLoai.getText());
				room.setGiuong(Integer.parseInt(txtSoGiuong.getText()));
				room.setGiaPhong(Long.parseLong(txtGiaPhong.getText()));
				if (new ContractService().deleteRoom(room)) 
				{
					i--;
					showdeleteResult();
				}	
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnXoa);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(411, 126, 89, 23);
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMaPhong.setText("");
				txtTang.setText("");
				txtIdLoai.setText("");
				txtSoGiuong.setText("");
				txtGiaPhong.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		panel.add(btnClear);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(411, 158, 89, 23);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnThoat.setBackground(Color.WHITE);
		panel.add(btnThoat);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 214, 540, 105);
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
	}

	public void chonhang()
	{
		selectedRow = table.getSelectedRow();
		
		
		
	}
	public void showTable() {
		
        for (Room room : list) {
            model.addRow(new Object[]{
            		room.getMaPhong(), room.getTang(), room.getTenLoai(), room.getGiuong(), room.getGiaPhong()
            });
        }
    }
	int i = 1;
	
	public void showResult() {
		Room room = list.get(list.size() - 1);
        model.addRow(new Object[]{
        		room.getMaPhong(), room.getTang(), room.getTenLoai(), room.getGiuong(), room.getGiaPhong()
        });
        model.setRowCount(0);
        i = 1;
        list = contractService.getListRoom();
        showTable();
        
    }
	public void showdeleteResult() {
		selectedRow = table.getSelectedRow();
	    model.removeRow(selectedRow);
	    model.setRowCount(0);
	    i=1;
	    list = contractService.getListRoom();
	    showTable();
	}
}
