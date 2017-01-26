package Class;

import java.rmi.RemoteException;

public interface interfaceObjetSeDeplacer {
	
	public void seDeplacer(char dest)throws RemoteException;
	public Joueur creationPerso() throws RemoteException;
}
