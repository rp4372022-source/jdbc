package jdbc.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public void delete() throws ClassNotFoundException ,SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager.getConnection("url","user","password");
        
        String sql = "DELETE FROM table WHERE name = ?;";
        PreparedStatement ps = connect.prepareStatement(sql);
        
        ps.setString(0, "name");
        
        int rowsAffected = ps.executeUpdate();
        if(rowsAffected == 0) System.out.println("Error");
        else System.out.println("Success");

        ps.close();
        connect.close();
    }
}
