package Class;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface interfaceObjetDiscussion extends Remote{
	public void chat() throws RemoteException ;
	public String receiveMsg(Message msg, Joueur J, Piece p) throws RemoteException;
	public void printMsg(Joueur J, Message msg, AlerteMsg alerte1) throws RemoteException;
}
