package model;

import java.util.Date;


public class Video {
	
	private int id;
	private String naziv;
	private String url;
	private String opis;
	private boolean dozvoljeniKomentari;
	private boolean vidljivostRejtinga;
	private boolean blokiran;
	private int brojPregleda;
	private Date datumKreiranja;
	private Korisnik korisnik;
	
	
	public Video() {
	}
	
	

	public Video(int id, String videoNaziv, String videoUrl, String opis, boolean dozvoljeniKomentari,
			boolean vidljivostRejtinga, boolean blokiran, int brojPregleda, Date datumKreiranja, Korisnik korisnik) {
		super();
		this.id = id;
		this.naziv = videoNaziv;
		this.url = videoUrl;
		this.opis = opis;
		this.dozvoljeniKomentari = dozvoljeniKomentari;
		this.vidljivostRejtinga = vidljivostRejtinga;
		this.blokiran = blokiran;
		this.brojPregleda = brojPregleda;
		this.datumKreiranja = datumKreiranja;
		this.korisnik = korisnik;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNaziv() {
		return naziv;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getOpis() {
		return opis;
	}



	public void setOpis(String opis) {
		this.opis = opis;
	}



	public boolean isDozvoljeniKomentari() {
		return dozvoljeniKomentari;
	}



	public void setDozvoljeniKomentari(boolean dozvoljeniKomentari) {
		this.dozvoljeniKomentari = dozvoljeniKomentari;
	}



	public boolean isVidljivostRejtinga() {
		return vidljivostRejtinga;
	}



	public void setVidljivostRejtinga(boolean vidljivostRejtinga) {
		this.vidljivostRejtinga = vidljivostRejtinga;
	}



	public boolean isBlokiran() {
		return blokiran;
	}



	public void setBlokiran(boolean blokiran) {
		this.blokiran = blokiran;
	}



	public int getBrojPregleda() {
		return brojPregleda;
	}



	public void setBrojPregleda(int brojPregleda) {
		this.brojPregleda = brojPregleda;
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



	@Override
	public String toString() {
		return "Video [id=" + id + ", naziv=" + naziv + ", url=" + url + ", opis=" + opis + ", dozvoljeniKomentari="
				+ dozvoljeniKomentari + ", vidljivostRejtinga=" + vidljivostRejtinga + ", blokiran=" + blokiran
				+ ", brojPregleda=" + brojPregleda + ", datumKreiranja=" + datumKreiranja + ", korisnik=" + korisnik
				+ "]";
	}
	
	


	


	
	
	
	
}
