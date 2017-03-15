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
		Naming.bind("ServeurCombat", obj);
		System.out.println("Serveur de Combat déclarée");
		interfaceObjetCombat C= (interfaceObjetCombat)Naming.lookup("//localhost/ServeurCombat");
	}

	
	public int combat(Joueur J) throws RemoteException {
		
		try {
			interfaceObjetSeDeplacer I= (interfaceObjetSeDeplacer)Naming.lookup("//localhost/serveurseDeplacer");
			
			
			ArrayList<Monstre> lm = I.renvoieDernierMonstre(J);
			if (lm.isEmpty()){
				return -1 ;
			}
			
			 Monstre m = lm.get(0);
				
			System.out.println("Vous entrez en combat");
			int tmp = 0 ; 
			int random = 0 + (int)(Math.random() * ((100 - 0) + 1));//Compris entre 0 et 100
				if (random>=50){
				tmp = m.getPdv() ; 
				m.setPdv((tmp-1));
				I.MajMonstre( m , J.getPiece());
				System.out.println("le monstre perd des pv");
				}
				else{
				tmp = J.getPdv() ;
				J.setPdv((tmp-1));
				System.out.println("le joueur perd des pv");
				}
				System.out.print("OK " + J.getPdv());
				System.out.print("M" + m.getPdv());
				if(J.getPdv()== 0){
				return 0; // le joueur meurt
				}
				if(m.getPdv()== 0){
				return 1 ; // le joueur tue le monstre 
				}
				
				
				
		} catch (MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 2;

		
	}
	
	

}
