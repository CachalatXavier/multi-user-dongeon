package Class;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import java.util.function.Consumer;

public class Serveur extends UnicastRemoteObject implements interfaceObjetSeDeplacer, Alerte, Runnable{
 	static Labyrinthe labyrinthe1 = new Labyrinthe();
 	private Vector list = new Vector();

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
	 
	public ArrayList<Porte> porteDispo(Piece piece){
		ArrayList<Porte> liste = new ArrayList<Porte>();
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
				System.out.println(labyrinthe1.Donjon.get(i).getListJoueur().size()>1);
				if (labyrinthe1.Donjon.get(i).getListJoueur().size()>1)
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

	public void infoClients(Joueur J){
		try {
			notifyListener2(J);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addClientListener (Alerte listener) throws java.rmi.RemoteException {
		System.out.println("adding listener -"+listener);
		list.add(listener); 
	}

	public void removeClientListener(Alerte listener)throws java.rmi.RemoteException {
		System.out.println("removing listener -"+listener);
		list.remove(listener); 
	}
	
	private void notifyListener2(Joueur joueur) throws RemoteException {
		  for (Enumeration e = list.elements(); e.hasMoreElements();) { 
			  Alerte listener = (Alerte) e.nextElement();
			  Joueur J2 = listener.getJoueur();
			  if (J2.getPiece().getId() == joueur.getPiece().getId()){
				  listener.newJoueur(joueur); 
		    }
		   }
	}

	
	public void miseAJourPosition(Joueur J, Piece nP, Piece oP){		
		nP.addJoueur(J);//Ajout du joueur dans l'array joueur de la nouvelle piece
		oP.delJoueur(J);//Suppression du joueur de l'array joueur de l'ancienne piece
		System.out.println("Element ajout : " + J.getNom() + " de " + nP.getId());
	    System.out.println("Element suppr : " + J.getNom() + " de " + oP.getId());
		infoClients(J);
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


	public void retirerlistJoueur(Joueur joueur, Piece piece) throws RemoteException {
		// TODO Auto-generated method stub
		labyrinthe1.Donjon.forEach(p -> 
		{
			if (p.getId()==piece.getId()){
				p.getListJoueur().remove(joueur);
				
			}
			for (int j=0 ; j<piece.getListJoueur().size(); j++){
				if(piece.getListJoueur().get(j)==joueur){
					piece.getListJoueur().remove(piece.getListJoueur().get(j));
				}
			}
		});
	}


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
}