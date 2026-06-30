package jdbcLearning;

import java.sql.*;

public class Retrieve {
    public static void main(String[] args) throws ClassNotFoundException ,SQLException {

        //Load and register the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //establish connection
        String url = "jdbc:mysql://localhost:3306/sqllearn";
        String user = "root";
        String password = "root";
        Connection connect = DriverManager.getConnection(url,user,password);

        //create statement
        Statement statement = connect.createStatement();

        //(create query)
        String query = "SELECT * FROM studentInfo";

        //Execute query
        ResultSet rs = statement.executeQuery(query);

        while(rs.next())
            System.out.println(rs.getInt(1) + " " + rs.getString("sname") + " " + rs.getInt("sage") + " " + rs.getString("scity"));

        //close resources
        statement.close();
        connect.close();
    }
}
