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
		Posion pos = new pos(pieceActuelle.getPos().getX(),pieceActuelle.get);
		if (dest == 'N'){
			
			pieceActuelle.getPos(); 
			pieceActuelle.setPos();
		}
	}
}

