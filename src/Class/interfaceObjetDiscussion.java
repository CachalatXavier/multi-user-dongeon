package Class;

import java.rmi.RemoteException;
import java.rmi.Remote;

// Interface permettant au joueur d'envoyer un message dans le tchat
public interface interfaceObjetDiscussion extends Remote{
	public void chat() throws RemoteException ;
	public String receiveMsg(Message msg, Joueur J, Piece p) throws RemoteException;
	public void addChatListener(Alerte A) throws RemoteException;
	public void removeChatListener(Alerte A) throws RemoteException;
	public String getEmetteurMSG() throws RemoteException;
	public String getContenuMSG() throws RemoteException;
}
