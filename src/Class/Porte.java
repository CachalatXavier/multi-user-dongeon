package Class;

public class Porte {
	
	private Piece piece1;
	private Piece piece2; 
	private String pos1;
	private String pos2;
	public Porte(){
	}
	
	public Porte(Piece piece1 ,String pos1, Piece piece2 , String pos2){
		this.piece1 = piece1;
		this.piece2 = piece2; 
		this.pos1 = pos1;
		this.pos2 = pos2;
	}
	
	
	public String getPos1() {
		return pos1;
	}

	public void setPos1(String pos1) {
		this.pos1 = pos1;
	}

	public String getPos2() {
		return pos2;
	}

	public void setPos2(String pos2) {
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
