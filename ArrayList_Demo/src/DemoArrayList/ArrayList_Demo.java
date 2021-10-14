package DemoArrayList;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ArrayList_Demo {

	//khai báo danh sách
	ArrayList<String> dsTen ;
	

	private JFrame frmArraylist;
	private JTextField textFieldHoTen;
	private JLabel lblHoTen;
	private JButton btnAdd;
	private JButton btnShowDS;
	private JTextArea textAreaDanhSach;
	private JLabel lblTrangThai;
	private JLabel lblDanhSachTimKiem;
	private JTextArea textAreaDanhSachTimKiem;
	private JLabel lblTimKiem;
	private JTextField textFieldTimKiem;
	private JButton btnTimKiem;

	protected Component frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList_Demo window = new ArrayList_Demo();
					window.frmArraylist.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArrayList_Demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmArraylist = new JFrame();
		frmArraylist.setTitle("Demo ArrayList");
		frmArraylist.setBounds(100, 100, 585, 400);
		frmArraylist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArraylist.getContentPane().setLayout(null);
		
		lblHoTen = new JLabel("Họ và tên:");
		lblHoTen.setFont(new Font("Arial", Font.BOLD, 14));
		lblHoTen.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoTen.setBounds(30, 24, 72, 27);
		frmArraylist.getContentPane().add(lblHoTen);
		
		textFieldHoTen = new JTextField();
		
		textFieldHoTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblTrangThai.setText("Tôi đang đợi bạn...");
			}
		});
		textFieldHoTen.setBounds(168, 24, 248, 27);
		frmArraylist.getContentPane().add(textFieldHoTen);
		textFieldHoTen.setColumns(10);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setFont(new Font("Arial", Font.BOLD, 12));
		
		dsTen = new ArrayList<String>();
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sử dụng arraylist là biến toàn cục
				themVaoDanhSach(dsTen);  //khai bao pt void themVaoDanhSach(ArrayList<String>)
				hienDanhSach(dsTen, textAreaDanhSachTimKiem);
			}
		});
		btnAdd.setBounds(422, 25, 118, 27);
		frmArraylist.getContentPane().add(btnAdd);
		
		btnShowDS = new JButton("Hiện danh sách");
		btnShowDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienDanhSach(dsTen, textAreaDanhSach); //khai bao pt void hienDanhSach(ArrayList<String>)
			}
		});
		btnShowDS.setFont(new Font("Arial", Font.BOLD, 12));
		btnShowDS.setBounds(308, 130, 125, 27);
		frmArraylist.getContentPane().add(btnShowDS);
		
		textAreaDanhSach = new JTextArea(5,20);
		textAreaDanhSach.setBounds(305, 166, 240, 170);
		frmArraylist.getContentPane().add(textAreaDanhSach);
		
		lblTrangThai = new JLabel("Hiện trạng thái thêm...");
		lblTrangThai.setFont(new Font("Arial", Font.ITALIC, 12));
		lblTrangThai.setForeground(Color.BLUE);
		lblTrangThai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrangThai.setBounds(254, 52, 161, 20);
		frmArraylist.getContentPane().add(lblTrangThai);
		
		lblDanhSachTimKiem = new JLabel("Tên vừa nhập");
		lblDanhSachTimKiem.setFont(new Font("Arial", Font.BOLD, 12));
		lblDanhSachTimKiem.setBounds(30, 131, 105, 23);
		frmArraylist.getContentPane().add(lblDanhSachTimKiem);
		
		textAreaDanhSachTimKiem = new JTextArea();
		textAreaDanhSachTimKiem.setBounds(32, 166, 240, 169);
		frmArraylist.getContentPane().add(textAreaDanhSachTimKiem);
		
		lblTimKiem = new JLabel("Họ và tên tìm kiếm:");
		lblTimKiem.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimKiem.setFont(new Font("Arial", Font.BOLD, 14));
		lblTimKiem.setBounds(30, 83, 161, 27);
		frmArraylist.getContentPane().add(lblTimKiem);
		
		textFieldTimKiem = new JTextField();
		textFieldTimKiem.setColumns(10);
		textFieldTimKiem.setBounds(168, 82, 248, 27);
		frmArraylist.getContentPane().add(textFieldTimKiem);
		
		btnTimKiem = new JButton("Tìm");

		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = false;
					for(int index = 0; index < dsTen.size(); index++) {
						String sTen = dsTen.get(index);
						if (sTen.equals(textFieldTimKiem.getText())){
							result = true;
							break;
						}
						else {
							result = false;
						}
					}
					if(result == true) {
						JOptionPane.showMessageDialog(frmArraylist, "Tên vừa nhập đã tồn tại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					} 
					else {
						JOptionPane.showMessageDialog(frmArraylist, "Tên vừa nhập chưa có trong danh sách", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				textFieldTimKiem.setText("");
			}
		});
		btnTimKiem.setFont(new Font("Arial", Font.BOLD, 12));
		btnTimKiem.setBounds(422, 82, 118, 28);
		frmArraylist.getContentPane().add(btnTimKiem);
	}

	public void themVaoDanhSach(ArrayList<String> ds) {
		//lấy dữ liệu từ điều khiển 
		String hoten = textFieldHoTen.getText();
		//thêm vào ds a
		ds.add(hoten);
		//xóa nội dung trên điều khiển
		textFieldHoTen.setText("");
		//cập nhập trạng thái
		lblTrangThai.setText("Đã thêm vào danh sách");	
	}
	
	public void hienDanhSach(ArrayList<String> ds, JTextArea textAreaDanhSach) {			
		textAreaDanhSach.setText("");
		//sử dụng duyệt theo chỉ số
		for(int index = 0; index < ds.size(); index++) {
			//lấy giá trị ở vị trí index, cất vào biến sTen
			String sTen = ds.get(index);
			//nạp vào điều khiển hiển thị
			textAreaDanhSach.append(sTen + "\n");
		}
	}
}