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
			Menu M = new Menu();
			
			Joueur J = new Joueur();
			J = M.Menu1(J);
			
			 
			

			while (1>0){
				ArrayList<Porte> direction = new ArrayList<Porte>();
			//System.out.println(J.getPiece().getPos().getX());
			//System.out.println(J.getPiece().getPos().getY());
			//System.out.println(J.getPiece().getId());
			direction = I.porteDispo(J.getPiece());
			//System.out.println(direction);
			 M.Menu2(direction , J ); // direction possible en parametre et le joueur
			 C.DetectionMonstre(J.getPiece());
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
