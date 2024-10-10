package lab5.daoImpl;

import lab5.dao.DienThoaiDAO;
import lab5.model.DienThoai;
import lab5.utils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {

	private static final String SELECT_ALL_SQL = "SELECT * FROM DIENTHOAI";
	private static final String INSERT_SQL = "INSERT INTO DIENTHOAI (MADT, TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_SQL = "UPDATE DIENTHOAI SET TENDT = ?, NAMSANXUAT = ?, CAUHINH = ?, MANCC = ?, HINHANH = ? WHERE MADT = ?";
	private static final String DELETE_SQL = "DELETE FROM DIENTHOAI WHERE MADT = ?";
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM DIENTHOAI WHERE MADT = ?";

	@Override
	public List<DienThoai> getAllDienThoai() throws SQLException {
		List<DienThoai> listDienThoai = new ArrayList<>();
		String sql = "SELECT * FROM DIENTHOAI";
		System.out.println("Starting to fetch all phones..."); // Thêm log

		try (Connection connection = ConnectDB.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			System.out.println("Query executed: " + sql); // Log để xác nhận câu query được thực hiện

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maDT = rs.getString("MADT");
				String tenDT = rs.getString("TENDT");
				int namSanXuat = rs.getInt("NAMSANXUAT");
				String cauHinh = rs.getString("CAUHINH");
				String maNCC = rs.getString("MANCC");
				String hinhAnh = rs.getString("HINHANH");

				DienThoai dienThoai = new DienThoai(maDT, tenDT, namSanXuat, cauHinh, maNCC, hinhAnh);
				listDienThoai.add(dienThoai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Không thể lấy dữ liệu điện thoại từ cơ sở dữ liệu.");
		}

		System.out.println("Finished fetching all phones."); // Log khi hoàn thành
		return listDienThoai;
	}

	@Override
	public DienThoai getDienThoaiById(String maDT) throws SQLException {
		DienThoai dt = null;

		try (Connection conn = ConnectDB.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {
			stmt.setString(1, maDT);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				dt = new DienThoai();
				dt.setMaDT(rs.getString("MADT"));
				dt.setTenDT(rs.getString("TENDT"));
				dt.setNamSanXuat(rs.getInt("NAMSANXUAT"));
				dt.setCauHinh(rs.getString("CAUHINH"));
				dt.setMaNCC(rs.getString("MANCC"));
				dt.setHinhAnh(rs.getString("HINHANH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Lỗi khi lấy thông tin điện thoại với mã " + maDT + ".");
		}

		return dt;
	}

	@Override
	public void insertDienThoai(DienThoai dt) throws SQLException {
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
			stmt.setString(1, dt.getMaDT());
			stmt.setString(2, dt.getTenDT());
			stmt.setInt(3, dt.getNamSanXuat());
			stmt.setString(4, dt.getCauHinh());
			stmt.setString(5, dt.getMaNCC());
			stmt.setString(6, dt.getHinhAnh());

			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Thêm điện thoại mới thành công.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Lỗi khi thêm điện thoại vào cơ sở dữ liệu.");
		}
	}

	@Override
	public void updateDienThoai(DienThoai dt) throws SQLException {
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
			stmt.setString(1, dt.getTenDT());
			stmt.setInt(2, dt.getNamSanXuat());
			stmt.setString(3, dt.getCauHinh());
			stmt.setString(4, dt.getMaNCC());
			stmt.setString(5, dt.getHinhAnh());
			stmt.setString(6, dt.getMaDT());

			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Cập nhật thông tin điện thoại thành công.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Lỗi khi cập nhật thông tin điện thoại.");
		}
	}

	@Override
	public void deleteDienThoai(String maDT) throws SQLException {
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE_SQL)) {
			stmt.setString(1, maDT);

			int rowsDeleted = stmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Xóa điện thoại thành công.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Lỗi khi xóa điện thoại với mã " + maDT + ".");
		}
	}
}
