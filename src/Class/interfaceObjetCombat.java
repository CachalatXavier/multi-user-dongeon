package Class;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceObjetCombat extends Remote{

	public Joueur combat(Joueur j) throws RemoteException ; // fonction de combat du joueur
	
}
