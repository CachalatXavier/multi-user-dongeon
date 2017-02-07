package Class;

import java.io.Serializable;

public class Monstre implements Serializable{
	private int vie;
	private String nom ;
	
	
	public Monstre(String nom ,int vie){
		this.nom=nom;
		this.vie=vie;
	}
	
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	} 
	
}
