package VMS.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import VMS.Model.VMS_Create;
import java.sql.*;

public class VMS_MRR_DAO {
	
public int MRR(VMS_Create vehicle)throws ClassNotFoundException {
		
		String MRR = "update vehicle set updatedDate = ?,remainingFuel=? where plateNumber= ?";
	
		int result = 0;
		
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/fuelstaff?characterEncoding=utf8","root","Vithya24");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(MRR)) {
            preparedStatement.setString(1, vehicle.getDate());
            preparedStatement.setFloat(2, vehicle.getRemainFuel());
            preparedStatement.setString(3,vehicle.getPlate_number());
             
          
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
