package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ShopInfo;

public class ShopInfoDAO {

    public ShopInfo getInformation(int id) throws Exception {
        String query = "SELECT * FROM CafeInfo WHERE Id = ?;";
        try (Connection con = MSSQLConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ShopInfo aboutShop = new ShopInfo(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            MSSQLConnection.getPhotoPath() + rs.getString(5),
                            rs.getString(6)
                    );
                    return aboutShop;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
}
