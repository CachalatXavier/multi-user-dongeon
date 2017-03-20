package Class;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class Serveur extends UnicastRemoteObject implements interfaceObjetSeDeplacer, Alerte, Runnable{
 	static Labyrinthe labyrinthe1 = new Labyrinthe();
 	private Vector list = new Vector();
 	private int entier;

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
			System.out.println("Serveur seDeplacer déclaré");
			
		   	labyrinthe1 = Labyrinthe.CreationLabyrinthe();
	      	
	}
	 
	public ArrayList<Porte> porteDispo(Piece piece){ // renvoi les porte disponible
		ArrayList<Porte> liste = new ArrayList<Porte>();
		liste.addAll(labyrinthe1.getSearchPorte()); // Arryliste des porte dans la piece 
		return liste;
	}

	
	public boolean DetectionMonstre(int ID) { // si il n'y a pas de joueur présent dans la piece, on renvoie qu'il y a un monstre
		boolean retour = true;
		int i ;
		int tmp = 0 ; 
		if (ID == 1){ // pas de monstre piece 1, piece safe
			retour = false;
		}
		else { 
			 for (i = 1 ; labyrinthe1.Donjon.size()>i ; i++ ){ // pour toute les piece 
				// System.out.println(labyrinthe1.Donjon.get(i).getId());
				 //System.out.println(labyrinthe1.Donjon.get(i).getListJoueur().isEmpty());
				if  ((labyrinthe1.Donjon.get(i).getId()==ID) && (labyrinthe1.Donjon.get(i).getListJoueur().size()>1)){
					// on retourne qu'il y un monstre que s'il n'y a pas d'autre joueur 
					retour = false ; 
				}
			 }
			};
			
			System.out.println(ID);
		System.out.println("FINAL" +retour);
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
	
	// On ajoute chaque nouveau client qui se connecte dans un vecteur
	public void addClientListener (Alerte listener) throws java.rmi.RemoteException {
		System.out.println("adding listener -"+listener);
		list.add(listener); 
	}

	// Si le client se déconnecte, on le retire du vecteur
	public void removeClientListener(Alerte listener)throws java.rmi.RemoteException {
		System.out.println("removing listener -"+listener);
		list.remove(listener); 
	}
	
	// On notifie les clients lorsqu'un joueur s'est déplacé vers leur pièce
	private void notifyListener2(Joueur joueur) throws RemoteException {
		  for (Enumeration e = list.elements(); e.hasMoreElements();) { 
			  Alerte listener = (Alerte) e.nextElement();
			  Joueur J2 = listener.getJoueur();
			  if (J2.getPiece().getId() == joueur.getPiece().getId()){
				try {  
				  listener.newJoueur(joueur); 
			  } catch(RemoteException re) {
			        System.out.println("removing listener -"+listener);
			        list.remove(listener); }
		    }
		   }
	}

	
	public void miseAJourPosition(Joueur J, Piece nP, Piece oP){	
		
	    labyrinthe1.Donjon.forEach(p -> {
	    	if (oP.getId()==p.getId()){ //enlever le joueur dans l'ancienne piece 
	    		if (p.getListJoueur().isEmpty()==false){
	    	//		System.out.println(" enlever  : " + p.getId() + p.getListJoueur().get(0));
	    			p.getListJoueur().remove(p.getListJoueur().indexOf(J.getNom()));
	    		}
	    	}
	    	if (nP.getId()==p.getId()){ // ajout le joueur dans la liste 
	    		p.getListJoueur().add(J.getNom());
	    	//	System.out.println("AJOUT : " + p.getId() + p.getListJoueur().get(0));
	    	}
	    	
	    });   		     	
	   
	    try {
				notifyListener2(J);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Override
	public Piece getPiece1() throws RemoteException {
		return labyrinthe1.Donjon.get(0);
		
	}
	
	public Piece getPiece(int x) throws RemoteException {
		return labyrinthe1.Donjon.get(x);
		
	}
	public int getSize() throws RemoteException {
		return labyrinthe1.Donjon.size();
		
	}

	// Retire le joueur de la pièce dans laquelle il se trouvait précédemment :
	public void retirerlistJoueur(Joueur joueur, Piece piece) throws RemoteException {
		// TODO Auto-generated method stub
		labyrinthe1.Donjon.forEach(p -> 
		{
			if (p.getId()==piece.getId()){
				p.getListJoueur().remove(joueur);
				
			}
		});
	}

	// Ajout du joueur dans la pièce vers laquelle il s'est déplacé :
	public void ajoutlistJoueur(Joueur joueur, Piece piece) throws RemoteException {
		// TODO Auto-generated method stub
		labyrinthe1.Donjon.forEach(p -> 
		{
			if (p.getId()==piece.getId()){
				p.getListJoueur().add(joueur.getNom());
				
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

	@Override
	public Joueur getJoueur() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMsg() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMsg(String joueur, String msg, Joueur J) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newMsg(Joueur emetteur, String msg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newJoueur(Joueur joueur) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirerJoueurSalle(Joueur J) { // retire le joueur en cas de mort
		// TODO Auto-generated method stub
		 labyrinthe1.Donjon.forEach(p -> {
		    	if (J.getPiece().getId()==p.getId()){ //enlever le joueur dans l'ancienne piece 
		    		if (p.getListJoueur().isEmpty()==false){
		    	//		System.out.println(" enlever  : " + p.getId() + p.getListJoueur().get(0));
		    			p.getListJoueur().remove(p.getListJoueur().indexOf(J.getNom()));
		    		}
		    	}
		 
	});
	}
}