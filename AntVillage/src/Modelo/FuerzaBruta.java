/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Control.AdmGrafo;
import java.util.ArrayList;

/**
 *
 * @author Yitsy
 */
public class FuerzaBruta {
    private ArrayList<Nodo>recorrido; //solo los nodos en orden
    private ArrayList<ArrayList<Nodo>>nodosAdyacentes; //lista de nodos adyacentes por cada nodo
    private AdmGrafo admgrafo;
    
    private Nodo anterior;
    private Nodo actual; 
    public FuerzaBruta(AdmGrafo adm) {
        this.anterior = new Nodo (); //vacío porque empieza desde el actual 
        this.actual = adm.getNodoGrafo(0); //obtiene el nodo inicial
        this.admgrafo = adm;
        recorrido = new ArrayList();
        nodosAdyacentes = new ArrayList();
        recorrido.add(actual); 
        llenado();
    }

    public FuerzaBruta() {
    }
    
    public Nodo siguienteCamino(){
        int i = actual.getId(); //obtiene el indice del nodo
        ArrayList<Nodo> adyacentes = nodosAdyacentes.get(i);//obtiene sus adyacentes
        if(adyacentes.size()> 0) //este if le permite devolverse si no tiene más arcos adyacentes
        {
            for(Nodo unNodoAdyacente : adyacentes)
            {
                if(unNodoAdyacente.getId()!= anterior.getId()) //para que no regrese por el mismo
                {
                    anterior = actual;
                    actual = unNodoAdyacente;
                    System.out.println("FB: NODO"+String.valueOf(actual.getId())+""
                            + "Agregado ");
                    recorrido.add(actual);
                    nodosAdyacentes.get(i).remove(unNodoAdyacente); //lo elimina para no volver a el
                    return actual;
                }
            }
        }else{
            actual = anterior;
            if(recorrido.size()-2>=0){
                anterior = recorrido.get(recorrido.size()-3);//obtiene el tras anterior
                System.out.println("El anterior es: "+String.valueOf(anterior.getId()));
            }else{
                 anterior = admgrafo.getNodoGrafo(0);//obtiene el primer nodo
            }
            System.out.println("FB: NODO"+String.valueOf(recorrido.get(
                    recorrido.size()-1).getId())+""
                            + "eliminado ");
            recorrido.remove(recorrido.size()-1); //remueve el último
        }
        return actual;
    }
    
    
    private void llenado(){
        for(Nodo unNodo : admgrafo.getGrafo().getListaNodos()){
            recorrido.add(unNodo);
            nodosAdyacentes.add(admgrafo.getGrafo().getAdyacentesByNodo(unNodo));
        }
    }
    public void restart(){
        
        recorrido = new ArrayList();
        nodosAdyacentes = new ArrayList();
        anterior = new Nodo (); //vacío porque empieza desde el actual 
        actual = admgrafo.getNodoGrafo(0); //obtiene el nodo inicial
        recorrido.add(actual); 
        llenado();
    }
    //GETTER-SETTER
    
}
