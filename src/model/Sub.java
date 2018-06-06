package model;

public class Sub {
	
	private int id;
	private String korisnik;
	private String toKorisnik;
	
	public Sub() {}

	public Sub(int id, String korisnik, String toKorisnik) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.toKorisnik = toKorisnik;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Sub [id=" + id + ", korisnik=" + korisnik + ", toKorisnik=" + toKorisnik + "]";
	}
	
	
	
	
	

}
