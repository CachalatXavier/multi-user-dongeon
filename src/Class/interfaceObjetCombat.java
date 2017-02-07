package Class;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceObjetCombat extends Remote{

	
	public int DetectionMonstre(Piece p) throws RemoteException;
}
