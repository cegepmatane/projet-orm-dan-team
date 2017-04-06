package com.fabrice.Exoplanetes.Persistance;


public class Exoplanete 
{
	protected int id;
	protected String planete;
	protected String etoile;
	
	public Exoplanete() 
	{
		super();
		this.id = 0;
		this.planete = "";
		this.etoile = "";
	}
	
	public Exoplanete(String planete, String etoile) 
	{
		super();
		this.id = 0;
		this.planete = planete;
		this.etoile = etoile;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getPlanete() 
	{
		return planete;
	}

	public void setPlanete(String planete) 
	{
		this.planete = planete;
	}

	public String getEtoile() 
	{
		return etoile;
	}

	public void setEtoile(String etoile) 
	{
		this.etoile = etoile;
	}
}

