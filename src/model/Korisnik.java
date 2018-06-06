package model;

import java.util.Date;

public class Korisnik {
	
	public enum Uloga {USER, ADMIN};
	
	private String username;
	private String lozinka;
	private String ime;
	private String prezime;
	private String email;
	private String opis;
	private Date datumRegistracije;
	private Uloga uloga;
	private boolean blokiran;
	
	public Korisnik() {}
	
	public Korisnik(String username, String lozinka, String ime, String prezime, String email, String opis,
			Date datumRegistracije, Uloga uloga, boolean blokiran) {
		super();
		this.username = username;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.opis = opis;
		this.datumRegistracije = datumRegistracije;
		this.uloga = uloga;
		this.blokiran = blokiran;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Date getDatumRegistracije() {
		return datumRegistracije;
	}
	public void setDatumRegistracije(Date datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}
	public Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	public boolean isBlokiran() {
		return blokiran;
	}
	public void setBlokiran(boolean blokiran) {
		this.blokiran = blokiran;
	}

	@Override
	public String toString() {
		return "Korisnik [username=" + username + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime
				+ ", email=" + email + ", opis=" + opis + ", datumRegistracije=" + datumRegistracije + ", uloga="
				+ uloga + ", blokiran=" + blokiran + "]";
	}
	
	
	
}
