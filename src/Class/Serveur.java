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
	// à completer 
	public ArrayList<String> porteDispo(Piece piece){
		int i =0; 
		ArrayList<String> renvoie = new ArrayList<String>();
		ArrayList<Porte> liste = new ArrayList<Porte>();
		System.out.println("petit test rmi");
		liste = labyrinthe1.getSearchPorte(); // Arryliste des porte dans la piece 
		//System.out.println(liste.size());
		for (i = 0 ;  i < liste.size();i++){
			 System.out.println(liste.get(i).getPiece1().getId());
			if (liste.get(i).getPiece1().getId()==piece.getId()){ // erreur cette ligne
				System.out.println("check2");
				if (liste.get(i).getPos1()=="N"){
					renvoie.add("N");
				}
				if (liste.get(i).getPos1()=="S"){
					renvoie.add("S");
					
				}
				if (liste.get(i).getPos1()=="O"){
					renvoie.add("O");
				}
				if (liste.get(i).getPos1()=="E"){
					renvoie.add("E");
				}
			}
			if (liste.get(i).getPiece2().getPos()==piece.getPos()){
				if (liste.get(i).getPos2()=="N"){
					renvoie.add("N");
				}
				if (liste.get(i).getPos2()=="S"){
					renvoie.add("S");
				}
				if (liste.get(i).getPos2()=="O"){
					renvoie.add("O");
				}
				if (liste.get(i).getPos2()=="E"){
					renvoie.add("E");
				}
			
		}
	}
		System.out.println(renvoie);		
		return renvoie;
	}
}
