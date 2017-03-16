package Class;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ThreadDiscussion implements Runnable{

	private Scanner sc;
	private Menu M;
	private Joueur J;
	private interfaceObjetDiscussion D;
	
	public ThreadDiscussion(Scanner sc, Menu M, Joueur J, interfaceObjetDiscussion D){
		this.sc = sc;
		this.M = M;
		this.J = J;
		this.D = D;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			 
		String str = sc.nextLine();
		char tchat = str.charAt(0);
		if (tchat == '"'){
		M.tchat(sc, J, D);
		}
		
	}

}
