import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BMI extends JFrame{

	public static void main(String[] args) {
		JFrame frame = new JFrame("BMI");

        frame.setSize(380, 350);

        JPanel panel = new JPanel(); 
        
        frame.add(panel);
        placeComponents(panel);
  
        frame.setVisible(true);
        
        frame.setLayout(null);
        
        frame.setLocationRelativeTo(null);
    }

    public static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel Label = new JLabel("TÍNH CHỈ SỐ BMI");
        Label.setBounds(120,10,200,25);
        panel.add(Label);
        
        JLabel LabelHeight = new JLabel("Chiều cao (cm)");
        LabelHeight.setBounds(30,50,100,25);
        panel.add(LabelHeight);

        JTextField txtHeight  = new JTextField(20);
        txtHeight .setBounds(140,50,200,25);
        panel.add(txtHeight );
        
        JLabel LabelWeight = new JLabel("Cân nặng (kg)");
        LabelWeight.setBounds(30,100,100,25);
        panel.add(LabelWeight);

        JTextField txtWeight  = new JTextField(20);
        txtWeight.setBounds(140,100,200,25);
        panel.add(txtWeight);

        JButton btnKQ = new JButton("TÍNH BMI");
        btnKQ.setBounds(30, 150, 310, 40);
        panel.add(btnKQ);
        
        JLabel LabelKQ = new JLabel("");
        LabelKQ.setBounds(30,200,500,25);
        panel.add(LabelKQ);
        
        JLabel LabelLK = new JLabel("");
        LabelLK.setBounds(30,230,500,25);
        panel.add(LabelLK);
        
      //xử lý sự kiện nút tính
        btnKQ.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	double Height=Double.parseDouble(txtHeight.getText());
                double Weight=Double.parseDouble(txtWeight.getText());
                double KQ = Weight / Math.pow((Height/100), 2);
                
                 if (KQ < 16) {
                	 LabelKQ.setText("BMI: " + KQ +" - Gầy độ III");
                	 LabelLK.setText("Lời khuyên: Bạn cần phải ăn nhiều hơn");
                 } else if (KQ >= 16 && KQ < 17){
                	 LabelKQ.setText("BMI: " + KQ +" - Gầy độ II");
                	 LabelLK.setText("Lời khuyên: Bạn cần phải ăn nhiều hơn");
                 } else if (KQ >= 17 && KQ < 18.5) {
                	 LabelKQ.setText("BMI: " + KQ +" - Gầy độ I");
                	 LabelLK.setText("Lời khuyên: Bạn cần phải ăn nhiều hơn");
                 } else if (KQ >= 18.5 && KQ < 25) {
                	 LabelKQ.setText("BMI: " + KQ +" - Bình thường");
                	 LabelLK.setText("Lời khuyên: Bạn hãy duy trì để cơ thể được khỏe mạnh");
                 } else if (KQ >= 25 && KQ < 30) {
                	 LabelKQ.setText("BMI: " + KQ +" - Thừa cân");
                	 LabelLK.setText("Lời khuyên: Bạn cần phải giảm cân");
                 } else if (KQ >= 30 && KQ < 34.9) {
                	 LabelKQ.setText("BMI: " + KQ +" - Béo phì độ I");
                	 LabelLK.setText("Lời khuyên: Bạn cần phải giảm cân");
                 } else if (KQ >= 35 && KQ <= 39.9) {
                	 LabelKQ.setText("BMI: " + KQ +" - Béo phì độ II");
                	 LabelLK.setText("Lời khuyên: Bạn cần phải giảm cân");
                 }else {
                	 LabelKQ.setText("BMI: " + KQ +" - Béo phì độ III");
                	 LabelLK.setText("Lời khuyên: Bạn cần phải giảm cân");
                 }
            }
        });
     }
}
