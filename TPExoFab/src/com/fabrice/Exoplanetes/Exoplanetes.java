package com.fabrice.Exoplanetes;

import com.fabrice.Exoplanetes.vue.ControleurFenetrePrincipale;
import com.fabrice.Exoplanetes.vue.FenetrePricipale;

public class Exoplanetes 
{
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		FenetrePricipale fenetrePricipale = new FenetrePricipale();
		
		ControleurFenetrePrincipale controleurFenetrePrincipale = new ControleurFenetrePrincipale(fenetrePricipale);
	}
}
