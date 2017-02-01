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
			Menu M = new Menu();
			Joueur J = new Joueur();
			J = M.Menu1(J);
			 
			ArrayList<String> direction = new ArrayList<String>();
			int i;
			while (1>0){
			direction = I.porteDispo(J.getPiece());
			 M.Menu2(direction); // direction possible en parametre
			 
			 Scanner sc = new Scanner(System.in);
			 String str = sc.nextLine();
			 char choixdirection =str.charAt(0);
			 J.MAJjoueurPos(J, choixdirection);
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
