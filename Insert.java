package jdbcLearning;

import java.sql.*;
public class Insert {
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
        String query = "INSERT INTO studentInfo(id,sname,sage,scity) VALUES (110,'Oki',18,'Raigad')";

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
