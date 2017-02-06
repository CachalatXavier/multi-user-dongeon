package Class;

import java.io.Serializable;

public class Porte implements Serializable {
	
	private Piece piece1;
	private Piece piece2; 
	private char pos1; // postion N,S,E,O dans la piece 1
	private char pos2; // postion N,S,E,O dans la piece 2
	public Porte(){
	}
	
	public Porte(Piece piece1 ,char pos1, Piece piece2 , char pos2){
		this.piece1 = piece1;
		this.piece2 = piece2; 
		this.pos1 = pos1;
		this.pos2 = pos2;
	}
	
	
	public char getPos1() {
		return pos1;
	}

	public void setPos1(char pos1) {
		this.pos1 = pos1;
	}

	public char getPos2() {
		return pos2;
	}

	public void setPos2(char pos2) {
		this.pos2 = pos2;
	}

	public Piece getPiece1() {
		return piece1;
	}

	public void setPiece1(Piece piece1) {
		this.piece1 = piece1;
	}

	public Piece getPiece2() {
		return piece2;
	}

	public void setPiece2(Piece piece2) {
		this.piece2 = piece2;
	}
	
}
