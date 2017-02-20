package Class;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Alerte extends Remote{
	public String getJoueur() throws RemoteException; 
	public String getMsg() throws RemoteException;
	public void setMsg(String joueur, String msg) throws RemoteException;
}
