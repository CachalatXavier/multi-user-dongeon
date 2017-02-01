package Class;

import java.util.Scanner;

public class Joueur extends Vivant {
	private Piece piece;
	private Piece LastPosition ; 
	public Joueur(){
		
	}
	public Joueur(String Nom)  {
		super(Nom,10);
		this.piece = piece; 
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

	public void seDeplacer(char dest){
		Piece pieceActuelle = this.getPiece();
		Position pos = new Position(pieceActuelle.getPos().getX(),pieceActuelle.getPos().getY());
		if (dest == 'N'){
			pos.setY(pos.getY()-1);
			System.out.println("vous allez au Nord");
		}
		if (dest == 'S'){
			pos.setY(pos.getY()+1);
			System.out.println("vous allez au Sud");
		}
		if (dest == 'E'){
			pos.setX(pos.getX()+1);
			System.out.println("vous allez � l'est");
		}
		if (dest == 'O'){
			pos.setX(pos.getX()-1);
			System.out.println("vous allez � l'ouest");
		}
		pieceActuelle.setPos(pos);
		
	}
	public Joueur creationPersoJoueur(Joueur J) {
		//Creation Personnage
		System.out.println("Bonjour comment s'appelle votre Personnage?");
		Scanner perso = new Scanner(System.in);
		  	String nom = perso.nextLine();
		  	System.out.println("Votre Personnage s'appelle: "+nom);
		  	
		  	System.out.println("Vous entrez maintenant dans le Donjon! \n"
		  			+ "Que la chance vous sourie aventurier....");
		
			J.setNom(nom);
			Position pos1 = new Position(3,0);
			Piece Piece1 = new Piece(pos1,1);
			J.setPiece(Piece1);
		  	return J;
	}
	public Joueur MAJjoueurPos(Joueur j , char direction ){
		j.LastPosition=j.getPiece();
		j.getPiece().delJoueur(j, getPiece());//Supression du joueur de l'array joueur de l'ancienne piece
		j.seDeplacer(direction);
		j.getPiece().addJoueur(j, getPiece());//Ajout du joueur dans l'array joueur de la nouvelle piece
		return j;
	}
}

