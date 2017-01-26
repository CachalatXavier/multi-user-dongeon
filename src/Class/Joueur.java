package Class;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Joueur extends Vivant {
	private Piece piece;

	
	public Joueur(String Nom) throws RemoteException {
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
	public Joueur creationPerso(){
		//Creation Personnage
		System.out.println("Bonjour comment s'appelle votre Personnage?");
		Scanner perso = new Scanner(System.in);
		  	String nom = perso.nextLine();
		  	System.out.println("Votre Personnage s'appelle: "+nom);
		  	
		  	System.out.println("Vous entrez maintenant dans le Donjon! \n"
		  			+ "Que la chance vous sourie aventurier....");
		  	Joueur joueur1 = null;
			try {
				joueur1 = new Joueur(nom);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	return joueur1;
	}
}

