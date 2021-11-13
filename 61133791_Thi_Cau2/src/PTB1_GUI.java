import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PTB1_GUI {

	private JFrame frame;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PTB1_GUI window = new PTB1_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PTB1_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PHƯƠNG TRÌNH BẬC NHẤT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 416, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblA = new JLabel("Nhập a:");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblA.setBounds(40, 59, 83, 25);
		frame.getContentPane().add(lblA);
		
		txtA = new JTextField();
		txtA.setBounds(102, 59, 255, 25);
		frame.getContentPane().add(txtA);
		txtA.setColumns(10);
		
		JLabel lblB = new JLabel("Nhập b:");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblB.setBounds(40, 94, 83, 25);
		frame.getContentPane().add(lblB);
		
		txtB = new JTextField();
		txtB.setColumns(10);
		txtB.setBounds(102, 94, 255, 25);
		frame.getContentPane().add(txtB);
		
		JButton btnTinh = new JButton("TÍNH");
		btnTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strA = txtA.getText();
				String strB = txtB.getText();
				double a, b, ketqua;
				
				try {
					a = Double.parseDouble(strA);
				} catch (Exception e1) {
					a = 0;
					txtA.setText(String.valueOf(a));
				}
				
				try {
					b = Double.parseDouble(strB);
				} catch (Exception e1) {
					b = 0;
					txtB.setText(String.valueOf(b));
				}
				
				if(a == 0)
					 txtKetQua.setText("Phương trình vô nghiệm");
				 else if(b == 0)
					 txtKetQua.setText("Phương trình vô số nghiệm");
				 else {
					 ketqua = -b/a;
					 txtKetQua.setText(String.valueOf(ketqua));
				 }
			}
		});
		btnTinh.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTinh.setBounds(174, 129, 101, 31);
		frame.getContentPane().add(btnTinh);
		
		txtKetQua = new JTextField();
		txtKetQua.setColumns(10);
		txtKetQua.setBounds(102, 176, 255, 25);
		frame.getContentPane().add(txtKetQua);
		
		JLabel lblKetQua = new JLabel("Kết quả");
		lblKetQua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKetQua.setBounds(40, 176, 83, 25);
		frame.getContentPane().add(lblKetQua);
	}

}
