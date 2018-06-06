package dto;

import java.util.Date;

import model.Video;

public class VideoDTO {
	private int id;
	private String naziv;
	private String url;
	private String opis;
	private boolean dozvoljeniKomentari;
	private boolean vidljivostRejtinga;
	private boolean blokiran;
	private int brojPregleda;
	private Date datumKreiranja;
	private String korisnikUsername;
	
	public VideoDTO() {}
	
	public VideoDTO(Video video) {
		this.id = video.getId();
		this.naziv = video.getNaziv();
		this.url = video.getUrl();
		this.opis = video.getOpis();
		this.dozvoljeniKomentari = video.isDozvoljeniKomentari();
		this.vidljivostRejtinga = video.isVidljivostRejtinga();
		this.blokiran = video.isBlokiran();
		this.brojPregleda = video.getBrojPregleda();
		this.datumKreiranja = video.getDatumKreiranja();
		this.korisnikUsername = video.getKorisnik().getUsername();
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

	public String getKorisnikUsername() {
		return korisnikUsername;
	}

	public void setKorisnikUsername(String korisnikUsername) {
		this.korisnikUsername = korisnikUsername;
	}


	
	
}
