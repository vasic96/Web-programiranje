package model;

import java.util.Date;

public class Sub {
	
	private String korisnik;
	private String toKorisnik;
	private Date datum;
	
	public Sub() {}

	public Sub(String korisnik, String toKorisnik, Date datum) {
		super();
		this.korisnik = korisnik;
		this.toKorisnik = toKorisnik;
		this.datum = datum;
	}
	

	public Sub(String korisnik, String toKorisnik) {
		super();
		this.korisnik = korisnik;
		this.toKorisnik = toKorisnik;
	}
	
	public String getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}

	public String getToKorisnik() {
		return toKorisnik;
	}

	public void setToKorisnik(String toKorisnik) {
		this.toKorisnik = toKorisnik;
	} 

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Sub [korisnik=" + korisnik + ", toKorisnik=" + toKorisnik + ", datum=" + datum + "]";
	}

	
	
	
	

}
