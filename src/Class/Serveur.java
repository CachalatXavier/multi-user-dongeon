package Class;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur extends UnicastRemoteObject implements interfaceObjetSeDeplacer {


	public Serveur() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {

	
			LocateRegistry.createRegistry(1099);
			Serveur obj = new Serveur();
			Naming.bind("serveurseDeplacer", obj);
			System.out.println("server seDeplacer déclarer");
			
			
		   	Labyrinthe labyrinthe1 = new Labyrinthe();
		   	Labyrinthe.CreationLabyrinthe();
	      	// joueur1.setPiece(labyrinthe1.Donjon.get(0));	*/  
	      	
	      	
	}

	@Override
	public void seDeplacer(char dest) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
