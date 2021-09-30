import java.util.Scanner; 

public class LAPPHUONG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float canh;
		Scanner scanner =  new Scanner(System.in);
		System.out.print("Nhập cạnh của hình lập phương: ");
		canh = scanner.nextFloat();
		
		float thetich = canh * canh * canh;
		thetich = (float) Math.pow(canh,3);
		
		System.out.printf("Thể tích khối lập phương: %.1f", thetich);
	}

}