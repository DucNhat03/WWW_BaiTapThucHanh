package lab5.dao;

import lab5.model.DienThoai;
import java.sql.SQLException;
import java.util.List;

public interface DienThoaiDAO {
	List<DienThoai> getAllDienThoai() throws SQLException;

	DienThoai getDienThoaiById(String maDT) throws SQLException;

	void insertDienThoai(DienThoai dt) throws SQLException;

	void updateDienThoai(DienThoai dt) throws SQLException;

	void deleteDienThoai(String maDT) throws SQLException;
}
