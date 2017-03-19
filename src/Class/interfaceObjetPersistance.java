package Class;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface interfaceObjetPersistance  extends Remote {
	
	public void EcrireMAJ(String nom,int pv,int x,int y,int id)throws RemoteException;
	public ArrayList lecture(String nom)throws RemoteException;
	public void EcrireCreation(String nom)throws RemoteException;
	public String Identification(String nom, String mdp)throws RemoteException;
	public void AjoutConnexion(String nom,String mdp)throws RemoteException;
	
}

