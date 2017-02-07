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
		
		
		//Creation piece 1
		Position p1 =new Position (3,0);
		Piece piece1= new Piece(p1,1);
		
		//Creation piece 2
		Position p2 =new Position (3,1);
		Piece piece2= new Piece(p2,2);
		//Creation porte piece1/piece2
		Porte p1_2 = new Porte(piece1,'S',piece2,'N');
		//Ajout porte 
		piece1 =piece1.ajoutPorte(piece1, p1_2);
		piece2 =piece2.ajoutPorte(piece2, p1_2);
		
		
		//Creation piece 3
		Position p3 =new Position (4,1);
		Piece piece3= new Piece(p3,3);
		
		//Creation porte piece2/piece3
		Porte p2_3 = new Porte(piece2,'E',piece3,'O');
		//Ajout Porte
		piece3 =piece3.ajoutPorte(piece3, p2_3);
		piece2 =piece2.ajoutPorte(piece2, p2_3);
		
		
		//Creation piece 5
		Position p5 =new Position (2,1);
		Piece piece5= new Piece(p5,5);
		
		//Creation porte piece2/piece5
		Porte p2_5 = new Porte(piece2,'O',piece5,'E');
		//Ajout Porte
		piece5 =piece5.ajoutPorte(piece5, p2_5);
		piece2 =piece2.ajoutPorte(piece2, p2_5);
		
	   
		
		labyrinthe1.Donjon.add(piece1);
		labyrinthe1.Donjon.add(piece2);
		labyrinthe1.Donjon.add(piece3);
		labyrinthe1.Donjon.add(piece5);
		//Porte p1_2 = new Porte(piece1,piece2);
		labyrinthe1.SearchPorte.add(p1_2);
		labyrinthe1.SearchPorte.add(p2_3);
		labyrinthe1.SearchPorte.add(p2_5);
		
		return labyrinthe1;
	}
	
}
