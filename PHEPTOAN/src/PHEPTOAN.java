import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 

public class PHEPTOAN {
	
    public static void main(String[] args) {    

        JFrame frame = new JFrame("CÁC PHÉP TOÁN");

        frame.setSize(400, 300);

        JPanel panel = new JPanel(); 
        
        frame.add(panel);
        placeComponents(panel);
  
        frame.setVisible(true);
    }

    public static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel Label = new JLabel("CÁC PHÉP TOÁN SỐ HỌC");
        Label.setBounds(120,10,200,25);
        panel.add(Label);
        
        JLabel LabelA = new JLabel("A =");
        LabelA.setBounds(70,50,20,25);
        panel.add(LabelA);

        JTextField txtA  = new JTextField(20);
        txtA .setBounds(140,50,200,25);
        panel.add(txtA );
        
        JLabel LabelB = new JLabel("B =");
        LabelB.setBounds(70,100,20,25);
        panel.add(LabelB);

        JTextField txtB  = new JTextField(20);
        txtB .setBounds(140,100,200,25);
        panel.add(txtB );


        JButton btnCong = new JButton("+");
        btnCong.setBounds(75,150,50,25);
        panel.add(btnCong);
        
        JButton btnTru = new JButton("-");
        btnTru.setBounds(145,150,50,25);
        panel.add(btnTru);
        
        JButton btnNhan = new JButton("*");
        btnNhan.setBounds(215,150,50,25);
        panel.add(btnNhan);
        
        JButton btnChia = new JButton("/");
        btnChia.setBounds(285,150,50,25);
        panel.add(btnChia);
       
        JLabel LabelKQ = new JLabel("KẾT QUẢ");
        LabelKQ.setBounds(50,200,100,25);
        panel.add(LabelKQ);

        JTextField txtKQ = new JTextField(20);
        txtKQ .setBounds(140,200,200,25);
        panel.add(txtKQ);
        
      //xử lý sự kiện nút tính
		ActionListener bolangnghe = new ActionListener() {
			public void cong() {
				double A = Double.parseDouble(txtA.getText());
				double B = Double.parseDouble(txtB.getText());
		        double KQ = A + B;
		        txtKQ.setText(String.valueOf(KQ));
		    }

		    public void tru() {
		    	double A = Double.parseDouble(txtA.getText());
			    double B = Double.parseDouble(txtB.getText());
		        double KQ = A - B;
		        txtKQ.setText(String.valueOf(KQ));
		    }

		    public void nhan() {
			    double A = Double.parseDouble(txtA.getText());
			    double B = Double.parseDouble(txtB.getText());
		        double KQ = A * B;
		        txtKQ.setText(String.valueOf(KQ));
		    }

		    public void chia() {
		    	double A = Double.parseDouble(txtA.getText());
			    double B = Double.parseDouble(txtB.getText());
			    double KQ = A / B;
		        txtKQ.setText(String.valueOf(KQ));
		    }

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (e.getActionCommand() == "+") {
		            cong();
		        } else if (e.getActionCommand() == "-") {
		            tru();
		        } else if (e.getActionCommand() == "*") {
		            nhan();
		        } else if (e.getActionCommand() == "/") {
		            chia();
		        }
		    }
		};
		btnCong.addActionListener(bolangnghe);
		btnTru.addActionListener(bolangnghe);
		btnNhan.addActionListener(bolangnghe);
		btnChia.addActionListener(bolangnghe);
		WindowAdapter a = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		
    }
}