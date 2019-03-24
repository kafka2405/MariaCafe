package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cake;

public class CakeDAO {

    public Cake getOne(int id) throws Exception {
        String query = "SELECT * FROM Cake WHERE Id = ?;";
        try (Connection con = MSSQLConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cake cake = new Cake(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        MSSQLConnection.getPhotoPath() + rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                return cake;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public int totalSushi() throws Exception {
        String query = "SELECT COUNT(id) FROM Cake";
        int total = 0;
        try (Connection connection = MSSQLConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        }
        return total;
    }

    public ArrayList<Cake> getMost2Update() throws Exception {
        String query = "SELECT TOP 2 * FROM Cake ORDER BY DayCreated DESC;";
        ArrayList<Cake> listCake = new ArrayList<Cake>();
        try (Connection con = MSSQLConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cake cake = new Cake(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        MSSQLConnection.getPhotoPath() + rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                listCake.add(cake);
            }
        } catch (Exception e) {
            throw e;
        }
        return listCake;
    }

    public ArrayList<Cake> getListByIndex(int start, int end) throws Exception {
        String query = "SELECT * FROM (\n"
                + "SELECT *, ROW_NUMBER() OVER (ORDER BY DayCreated DESC) AS RowNum FROM Cake s\n"
                + ") AS MyDerivedTable WHERE MyDerivedTable.RowNum BETWEEN ? AND ?;";
        ArrayList<Cake> listCake = new ArrayList<Cake>();
        try (Connection con = MSSQLConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, start);
            ps.setInt(2, end);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cake cake = new Cake(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDate(4),
                            MSSQLConnection.getPhotoPath() + rs.getString(5),
                            rs.getString(6),
                            rs.getString(7)
                    );
                    listCake.add(cake);
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return listCake;
    }
}
