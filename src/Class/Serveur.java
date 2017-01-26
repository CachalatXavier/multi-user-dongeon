package Class;
import java.net.ServerSocket;
import java.util.Scanner;

public class Serveur {

	public static void main(String[] args) {
		  System.out.println("               *                  ");
		  System.out.println("              ***                 ");
		  System.out.println("            *******               ");
		  System.out.println("          ***********             ");
		  System.out.println("        ***************           ");
		  System.out.println("      *******************         ");
		  System.out.println("    ***********************       ");
		  System.out.println("  ***************************     ");
		  System.out.println("  ***************************     ");
		  System.out.println("  ****                   ****     ");
		  System.out.println("  **** Dungeon et Dragon ****     ");
		  System.out.println("  ****                   ****     ");
		  System.out.println("  ***************************     ");
		  System.out.println("    ***********************       ");
		  System.out.println("      *******************         ");
		  System.out.println("        ***************           ");
		  System.out.println("          ***********             ");
		  System.out.println("            *******               ");
		  System.out.println("              ***                 ");
		  System.out.println("               *                  ");
		  System.out.println("                                  ");
		  System.out.println("                                  ");
		  
		  System.out.println("Bonjour que voulez faire ?\n"
		  		+ "1) Créer un Personnage \n"
		  		+ "2) Quitter \n");
		  Scanner menu = new Scanner(System.in);
		  int i = menu.nextInt();
		  switch (i)
		  {
		    case 1:
		      //Creation Personnage
		    		System.out.println("Bonjour comment s'apelle votre Personnage?");
		    		Scanner perso = new Scanner(System.in);
		  		  	String nom = perso.nextLine();
		  		  	System.out.println("Votre Personnage s'apelle: "+nom);
		  		  	Joueur joueur1 = new Joueur (nom);
		  		  	
		  		  	System.out.println("Vous entrez maintenant dans le Donjon! \n"
		  		  			+ "Que la chance vous sourie aventurier....");
		  		  	
		  		  	joueur1.setPiece(piece1);

		    break;
		    case 2:
			      //Quitter le programme
			      break;
		    default:
		      /*Action*/;
		  }
		  
		  
	}

}
