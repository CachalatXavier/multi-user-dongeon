package Class;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class AlerteMsg extends UnicastRemoteObject implements Alerte{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private String joueur;

	public AlerteMsg() throws RemoteException {
		super();
	}
	
	public static void main(String[] args) throws Exception {

		LocateRegistry.createRegistry(1105);
		AlerteMsg a = new AlerteMsg();
		Naming.bind("alerteMsg", a);
		System.out.println("server alerte déclaré");
	}
	
	public AlerteMsg(String joueur, String msg) throws RemoteException{
		this.msg = msg;
		this.joueur = joueur;
	}
	
	public String getJoueur(){
		return joueur;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String joueur, String msg) {
		this.msg = msg;
		this.joueur = joueur;
	}	
	
}
