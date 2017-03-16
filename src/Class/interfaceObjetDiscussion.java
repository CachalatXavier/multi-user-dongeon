package Class;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface interfaceObjetDiscussion extends Remote{
	public void chat() throws RemoteException ;
	public String receiveMsg(Message msg, Joueur J, Piece p) throws RemoteException;
	public void addChatListener(Alerte A) throws RemoteException;
	public void removeChatListener(Alerte A) throws RemoteException;
	public String getEmetteurMSG() throws RemoteException;
	public String getContenuMSG() throws RemoteException;
}
