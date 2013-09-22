package registration;

import Database.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class UniqueID {

    public static String generate() {
        UUID uuid = UUID.randomUUID();
        String id = (uuid + "").replace("-", "");
        while (searchAndAdd(id)) {
            uuid = UUID.randomUUID();
            id = (uuid + "").replace("-", "");
        }
        return id;
    }

    private static boolean searchAndAdd(String id) {
        DatabaseConnectionHandler db = new DatabaseConnectionHandler();
        try {
            Connection con = db.getConnection();
            String queryCheck = "SELECT count(*) from id WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                final int count = resultSet.getInt(1);
                if (count > 0) {
                    return true;
                } else {
                    Statement st = con.createStatement();
                    int rs = st.executeUpdate("INSERT INTO id VALUES ('" + id + "')");
                    return false;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
}
