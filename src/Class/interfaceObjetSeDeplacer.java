package Class;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface interfaceObjetSeDeplacer extends Remote {
	public ArrayList<Porte> porteDispo (Piece piece) throws RemoteException ;  
	public void seDeplacer(char dest)throws RemoteException;
}
