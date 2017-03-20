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
	private interfaceObjetCombat C;
	public ThreadSeDeplacer(Scanner sc, Menu M, Joueur J, interfaceObjetSeDeplacer I, interfaceObjetDiscussion D
			,interfaceObjetCombat C){
		this.sc = sc;
		this.M = M;
		this.J = J;
		this.I = I;
		this.D = D;
		this.C=C;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

			while (1>0){
				ArrayList<Porte> direction = new ArrayList<Porte>();
				try {
					direction = I.porteDispo(J.getPiece());
					
				M.Menu2(direction , J , I, D); // direction possible en parametre et le joueur
					Scanner sc = new Scanner(System.in);
					if (I.DetectionMonstre(J.getPiece().getId()) == true){ // il n'y a pas d'autre joueur = monstre qui apparait 
						
						if(J.getPiece().getMonstre().isEmpty()==false){ // en cas si le monstre n'est pas créer dans le labyrinthe
						System.out.println("Un " + J.getPiece().getMonstre().get(0).getNom() + " apparaît !"); // nom du monstre
						}
						System.out.println("voulez vous battre ? (1)");
						System.out.println("ou fuir ? (2)");
						
						int i = sc.nextInt();
						if (i == 1){
							System.out.println("Que le combat commence ! ");
							 J.setPdv(C.combat(J).getPdv()); // Appelle du combat et mise à jour 
							 								 // point du vie du joueur
							if (J.getPdv()==0 ) { // mort du joueur
								System.out.println("Vous etes mort");
								System.out.println("Vous revenez au menu principal ");
								I.retirerJoueurSalle(J); // on retire le joueur de la salle de discussion
								M.Menu1(J, I); // relance le menu principale
								
								
								
							}
							else {
								System.out.println("vous avez gagné !!"); // le joueur recupére tous points de vie +1
								System.out.println("Vous avez "+ J.getPdv()+ " points de vie");
							}
							
						}
						else {
							System.out.println("Vous fuyez .... " );
							J = J.Fuir(J , I); // retour à la salle precedente
							System.out.println("vous retournez en arriére ");
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

	
	

