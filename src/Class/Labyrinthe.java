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
	
	public static Labyrinthe CreationLabyrinthe(){
		ArrayList Donjon = new ArrayList<Piece>(); 
		Labyrinthe labyrinthe1 = new Labyrinthe(Donjon);
		Position p1 =new Position (3,0);
		Piece piece1= new Piece(p1,0);
		labyrinthe1.Donjon.add(piece1);
		
		Position p2 =new Position (3,1);
		Piece piece2= new Piece(p2,0);
		labyrinthe1.Donjon.add(piece2);
		
		Porte p1_2 = new Porte(piece1,piece2);
		labyrinthe1.SearchPorte.add(p1_2);
		
		return labyrinthe1;
	}
}
