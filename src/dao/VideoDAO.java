package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Video;

public class VideoDAO {
	
	public static Video getVideo(int id) {
		
		Connection connection = ConnectionManager.getConnection();
		System.out.println(connection.toString());
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			String query = "SELECT naziv, url, opis, dozvoljeni_komentari,vidljivost_rejtinga, blokiran, broj_pregleda, datum_kreiranja, korisnik_username FROM videos WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int index = 1;
				Video video = new Video();
				video.setId(id);
				video.setNaziv((resultSet.getString(index++)));
				video.setUrl(resultSet.getString(index++));
				video.setOpis(resultSet.getString(index++));
				video.setDozvoljeniKomentari(resultSet.getBoolean(index++));
				video.setVidljivostRejtinga(resultSet.getBoolean(index++));
				video.setBlokiran(resultSet.getBoolean(index++));
				video.setBrojPregleda(resultSet.getInt(index++));
				video.setDatumKreiranja(resultSet.getDate(index++));
				video.setKorisnik(KorisnikDAO.getById(resultSet.getString(index++)));
				System.out.println(video);
				return video;
			}
			
			
		}catch (Exception e) {
			
				System.out.println(e.getMessage());
			}
		finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

			
			return null;
		}
	
	public static List<Video> getAll(){
		Connection connection = ConnectionManager.getConnection();
		System.out.println(connection.toString());
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Video> videos = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM videos";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int index = 1;
				Video video = new Video();
				video.setId(resultSet.getInt(index++));
				video.setNaziv(resultSet.getString(index++));
				video.setUrl(resultSet.getString(index++));
				video.setOpis(resultSet.getString(index++));
				video.setDozvoljeniKomentari(resultSet.getBoolean(index++));
				video.setVidljivostRejtinga(resultSet.getBoolean(index++));
				video.setBlokiran(resultSet.getBoolean(index++));
				video.setBrojPregleda(resultSet.getInt(index++));
				video.setDatumKreiranja(resultSet.getDate(index++));
				video.setKorisnik(KorisnikDAO.getById(resultSet.getString(index++)));
				videos.add(video);
			}
			
			return videos;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return videos;
		
	}
	
	public static boolean saveVideo(Video video ) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			
			String query = "INSERT INTO videos(naziv,url,opis,dozvoljeni_komentari,vidljivost_rejtinga,blokiran,broj_pregleda,datum_kreiranja,korisnik_username) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			int index = 1;
			preparedStatement.setString(index++, video.getNaziv());
			preparedStatement.setString(index++, video.getUrl());
			preparedStatement.setString(index++, video.getOpis());
			preparedStatement.setBoolean(index++, video.isDozvoljeniKomentari());
			preparedStatement.setBoolean(index++, video.isVidljivostRejtinga());
			preparedStatement.setBoolean(index++, video.isBlokiran());
			preparedStatement.setInt(index++, video.getBrojPregleda());
			preparedStatement.setDate(index++, new Date(video.getDatumKreiranja().getTime()));
			preparedStatement.setString(index++, video.getKorisnik().getUsername());
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate(); 
			return true;
			
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		
		
		return false;
	}
	
	public static boolean deleteVideo(int id) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			
			String query = "DELETE FROM videos WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			return preparedStatement.executeUpdate() == 1;
						
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		
		return false;
	}
	
	public static boolean incrementViews(int id) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			
			String query = "UPDATE videos SET broj_pregleda = broj_pregleda + 1 WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			return preparedStatement.executeUpdate() == 1;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {preparedStatement.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}
		
		return false;
		
	}
	

		
		
}

	
	
	
	
	
	
