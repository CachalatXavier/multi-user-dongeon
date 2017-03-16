package Class;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class client {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		try {
			
			interfaceObjetSeDeplacer I= (interfaceObjetSeDeplacer)Naming.lookup("//localhost/serveurseDeplacer");
			interfaceObjetCombat C= (interfaceObjetCombat)Naming.lookup("//localhost/ServeurCombat");
			interfaceObjetDiscussion D = (interfaceObjetDiscussion)Naming.lookup("//localhost/serveurDiscussion");
			Alerte A = (Alerte)Naming.lookup("//localhost/alerteMsg");
			Menu M = new Menu();
			
			Joueur J = new Joueur();
			J = M.Menu1(J , I);

			while (1>0){
				ArrayList<Porte> direction = new ArrayList<Porte>();
			//System.out.println(J.getPiece().getPos().getX());
			//System.out.println(J.getPiece().getPos().getY());
			//System.out.println(J.getPiece().getId());
			direction = I.porteDispo(J.getPiece());
			
			
			 M.Menu2(direction , J , I, D, A); // direction possible en parametre et le joueur
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
					else System.out.println("vous avez gagn� !!");
					
				}
				else {
					System.out.println("Vous fuyez .... " );
					J = J.Fuir(J , I);
					System.out.println("vous retournez en arri�re ");
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
	
}
