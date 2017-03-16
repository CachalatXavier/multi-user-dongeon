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

			while (1>0){
				ArrayList<Porte> direction = new ArrayList<Porte>();
			//System.out.println(J.getPiece().getPos().getX());
			//System.out.println(J.getPiece().getPos().getY());
			//System.out.println(J.getPiece().getId());
			direction = I.porteDispo(J.getPiece());
			
			
			 M.Menu2(direction , J , I, D); // direction possible en parametre et le joueur
			 if (I.DetectionMonstre(J.getPiece().getId()) == true){
				System.out.println("il y a des monstres"); 
				System.out.println("voulez vous battre ? (1)");
				System.out.println("ou fuir ? (2)");
				Scanner sc = new Scanner(System.in);
				int i = sc.nextInt();
				if (i == 1){
					System.out.println("Que le combat commence ! ");
					 J.setPdv(C.combat(J).getPdv());
					
					if (J.getPdv()==0 ) {
						System.out.println("Vous etes mort");
						
					}
					else System.out.println("vous avez gagné !!");
					
				}
				else {
					System.out.println("Vous fuyez .... " );
					J = J.Fuir(J , I);
					System.out.println("vous retournez en arriére ");
				}
				
			 }
			 else System.out.println("il n'y a pas de monstre");
			}

		
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
