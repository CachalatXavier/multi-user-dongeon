package Class;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreadSeDeplacer implements Runnable{

	private Scanner sc;
	private Menu M;
	private Joueur J;
	private interfaceObjetSeDeplacer I;
	private interfaceObjetDiscussion D;

	public ThreadSeDeplacer(Scanner sc, Menu M, Joueur J, interfaceObjetSeDeplacer I, interfaceObjetDiscussion D){
		this.sc = sc;
		this.M = M;
		this.J = J;
		this.I = I;
		this.D = D;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

			while (1>0){
				ArrayList<Porte> direction = new ArrayList<Porte>();
				try {
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
					}
					else {
						System.out.println("Vous fuyez .... " );
						J = J.Fuir(J , I);
						System.out.println("vous retournez en arrière ");
					}
					
				 }
				 else System.out.println("il n'y a pas de monstre");
				}
				 catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		
	}
}
	
	

