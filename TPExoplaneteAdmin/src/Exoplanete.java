

public class Exoplanete {
	
	public Exoplanete(String planete, String etoile, String typeEtoile, String masse, String rayon, String flux,
			String temperature, String periode, String distance, String zone, String ist, String sph, String hzd,
			String hzc, String hza, String pClasse, String hClasse, String phi, String distance2, String status,
			String decouverte) {
		super();
		this.planete = planete;
		this.etoile = etoile;
		this.typeEtoile = typeEtoile;
		this.masse = masse;
		this.rayon = rayon;
		this.flux = flux;
		this.temperature = temperature;
		this.periode = periode;
		this.distance = distance;
		this.zone = zone;
		this.ist = Float.parseFloat(ist);
		this.sph = Float.parseFloat(sph);
		this.hzd = hzd;
		this.hzc = hzc;
		this.hza = hza;
		this.pClasse = pClasse;
		this.hClasse = hClasse;
		this.phi = Float.parseFloat(phi);
		this.distance2 = distance2;
		this.status = status;
		this.decouverte = decouverte;
	}
	
	public Exoplanete(int id,String planete, String etoile, String typeEtoile, String masse, String rayon, String flux,
			String temperature, String periode, String distance, String zone, String ist, String sph, String hzd,
			String hzc, String hza, String pClasse, String hClasse, String phi, String distance2, String status,
			String decouverte) {

	}
	
	public static final int NBR_DE_VAR = 21;

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
	protected Float ist;
	protected Float sph;
	protected String hzd;
	protected String hzc;
	protected String hza;
	protected String pClasse;
	protected String hClasse;
	protected Float phi;
	protected String distance2;
	protected String status;
	protected String decouverte;
	
	public static String getNomVar(int i)
	{
		String[] tab = new String[21];
		
		tab[0] = "Planete";
		tab[1] = "Etoile";
		tab[2] = "Type d'Etoile";
		tab[3] = "Masse";
		tab[4] = "Rayon";
		tab[5] = "flux";
		tab[6] = "Temperature";
		tab[7] = "Periode";
		tab[8] = "Distance";
		tab[9] = "Zone";
		tab[10] = "ist";
		tab[11] = "sph";
		tab[12] = "hzd";
		tab[13] = "hzc";
		tab[14] = "hza";
		tab[15] = "pClasse";
		tab[16] = "hClasse";
		tab[17] = "phi";
		tab[18] = "Distance 2";
		tab[19] = "Status";
		tab[20] = "Decouverte";
		
		return tab[i];
		
	}
	
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

	public Float getIst() {
		return ist;
	}

	public void setIst(Float ist) {
		this.ist = ist;
	}

	public Float getSph() {
		return sph;
	}

	public void setSph(Float sph) {
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

	public Float getPhi() {
		return phi;
	}

	public void setPhi(Float phi) {
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

	public Exoplanete(int id,String planete, String etoile, String typeEtoile, String masse, String rayon, String flux,
			String temperature, String periode, String distance, String zone, Float ist, Float sph, String hzd,
			String hzc, String hza, String pClasse, String hClasse, Float phi, String distance2, String status,
			String decouverte) {
		super();
		this.id = id;
		this.planete = planete;
		this.etoile = etoile;
		this.typeEtoile = typeEtoile;
		this.masse = masse;
		this.rayon = rayon;
		this.flux = flux;
		this.temperature = temperature;
		this.periode = periode;
		this.distance = distance;
		this.zone = zone;
		this.ist = ist;
		this.sph = sph;
		this.hzd = hzd;
		this.hzc = hzc;
		this.hza = hza;
		this.pClasse = pClasse;
		this.hClasse = hClasse;
		this.phi = phi;
		this.distance2 = distance2;
		this.status = status;
		this.decouverte = decouverte;
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
