package Model;

public class SinhVien {

	int MSSV;
	String hoTen;
	String gioiTinh;
	String SDT;
	String lop;
	String diaChi;
	
	
	public SinhVien() {
		
	}

	public SinhVien(String hoTen, String gioiTinh, String SDT, String lop, String diaChi) {
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.SDT = SDT;
		this.lop = lop;
		this.diaChi = diaChi;
	}
	
	public SinhVien(int MSSV, String hoTen, String gioiTinh, String SDT, String lop, String diaChi) {

		this.MSSV = MSSV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.SDT = SDT;
		this.lop = lop;
		this.diaChi = diaChi;
	}


	public int getMSSV() {
		return MSSV;
	}


	public void setMSSV(int mSSV) {
		MSSV = mSSV;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getSDT() {
		return SDT;
	}


	public void setSDT(String sDT) {
		SDT = sDT;
	}


	public String getLop() {
		return lop;
	}


	public void setLop(String lop) {
		this.lop = lop;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
}
