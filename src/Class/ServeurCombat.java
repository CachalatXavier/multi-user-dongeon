package Class;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServeurCombat extends UnicastRemoteObject implements interfaceObjetCombat {
			
	
		public ServeurCombat() throws RemoteException {
		super();
		
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub

		LocateRegistry.createRegistry(1101);
		ServeurCombat obj = new ServeurCombat();
		Naming.bind("ServeurDeCombat", obj);
		System.out.println("Serveur de Combat déclarée");
		
		
	}
	
	public void DetectionMonstre(Piece p){
		I.GetLabyrinthe();
		
		
		
	}

}
