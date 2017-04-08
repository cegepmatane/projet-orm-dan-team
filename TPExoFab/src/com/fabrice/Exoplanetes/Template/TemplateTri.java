package com.fabrice.Exoplanetes.Template;


import com.fabrice.Exoplanetes.Exoplanete;

public abstract class TemplateTri 
{
	protected Exoplanete[] listePlanetes;
	
	public TemplateTri(Exoplanete[] planetes)
	{
		this.listePlanetes = planetes;
	}
	
	public void afficherDonneeOriginales()
	{
		System.out.print("Données original : ");
		for (Exoplanete planete : this.listePlanetes) 
		{
			System.out.print(planete + " ");
		}
		System.out.println(" ");
	}
	
	protected void trierHabitable()
	{
		
	}
	
	protected void trierAtteignable()
	{
		
	}
	
	protected void trierAnalysable()
	{
		
	}
	
	public void afficherDonneeTriees()
	{
		System.out.print("Données triées : ");
		for (Exoplanete planete : this.listePlanetes) 
		{
			System.out.print(planete + " ");
		}
		System.out.println(" ");
	}
	
	/*public void executer()
	{
		this.afficherDonneeOriginales();
		this.trier();
		this.afficherDonneeTriees();
	}*/
}
