package VMS.Dao;

import java.sql.*;

import VMS.Model.VMS_Create;

public class VMS_Create_DAO {
	
	public int registerVehicle(VMS_Create vehicle)throws ClassNotFoundException {
		
		String INSERT_VEHICLE = "INSERT INTO vehicle " + "(plateNumber,status,updatedDate,remainingFuel,fuelLimit,vehicleType,chassisNumber,userID,fuelID) values"+"(?,?,?,?,?,?,?,?,?)";
	
		int result = 0;
		
        Class.forName("com.mysql.jdbc.Driver");
        
        String status ="updated";
        

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/fuelstaff?","root","Vithya24");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VEHICLE)) {
        	preparedStatement.setString(1, vehicle.getPlate_number());
        	preparedStatement.setString(2,status);
        	preparedStatement.setString(3, vehicle.getDate());
        	preparedStatement.setFloat(4, vehicle.getRemainFuel());
        	preparedStatement.setFloat(5, vehicle.getFuelLimit());
        	preparedStatement.setString(6, vehicle.getVtype());
            preparedStatement.setString(7, vehicle.getChassis_Number());
            preparedStatement.setString(8, vehicle.getUserID());
            preparedStatement.setString(9, vehicle.getFuelType());
            
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
