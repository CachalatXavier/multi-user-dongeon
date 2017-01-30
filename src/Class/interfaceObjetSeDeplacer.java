package Class;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceObjetSeDeplacer extends Remote {
	
	public void seDeplacer(char dest)throws RemoteException;
}
