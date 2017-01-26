package Class;

import java.util.ArrayList;

public class Labyrinthe {
	private ArrayList<Piece> Donjon = new ArrayList<Piece>(); 
	
	void CreationLabyrinthe(){
		Position p1 =new Position (3,0);
		Piece piece1= new Piece(p1,0);
		Donjon.add(piece1);
		
		Position p2 =new Position (3,1);
		Piece piece2= new Piece(p2,0);
		Donjon.add(piece2);
		
		Porte p1_2 = new Porte(piece1,piece2);
		
	}

}
