package dao;

import java.sql.SQLException;
import java.util.List;
import model.TinTuc;

public interface TinTucDAO {

	List<TinTuc> getTinTucByDanhMuc(int maDM) throws SQLException;

	List<TinTuc> getAllTinTuc() throws SQLException;

	void addTinTuc(TinTuc tinTuc) throws SQLException;

	void deleteTinTuc(int maTT) throws SQLException;
}
