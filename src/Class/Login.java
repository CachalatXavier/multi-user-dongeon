package Class;
import java.io.File;

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

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;




public class Login {
	int test;
	
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Login i= new Login();
		i.Ecrire();
		
	}
	
	
	
	public void Ecrire(){
		//Etape 1:Récuperation d'une instance de la classe "DocumentBuilderFactory"
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
		
		//Etape 2: Création d'un parseur
		    final DocumentBuilder builder = factory.newDocumentBuilder();
		    
		     //Etape 3 : création d'un Document
		    final Document document= builder.newDocument();
		    
		     //Etape 4 : création de l'Element racine
		    final Element racine = document.createElement("repertoire");
		    document.appendChild(racine);
		    
		    //Etape 5 Creation de l'element Personnage
		    final Element personnage = document.createElement("personnage");
		    racine.appendChild(personnage);
		    personnage.setAttribute("Login", "Aldra");
		    
		    final Element PdV = document.createElement("PdV");
		    personnage.appendChild(PdV);
		    PdV.appendChild(document.createTextNode("10"));
		    /*
		     * Etape 8 : affichage
		     */
		    final TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    final Transformer transformer = transformerFactory.newTransformer();
		    final DOMSource source = new DOMSource(document);
		    final StreamResult sortie = new StreamResult(new File("C:\\Users\file.xml"));
		    //final StreamResult result = new StreamResult(System.out);
				
		    //prologue
		    transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");			
		    		
		    //formatage
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				
		    //sortie
		    transformer.transform(source, sortie);

		}catch (final ParserConfigurationException e) {
		    e.printStackTrace();
		}
		catch (TransformerConfigurationException e) {
		    e.printStackTrace();
		}
		catch (TransformerException e) {
		    e.printStackTrace();
		}	
		 
		 
	 }
	
}
 