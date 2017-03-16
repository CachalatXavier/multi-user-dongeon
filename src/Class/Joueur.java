package Class;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Joueur extends Vivant {
	private Piece piece;
	private Piece LastPosition ; 
	private String AlJoueur;
	private String AlMsg;
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
	
	public Joueur creationPersoJoueur(Joueur J, Piece piece1) {
		//Creation Personnage
		System.out.println("Bonjour comment s'appelle votre Personnage?");
		Scanner perso = new Scanner(System.in);
		  	String nom = perso.nextLine();
		  	System.out.println("Votre Personnage s'appelle: "+nom);
		  	
		  	System.out.println("Vous entrez maintenant dans le Donjon! \n"
		  			+ "Que la chance vous sourie aventurier....");
		
			J.setNom(nom);
			J.setPdv(10);
			
			J.setPiece(piece1);
		  	return J;
	}
	public Joueur MAJjoueurPos(Joueur j , char direction , Piece NewPiece , interfaceObjetSeDeplacer i){
		Piece oldPiece = j.getPiece();
		j.setLastPosition(oldPiece); 		
		j.setPiece(NewPiece);
		Piece p1 = j.getPiece();
		p1.addJoueur(j);
		oldPiece.delJoueur(j);
		try {
			i.miseAJourPosition(j, NewPiece, oldPiece);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int k = 0; k<p1.getListJoueur().size();k++){
			if (p1.getListJoueur().get(k)!= j){
				System.out.println(p1.getListJoueur().get(k).getNom()+" est dans la pièce");
			}
		}
		
		return j;
	}
	public Joueur Fuir (Joueur j , interfaceObjetSeDeplacer i ){
		
		j.getPiece().delJoueur(j); //Suppression du joueur de l'array joueur de l'ancienne piece
		Piece p = j.getPiece();
		j.setPiece(getLastPosition());
		j.setLastPosition(p);
		j.getPiece().addJoueur(j);//Ajout du joueur dans l'array joueur de la nouvelle piece
		return j ; 
	}
}

