package Class;

public class Joueur extends Vivant{
	private Piece piece;
	
	public Joueur(String Nom) {
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
			System.out.println("vous allez � l'est");
		}
		if (dest == 'O'){
			pos.setX(pos.getX()-1);
			System.out.println("vous allez � l'ouest");
		}
		pieceActuelle.setPos(pos);
		
	}
}

