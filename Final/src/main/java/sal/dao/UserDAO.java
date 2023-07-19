package sal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import  sal.dao.DBConnect;
import sal.dao.Staff;

import sal.model.User;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/fuelstaff";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Vithya24";
	
	public static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	private static final String INSERT_USERS_SQL = "INSERT INTO salary" + "  (date, amount, reason) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select salaryID,date,amount,reason from salary where salaryID =?";
	private static final String SELECT_ALL_USERS = "select * from salary";
	private static final String DELETE_USERS_SQL = "delete from salary where salaryID = ?;";
	private static final String UPDATE_USERS_SQL = "update salary set date = ?,amount= ?, reason =? where salaryID = ?;";

	public UserDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getDate());
			preparedStatement.setString(2, user.getAmount());
			preparedStatement.setString(3, user.getReason());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String date = rs.getString("date");
				String amount = rs.getString("amount");
				String reason = rs.getString("reason");
				user = new User(id, date, amount, reason);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("salaryID");
				String date = rs.getString("date");
				String amount = rs.getString("amount");
				String reason = rs.getString("reason");
				users.add(new User(id, date, amount, reason));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getDate());
			statement.setString(2, user.getAmount());
			statement.setString(3, user.getReason());
			statement.setInt(4, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
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
	
	public static List<Staff>getStaffDetails(String staffID){
		ArrayList<Staff> st = new ArrayList<>();
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "select * from staff where StaffID = '" +staffID+"'";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					String sid = rs.getString(1);
					String firstname = rs.getString(2);
					String lastname = rs.getString(3);
					String nic = rs.getString(4);
					String address = rs.getString(5);
					String email = rs.getString(6);
					String accNo = rs.getString(7);
					String password = rs.getString(9);
					String stafftype = rs.getString(10);
					int contractyears = rs.getInt(11);
					Double basicsalary = rs.getDouble(12);
					Double otRate = rs.getDouble(13);
					
					Staff s = new Staff();
					st.add(s);
					
					 
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		return st;
	}

}