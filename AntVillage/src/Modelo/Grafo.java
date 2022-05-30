
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
    private Nodo espera;
    public Grafo(int cantidad_nodos) {
        this.listaNodos = new ArrayList();
        this.cantidad_nodos = cantidad_nodos;
        this.adyacencia = new int[cantidad_nodos][cantidad_nodos];
        Nodo espera = null;
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
   
    public void colocarArco(int id_nodoA, int id_nodoB, int peso){
        this.adyacencia[id_nodoA][id_nodoB] = peso;
    }

    public ArrayList<Nodo> getListaNodos() {
        return listaNodos;
    }

    public int getCantidad_nodos() {
        return cantidad_nodos;
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
    public ArrayList<Nodo> getAdyacentesByNodo(Nodo nodoA){
        ArrayList<Nodo> nodosConArco = new ArrayList();
        for(Nodo nodoB: listaNodos){
            if(haveArco(nodoA, nodoB)){
                nodosConArco.add(nodoB);
            }
        }
        return nodosConArco;
    }
    public boolean haveArco(int idNodoA, int idNodoB){
        int valor = this.adyacencia[idNodoA][idNodoB];
        if (valor >0){
            return true; //tiene un arco de A -> B
        }else{
            return false; //no hay conexión entre ellos
        }
    }
    //Método sobrecargado de la función anterior
    public boolean haveArco(Nodo nodoA, Nodo nodoB){
        int valor = this.adyacencia[nodoA.getId()][nodoB.getId()];
        if (valor >0){
            return true; //tiene un arco
        }else{
            return false; //no hay conexión entre ellos
        }
    }
    //=========================================================================
    //                      Métodos de control de alimento
    //=========================================================================
    public void colocarAlimento(int id){
        Nodo unNodo = obtenerNodo(id);
        unNodo.setHaveFood(true);
    }
     public void colocarAlimento(Nodo unNodo){
        unNodo.setHaveFood(true);
    }
     public void setAlimentoEspera(int i){
         Nodo unNodo = obtenerNodo(i);
         System.out.println("Has colocado el alimento en la espera en el nodo:"
                 + String.valueOf(i));
         espera = unNodo;
    }
     public void retirarAlimentoEspera(){
         espera = null;
     }
  
    public boolean retirarAlimento(){
        /*Busca en el grafo el alimento para retirarlo del nodo 
        se supone que habrá un alimento en el grafo solamente*/
        for (int i = 0; i <cantidad_nodos; i++){
            Nodo unNodo = listaNodos.get(i);
            if(unNodo.isHaveFood()){
                unNodo.setHaveFood(false);
                return true;
            }
        }
        return false;
    }
    public boolean retirarAlimento(Nodo unNodo){
        if(unNodo.isHaveFood()){
            unNodo.setHaveFood(false);
            return true; //alimento retirado
        }else{
            return false;
        }
    }
    public boolean retirarAlimento(int id){
        Nodo unNodo = listaNodos.get(id);
        if(unNodo.isHaveFood()){
            unNodo.setHaveFood(false);
            return true; //alimento retirado
        }else{
            return false;
        }
    }
    
    public Nodo getNodoAlimento(){
        /*
        Retorna el nodo que contiene el alimento
        si ninguno tiene alimento retorna null
        */
        for(int i = 0; i<cantidad_nodos; i++){
            Nodo unNodo = listaNodos.get(i);
            if  (unNodo.isHaveFood()){
                return unNodo;
            }
        }
        return null;
    }
    public boolean hayComida(){
        for(Nodo unNodo : this.listaNodos){
            if(unNodo.isHaveFood()){
                return true; //El grafo tiene un alimento
            }
        }
        return false;//El grafo no tiene alimento
    }

    public Nodo getEspera() {
        return espera;
    }
    
    /**
     *Obtiene el valor del arco entre un par de nodos
     * @return valor del peso
     */
    public int getArco(int a, int b){
        int valor = this.adyacencia[a][b];
        return valor;
    }
    public int getArco(Nodo a, Nodo b){
        int valor = this.adyacencia[a.getId()][b.getId()];
        return valor;
    }
    
}

