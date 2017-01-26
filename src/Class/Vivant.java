package Class;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Vivant extends UnicastRemoteObject implements interfaceObjetSeDeplacer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nom ;
	protected Piece piece; 
	private int pdv ;
	
	public Vivant()throws RemoteException {

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

	@Override
	public void seDeplacer(char dest) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Joueur creationPerso() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
}

