package Class;

public class Joueur extends Vivant{
	private Position lastpos;
	
	public Joueur(String Nom) {
		super(Nom,10);
		// TODO Auto-generated constructor stub
		this.lastpos = lastpos; 
	}

	public Position getLastpos() {
		return lastpos;
	}

	public void setLastpos(Position lastpos) {
		this.lastpos = lastpos;
	}

	
}

