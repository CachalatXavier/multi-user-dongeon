package Class;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.util.ArrayList;

public class Discussion extends UnicastRemoteObject implements interfaceObjetDiscussion {

	public ArrayList<Joueur> listJoueurChat = new ArrayList<Joueur>();
	public Piece salon;
	public interfaceObjetDiscussion client=null;
	
	protected Discussion(String string, Piece piece) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) throws Exception {

		LocateRegistry.createRegistry(1100);
		Serveur obj = new Serveur();
		Naming.bind("serveurDiscussion", obj);
		System.out.println("server Discussion déclaré");
		
		/*while(true){
    		String msg=s.nextLine().trim();
    		if (Discussion.getClient()!=null){
    			interfaceObjetDiscussion client=Discussion.getClient();
    			msg="["+server.getName()+"] "+msg;
    			client.send(msg);
    		}	
    	}*/
		      	
	}
/*	
	public void setClient(interfaceObjetDiscussion c){
		client=c;
	}
 
	public static interfaceObjetDiscussion getClient(){
		return client;
	} */

	public void lireMsg(){
		
	}
	
	public void ecrireMsg(){
		
	}

	@Override
	public void chat() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
