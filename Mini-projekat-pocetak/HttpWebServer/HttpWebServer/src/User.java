
public class User {
	private int broj;
	private String ime;
	private String prezime;
	private String sprema;
	private String zanimanje;
	private int godiste;
	private Boolean odobreno;
	
	
	public User() {
		
	}
	
	
	public User(int broj, String ime, String prezime, String sprema, String zanimanje, int godiste) {
		super();
		this.broj = broj;
		this.ime = ime;
		this.prezime = prezime;
		this.sprema = sprema;
		this.zanimanje = zanimanje;
		this.godiste = godiste;
		this.odobreno = false;
	}

	public Boolean getOdobreno(){
		return odobreno;
	}
	public void setOdobreno(Boolean value) {
		this.odobreno = value;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
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
	public String getSprema() {
		return sprema;
	}
	public void setSprema(String sprema) {
		this.sprema = sprema;
	}
	public String getZanimanje() {
		return zanimanje;
	}
	public void setZanimanje(String zanimanje) {
		this.zanimanje = zanimanje;
	}
	public int getGodiste() {
		return godiste;
	}
	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}
	
}
