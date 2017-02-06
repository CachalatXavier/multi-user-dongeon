package Class;

import java.util.ArrayList;
import java.util.List;
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
	public void Menu2(ArrayList<Porte> direction, Joueur J){
		 int i ; 
		 ArrayList<String> renvoiedirection = new ArrayList<String>();
		 List<Integer> renvoieID = new ArrayList<Integer>();
		
		for (i = 0 ;  i < direction.size();i++){
			if (direction.get(i).getPiece1().getId()==J.getPiece().getId()){
				
				
				if (direction.get(i).getPos1()=='N'){
					renvoiedirection.add("N");
					renvoieID.add(direction.get(i).getPiece2().getId());
					System.out.println("check N");
				}
					
				if (direction.get(i).getPos1()=='S'){
					renvoiedirection.add("S");
					renvoieID.add(direction.get(i).getPiece2().getId());
					System.out.println("check S");
				}
				if (direction.get(i).getPos1()=='O'){
					renvoiedirection.add("O");
					renvoieID.add(direction.get(i).getPiece2().getId());
					System.out.println("check O");
				}
				if (direction.get(i).getPos1()=='E'){
					renvoiedirection.add("E");
					renvoieID.add(direction.get(i).getPiece2().getId());
					System.out.println("check E");
				}
			}
			if (direction.get(i).getPiece2().getId()==J.getPiece().getId()){
				if (direction.get(i).getPos2()=='N'){
					renvoiedirection.add("N");
					renvoieID.add(direction.get(i).getPiece1().getId());
					System.out.println(direction.get(i).getPiece1().getId());
				}
				if (direction.get(i).getPos2()=='S'){
					renvoiedirection.add("S");
					renvoieID.add(direction.get(i).getPiece1().getId());
					System.out.println("check S");
				}
				if (direction.get(i).getPos2()=='O'){
					renvoiedirection.add("O");
					renvoieID.add(direction.get(i).getPiece1().getId());
					System.out.println("check O");
				}
				if (direction.get(i).getPos2()=='E'){
					renvoiedirection.add("E");
					renvoieID.add(direction.get(i).getPiece1().getId());
					System.out.println("check E");
				}
			}	
		}
		
		 System.out.println("                                  ");
		 System.out.println("vous pouvez aller au " + renvoiedirection );
		 System.out.println("Aventurier, dans quelle direction voulez vous aller?  ");
		 
		 int ID ;
		 Scanner sc = new Scanner(System.in);
		 String str = sc.nextLine();
		 char choixdirection =str.charAt(0);
		 if (choixdirection == 'S'){
			 System.out.println("vous aller au Sud" );
			 ID = renvoiedirection.indexOf("S");
			 ID = renvoieID.get(ID);
			 J.MAJjoueurPos(J, choixdirection,ID);
		 }
		 if (choixdirection == 'N'){
			 System.out.println("vous aller au Nord" );
			 ID = renvoiedirection.indexOf("N");
			 ID = renvoieID.get(ID);
			 J.MAJjoueurPos(J, choixdirection,ID);
		 }
		 if (choixdirection == 'E'){
			 System.out.println("vous aller a l'Est" );
			 ID = renvoiedirection.indexOf("E");
			 ID = renvoieID.get(ID);
			 J.MAJjoueurPos(J, choixdirection,ID);
		 }
		 if (choixdirection == 'O'){
			 System.out.println("vous aller a l'Ouest" );
			 ID = renvoiedirection.indexOf("O");
			 ID = renvoieID.get(ID);
			 J.MAJjoueurPos(J, choixdirection,ID); 
		 }
		 
		 
	}
		
}
		
	

