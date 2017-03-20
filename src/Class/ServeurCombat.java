package Class;
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
		System.out.println("Serveur de Combat déclaré");
		interfaceObjetCombat C= (interfaceObjetCombat)Naming.lookup("//localhost/ServeurCombat");
	}

	
	public Joueur combat(Joueur J) throws RemoteException {			
		
				if (J.getPiece().getMonstre().isEmpty()==false){
				Monstre m = J.getPiece().getMonstre().get(0);				
				J.setPdv(jetDeDee(J,m).getPdv());
				}
				else
				{
					Monstre m2 = new Monstre("Quagga sauvage",5);
					J.setPdv(jetDeDee(J,m2).getPdv());
				}
				return J;
		}			
		

	public Joueur jetDeDee(Joueur J , Monstre m){
		int random = 0 + (int)(Math.random() * ((100 - 0) + 1));//Compris entre 0 et 100
		int tmp = 0; 
		int vieJoueur;
		vieJoueur = J.getPdv();
		int pdvm ;
		pdvm = m.getPdv();
		while (1<2)
		{	
			random = 0 + (int)(Math.random() * ((100 - 0) + 1));//Compris entre 0 et 100
			if (random>=50){
				tmp = m.getPdv() ; 
				m.setPdv((tmp-1));
				
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
				return J; // le joueur meurt
			}
			if(m.getPdv()== 0){
				J.setPdv(vieJoueur+1);
				m.setPdv(pdvm);
				return J ; // le joueur tue le monstre 
			}
		
		}
	}
}
