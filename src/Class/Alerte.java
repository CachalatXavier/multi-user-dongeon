package Class;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Alerte extends Remote{
	public Joueur getJoueur() throws RemoteException; 
	public String getMsg() throws RemoteException;
	public void setMsg(String joueur, String msg, Joueur J) throws RemoteException;
	public void newMsg(Joueur emetteur, String msg) throws RemoteException;
}
