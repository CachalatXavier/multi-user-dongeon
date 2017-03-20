package Class;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Joueur extends Vivant {
	private Piece piece;
	private Piece LastPosition ; 
	private String AlJoueur;
	private String AlMsg;
	private interfaceObjetPersistance l;
	public Joueur(){
		
	}
	public Joueur(String Nom)  {
		super(Nom,10);
		this.piece = piece; 
		this.LastPosition = LastPosition ;
	}

	public Piece getLastPosition() {
		return LastPosition;
	}
	public void setLastPosition(Piece lastPosition) {
		LastPosition = lastPosition;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}	
	
	public Joueur creationPersoJoueur(Joueur J, Piece piece1) { // création d'un joueur avec les attribut de base 
		//Creation Personnage
		System.out.println("Bonjour comment s'appelle votre Personnage?");
		Scanner perso = new Scanner(System.in);
		  	String nom = perso.nextLine();
		  	System.out.println("Votre Personnage s'appelle: "+nom);
		  	System.out.println("Veuillez rentrer le mot de passe de votre personnage: ");
		  	String mdp = perso.nextLine();
		  	//Ajout dans la BD de connexion
		  	
		  	try {
				l=(interfaceObjetPersistance)Naming.lookup("//localhost/ServeurPersistance");
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  	
		  	try {
				l.AjoutConnexion(nom, mdp);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	//Creation du fichier
			try {
				l.EcrireCreation(nom);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	
		  	System.out.println("Vous entrez maintenant dans le Donjon! \n"
		  			+ "Que la chance vous sourie aventurier....");
		
			J.setNom(nom);
			J.setPdv(10);
			J.setPiece(piece1);
			
		  	return J;
	}
	public Joueur MAJjoueurPos(Joueur j , char direction , Piece NewPiece , interfaceObjetSeDeplacer i){
		Piece oldPiece = j.getPiece(); 	// mise a jour de la piece du joueur
		j.setLastPosition(oldPiece); 		
		j.setPiece(NewPiece);

		try {
			i.miseAJourPosition(j, NewPiece, oldPiece);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int k = 0; k<NewPiece.getListJoueur().size();k++){
			if (NewPiece.getListJoueur().get(k)!= j.getNom()){
				System.out.println(NewPiece.getListJoueur().get(k)+" est dans la pièce");
			}
		}
		
		return j;
	}
	public Joueur Fuir (Joueur j , interfaceObjetSeDeplacer i ){
		// mise a jour de la piece du jour lorsqu'il fuit 
		Piece oldPiece = j.getPiece();
		Piece newPiece = j.getLastPosition(); 
		j.setLastPosition(oldPiece);
		j.setPiece(newPiece);
		
		try {
			i.miseAJourPosition(j, newPiece, oldPiece);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return j ; 
	}
}

