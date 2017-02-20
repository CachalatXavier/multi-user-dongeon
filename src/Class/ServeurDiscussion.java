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

public class ServeurDiscussion extends UnicastRemoteObject implements interfaceObjetDiscussion{
	//Discussion chat = new Discussion();
	public ArrayList<Joueur> listJoueurChat = new ArrayList<Joueur>();
	public ArrayList<Message> listMessage = new ArrayList<Message>();
//	private interfaceDiscussionNotif notif;
	
	public ServeurDiscussion() throws RemoteException {
		super();
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
		System.out.println("server Discussion déclaré");
		
	}
	
	public String receiveMsg(Message msg, Joueur J, Piece p) throws RemoteException{
		listMessage.add(msg);
		System.out.println("Message reçu");
		System.out.println(msg.getEmetteur().getNom() + " : " + msg.getMsg());
		if(listMessage.get(0)!=null){
			for (int i = 0 ;  i < listMessage.size();i++){
					for (int j = 0 ; j < p.getListJoueur().size(); j++){
						p.getListJoueur().get(j).setAlertMsg(J.getNom(), msg.getMsg());
						System.out.println(listMessage.get(i).getEmetteur().getNom()+ " : " +listMessage.get(i).getMsg() + " : " + listMessage.get(i).getEmetteur().getPiece().getId());
					}	
				
			}
		}	
		try {
			printMsg(msg);
		} catch (MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMessage.get(0).getMsg();
	}
	
	public void printMsg(Message msg) throws MalformedURLException, RemoteException, NotBoundException{
		/*for (int i = 0 ;  i < listMessage.size();i++){
			if(listMessage.get(i).getEmetteur().getPiece() == J.getPiece()){
				System.out.println(listMessage.get(i).getEmetteur().getNom()+ " : " +listMessage.get(i).getMsg());
			}
		}*/
		Alerte A = (Alerte)Naming.lookup("//localhost/alerteMsg");	
		A.setMsg(msg.getEmetteur().getNom(),msg.getMsg());
	}
	
	public void clearDiscussion(){
		
	}
/*	public synchronized void enregistrerNotification(String nomJoueur, interfaceDiscussionNotif n, String msg)
			throws RemoteException {
		chat.setNotification(n, nomJoueur, msg);
	}
	
	public synchronized void enleverNotification(String nomJoueur) throws RemoteException {
		chat.setNotification(null, nomJoueur, null);
	}*/

	@Override
	public void chat() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printMsg(Joueur J, Message msg, AlerteMsg alerte1) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	/*public void addJoueurChat(Joueur j){
		chat.listJoueurChat.add(j);
	}

	public ArrayList<Joueur> getJoueurChat(Piece p){
		return p.getListJoueur();
	}
	
	public boolean receiveMsg(Message msg){
		chat.listMessage.add(msg);
		return true;
	}
	
	public void clearDiscussion(){
		chat.listMessage.clear();
	}
	
	public void printMsg1(){
		System.out.println(chat.listMessage.get(0).getEmetteur()+ " : " +chat.listMessage.get(0).getMsg());
	}
	*/
	



/*	@Override
	public void notification(String nomJoueur, String msg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}*/

	
}