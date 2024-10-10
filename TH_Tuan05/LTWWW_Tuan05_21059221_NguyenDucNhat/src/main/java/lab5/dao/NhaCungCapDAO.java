package lab5.dao;

import lab5.model.NhaCungCap;
import java.sql.SQLException;
import java.util.List;

public interface NhaCungCapDAO {
    List<NhaCungCap> selectAllNhaCungCap() throws SQLException;
}
