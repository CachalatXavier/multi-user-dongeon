package Class;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class ServeurDiscussion extends UnicastRemoteObject implements interfaceObjetDiscussion, Alerte, Runnable{
	//Discussion chat = new Discussion();
	public ArrayList<Joueur> listJoueurChat = new ArrayList<Joueur>();
	public ArrayList<Message> listMessage = new ArrayList<Message>();
	private Vector list = new Vector();
	private volatile String emetteur;
	private volatile String msg;
	
	public ServeurDiscussion() throws RemoteException {
		//super();
		emetteur = "";
		msg = "";
	//	this.chat = chat;
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {

		LocateRegistry.createRegistry(1102);
		ServeurDiscussion srv = new ServeurDiscussion();
		Naming.bind("serveurDiscussion", srv);
		System.out.println("Serveur Discussion déclaré");
		
		
	}
	
	public String getEmetteurMSG() throws java.rmi.RemoteException {
		        return emetteur; 
	}
	
	public String getContenuMSG() throws java.rmi.RemoteException {
        return msg; 
	}
	
	public void addChatListener (Alerte listener) throws java.rmi.RemoteException {
		System.out.println("adding listener -"+listener);
		list.add(listener); 
	}

	public void removeChatListener(Alerte listener)throws java.rmi.RemoteException {
		System.out.println("removing listener -"+listener);
		list.remove(listener); 
	}
	
	public String receiveMsg(Message msg, Joueur J, Piece p) throws RemoteException{
		listMessage.add(msg);
		System.out.println("Message reçu");
		System.out.println(msg.getEmetteur().getNom() + " : " + msg.getMsg());
		notifyListener(msg.getEmetteur(),msg.getMsg());
		return listMessage.get(0).getMsg();
	}

	
	private void notifyListener(Joueur emetteur, String msg) throws RemoteException {
		  for (Enumeration e = list.elements(); e.hasMoreElements();) { 
			  Alerte listener = (Alerte) e.nextElement();
			  Joueur J2 = listener.getJoueur();
			  if (J2.getPiece().getId() == emetteur.getPiece().getId()){
		    try {
		      listener.newMsg(emetteur,msg);
		    } catch(RemoteException re) {
		        System.out.println("removing listener -"+listener);
		        list.remove(listener); } 
		    } 
		   }
	}
	
	@Override
	public void chat() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Joueur getJoueur() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newMsg(Joueur emetteur, String msg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newJoueur(Joueur joueur) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
}