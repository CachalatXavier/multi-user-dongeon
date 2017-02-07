package Class;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServeurCombat extends UnicastRemoteObject implements interfaceObjetCombat {
	Labyrinthe lab = new Labyrinthe();
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
	
	public int DetectionMonstre(Piece p) throws RemoteException {	
		lab.recupererLabyrinthe();
		Piece salle = lab.Donjon.get(p.getId());
		int i=salle.getMonstre().size();
		return i;
	}
	

}
