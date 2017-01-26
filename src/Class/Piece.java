package Class;

import java.util.ArrayList;

public class Piece {
	private Position pos ;
	private ArrayList<Joueur> listJoueur = new ArrayList<Joueur>(); 
	private ArrayList<Monstre> Monstre = new ArrayList<Monstre>();
	private int id; 
	public Piece(Position pos, int id,ArrayList<Monstre> monstre) {
		super();
		this.id = id; 
		this.pos = pos;
		Monstre = monstre;
	}
	public Piece(Position pos , int id ){
		super();
		this.id = id;
		this.pos = pos;
	}
	
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public ArrayList<Joueur> getListJoueur() {
		return listJoueur;
	}
	public void setListJoueur(ArrayList<Joueur> listJoueur) {
		this.listJoueur = listJoueur;
	}
	public ArrayList<Monstre> getMonstre() {
		return Monstre;
	}
	public void setMonstre(ArrayList<Monstre> monstre) {
		Monstre = monstre;
	} 
	
}
