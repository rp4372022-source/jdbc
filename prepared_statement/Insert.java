package jdbc.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public void insert() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("url","user","pass");

        String sql = "INSERT INTO db_table(name,course) VALUES (? ,?);";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,"name");
        ps.setString(2,"course");

        int rowsAffected = ps.executeUpdate();
        System.out.println(rowsAffected);

        ps.close();
        connection.close();
    }
}
