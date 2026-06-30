package jdbcLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
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
        String query = "UPDATE studentInfo set sname = 'Tejas' WHERE id = 110";

        //Execute query
        int rowsAffected = statement.executeUpdate(query);

        //check
        if(rowsAffected == 0) System.out.println("Error");
        else System.out.println("Success");

        //close resources
        statement.close();
        connect.close();
    }
}
