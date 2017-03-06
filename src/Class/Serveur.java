package Class;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Serveur extends UnicastRemoteObject implements interfaceObjetSeDeplacer {
 	static Labyrinthe labyrinthe1 = new Labyrinthe();

	public Serveur() throws RemoteException {
		super();
		this.labyrinthe1 = labyrinthe1 ;
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
	 
	public ArrayList<Porte> porteDispo(Piece piece){
		//int i =0; 
		//ArrayList<String> renvoie = new ArrayList<String>();
		ArrayList<Porte> liste = new ArrayList<Porte>();
		// System.out.println("petit test rmi");
		liste.addAll(labyrinthe1.getSearchPorte()); // Arryliste des porte dans la piece 
		
		return liste;
	}

	
	public boolean DetectionMonstre(int ID) {
		boolean retour = true;
		int i ;
		for (i = 0 ; labyrinthe1.Donjon.size() > i ; i++)
		{
			
			if (labyrinthe1.Donjon.get(i).getId()==ID)
			{
				
				if (labyrinthe1.Donjon.get(i).getMonstre().isEmpty())
				{
					retour = false ;					
				}
			}
		}
		return retour ;
	}
	public ArrayList<Monstre> renvoieDernierMonstre(Joueur J){
		ArrayList<Monstre> list = new ArrayList<Monstre>(); 
		labyrinthe1.Donjon.forEach(piece -> {
			if (piece.getId()==J.getPiece().getId()){
				  list.addAll(piece.getMonstre()); 
			}
		});
		return list;  
	}

	@Override
	public Piece getPiece1() throws RemoteException {
		return labyrinthe1.Donjon.get(0);
		
	}

	@Override
	public void retirerlistJoueur(Joueur joueur, Piece piece) throws RemoteException {
		// TODO Auto-generated method stub
		labyrinthe1.Donjon.forEach(p -> 
		{
			if (p.getId()==piece.getId()){
				p.getListJoueur().remove(joueur);
				
			}
		});
	}

	@Override
	public void ajoutlistJoueur(Joueur joueur, Piece piece) throws RemoteException {
		// TODO Auto-generated method stub
		labyrinthe1.Donjon.forEach(p -> 
		{
			if (p.getId()==piece.getId()){
				p.getListJoueur().add(joueur);
				
			}
		});
	}

	public void MajMonstre(Monstre m , Piece p ) throws RemoteException {
		
		labyrinthe1.Donjon.forEach(piece -> 
		{
			if (p.getId()==piece.getId()){
				piece.retirerLastMonstre(p); 				
			}
		});	
	}
}
