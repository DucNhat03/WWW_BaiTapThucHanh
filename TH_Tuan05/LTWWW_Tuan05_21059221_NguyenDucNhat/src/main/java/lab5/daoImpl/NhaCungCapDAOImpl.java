package lab5.daoImpl;

import lab5.dao.NhaCungCapDAO;
import lab5.model.NhaCungCap;
import lab5.utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {
	private static final String SELECT_ALL_SQL = "SELECT * FROM NHACUNGCAP";

	@Override
	public List<NhaCungCap> selectAllNhaCungCap() throws SQLException {
		List<NhaCungCap> nhaCungCaps = new ArrayList<>();
		try (Connection connection = ConnectDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maNCC = rs.getString("MANCC");
				String tenNCC = rs.getString("TENNHACC");
				String diaChi = rs.getString("DIACHI");
				String soDienThoai = rs.getString("SODIENTHOAI");
				NhaCungCap nhaCungCap = new NhaCungCap(maNCC, tenNCC, diaChi, soDienThoai);
				nhaCungCaps.add(nhaCungCap);
			}
		} catch (SQLException e) {
			System.err.println("Lỗi khi lấy danh sách nhà cung cấp: " + e.getMessage());
			throw e;
		}
		return nhaCungCaps;
	}
}
