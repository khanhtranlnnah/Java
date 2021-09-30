import java.util.Scanner;
public class ThongTinSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hoten = "";
		double diemtb = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Họ và tên SV:");
		hoten = scanner.nextLine();
		
		System.out.print("Điểm TB:"); 
		diemtb = scanner.nextDouble();
		
		System.out.printf("Sinh viên: %s", hoten);
		System.out.printf("\nCó điểm trung bình là: %.1f", diemtb);
	}
}