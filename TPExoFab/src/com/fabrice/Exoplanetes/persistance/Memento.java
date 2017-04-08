package com.fabrice.Exoplanetes.persistance;

import java.util.LinkedHashMap;

public class Memento 
{
	private LinkedHashMap<Integer, ExoplaneteMemento> listeExoplanete;
	
	public Memento()
	{
		this.listeExoplanete = new LinkedHashMap<Integer, ExoplaneteMemento>();
	}
	
	public void ajouterMemento(Integer id, ExoplaneteMemento memento)
	{
		this.listeExoplanete.put(id, memento);
	}
	
	public LinkedHashMap<Integer, ExoplaneteMemento> getListeMemento()
	{
		return listeExoplanete;
	}

	public void setListeMemento(LinkedHashMap<Integer, ExoplaneteMemento> listeExoplanete) 
	{
		this.listeExoplanete = listeExoplanete;
	}
}
