package jdbc.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrive {
    public void retrive(String[] args) throws ClassNotFoundException ,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connect = DriverManager.getConnection("url","user","pass");

        String sql = "SELECT * FROM studentInfo";
        PreparedStatement statement = connect.prepareStatement(sql);

        ResultSet rs = statement.executeQuery(sql);
        while(rs.next())
            System.out.println(rs.getInt(1) + " " + rs.getString("sname") + " " + rs.getInt("sage") + " " + rs.getString("scity"));

        statement.close();
        connect.close();
    }
}
