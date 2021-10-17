package SanPham;

public class SanPham {
	private String maSP;
	private String tenSP;
	private double giaSP;
	
	public SanPham() {
		super();
	}

	public SanPham(String maSP, String tenSP, double giaSP) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaSP = giaSP;
	}
	
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public double getGiaSP() {
		return giaSP;
	}
	public void setGiaSP(double giaSP) {
		this.giaSP = giaSP;
	}
}
