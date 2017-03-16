package Class;

import java.io.Serializable;

public class Monstre implements Serializable{
	private int Pdv;
	private String nom ;
	
	
	public Monstre(String nom ,int Pdv){
		this.nom=nom;
		this.Pdv=Pdv;
	}
	
	public int getPdv() {
		return Pdv;
	}
	public void setPdv(int Pdv) {
		this.Pdv = Pdv;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	} 
	
}
