
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Grafo {
    private ArrayList<Nodo> listaNodos;
    private int cantidad_nodos;
    private int[][] adyacencia;

    public Grafo(int cantidad_nodos) {
        this.listaNodos = new ArrayList <> ();
        this.cantidad_nodos = cantidad_nodos;
        this.adyacencia = new int[cantidad_nodos][cantidad_nodos];
    }
  
    public Nodo getPrimerNodo(){
        return listaNodos.get(0);
    }
    public void agregar(int id, int x, int y ){
        Nodo nuevoNodo = new Nodo(id, x, y, false);
        listaNodos.add(nuevoNodo);
    }
    public Nodo obtenerNodo(int id){
        return listaNodos.get(id);
    }
    public boolean colocarAlimento(int id){
        Nodo actual = obtenerNodo(id);
        actual.setHaveFood(true);
        return true;
    }
    public void colocarArco(int id_nodoA, int id_nodoB, int peso){
        this.adyacencia[id_nodoA][id_nodoB] = peso;
    }

    public ArrayList<Nodo> getListaNodos() {
        return listaNodos;
    }

    public void setListaNodos(ArrayList<Nodo> listaNodos) {
        this.listaNodos = listaNodos;
    }

    public int getCantidad_nodos() {
        return cantidad_nodos;
    }

    public void setCantidad_nodos(int cantidad_nodos) {
        this.cantidad_nodos = cantidad_nodos;
    }

    public int[][] getAdyacencia() {
        return adyacencia;
    }

    public void setAdyacencia(int[][] adyacencia) {
        this.adyacencia = adyacencia;
    }
    public String get_Arcos_To_String(int idNodo){
        String arcos= "";
        for(int i = 0; i <cantidad_nodos; i++)
        {
            int valor = this.adyacencia[idNodo][i];
            if (valor!=0)
            {
             arcos+= String.valueOf(idNodo)+" -> "+String.valueOf(i)+" = "+String.valueOf(valor)+"\n";
            }
        }
        if(arcos.isBlank())
        {
            arcos = "Sin arcos";  
        }
        return arcos;
    
    }
    public boolean haveArco(int idNodoA, int idNodoB){
        int valor = this.adyacencia[idNodoA][idNodoB];
        if (valor >0){
            return true; //tiene un arco
        }else{
            return false; //no hay conexión entre ellos
        }
    }
    //Métoodo sobrecargado de la función anterior
    public boolean haveArco(Nodo nodoA, Nodo nodoB){
        int valor = this.adyacencia[nodoA.getId()][nodoB.getId()];
        if (valor >0){
            return true; //tiene un arco
        }else{
            return false; //no hay conexión entre ellos
        }
    }
}

