package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "danhmuc")
public class DanhMuc {
	@Id
	private int maDM;
	private String tenDanhMuc;
	private String nguoiQuanLy;
	private String ghiChu;

	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DanhMuc(int maDM, String tenDanhMuc, String nguoiQuanLy, String ghiChu) {
		this.maDM = maDM;
		this.tenDanhMuc = tenDanhMuc;
		this.nguoiQuanLy = nguoiQuanLy;
		this.ghiChu = ghiChu;
	}

	public int getMaDM() {
		return maDM;
	}

	public void setMaDM(int maDM) {
		this.maDM = maDM;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getNguoiQuanLy() {
		return nguoiQuanLy;
	}

	public void setNguoiQuanLy(String nguoiQuanLy) {
		this.nguoiQuanLy = nguoiQuanLy;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "DanhMuc [maDM=" + maDM + ", tenDanhMuc=" + tenDanhMuc + ", nguoiQuanLy=" + nguoiQuanLy + ", ghiChu="
				+ ghiChu + "]";
	}

}
