package Class;

public class Porte {
	
	private Piece piece1;
	private Piece piece2; 
	
	public Porte(Piece piece1 , Piece piece2){
		this.piece1 = piece1;
		this.piece2 = piece2; 
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
