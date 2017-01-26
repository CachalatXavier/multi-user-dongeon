package Class;

public class Joueur extends Vivant{
	private Position lastpos;
	
	public Joueur(String Nom) {
		super(Nom,10);

		this.lastpos = lastpos; 
	}

	public Position getLastpos() {
		return lastpos;
	}

	public void setLastpos(Position lastpos) {
		this.lastpos = lastpos;
	}
	
	public void seDeplacer(String dest){
		Piece pieceActuelle = this.getPiece();
		
	}
}

