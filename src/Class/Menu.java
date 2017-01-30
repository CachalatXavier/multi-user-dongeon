package Class;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Menu {

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Joueur Menu1() {
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
	  
	  if (i == 1){
		  	Joueur J = new Joueur();
		  	 J.creationPersoJoueur();
		  	System.out.println(J.getNom());
	     	 return J;      		 
	  }
	  
	  else {
		      return null; 
	  }		
	}
	
	
}
