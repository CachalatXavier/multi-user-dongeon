package Class;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Vivant {
	/**
	 * 
	 */
	protected String nom ;
	protected Piece piece; 
	private int pdv ;
	

	public Vivant() {
		// TODO Auto-generated constructor stub
	}
	
	public Vivant(String nom, int pdv) throws RemoteException {
		this.nom = nom;
		this.pdv=pdv; 
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int getPdv() {
		return pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

	
}

