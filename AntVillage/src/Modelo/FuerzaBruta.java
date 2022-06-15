
package Modelo;

import Control.AdmGrafo;
import java.util.ArrayList;

/**
 *
 * @author Yitzy
 */
/**
*@code Algoritmo que va otorgando los valores para la hormiga azul vaya 
* recorriendo el camino
*/
public class FuerzaBruta {
    private ArrayList<Nodo>recorrido; //solo los nodos en orden
    private ArrayList<ArrayList<Nodo>>nodosAdyacentes; //lista de nodos adyacentes por cada nodo
    private AdmGrafo admgrafo;
    
    private Nodo anterior; //guarda el nodo anteriormente recorrido
    private Nodo actual;  //guarda el nodo actual
    
    
    public FuerzaBruta(AdmGrafo adm) {
        this.anterior = new Nodo (); //vacío porque empieza desde el actual 
        this.actual = adm.getNodoGrafo(0); //obtiene el nodo inicial
        this.admgrafo = adm;
        recorrido = new ArrayList();
        nodosAdyacentes = new ArrayList();
        recorrido.add(actual); 
        llenado();
    }
    /**
     *@code obtiene el siguiente nodo como opción a recorrer
     *@param vacío
     *@return el siguiente nodo
     */
    public Nodo siguienteCamino(){
        int i = actual.getId(); //obtiene el indice del nodo
        ArrayList<Nodo> adyacentes = nodosAdyacentes.get(i);//obtiene sus adyacentes
        if(adyacentes.size()> 0) //este if le permite devolverse si no tiene más arcos adyacentes
        {
            for(Nodo unNodoAdyacente : adyacentes) //va a recorrer todos los adyacentes
            {
                if(unNodoAdyacente.getId()!= anterior.getId()) //para que no regrese por el mismo
                {
                    anterior = actual;
                    actual = unNodoAdyacente;
                    recorrido.add(actual);
                    nodosAdyacentes.get(i).remove(unNodoAdyacente); //lo elimina para no volver a el
                    return actual;
                }
            }
        }else{
            actual = anterior; //se devuelve
            if(recorrido.size()-2>=0){
                anterior = recorrido.get(recorrido.size()-3);//obtiene el tras anterior
                System.out.println("El anterior es: "+String.valueOf(anterior.getId()));
            }else{
                 anterior = admgrafo.getNodoGrafo(0);
                //obtiene el primer nodo en caso de no encontrar más camino
            }
            System.out.println("FB: NODO"+String.valueOf(recorrido.get(
                    recorrido.size()-1).getId())+""
                            + "eliminado ");
            recorrido.remove(recorrido.size()-1); //remueve el último
        }
        return actual;
    }
    
    /**
     *@code llena los nodos adyacentes por cada nodo
     *@param vacío
     *@return vacío
     */
    private void llenado(){
        for(Nodo unNodo : admgrafo.getGrafo().getListaNodos()){
            recorrido.add(unNodo);
            nodosAdyacentes.add(admgrafo.getGrafo().getAdyacentesByNodo(unNodo));
        }
    }
      /**
     *@code Compara si el nodo que se ingresa corresponde al mismo del actual
     * para saber si ha llegado
     *@param Nodo destino
     *@return boolean
     */
    public boolean hallegado(Nodo destino){
        if(destino.getId() == actual.getId()){
            return true;
        }else
            return false;
    }
      /**
     *@code reinicia los valores en cero
     *@param vacío
     *@return vacío
     */
    public void restart(){
        
        recorrido = new ArrayList();
        nodosAdyacentes = new ArrayList();
        anterior = new Nodo (); //vacío porque empieza desde el actual 
        actual = admgrafo.getNodoGrafo(0); //obtiene el nodo inicial
        recorrido.add(actual); 
        llenado();
    }
    
}
