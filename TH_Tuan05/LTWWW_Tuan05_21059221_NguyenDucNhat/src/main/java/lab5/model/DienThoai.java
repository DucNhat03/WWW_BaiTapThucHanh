package lab5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DienThoai {
	@Id
	private String maDT;
	private String tenDT;
	private int namSanXuat;
	private String cauHinh;
	private String maNCC;
	private String hinhAnh;

	public DienThoai() {
	}

	public DienThoai(String maDT, String tenDT, int namSanXuat, String cauHinh, String maNCC, String hinhAnh) {
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
		this.maNCC = maNCC;
		this.hinhAnh = hinhAnh;
	}

	public String getMaDT() {
		return maDT;
	}

	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public int getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public String toString() {
		return "DienThoai [maDT=" + maDT + ", tenDT=" + tenDT + ", namSanXuat=" + namSanXuat + ", cauHinh=" + cauHinh
				+ ", maNCC=" + maNCC + ", hinhAnh=" + hinhAnh + "]";
	}

}
