package Class;

import java.io.Serializable;
import java.util.ArrayList;

public class Piece implements Serializable{
	private Position pos ;
	private ArrayList<Joueur> listJoueur = new ArrayList<Joueur>(); 
	private ArrayList<Monstre> Monstre = new ArrayList<Monstre>();
	private ArrayList<Porte> Porte = new ArrayList<Porte>();
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
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public ArrayList<Porte> getPorte() {
		return Porte;
	}
	public void setPorte(ArrayList<Porte> porte) {
		Porte = porte;
	} 
	public Piece ajoutPorte(Piece piece,Porte p){
		ArrayList<Porte> liste = new ArrayList<Porte>();
		liste = piece.getPorte();
		piece.setPorte(liste);
		return piece ; 
	}
}
