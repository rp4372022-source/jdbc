package jdbc;

import java.sql.*;

public class A1_Structure {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try{
            // Load and Register the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            String url = "", user = "", password = "";
            connection = DriverManager.getConnection(url, user, password);

            // creating statement
            statement = connection.createStatement();

            // execute query
            
            // >for non select operation (insertion,updation,deletion) use executeUpdate()
            String sql = "INSERT INTO studentdb(name,course) VALUES ('Rutik','AIML');";
            int rowsAffected = statement.executeUpdate(sql);
            if(rowsAffected != 0) System.out.println("Error");
            else System.out.println("Success");
            System.out.println("Rows affected = "+rowsAffected);
            
            // >for select operation (fetching) use executeQuery
            String sql1 = "SELECT * FROM studentdb WHERE student_id = 101";
            ResultSet rs = statement.executeQuery(sql1);
            while(rs.next()){
                String name = rs.getString(1);
                String course = rs.getString(2);
                System.out.println("Name: "+name+" Course: "+course);
            }
            // process the result

        } catch (Exception e){
            e.printStackTrace();
        }
        finally{
            // close the resources
            try{
                statement.close();
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
