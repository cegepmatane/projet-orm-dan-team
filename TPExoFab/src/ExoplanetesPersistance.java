import com.fabrice.Exoplanetes.Persistance.vue.ControleurFenetrePrincipale;
import com.fabrice.Exoplanetes.Persistance.vue.FenetrePricipale;

public class ExoplanetesPersistance 
{
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		FenetrePricipale fenetrePricipale = new FenetrePricipale();
		
		ControleurFenetrePrincipale controleurFenetrePrincipale = new ControleurFenetrePrincipale(fenetrePricipale);
		
		//controleurFenetrePrincipale.ecrireLogListeExoplanette();
	}
}
