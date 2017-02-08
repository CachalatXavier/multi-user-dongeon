package Class;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

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
		
	}
	
	public int DetectionMonstre(Piece p) throws RemoteException {	
		int i =0 ;
		
		return i;
	}
	
	public Vivant Combat(Piece p,Vivant v1,Vivant v2){
		
		//Passer la piece en combat
		System.out.println("Vous entrez en combat");
		while(1>0){
			int random = 0 + (int)(Math.random() * ((100 - 0) + 1));//Compris entre 0 et 100
				if (random>=50){
				v2.setPdv(v2.getPdv()-1);
				
				}else{
				v1.setPdv(v1.getPdv()-1);
				}
				if(v1.getPdv()== 0){
				return v1;
				}
				if(v2.getPdv()== 0){
				return v2;
				}  
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
		}

	}
	
	

}
