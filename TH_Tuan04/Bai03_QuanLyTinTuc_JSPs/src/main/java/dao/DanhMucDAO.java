package dao;

import java.sql.SQLException;
import java.util.List;
import model.DanhMuc;

public interface DanhMucDAO {

	List<DanhMuc> getAllDanhMuc() throws SQLException;

	void addDanhMuc(DanhMuc danhMuc) throws SQLException;

	void deleteDanhMuc(int maDM) throws SQLException;
}
