import java.util.Scanner;

public class PTB1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 double a, b;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Phương trình bậc nhất ax + b = 0");
		 
		 while (true) {
			 try {
				 System.out.println("Nhập A: ");
				 a = sc.nextDouble();
				 break;
			 } 
			 catch (Exception e) {
				// TODO: handle exception
				 System.out.println("Vui lòng nhập hệ số");
				 sc.next();
			}
		 }
		 while (true) {
			 try {
				 System.out.println("Nhập B: ");
				 b = sc.nextDouble();
				 break;
			 } 
			 catch (Exception e) {
				// TODO: handle exception
				 System.out.println("Vui lòng nhập hệ số");
				 sc.next();
			}
		 }
		 if(a == 0)
			 System.out.println("Phương trình vô nghiệm");
		 else if(b == 0)
			 System.out.println("Phương trình vô số nghiệm");
		 else {
			 double ketqua = -b/a;
			 System.out.println("Phương trình có nghiệm x = " + ketqua);
		 }
	}

}
