package Class;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

public class ServeurPersistance extends UnicastRemoteObject implements interfaceObjetPersistance{
	
	protected ServeurPersistance() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {

		LocateRegistry.createRegistry(1105);
		ServeurPersistance srv = new ServeurPersistance();
		Naming.bind("ServeurPersistance", srv);
		System.out.println("Serveur Persistance déclaré");
	}
	
	public void AjoutConnexion(String nom,String mdp) throws RemoteException {
		
		  File file = new File("C:\\Users/Public/Connexion.txt");
		try{
			PrintWriter writer = new PrintWriter(new FileWriter(file, true));
			//FileWriter writer = new FileWriter(file, true);
			String ligne;// = System.getProperty("line.separator");
			ligne=nom+" "+mdp;
		    writer.println(ligne);
		    writer.close();
		} catch (IOException e) {
			System.out.println("Erreur lors de la creation du fichier");
		}
	}
	
	public String Identification(String nom,String mdp) throws RemoteException {
		
	
	
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
		      //Suprise motherfucker
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
				      //Suprise motherfucker
				       System.out.println("MDP Correct");
					  scanner2.close();
					  return nom;
				   }
				   
				}
				scanner.close();
		   }
		}
	System.out.println("Identifiant incorrect");	
	return null;	
	}

	public void EcrireCreation(String nom) throws RemoteException {
	try{
	    PrintWriter writer = new PrintWriter("C:\\Users/Public/"+nom+".txt", "UTF-8");
	    writer.println(nom);
	    writer.println("10");
	    writer.println("3");
	    writer.println("0");
	    writer.println("1");
	    writer.close();
	} catch (IOException e) {
		System.out.println("Erreur lors de la creation du fichier");
	}
		
	}
	
	public ArrayList<String> lecture(String nom) throws RemoteException {
		ArrayList<String> Perso = new ArrayList<String>(); 
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users/Public/"+nom+".txt", true));
			try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users/Public/"+nom+".txt"))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			    System.out.println(line);
			    Perso.add(line);
			    }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //File file = new File("C:\\Users/Public/"+nom+".txt");
		 //PrintWriter writer = null;
 catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return Perso;
	}

	public void EcrireMAJ(String nom,int pv,int x,int y,int id){
		
		try{
		    PrintWriter writer = new PrintWriter("C:\\Users/Public/"+nom+".txt", "UTF-8");
		    writer.println(nom);
		    writer.println(pv);
		    writer.println(x);
		    writer.println(y);
		    writer.println(id);
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
			
		}
	

	
	
	
}


	
	

	


