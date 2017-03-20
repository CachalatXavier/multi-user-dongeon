package Class;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface interfaceObjetSeDeplacer extends Remote {
	public ArrayList<Porte> porteDispo (Piece piece) throws RemoteException ;  
	
	public boolean DetectionMonstre(int ID)throws RemoteException; // renvoie si il y un monstre
	public Piece getPiece1()throws RemoteException; // renvoie la piece1
	public Piece getPiece(int x) throws RemoteException; // renvoie la piéce au joueur 
	public int getSize() throws RemoteException;
	public void retirerlistJoueur (Joueur joueur, Piece piece)throws RemoteException ; // retire le joueur de la liste de la piece
	public ArrayList<Monstre> renvoieDernierMonstre(Joueur J ) throws RemoteException ; 
	public void ajoutlistJoueur(Joueur joueur, Piece piece) throws RemoteException; // ajoute un joueur dans la liste de la piece
	public void miseAJourPosition(Joueur J, Piece nP, Piece oP) throws RemoteException; // met a jour la position du joueur
	public void addClientListener (Alerte listener) throws java.rmi.RemoteException;	
	public void retirerJoueurSalle (Joueur J)throws java.rmi.RemoteException;
}
