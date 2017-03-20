package Class;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
private interfaceObjetPersistance Log;
String test;
ArrayList<String> Perso;
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Joueur Menu1(Joueur J , interfaceObjetSeDeplacer I) throws RemoteException {
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
	  
	  if (i == 1){
		  //ServeurPeristance object
		 try {
			Log=(interfaceObjetPersistance)Naming.lookup("//localhost/ServeurPersistance");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		System.out.println("Bonjour comment s'appelle votre Personnage?");
		Scanner perso = new Scanner(System.in);
		String nom = perso.nextLine();
		System.out.println("Veuillez Rentrer votre Mot de Passe");
		String mdp = perso.nextLine();
		while(test==null){
			test=Log.Identification(nom,mdp);
		  }
	  	Perso=Log.lecture(test);
	  	
	  	//Recherche de la piece
	  	for (i = 0 ; I.getSize()> i ; i++)
		{
	  		if(I.getPiece(i).getId()==Integer.parseInt(Perso.get(4))){
	  			
	  		//Creation du joueur
	  		  	J.setNom(Perso.get(0));	
	  		  	J.setPdv(Integer.parseInt(Perso.get(1)));
	  		  	J.setPiece(I.getPiece(i));
	  		}
		}
		  return J;
}
	  
	  
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
	private void While(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void Menu2(ArrayList<Porte> direction, Joueur J , interfaceObjetSeDeplacer interf, interfaceObjetDiscussion D){
		 int i ; 
		 ArrayList<String> renvoiedirection = new ArrayList<String>();
		 ArrayList<Piece> renvoieID = new ArrayList<Piece>();
		// detection des portes disponible de la piece sur le 1er attribut
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
			// detection des portes disponible de la piece sur le 2nd attribut
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
		
		try {
			Log=(interfaceObjetPersistance)Naming.lookup("//localhost/ServeurPersistance");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//MAJ position du Joueur dans le ficheri de Persitance
		try {
			Log.EcrireMAJ(J.getNom(), J.getPdv(), J.getPiece().getPos().getX(),J.getPiece().getPos().getY(), J.getPiece().getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 System.out.println("                                  ");
		 System.out.println("vous pouvez aller au " + renvoiedirection );
		 System.out.println("Aventurier, dans quelle direction voulez vous aller?  ");
		 
		 int index = 0 ; Piece Npiece = null; 
		 Scanner sc = new Scanner(System.in);
		 String str = sc.nextLine();
		 char choixdirection =str.charAt(0);
		 // detection du tchat
		 if (choixdirection == '"'){
			tchat(sc, J, D); 
		// choix de la direction
		 }
		 if (choixdirection == 'S'){
			 System.out.println("vous allez au Sud" );
			 index = renvoiedirection.indexOf("S"); 
			 Npiece = renvoieID.get(index); // recuperation ID new piece
			 J.MAJjoueurPos(J, choixdirection,Npiece , interf );// mise a jour de la postion
			
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
			 
		 } // test erreur
		  if((choixdirection != 'O')&&(choixdirection != 'E')&&(choixdirection != 'S')&&(choixdirection != 'N')&&(choixdirection != '"')){
			  System.out.println("Vous vous perdez dans la forêt des monstres, attention!");
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
		
	

