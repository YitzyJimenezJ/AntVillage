

package Control;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class archivos {
    public ListaHistorico listapartidas;
    public int cantiArchivos;
    public archivos() {
        this.listapartidas = new ListaHistorico();
        cantiArchivos = getCantidadPartidas();
    }

    
    
    public static void crearXML(String nombArch, int cNodos, int cAlimentos, int cVerde, int cAzul) {
        
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            
            Document documento = implementation.createDocument(null, "Partida", null);
            documento.setXmlVersion("1.0");
            
            Element partida = documento.createElement("partida");
            
            Element nodos = documento.createElement("CantidadNodos");
            Text textNodos = documento.createTextNode(String.valueOf(cNodos));
            nodos.appendChild(textNodos);
            partida.appendChild(nodos);
            
            Element alimentos = documento.createElement("CantidadAlimentos");
            Text textAlimentos = documento.createTextNode(String.valueOf(cAlimentos));
            alimentos.appendChild(textAlimentos);
            partida.appendChild(alimentos);
            
            Element cverdes = documento.createElement("RecolectadosEquipoVerde");
            Text textVerdes = documento.createTextNode(String.valueOf(cVerde));
            cverdes.appendChild(textVerdes);
            partida.appendChild(cverdes);
            
            Element cazules = documento.createElement("RecolectadosEquipoAzul");
            Text textAzules = documento.createTextNode(String.valueOf(cAzul));
            cazules.appendChild(textAzules);
            partida.appendChild(cazules);
            
            documento.getDocumentElement().appendChild(partida);
            
            Source sourse = new DOMSource(documento);
            Result result = new StreamResult(new File(nombArch));
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(sourse, result);
        }catch(ParserConfigurationException | TransformerConfigurationException ex){
            System.out.println("\n\nError al crear archivo");
        } catch (TransformerException ex) {
            System.out.println("+Error al trasformar");
        }  
    }
    public void leerXML(){
        for(int contador = 1; contador <= cantiArchivos;contador++ ){
            String nombArch = "partida"+String.valueOf(contador)+".xml";
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                File xml  = new File(nombArch);
                Document documento = builder.parse(xml);
                NodeList partidas = documento.getElementsByTagName("partida");
                for(int i = 0; i< partidas.getLength(); i++ ){
                    Node nodo = partidas.item(i);
                    if(nodo.getNodeType() == Node.ELEMENT_NODE){
                        Element e = (Element) nodo; 
                        NodeList hijos = e.getChildNodes();
                        
                        int[] listaAtributos = new int[4];
                        for(int j = 0; j < hijos.getLength(); j++){
                            Node hijo = hijos.item(j);
                            if(hijo.getNodeType() == Node.ELEMENT_NODE){
                               Element ehijo = (Element) hijo; 
                               listaAtributos[j] = Integer.parseInt(ehijo.getTextContent().trim());
                            }
                        }
                        listapartidas.Insertar(
                                contador, 
                                listaAtributos[0],
                                listaAtributos[1], 
                                listaAtributos[2],
                                listaAtributos[3]);
                    }
                }
            } catch (ParserConfigurationException | SAXException ex) {
                Logger.getLogger(archivos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println("NO SE ENCUENTRA EL ARCHIVOS");
            }   
        } 
    }
    public int getCantidadPartidas()
    {
        int contador = 1; 
        boolean archivoExiste = true;
        while(archivoExiste)
        {
            String nombArch = "partida"+String.valueOf(contador)+".xml";
            try 
            {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document documento = builder.parse(new File(nombArch));
                contador+=1;
            }catch(IOException ex)
            {
                archivoExiste = false;
                System.out.println("Ya no hay más archivos por leer");
            } catch (ParserConfigurationException | SAXException ex) 
            {
                archivoExiste = false;
                Logger.getLogger(archivos.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERROR CON LOS BUILDERS");
            }
        
        }
    return contador;
    }
    
    public boolean borrarPartida(int partida){
        String nombArch= "partida"+String.valueOf(partida)+".xml";
        File fichero = new File(nombArch);
        if (fichero.delete())
        {
            System.out.println("El fichero ha sido borrado satisfactoriamente");
            listapartidas.eliminar(partida);
            return true;
        }
        else{
            System.out.println("El fichero no puede ser borrado");
            return false;
        }
    }
}