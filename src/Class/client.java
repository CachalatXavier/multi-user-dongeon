package Class;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.rmi.*;
import java.rmi.server.*;

public class client extends UnicastRemoteObject implements Alerte {
	
	// J1 sera le joueur utilisé par le client 
	private static Joueur J1;
	
	public client() throws RemoteException {}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

			interfaceObjetSeDeplacer I;
			// On connecte le client aux serveurs via les interfaces
			try {
				I = (interfaceObjetSeDeplacer)Naming.lookup("//localhost/serveurseDeplacer");
				interfaceObjetCombat C= (interfaceObjetCombat)Naming.lookup("//localhost/ServeurCombat");
				interfaceObjetDiscussion D = (interfaceObjetDiscussion)Naming.lookup("//localhost/serveurDiscussion");
				
				 String emetteur = D.getEmetteurMSG();
				 String msg = D.getContenuMSG();
				    System.out.println(emetteur + " : " + msg);
				    client cli = new client();
				    D.addChatListener(cli);
				    I.addClientListener(cli);
				
				Menu M = new Menu();			
				Joueur J = new Joueur();
				J = M.Menu1(J , I);
				setJoueur(J);
				Scanner sc = new Scanner(System.in);
					
			ThreadSeDeplacer t1 = new ThreadSeDeplacer(sc, M, J, I , D, C);
			ThreadDiscussion t2 = new ThreadDiscussion(sc, M, J, D);
			t1.run();
			t2.run();

				
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}
	
	// Quand un joueur écrit dans le tchat, le message est affiché par le client
	public void newMsg(Joueur emetteur, String msg)throws java.rmi.RemoteException {
		if (msg != null){
			System.out.println(emetteur.getNom() + " : " + msg);
		}
	}
	
	// Quand un nouveau joueur arrive dans la pièce, les clients sont informés
	public void newJoueur(Joueur joueur) throws java.rmi.RemoteException {
		if (joueur!=null){
			System.out.println(joueur.getNom() + " est entré dans la pièce " + joueur.getPiece().getId());
		}
	}

	public Joueur getJoueur(){
		return J1;
	}
	
	public static void setJoueur(Joueur J){
		J1 = J;
		System.out.println("Joueur : " + J1.getNom());
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


	
}
