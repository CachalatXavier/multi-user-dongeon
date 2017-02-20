package Class;

import java.util.Scanner;

public class Joueur extends Vivant {
	private Piece piece;
	private Piece LastPosition ; 
	private AlerteMsg alerteMsg;
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
	public AlerteMsg getAlerteMsg(){
		return alerteMsg;
	}
	public void setAlertMsg(String joueur, String msg){
		alerteMsg.setMsg(joueur, msg);
		System.out.print(joueur + " : " + msg);
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
			
			J.setPiece(piece1);
		  	return J;
	}
	public Joueur MAJjoueurPos(Joueur j , char direction , Piece NewPiece , interfaceObjetSeDeplacer i){
		j.setLastPosition(j.getPiece()); 
		j.getPiece().delJoueur(j, getPiece() , i);//Suppression du joueur de l'array joueur de l'ancienne piece
		j.setPiece(NewPiece);
		//j.seDeplacer(direction);
		j.getPiece().addJoueur(j, getPiece(), i);//Ajout du joueur dans l'array joueur de la nouvelle piece
		return j;
	}
	public Joueur Fuir (Joueur j , interfaceObjetSeDeplacer i ){
		
		j.getPiece().delJoueur(j, getPiece() , i); //Suppression du joueur de l'array joueur de l'ancienne piece
		Piece p = j.getPiece();
		j.setPiece(getLastPosition());
		j.setLastPosition(p);
		j.getPiece().addJoueur(j, getPiece() , i);//Ajout du joueur dans l'array joueur de la nouvelle piece
		return j ; 
	}
}

