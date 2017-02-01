package Class;

import java.util.ArrayList;

public class Labyrinthe {
	public ArrayList<Piece> Donjon = new ArrayList<Piece>(); 
	public ArrayList<Porte> SearchPorte = new ArrayList<Porte>(); 
	
	public Labyrinthe (){
		super();
	}
	
	
	public Labyrinthe(ArrayList<Piece> donjon) {
		super();
		Donjon = donjon;
	}
	
	public ArrayList<Piece> getDonjon() {
		return Donjon;
	}


	public void setDonjon(ArrayList<Piece> donjon) {
		Donjon = donjon;
	}


	public ArrayList<Porte> getSearchPorte() {
		return SearchPorte;
	}


	public void setSearchPorte(ArrayList<Porte> searchPorte) {
		SearchPorte = searchPorte;
	}


	public static Labyrinthe CreationLabyrinthe(){
		ArrayList Donjon = new ArrayList<Piece>(); 
		Labyrinthe labyrinthe1 = new Labyrinthe(Donjon);
		
		
		
		Position p1 =new Position (3,0);
		Piece piece1= new Piece(p1,0);
		
		Position p2 =new Position (3,1);
		Piece piece2= new Piece(p2,0);
		Porte p1_2 = new Porte(piece1,"S",piece2,"N");
	    piece1 =piece1.ajoutPorte(piece1, p1_2);
		piece2 =piece1.ajoutPorte(piece2, p1_2);
		
		labyrinthe1.Donjon.add(piece1);
		labyrinthe1.Donjon.add(piece2);
		//Porte p1_2 = new Porte(piece1,piece2);
		labyrinthe1.SearchPorte.add(p1_2);
		
		return labyrinthe1;
	}
	
}
