package com.itp.service;

import java.io.IOException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import com.itp.connection.CommonConstants;
import com.itp.connection.CommonUtil;
import com.itp.connection.DBConnectionUtil;
import com.itp.connection.QueryUtil;
import com.itp.model.Staff;

public class StaffInterfaceImpl implements StaffInterface{

	public static final Logger log = Logger.getLogger(StaffInterface.class.getName());

	private static Connection connection;

	private static Statement statement;

	
	/*static{
		//create table or drop if exist
		createStaffTable();
	}*/
	
	

	private PreparedStatement preparedStatement123;

	
	public static void createStaffTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
	}

	
	@Override
	public void AddStaff(Staff s1) {
		// TODO Auto-generated method stub
		String StaffID = CommonUtil.generateIDs(getStaffIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement123 = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_STAFFS));
			connection.setAutoCommit(false);
			
			//Generate staff IDs
			s1.setStaffID(StaffID);
			preparedStatement123.setString(CommonConstants.COLUMN_INDEX_ONE, s1.getStaffID());
			preparedStatement123.setString(CommonConstants.COLUMN_INDEX_TWO, s1.getFirstName());
			preparedStatement123.setString(CommonConstants.COLUMN_INDEX_THREE, s1.getLastName());
			preparedStatement123.setString(CommonConstants.COLUMN_INDEX_FOUR, s1.getNIC());
			preparedStatement123.setString(CommonConstants.COLUMN_INDEX_FIVE, s1.getAddress());
			preparedStatement123.setString(CommonConstants.COLUMN_INDEX_SIX, s1.getEmail());
			preparedStatement123.setString(CommonConstants.COLUMN_INDEX_SEVEN, s1.getAccNo());
			preparedStatement123.setString(CommonConstants.COLUMN_INDEX_EIGHT, s1.getPassword());
			preparedStatement123.setString(CommonConstants.COLUMN_INDEX_NINE, s1.getStaffType());
			preparedStatement123.setDouble(CommonConstants.COLUMN_INDEX_TEN, s1.getContactYears());
			preparedStatement123.setDouble(CommonConstants.COLUMN_INDEX_ELEVEN, s1.getBasicSalary());
			preparedStatement123.setDouble(CommonConstants.COLUMN_INDEX_TWELVE, s1.getOt());
			
			// Add staff
			preparedStatement123.execute();
			
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		} finally {
			
			try {
				if (preparedStatement123 != null) {
					preparedStatement123.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
	}

	@Override
	public Staff getStaffByID(String StaffID) {
		// TODO Auto-generated method stub
		return actionOnStaff(StaffID).get(0);
	}

	@Override
	public ArrayList<Staff> getStaffs() {
		// TODO Auto-generated method stub
		return actionOnStaff(null);
	}

	@Override
	public Staff UpdateStaff(String StaffID, Staff s1) {
		// TODO Auto-generated method stub
		if (StaffID != null && !StaffID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement123 = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_STAFF));
				
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_ONE, s1.getFirstName());
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_TWO, s1.getLastName());
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_THREE, s1.getNIC());
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_FOUR, s1.getAddress());
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_FIVE, s1.getEmail());
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_SIX, s1.getAccNo());
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_SEVEN, s1.getPassword());
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_EIGHT, s1.getStaffType());
				preparedStatement123.setInt(CommonConstants.COLUMN_INDEX_NINE, s1.getContactYears());
				preparedStatement123.setDouble(CommonConstants.COLUMN_INDEX_TEN, s1.getBasicSalary());
				preparedStatement123.setDouble(CommonConstants.COLUMN_INDEX_ELEVEN, s1.getOt());
				
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_TWELVE, s1.getStaffID());
				
				preparedStatement123.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement123 != null) {
						preparedStatement123.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated employee
		return getStaffByID(StaffID);
	}

	@Override
	public void RemoveStaff(String StaffID) {
		// TODO Auto-generated method stub
		if (StaffID != null && !StaffID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement123 = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_STAFF));
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_ONE, StaffID);
				preparedStatement123.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement123 != null) {
						preparedStatement123.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}
	
	private ArrayList<Staff> actionOnStaff(String StaffID) {

		ArrayList<Staff> StaffList = new ArrayList<Staff>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (StaffID != null && !StaffID.isEmpty()) {
				
				preparedStatement123 = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STAFF));
				preparedStatement123.setString(CommonConstants.COLUMN_INDEX_ONE, StaffID);
			}
			
			else {
				preparedStatement123 = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_STAFFS));
			}
			ResultSet resultSet = preparedStatement123.executeQuery();

			while (resultSet.next()) {
				Staff s1 = new Staff();
				
				s1.setStaffID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				s1.setFirstName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				s1.setLastName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				s1.setNIC(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				s1.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				s1.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				s1.setAccNo(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				s1.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				s1.setStaffType(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				s1.setContactYears(resultSet.getInt(CommonConstants.COLUMN_INDEX_TEN));
				s1.setBasicSalary(resultSet.getDouble(CommonConstants.COLUMN_INDEX_ELEVEN));
				s1.setOt(resultSet.getDouble(CommonConstants.COLUMN_INDEX_TWELVE));
				StaffList.add(s1);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement123 != null) {
					preparedStatement123.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return StaffList;
	}

	private ArrayList<String> getStaffIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement123 = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STAFF_IDS));
			ResultSet resultSet = preparedStatement123.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement123 != null) {
					preparedStatement123.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}

}
