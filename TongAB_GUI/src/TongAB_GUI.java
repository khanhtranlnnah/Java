import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 

public class TongAB_GUI {
	
    public static void main(String[] args) {    

        JFrame frame = new JFrame("Tính tổng A và B");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); 
        
        frame.add(panel);
        placeComponents(panel);
  
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel Label = new JLabel("TÍNH TỔNG A VÀ B");
        Label.setBounds(140,10,110,25);
        panel.add(Label);
        
        JLabel LabelA = new JLabel("A =");
        LabelA.setBounds(70,50,20,25);
        panel.add(LabelA);

        JTextField txtA  = new JTextField(20);
        txtA .setBounds(140,50,200,25);
        panel.add(txtA );
        
        JLabel LabelB = new JLabel("B =");
        LabelB.setBounds(70,80,20,25);
        panel.add(LabelB);

        JTextField txtB  = new JTextField(20);
        txtB .setBounds(140,80,200,25);
        panel.add(txtB );


        JButton btnCong = new JButton("A + B =");
        btnCong.setBounds(40,110,80,25);
        panel.add(btnCong);
        
        JTextField txtKQ  = new JTextField(20);
        txtKQ .setBounds(140,110,200,25);
        panel.add(txtKQ );
        
		//xử lý sự kiện nút tính tổng
		ActionListener bolangnghe = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String strA = txtA.getText();
				String strB = txtB.getText();
				int a = Integer.parseInt(strA);
				int b = Integer.parseInt(strB);
				int c = a + b;
				txtKQ.setText(String.valueOf(c));
			}
		};
		btnCong.addActionListener(bolangnghe);
		WindowAdapter a = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		
    }
}