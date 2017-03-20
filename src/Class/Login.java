package Class;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Login {
	int test;
	public ArrayList<Document> stylo = new ArrayList<Document>();
	
	
	
	public void AjoutConnexion(String nom,String mdp){
		
		  File file = new File("C:\\Users/Public/Connexion.txt");
		try{
			PrintWriter writer = new PrintWriter(new FileWriter(file, true));
			String ligne;// = System.getProperty("line.separator");
			ligne=nom+" "+mdp;
		    writer.println(ligne);
		    writer.close();
		} catch (IOException e) {
			System.out.println("Erreur lors de la creation du fichier");
		}
	}
	
	public int Identification(){
		
		System.out.println("Bonjour comment s'appelle votre Personnage?");
		Scanner perso = new Scanner(System.in);
		  	String nom = perso.nextLine();
		System.out.println("Veuillez Rentrer votre Mot de Passe");
		String mdp = perso.nextLine();
	
		 File file = new File("C:\\Users/Public/Connexion.txt");
		//Recherche Nom
		Scanner scanner=null;
		Scanner scanner2=null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (scanner.hasNextLine()) {
		   final String lineFromFile = scanner.nextLine();
		   if(lineFromFile.contains(nom)) { 
		       System.out.println("Nom Correct");
			   
		       
			try {
				scanner2 = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				while (scanner2.hasNextLine()) {
				   final String lineFromFile2 = scanner2.nextLine();
				   if(lineFromFile2.contains(mdp)) { 
				       System.out.println("MDP Correct");
					  scanner2.close(); 
				       break;
				   }
				   return 1;
				}
				scanner.close();
		       break;
		   }
		}
	System.out.println("Identifiant incorrect");	
	return 0;	
	}

	public void EcrireCreation(String nom){
	try{
	    PrintWriter writer = new PrintWriter("C:\\Users/Public/"+nom+".txt", "UTF-8");
	    writer.println(nom);
	    writer.println("10");
	    writer.println("3");
	    writer.println("0");
	    writer.close();
	} catch (IOException e) {
		System.out.println("Erreur lors de la creation du fichier");
	}
		
	}
	
	public ArrayList lecture(String nom){
		ArrayList<String> Perso = null; 
		 File file = new File("C:\\Users/Public/"+nom+".txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       Perso.add(line);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Perso;
	}
	public void EcrireMAJ(String nom,int pv,int x,int y){
		
		try{
		    PrintWriter writer = new PrintWriter("C:\\Users/Public/"+nom+".txt", "UTF-8");
		    writer.println(nom);
		    writer.println(pv);
		    writer.println(x);
		    writer.println(y);
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
			
		}
	
	
	
}
 