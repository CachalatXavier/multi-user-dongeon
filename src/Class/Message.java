package Class;
import java.io.Serializable;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Joueur emetteur;
	public String message;
	public Piece salon;
	
	public Message(Joueur emetteur, String message, Piece salon){
		this.emetteur = emetteur;
		this.message = message;
		this.salon = salon;
	}
	
	public Joueur getEmetteur(){
		return emetteur;
	}
	
	public String getMsg(){
		return message;
	}
	
	public Piece getSalon(){
		return salon;
	}
}
