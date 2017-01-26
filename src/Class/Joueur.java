package Class;

public class Joueur {
	private int vie;
	private String nom ; 
	private Position lastpos;
	
	public Joueur( String nom){
		this.nom= nom; 
		this.lastpos = new Position(1,1);
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

	public Position lastPos() {
		return lastpos;
	}

	public void lastPos(Position pos) {
		this.lastpos = pos;
	}
	
	public void seDeplacer(String direction){
		
	}
	
}

