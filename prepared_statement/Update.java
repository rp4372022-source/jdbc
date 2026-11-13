package jdbc.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void update(String[] args) throws ClassNotFoundException ,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection connect = DriverManager.getConnection("url","user","password");
        String sql = "UPDATE studentInfo set sname = ? WHERE id = ?";
        
        PreparedStatement ps = connect.prepareStatement(sql);
        
        int rowsAffected = ps.executeUpdate();
        if(rowsAffected == 0) System.out.println("Error");
        else System.out.println("Success");

        ps.close();
        connect.close();
    }
}
