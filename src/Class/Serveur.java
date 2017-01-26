package Class;
import java.net.ServerSocket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Scanner;

public class Serveur {

	public static void main(String[] args) throws Exception {
		
			LocateRegistry.createRegistry(1099);
			
			Vivant j = new Vivant();
			Naming.bind("serveurseDeplacer", j);
			System.out.println("server seDeplacer déclarer");
			
			/*
		   	Labyrinthe labyrinthe1 = new Labyrinthe();
		   	Labyrinthe.CreationLabyrinthe();
	      	// joueur1.setPiece(labyrinthe1.Donjon.get(0));	*/  
	      	
	      	
	}
	
}
