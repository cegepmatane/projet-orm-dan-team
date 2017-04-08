package com.fabrice.Exoplanetes.persistance;

import com.fabrice.Exoplanetes.Exoplanete;

public class ExoplaneteMemento
{
	protected Exoplanete exoplanete;
	protected int id;

	public ExoplaneteMemento(Exoplanete exoplanete)
	{
		this.exoplanete = exoplanete;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Exoplanete getExoplanete()
	{
		return exoplanete;
	}
}
