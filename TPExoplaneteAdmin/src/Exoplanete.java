

public class Exoplanete {
	
	protected int id;
	protected String planete;
	protected String etoile;
	protected String typeEtoile;
	protected String masse;
	protected String rayon;
	protected String flux;
	protected String temperature;
	protected String periode;
	protected String distance;
	protected String zone;
	protected float ist;
	protected float sph;
	protected String hzd;
	protected String hzc;
	protected String hza;
	protected String pClasse;
	protected String hClasse;
	protected float phi;
	protected String distance2;
	protected String status;
	protected String decouverte;
	
	public String getTypeEtoile() {
		return typeEtoile;
	}

	public void setTypeEtoile(String typeEtoile) {
		this.typeEtoile = typeEtoile;
	}

	public String getMasse() {
		return masse;
	}

	public void setMasse(String masse) {
		this.masse = masse;
	}

	public String getRayon() {
		return rayon;
	}

	public void setRayon(String rayon) {
		this.rayon = rayon;
	}

	public String getFlux() {
		return flux;
	}

	public void setFlux(String flux) {
		this.flux = flux;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public float getIst() {
		return ist;
	}

	public void setIst(float ist) {
		this.ist = ist;
	}

	public float getSph() {
		return sph;
	}

	public void setSph(float sph) {
		this.sph = sph;
	}

	public String getHzd() {
		return hzd;
	}

	public void setHzd(String hzd) {
		this.hzd = hzd;
	}

	public String getHzc() {
		return hzc;
	}

	public void setHzc(String hzc) {
		this.hzc = hzc;
	}

	public String getHza() {
		return hza;
	}

	public void setHza(String hza) {
		this.hza = hza;
	}

	public String getpClasse() {
		return pClasse;
	}

	public void setpClasse(String pClasse) {
		this.pClasse = pClasse;
	}

	public String gethClasse() {
		return hClasse;
	}

	public void sethClasse(String hClasse) {
		this.hClasse = hClasse;
	}

	public float getPhi() {
		return phi;
	}

	public void setPhi(float phi) {
		this.phi = phi;
	}

	public String getDistance2() {
		return distance2;
	}

	public void setDistance2(String distance2) {
		this.distance2 = distance2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDecouverte() {
		return decouverte;
	}

	public void setDecouverte(String decouverte) {
		this.decouverte = decouverte;
	}

	public Exoplanete() {
		super();
		this.id = 0;
		this.planete = "";
		this.etoile = "";
	}
	
	public Exoplanete(String planete, String etoile) {
		super();
		this.id = 0;
		this.planete = planete;
		this.etoile = etoile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanete() {
		return planete;
	}

	public void setPlanete(String planete) {
		this.planete = planete;
	}

	public String getEtoile() {
		return etoile;
	}

	public void setEtoile(String etoile) {
		this.etoile = etoile;
	}


}
