import java.util.Scanner;

public class HCN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float dai, rong;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập chiều dài: ");
		dai = scanner.nextFloat();
		
		System.out.print("Nhập chiều rộng: ");
		rong = scanner.nextFloat();
		
		float chuvi = (dai + rong) * 2;
		float dientich = dai * rong;
		float min = Math.min(dai, rong);
		
		System.out.println();
		System.out.printf("Chu vi hình chữ nhật là: %.1f", chuvi);
		System.out.printf("\nDiện tích hình chữ nhật là: %.1f", dientich);
		System.out.printf("\nCạnh nhỏ nhất của hình là: %.1f", min);
	}
}