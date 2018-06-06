package model;

import java.util.Date;

public class Komentar {
	int id;
	String sadrzaj;
	Date datumKreiranja;
	Korisnik korisnik;
	Video video;
	
	public Komentar() {}
	
	
	
	public Komentar(int id, String sadrzaj, Date datumKreiranja, Korisnik korisnik, Video video) {
		this.id = id;
		this.sadrzaj = sadrzaj;
		this.datumKreiranja = datumKreiranja;
		this.korisnik = korisnik;
		this.video = video;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}



	@Override
	public String toString() {
		return "Komentar [id=" + id + ", sadrzaj=" + sadrzaj + ", datumKreiranja=" + datumKreiranja + ", korisnik="
				+ korisnik + ", video=" + video + "]";
	}
	
	
	
	
}
