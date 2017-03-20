package Class;

import java.util.ArrayList;

public class Labyrinthe  {
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
		ArrayList<Piece> Donjon = new ArrayList<Piece>(); 
		Labyrinthe labyrinthe1 = new Labyrinthe(Donjon);
		
		
		//Creation piece 1
		Position p1 =new Position (3,0);
		Piece piece1= new Piece(p1,1);
		
		//Creation piece 2
		Position p2 =new Position (3,1);
		Piece piece2= new Piece(p2,2);
		Monstre Monstre1 = new Monstre("quagga sauvage" , 5);
		piece2.ajoutMonstre(piece2, Monstre1);
		//Creation porte piece1/piece2
		Porte p1_2 = new Porte(piece1,'S',piece2,'N');
		//Ajout porte 
		piece1 =piece1.ajoutPorte(piece1, p1_2);
		piece2 =piece2.ajoutPorte(piece2, p1_2);
		
		
		//Creation piece 3
		Position p3 =new Position (4,1);
		Piece piece3= new Piece(p3,3);
		//Creation monstre
		Monstre Monstre3 = new Monstre("Quagga armé" , 6);
		piece3.ajoutMonstre(piece3, Monstre3);
		
		//Creation porte piece2/piece3
		Porte p2_3 = new Porte(piece2,'E',piece3,'O');
		//Ajout Porte
		piece3 =piece3.ajoutPorte(piece3, p2_3);
		piece2 =piece2.ajoutPorte(piece2, p2_3);
		
		
		//Creation piece 5
		Position p5 =new Position (2,1);
		Piece piece5= new Piece(p5,5);
		//Creation monstre
		Monstre Monstre5 = new Monstre("Garde Quagga" , 6);
		piece2.ajoutMonstre(piece5, Monstre5);
		
		//Creation porte piece2/piece5
		Porte p2_5 = new Porte(piece2,'O',piece5,'E');
		//Ajout Porte
		piece5 =piece5.ajoutPorte(piece5, p2_5);
		piece2 =piece2.ajoutPorte(piece2, p2_5);
		
	   
		//Creation piece 6
				Position p6 =new Position (3,2);
				Piece piece6= new Piece(p6,6);
				Monstre Monstre6 = new Monstre("Garde Quagga" , 6);
				piece2.ajoutMonstre(piece6, Monstre6);
				//Creation porte 
				Porte p2_6 = new Porte(piece2,'S',piece6,'N');
				//Ajout porte 
				piece6 =piece6.ajoutPorte(piece6, p2_6);
				piece2 =piece2.ajoutPorte(piece2, p2_6);
				
		//Creation piece 7
				Position p7 =new Position (2,2);
				Piece piece7= new Piece(p7,7);
				Monstre Monstre7 = new Monstre("Quagga sauvage" , 5);
				piece7.ajoutMonstre(piece7, Monstre7);
				//Creation porte
				Porte p5_7 = new Porte(piece5,'S',piece7,'N');
				Porte p6_7 = new Porte(piece6,'O',piece7,'E');
				//Ajout portes 
				piece5 =piece5.ajoutPorte(piece5, p5_7);
				piece7 =piece7.ajoutPorte(piece7, p5_7);	
				piece6 =piece6.ajoutPorte(piece6, p6_7);
				piece7 =piece7.ajoutPorte(piece7, p6_7);
				
		//Creation piece 8
				Position p8 =new Position (4,2);
				Piece piece8= new Piece(p8,8);
				Monstre Monstre8 = new Monstre("Quagga méchant" , 8);
				piece8.ajoutMonstre(piece8, Monstre8);
				//Creation porte
				Porte p6_8 = new Porte(piece6,'E',piece8,'O');
				//Ajout portes 
				piece6 =piece6.ajoutPorte(piece6, p6_8);
				piece8 =piece8.ajoutPorte(piece8, p6_8);
				
		//Creation piece 9
				Position p9 =new Position (3,3);
				Piece piece9= new Piece(p9,9);
				Monstre Monstre9 = new Monstre("Reine Quagga" , 15);
				piece9.ajoutMonstre(piece9, Monstre9);
				//Creation porte 
				Porte p6_9 = new Porte(piece6,'S',piece9,'N');
				//Ajout portes 
				piece6 =piece6.ajoutPorte(piece6, p6_9);
				piece9 =piece9.ajoutPorte(piece9, p6_9);
				
		
		labyrinthe1.Donjon.add(piece1);
		labyrinthe1.Donjon.add(piece2);
		labyrinthe1.Donjon.add(piece3);
		labyrinthe1.Donjon.add(piece5);
		labyrinthe1.Donjon.add(piece6);
		labyrinthe1.Donjon.add(piece7);
		labyrinthe1.Donjon.add(piece8);
		labyrinthe1.Donjon.add(piece9);

		labyrinthe1.SearchPorte.add(p1_2);
		labyrinthe1.SearchPorte.add(p2_3);
		labyrinthe1.SearchPorte.add(p2_5);
		labyrinthe1.SearchPorte.add(p2_6);
		labyrinthe1.SearchPorte.add(p5_7);
		labyrinthe1.SearchPorte.add(p6_7);
		labyrinthe1.SearchPorte.add(p6_8);
		labyrinthe1.SearchPorte.add(p6_9);
		
		return labyrinthe1;
	}
	
}
