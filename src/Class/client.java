package Class;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.rmi.*;
import java.rmi.server.*;

public class client extends UnicastRemoteObject implements Alerte {
	
	private static Joueur J1;
	
	public client() throws RemoteException {}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
			try {
			
			interfaceObjetSeDeplacer I= (interfaceObjetSeDeplacer)Naming.lookup("//localhost/serveurseDeplacer");
			interfaceObjetCombat C= (interfaceObjetCombat)Naming.lookup("//localhost/ServeurCombat");
			interfaceObjetDiscussion D = (interfaceObjetDiscussion)Naming.lookup("//localhost/serveurDiscussion");
			
			 String emetteur = D.getEmetteurMSG();
			 String msg = D.getContenuMSG();
			    System.out.println(emetteur + " : " + msg);
			    client cli = new client();
			    D.addChatListener(cli);
			
			Menu M = new Menu();			
			Joueur J = new Joueur();
			J = M.Menu1(J , I);
			setJoueur(J);
			Scanner sc = new Scanner(System.in);
			
		ThreadSeDeplacer t1 = new ThreadSeDeplacer(sc, M, J, I , D);
		ThreadDiscussion t2 = new ThreadDiscussion(sc, M, J, D);
		t1.run();
		t2.run();
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void newMsg(Joueur emetteur, String msg)throws java.rmi.RemoteException {
		if (msg != null){
			System.out.println(emetteur.getNom() + " : " + msg);
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
