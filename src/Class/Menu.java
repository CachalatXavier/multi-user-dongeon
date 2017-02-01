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
		  	
		  	 J =J.creationPersoJoueur(J);
	     	 return J;      		 
	  }
	  
	  else {
		      return null; 
	  }		
	}
	public void Menu2(ArrayList<String> direction, Joueur J){
		 System.out.println("                                  ");
		 System.out.println("vous pouvez aller au " + direction );
		 Scanner sc = new Scanner(System.in);
		 String str = sc.nextLine();
		 char choixdirection =str.charAt(0);
		 if (choixdirection == 'S'){
			 System.out.println("vous pouvez aller au Sud" );
		 }
		 if (choixdirection == 'N'){
			 System.out.println("vous pouvez aller au Nord" );
		 }
		 if (choixdirection == 'E'){
			 System.out.println("vous pouvez aller a l'Est" );
		 }
		 if (choixdirection == 'O'){
			 System.out.println("vous pouvez aller a l'Ouest" );
			 
		 }
		 System.out.println("Aventurier, dans quelle direction voulez vous aller?  " +direction);
		 
		 J.MAJjoueurPos(J, choixdirection);
		 
	}
		
	
	
}
