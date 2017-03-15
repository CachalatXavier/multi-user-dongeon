package Class;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface interfaceObjetSeDeplacer extends Remote {
	public ArrayList<Porte> porteDispo (Piece piece) throws RemoteException ;  
	
	public boolean DetectionMonstre(int ID)throws RemoteException;
	public Piece getPiece1()throws RemoteException;
	public void retirerlistJoueur (Joueur joueur, Piece piece)throws RemoteException ; 
	public ArrayList<Monstre> renvoieDernierMonstre(Joueur J ) throws RemoteException ; 
	public void ajoutlistJoueur(Joueur joueur, Piece piece) throws RemoteException;
	public int pieceVide(Piece p )throws RemoteException ; 
}
