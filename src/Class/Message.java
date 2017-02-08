package Class;

public class Message {
	public Joueur emetteur;
	public String message;
	
	public Message(Joueur emetteur, String message){
		this.emetteur = emetteur;
		this.message = message;
	}
	
	public Joueur getEmetteur(){
		return emetteur;
	}
	
	public String getMsg(){
		return message;
	}
}
