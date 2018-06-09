package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sub;

public class SubDAO {

	
	public static boolean subscribe(Sub sub) {
		return false;
	}
	
	public static boolean unsubscribe(Sub sub) {
		return false;
	}
	
	public static List<Sub> mySubs(String username){
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Sub> subs = new ArrayList<>();
		try {
			
			String query = "SELECT * FROM sub WHERE korisnik = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int index = 1;
				Sub sub = new Sub();
				sub.setKorisnik(resultSet.getString(index++));
				sub.setToKorisnik(resultSet.getString(index++));
				sub.setDatum(resultSet.getTimestamp(index++));
				subs.add(sub);
			}
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return subs;
		
		
	}
	
	public static boolean subscribed(Sub sub) {
		
		if(sub.getKorisnik().equals(sub.getToKorisnik())) {
			return true;
		}
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {			
			String query = "SELECT * FROM sub WHERE korisnik = ? and to_korisnik = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sub.getKorisnik());
			preparedStatement.setString(2, sub.getToKorisnik());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}

	
}