package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Korisnik;
import model.Korisnik.Uloga;

public class KorisnikDAO {
	
	public static Korisnik getById(String username) {
		
		Connection connection = ConnectionManager.getConnection();
		System.out.println(connection.toString());
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String query = "SELECT * FROM korisnik WHERE username = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			System.out.println(preparedStatement);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Korisnik korisnik = new Korisnik();
				int index = 1;
				korisnik.setUsername(resultSet.getString(index++));
				korisnik.setLozinka(resultSet.getString(index++));
				korisnik.setIme(resultSet.getString(index++));
				korisnik.setPrezime(resultSet.getString(index++));
				korisnik.setEmail(resultSet.getString(index++));
				korisnik.setOpis(resultSet.getString(index++));
				korisnik.setDatumRegistracije(resultSet.getTimestamp(index++));
				korisnik.setUloga(Uloga.valueOf(resultSet.getString(index++)));
				korisnik.setBlokiran(resultSet.getBoolean(index++));
				
				return korisnik;
			}
			}catch (Exception e) {
			
				System.out.println(e.getMessage());
			}
		finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

			
			return null;

		
		
		
	}
	
	public static boolean add(Korisnik korisnik) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			
			String query = "INSERT INTO korisnik VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			int index = 1;
			preparedStatement.setString(index++, korisnik.getUsername());
			preparedStatement.setString(index++, korisnik.getLozinka());
			preparedStatement.setString(index++, korisnik.getIme());
			preparedStatement.setString(index++, korisnik.getPrezime());
			preparedStatement.setString(index++, korisnik.getEmail());
			preparedStatement.setString(index++, korisnik.getOpis());
			java.sql.Timestamp sq = new java.sql.Timestamp(korisnik.getDatumRegistracije().getTime());  
			preparedStatement.setTimestamp(index++, sq);
			preparedStatement.setString(index++, korisnik.getUloga().name());
			preparedStatement.setBoolean(index++, korisnik.isBlokiran());
			
			return preparedStatement.executeUpdate() == 1;
			
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		
		
		return false;
	}

}
