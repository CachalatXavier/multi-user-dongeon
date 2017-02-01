package Class;

import java.util.Scanner;

public class Joueur extends Vivant {
	private Piece piece;

	public Joueur(){
		
	}
	public Joueur(String Nom)  {
		super(Nom,10);
		this.piece = piece; 
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
			System.out.println("vous allez à l'est");
		}
		if (dest == 'O'){
			pos.setX(pos.getX()-1);
			System.out.println("vous allez à l'ouest");
		}
		pieceActuelle.setPos(pos);
		
	}
	public Joueur creationPersoJoueur() {
		//Creation Personnage
		System.out.println("Bonjour comment s'appelle votre Personnage?");
		Scanner perso = new Scanner(System.in);
		  	String nom = perso.nextLine();
		  	System.out.println("Votre Personnage s'appelle: "+nom);
		  	
		  	System.out.println("Vous entrez maintenant dans le Donjon! \n"
		  			+ "Que la chance vous sourie aventurier....");
		  	Joueur joueur1 = new Joueur();
			joueur1.setNom(nom);
			Position pos1 = new Position(3,0);
			Piece Piece1 = new Piece(pos1,1);
			joueur1.setPiece(Piece1);
		  	return joueur1;
	}
}

