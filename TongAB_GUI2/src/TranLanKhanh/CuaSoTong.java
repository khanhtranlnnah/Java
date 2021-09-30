package TranLanKhanh;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Label;

public class CuaSoTong extends Frame{
	//hàm tạo
	public CuaSoTong(){
		//quy định layout
		FlowLayout fl = new FlowLayout();
		setLayout(fl);
		//kích thước
		setBounds(0,0,400,200);
		//đưa các điều khiển vào Frame
		lblA = new Label("A = ");
		lblB = new Label("B = ");
		lblKQ = new Label("KQ = ");
		
		txtA = new TextField();
		txtB = new TextField();
		txtKQ = new TextField();
		
		btnCong = new Button("Tính tổng");
		
		add(lblA); 
		add(txtA);
		add(lblB); 
		add(txtB);
		add(btnCong);
		//bộ lắng nghe và xử lý sự kiện cho nút nhấn tính tổng
		btnCong.addActionListener(new bolangnghe_xuly_cong());
		add(lblKQ); 
		add(txtKQ);
		setTitle("Tính Tổng A và B");
		setVisible(true);
		//thêm bộ lắng nghe xử lý sự kiện cho frame
		addWindowListener(new bolangnghe_xuly_cuaso());
	}
	
	class bolangnghe_xuly_cong implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String strA = txtA.getText();
			String strB = txtB.getText();
			int a = Integer.parseInt(strA);
			int b = Integer.parseInt(strB);
			int c = a + b;
			txtKQ.setText(String.valueOf(c));
		}
		
	}
	
	class bolangnghe_xuly_cuaso implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	//thuộc tính
	TextField txtA, txtB, txtKQ;
	Label lblA, lblB, lblKQ;
	Button btnCong;
}
