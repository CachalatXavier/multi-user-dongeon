package Class;
import java.net.ServerSocket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Scanner;

public class Serveur {

<<<<<<< HEAD
	public static void main(String[] args) throws Exception {
=======
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
		  
		  if (i == 1){
		    	
		      	Joueur joueur1 = creationPerso();			      	
		      	Labyrinthe labyrinthe1 = CreationLabyrinthe();
		      	joueur1.setPiece(labyrinthe1.Donjon.get(0));
		      	
		      	
		      	
		  }
		  
	//	  else {
			      //Quitter le programme			  
		    
		      /*Action*/;
		//  }
		  		  		  
	}

	public static Joueur creationPerso(){
		//Creation Personnage
		System.out.println("Bonjour comment s'appelle votre Personnage?");
		Scanner perso = new Scanner(System.in);
		  	String nom = perso.nextLine();
		  	System.out.println("Votre Personnage s'appelle: "+nom);
		  	
		  	System.out.println("Vous entrez maintenant dans le Donjon! \n"
		  			+ "Que la chance vous sourie aventurier....");
		  	Joueur joueur1 = new Joueur (nom);
		  	return joueur1;
	}
	
	public static Labyrinthe CreationLabyrinthe(){
		ArrayList Donjon = new ArrayList<Piece>(); 
		Labyrinthe labyrinthe1 = new Labyrinthe(Donjon);
		Position p1 =new Position (3,0);
		Piece piece1= new Piece(p1,0);
		labyrinthe1.Donjon.add(piece1);
>>>>>>> origin/master
		
			LocateRegistry.createRegistry(1099);
			
			Vivant j = new Vivant();
			Naming.bind("serveurseDeplacer", j);
			System.out.println("server seDeplacer déclarer");
			
			/*
		   	Labyrinthe labyrinthe1 = new Labyrinthe();
		   	Labyrinthe.CreationLabyrinthe();
	      	// joueur1.setPiece(labyrinthe1.Donjon.get(0));	*/  
	      	
	      	
	}
	
}
