package Class;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

public class Discussion extends UnicastRemoteObject implements interfaceObjetDiscussion {

	protected Discussion() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) throws Exception {

		LocateRegistry.createRegistry(1100);
		Serveur obj = new Serveur();
		Naming.bind("serveurDiscussion", obj);
		System.out.println("server Discussion déclaré");
		      	
	}

	public void lireMsg(){
		
	}
	
	public void ecrireMsg(){
		
	}
}
