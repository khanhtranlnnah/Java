package SanPham;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMaSP;
	private JTextField textFieldTenSP;
	private JTextField textFieldGia;
	JTextArea textAreaDSSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Sản Phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMaSP = new JLabel("Mã Sản Phẩm");
		lblMaSP.setFont(new Font("Arial", Font.BOLD, 12));
		lblMaSP.setBounds(30, 27, 97, 14);
		contentPane.add(lblMaSP);
		
		JLabel lblTenSP = new JLabel("Tên Sản Phẩm");
		lblTenSP.setFont(new Font("Arial", Font.BOLD, 12));
		lblTenSP.setBounds(30, 66, 97, 14);
		contentPane.add(lblTenSP);
		
		JLabel lblGiaSP = new JLabel("Giá ");
		lblGiaSP.setFont(new Font("Arial", Font.BOLD, 12));
		lblGiaSP.setBounds(30, 106, 92, 14);
		contentPane.add(lblGiaSP);
		
		textFieldMaSP = new JTextField();
		textFieldMaSP.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldMaSP.setBounds(138, 23, 253, 20);
		contentPane.add(textFieldMaSP);
		textFieldMaSP.setColumns(10);
		
		textFieldTenSP = new JTextField();
		textFieldTenSP.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldTenSP.setBounds(138, 62, 253, 20);
		contentPane.add(textFieldTenSP);
		textFieldTenSP.setColumns(10);
		
		textFieldGia = new JTextField();
		textFieldGia.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldGia.setBounds(138, 102, 253, 20);
		contentPane.add(textFieldGia);
		textFieldGia.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Arial", Font.BOLD, 12));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSanPham();
				hienThiSanPham();
			}

			
		});
		btnThem.setBounds(30, 144, 88, 23);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteSanPham();
			}
		});
		btnXoa.setFont(new Font("Arial", Font.BOLD, 12));
		btnXoa.setBounds(117, 144, 92, 23);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editSanPham();
			}
		});
		btnSua.setFont(new Font("Arial", Font.BOLD, 12));
		btnSua.setBounds(208, 144, 92, 23);
		contentPane.add(btnSua);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuLyTimKiem();
			}
		});
		btnTimKiem.setFont(new Font("Arial", Font.BOLD, 12));
		btnTimKiem.setBounds(299, 144, 92, 23);
		contentPane.add(btnTimKiem);
		
		textAreaDSSP = new JTextArea();
		textAreaDSSP.setBounds(21, 225, 372, 144);
		contentPane.add(textAreaDSSP);
		
		JLabel lblDS = new JLabel("DANH SÁCH SẢN PHẨM");
		lblDS.setHorizontalAlignment(SwingConstants.CENTER);
		lblDS.setFont(new Font("Arial", Font.BOLD, 13));
		lblDS.setBounds(30, 193, 361, 20);
		contentPane.add(lblDS);
	}
		XuLySP xlsp = new XuLySP();
		
		private void addSanPham() {
			StringBuilder sb = new StringBuilder();
			if (textFieldMaSP.getText().equals("")) {
				sb.append("Chưa nhập mã");
			}
			try {
				SanPham sp = getModel();
				if (xlsp.themSanPham(sp) > 0) {
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
					resetform();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		private SanPham getModel() {
			SanPham sp = new SanPham();
			sp.setMaSP(textFieldMaSP.getText());
			sp.setTenSP(textFieldTenSP.getText());
			sp.setGiaSP(Double.parseDouble(textFieldGia.getText()));
			return sp;
		}
		
		private void hienThiSanPham() {
			textAreaDSSP.setText("");
			for (SanPham DSSP : xlsp.listSanPham) {
				String MaSP = DSSP.getMaSP();
				String TenSP = DSSP.getTenSP();
				double GiaSP = DSSP.getGiaSP();
				textAreaDSSP.append(MaSP + "----" + TenSP + "----" + GiaSP + "\n");
			}
		}
		
		private void XuLyTimKiem() {
			// TODO Auto-generated method stub
			SanPham spTimKiem = xlsp.findSanPhamByMaSP(textFieldMaSP.getText());
			if(spTimKiem != null) {
				setModel(spTimKiem);
			}
			else {
				JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại");
			}
		}
		
		private SanPham setModel(SanPham sp) {
			textFieldMaSP.setText(sp.getMaSP());
			textFieldTenSP.setText(sp.getTenSP());
			textFieldTenSP.setText(Double.toString(sp.getGiaSP()));
			return sp;
		}
		
		public void resetform() {
			textFieldMaSP.setText("");
			textFieldTenSP.setText("");
			textFieldGia.setText("");
		}
		
		private void editSanPham() {
			// TODO Auto-generated method stub
			SanPham speditSP = xlsp.findSanPhamByMaSP(textFieldMaSP.getText());
			if (speditSP != null) {
				try {
					speditSP = getModel();
					xlsp.editSanPham(speditSP);
					JOptionPane.showMessageDialog(this, "Sửa thành công!");
					resetform();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		private void deleteSanPham() {
			// TODO Auto-generated method stub
			if(xlsp.deleteSanPham(textFieldMaSP.getText())> 0) {
				JOptionPane.showMessageDialog(this, "Xóa thành công");
				resetform();
			}
		}
}





















