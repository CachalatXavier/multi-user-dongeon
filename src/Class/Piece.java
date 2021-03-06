package Class;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Piece implements Serializable{
	private Position pos ; // position X, Y 
	public List<String> listJoueur = new ArrayList<String>();  // liste des joueur pr�sents dans la piece
	private ArrayList<Monstre> Monstre = new ArrayList<Monstre>(); // liste des monstre dans la piece
	private ArrayList<Porte> Porte = new ArrayList<Porte>(); // liste des portes de la piece
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
	public Piece(){
		
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
	public List<String> getListJoueur() {
		return listJoueur;
	}
	public void setListJoueur(List<String> listJoueur) {
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
	public Piece ajoutPorte(Piece piece,Porte p){ // ajout portes dans la liste des portes
		ArrayList<Porte> liste = new ArrayList<Porte>();
		liste = piece.getPorte();
		piece.setPorte(liste);
		return piece ; 
	}
public Piece ajoutMonstre(Piece p ,Monstre m){
	p.getMonstre().add(m);
		
	 return p;
	}
public void retirerLastMonstre(Piece p ){
	p.getMonstre().get(0); 
	p.getMonstre().remove(p.getMonstre().size()-1);
}

	
}
