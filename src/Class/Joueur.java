package Class;

public class Joueur {
	private int vie;
	private String nom ; 
	private Position pos;
	
	public Joueur( String nom){
		this.nom= nom; 
		this.pos = new Position(1,1);
		this.vie = 10; 
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
	
}

