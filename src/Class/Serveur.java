package Class;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Serveur extends UnicastRemoteObject implements interfaceObjetSeDeplacer {
 	static Labyrinthe labyrinthe1 = new Labyrinthe();

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
			
			
		  
		   	labyrinthe1 = Labyrinthe.CreationLabyrinthe();
	      	// joueur1.setPiece(labyrinthe1.Donjon.get(0));	*/  
	      	
	      	
	}

	@Override
	public void seDeplacer(char dest) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	 
	public ArrayList<Porte> porteDispo(Piece piece){
		//int i =0; 
		//ArrayList<String> renvoie = new ArrayList<String>();
		ArrayList<Porte> liste = new ArrayList<Porte>();
		// System.out.println("petit test rmi");
		liste.addAll(labyrinthe1.getSearchPorte()); // Arryliste des porte dans la piece 
		
		return liste;
	}

	@Override
	public Labyrinthe GetLabyrinthe() throws RemoteException {
		// TODO Auto-generated method stub
		return labyrinthe1;
	}
}
