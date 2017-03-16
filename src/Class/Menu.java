package Class;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Joueur Menu1(Joueur J , interfaceObjetSeDeplacer I) {
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
	  System.out.println("  **** Donjon et Dragon ****     ");
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
	  		+ "1) Continuer l'aventure! \n"
	  		+ "2) Créer un Personnage \n"
	  		+ "3) Quitter \n");
	  Scanner menu = new Scanner(System.in);
	  int i = menu.nextInt();
	  
	  if (i == 2){
				try {
					J =J.creationPersoJoueur(J,I.getPiece1());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	     	 return J;      		 
	  }
	  
	  else {
		      return null; 
	  }		
	}
	public void Menu2(ArrayList<Porte> direction, Joueur J , interfaceObjetSeDeplacer interf, interfaceObjetDiscussion D){
		 int i ; 
		 ArrayList<String> renvoiedirection = new ArrayList<String>();
		 ArrayList<Piece> renvoieID = new ArrayList<Piece>();
		
		for (i = 0 ;  i < direction.size();i++){
			if (direction.get(i).getPiece1().getId()==J.getPiece().getId()){
				
				
				if (direction.get(i).getPos1()=='N'){
					renvoiedirection.add("N");
					renvoieID.add(direction.get(i).getPiece2());
				//	System.out.println("check N");
				}
					 
				if (direction.get(i).getPos1()=='S'){
					renvoiedirection.add("S");
				
					renvoieID.add(direction.get(i).getPiece2());
				//	System.out.println("check S");
				}
				if (direction.get(i).getPos1()=='O'){
					renvoiedirection.add("O");
					renvoieID.add(direction.get(i).getPiece2());
				//	System.out.println("check O");
				}
				if (direction.get(i).getPos1()=='E'){
					renvoiedirection.add("E");
					renvoieID.add(direction.get(i).getPiece2());
				//	System.out.println("check E");
				}
			}
			if (direction.get(i).getPiece2().getId()==J.getPiece().getId()){
				if (direction.get(i).getPos2()=='N'){
					renvoiedirection.add("N");
					renvoieID.add(direction.get(i).getPiece1());
				
				}
				if (direction.get(i).getPos2()=='S'){
					renvoiedirection.add("S");
					renvoieID.add(direction.get(i).getPiece1());
				//	System.out.println("check S");
				}
				if (direction.get(i).getPos2()=='O'){
					renvoiedirection.add("O");
					renvoieID.add(direction.get(i).getPiece1());
				//	System.out.println("check O");
				}
				if (direction.get(i).getPos2()=='E'){
					renvoiedirection.add("E");
					renvoieID.add(direction.get(i).getPiece1());
			
				}
			}	
		}
		
		 System.out.println("                                  ");
		 System.out.println("vous pouvez aller au " + renvoiedirection );
		 System.out.println("Aventurier, dans quelle direction voulez vous aller?  ");
		 
		 int index = 0 ; Piece Npiece = null; 
		 Scanner sc = new Scanner(System.in);
		 String str = sc.nextLine();
		 char choixdirection =str.charAt(0);
		 if (choixdirection == '"'){
			tchat(sc, J, D); 
		 }
		 if (choixdirection == 'S'){
			 System.out.println("vous allez au Sud" );
			 index = renvoiedirection.indexOf("S");
			 Npiece = renvoieID.get(index);
			 J.MAJjoueurPos(J, choixdirection,Npiece , interf );
		 }
		 if (choixdirection == 'N'){
			 System.out.println("vous allez au Nord" );
			 index = renvoiedirection.indexOf("N");
			 Npiece = renvoieID.get(index);
			 J.MAJjoueurPos(J, choixdirection,Npiece , interf );
		 }
		 if (choixdirection == 'E'){
			 System.out.println("vous allez a l'Est" );
			 index = renvoiedirection.indexOf("E");
			
			 Npiece = renvoieID.get(index);
			 J.MAJjoueurPos(J, choixdirection,Npiece , interf );
		 }
		  if (choixdirection == 'O'){
			 System.out.println("vous allez a l'Ouest" );
			 index = renvoiedirection.indexOf("O");
			 Npiece = renvoieID.get(index);
			 J.MAJjoueurPos(J, choixdirection,Npiece , interf ); 
		 }		 
		 
	}
	
	public void tchat (Scanner scan, Joueur J, interfaceObjetDiscussion Ch){
	try{
		String string = scan.nextLine();
		String s;
		Message msg = new Message(J, string, J.getPiece());
		s = Ch.receiveMsg(msg, J, J.getPiece());		
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 		
	}
		
		
}
		
	

