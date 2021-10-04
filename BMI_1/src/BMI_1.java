import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BMI_1 {

	private JFrame frmTnhChS;
	private JTextField textHeight;
	private JTextField textWeight;
	private JTextField textKQ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI_1 window = new BMI_1();
					window.frmTnhChS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BMI_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTnhChS = new JFrame();
		frmTnhChS.setTitle("T\u00CDNH CH\u1EC8 S\u1ED0 BMI");
		frmTnhChS.setBounds(100, 100, 677, 356);
		frmTnhChS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTnhChS.getContentPane().setLayout(null);
		
		JLabel lblThongTin = new JLabel("TÍNH CHỈ SỐ BMI");
		lblThongTin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblThongTin.setToolTipText("Hello World");
		lblThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTin.setForeground(Color.BLACK);
		lblThongTin.setFont(new Font("Arial", Font.BOLD, 20));
		lblThongTin.setBounds(10, 10, 652, 35);
		frmTnhChS.getContentPane().add(lblThongTin);
		
		JLabel lblHeight = new JLabel("Chiều Cao (cm)");
		lblHeight.setFont(new Font("Arial", Font.BOLD, 15));
		lblHeight.setBounds(56, 74, 118, 35);
		frmTnhChS.getContentPane().add(lblHeight);
		
		textHeight = new JTextField();
		textHeight.setFont(new Font("Arial", Font.PLAIN, 15));
		textHeight.setColumns(10);
		textHeight.setBounds(184, 74, 251, 35);
		frmTnhChS.getContentPane().add(textHeight);
		
		JLabel lblWeight = new JLabel("Cân nặng (kg)");
		lblWeight.setFont(new Font("Arial", Font.BOLD, 15));
		lblWeight.setBounds(56, 131, 118, 35);
		frmTnhChS.getContentPane().add(lblWeight);
		
		textWeight = new JTextField();
		textWeight.setFont(new Font("Arial", Font.PLAIN, 15));
		textWeight.setColumns(10);
		textWeight.setBounds(184, 131, 251, 35);
		frmTnhChS.getContentPane().add(textWeight);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Region", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(478, 68, 148, 98);
		frmTnhChS.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton radAsian = new JRadioButton("Asian");
		radAsian.setFont(new Font("Arial", Font.PLAIN, 15));
		radAsian.setBounds(0, 29, 103, 21);
		panel.add(radAsian);
		
		JRadioButton radNonAsian = new JRadioButton("Non - Asian");
		radNonAsian.setFont(new Font("Arial", Font.PLAIN, 15));
		radNonAsian.setBounds(0, 59, 103, 21);
		panel.add(radNonAsian);
		
		JButton btnNewButton = new JButton("Tính BMI");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
            	double Height=Double.parseDouble(textHeight.getText());
                double Weight=Double.parseDouble(textWeight.getText());
                double KQ = Weight / Math.pow((Height/100), 2);
                boolean isAsian = false;
                if(radAsian.isSelected() == true) 
                {
                    if (KQ < 18.5) {
                   	 textKQ.setText(KQ + " - Underweight");
                    } else if (KQ >= 18.5 && KQ <= 22.9){
                   	 textKQ.setText(KQ + " - Nomal");
                    } else if (KQ >= 23 && KQ <= 24.9) {
                   	 textKQ.setText(KQ +" - Overweight");
                    } else if (KQ >= 25 && KQ <= 29.9) {
                   	 textKQ.setText(KQ +" - Pre-Obese");
                    } else if (KQ == 30) {
                      	 textKQ.setText(KQ +" - Obese");
                    }else if (KQ > 30 && KQ <= 40) {
                   	 textKQ.setText(KQ +" - Obese I");
                    } else if (KQ >= 40.1 && KQ <= 50) {
                   	 textKQ.setText(KQ +" - Obese Type II");
                    }else {
                   	 textKQ.setText(KQ +" - Obese Type II");
                    }
                }
                else if (radNonAsian.isSelected() == true){
                	if (KQ < 18.5) {
                      	 textKQ.setText(KQ + " - Underweight");
                       } else if (KQ >= 18.5 && KQ <= 24.9){
                      	 textKQ.setText(KQ + " - Nomal");
                       } else if (KQ >= 25 && KQ <= 29.9) {
                      	 textKQ.setText(KQ +" - Overweight");
                       } else if (KQ == 30) {
                         	 textKQ.setText(KQ +" - Obese");
                       }else if (KQ > 30 && KQ <= 40) {
                      	 textKQ.setText(KQ +" - Obese I");
                       } else if (KQ >= 40.1 && KQ <= 50) {
                      	 textKQ.setText(KQ +" - Obese Type II");
                       }else {
                      	 textKQ.setText(KQ +" - Obese Type II");
                       }
                }
                }	
});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(247, 187, 129, 35);
		frmTnhChS.getContentPane().add(btnNewButton);
		
		JLabel lblKQ = new JLabel("Kết quả");
		lblKQ.setFont(new Font("Arial", Font.BOLD, 15));
		lblKQ.setBounds(56, 242, 118, 35);
		frmTnhChS.getContentPane().add(lblKQ);
		
		textKQ = new JTextField();
		textKQ.setFont(new Font("Arial", Font.PLAIN, 15));
		textKQ.setColumns(10);
		textKQ.setBounds(184, 242, 251, 35);
		frmTnhChS.getContentPane().add(textKQ);
		
		
	}

}
