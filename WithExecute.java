package jdbcLearning;

//with execute command and surrounded with try catch

import java.sql.*;
public class WithExecute {
    static void insert(){
        Connection connection = null;
        Statement statement = null;
        //Driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establishing connections
            String url = "jdbc:mysql://localhost:3306/sqllearn";
            String user = "root", password = "root";
            connection = DriverManager.getConnection(url,user,password);

            //Creating statement
            statement = connection.createStatement();

            String query = "INSERT INTO studentInfo(id, sname, sage, scity) VALUES (110,'Tejas',22,'Raigad') ";

            //Execute query
            boolean isExecuted = statement.execute(query);

            if(!isExecuted && statement.getUpdateCount() > 0) System.out.println("Success");
            else System.out.println("Error");
        } catch (ClassNotFoundException | SQLException  e){
            e.printStackTrace();
        }
        //closing resources
        finally{
            try{
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    static void retrieve(){
        Connection connection = null;
        Statement statement = null;
        //Driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establishing connections
            String url = "jdbc:mysql://localhost:3306/sqllearn";
            String user = "root", password = "root";
            connection = DriverManager.getConnection(url,user,password);

            //Creating statement
            statement = connection.createStatement();

            String query = "SELECT * FROM studentInfo";

            //Execute query
            boolean isExecuted = statement.execute(query);

            if(isExecuted) {
                ResultSet rs = statement.getResultSet();

                while(rs.next()){
                    System.out.println(rs.getInt(1) + " " + rs.getString("sname") + " " + rs.getInt("sage") + " " + rs.getString("scity"));
                }
            }
            else System.out.println("No data found");
        } catch (ClassNotFoundException | SQLException  e){
            e.printStackTrace();
        }
        //closing resources
        finally{
            try{
                if(statement != null) statement.close(); //if statement to avoid null pointer exception
                if(connection != null) connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        retrieve();
    }
}
