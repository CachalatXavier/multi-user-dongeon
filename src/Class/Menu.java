package Class;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Joueur Menu1(Joueur J) {
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
		  	Joueur joueur = new Joueur();
		  	 J = joueur.creationPersoJoueur();
	     	 return J;      		 
	  }
	  
	  else {
		      return null; 
	  }		
	}
	public void Menu2(ArrayList<String> direction){
		 System.out.println("                                  ");
		 System.out.println("vous pouvez aller au " + direction );
		 Scanner menu = new Scanner(System.in);
		 String i = menu.toString();
		 if (i == "S"){
			 System.out.println("vous pouvez aller au Sud" );
		 }
		 if (i == "N"){
			 System.out.println("vous pouvez aller au Nord" );
		 }
		 if (i == "E"){
			 System.out.println("vous pouvez aller a l'Est" );
		 }
		 if (i == "O"){
			 System.out.println("vous pouvez aller a l'Ouest" );
		 }
	}
	
	
}
