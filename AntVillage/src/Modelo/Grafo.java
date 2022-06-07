
package Modelo;

import java.util.ArrayList;

    /**
    *@code tipo de dato no lineal del grafo que contiene nodos
    *y la matriz de adyacencia
    */
public class Grafo {
    private ArrayList<Nodo> listaNodos;
    private int cantidad_nodos;
    private int[][] adyacencia;
    public Grafo(int cantidad_nodos) {
        this.listaNodos = new ArrayList();
        this.cantidad_nodos = cantidad_nodos;
        this.adyacencia = new int[cantidad_nodos][cantidad_nodos];
    }
     /**
     *@code obtiene el primer nodo del grafo
     */
    public Nodo getPrimerNodo(){
        return listaNodos.get(0);
    }
     /**
     *@code crea un nodo con los valores 
     *@param int id, int x, int y
     *@return vacío
     */
    public void agregar(int id, int x, int y ){
        Nodo nuevoNodo = new Nodo(id, x, y, false);
        listaNodos.add(nuevoNodo);
    }
     /**
     *@code obtiene el nodo correspondiente a su id (el id es su posición en la lista)
     *@param int id
     *@return Nodo 
     */
    public Nodo obtenerNodo(int id){
        return listaNodos.get(id);
    }
    /**
     *@code colocar arco entre un par de nodos
     *@param int idNodoA, int idNodoB, int peso
     *@return vacío
     */
    public void colocarArco(int id_nodoA, int id_nodoB, int peso){
        this.adyacencia[id_nodoA][id_nodoB] = peso;
    }
    //GETTER-SETTER
    public ArrayList<Nodo> getListaNodos() {
        return listaNodos;
    }

    public int getCantidad_nodos() {
        return cantidad_nodos;
    }
    public void setAdyacencia(int[][] adyacencia) {
        this.adyacencia = adyacencia;
    }
    //Método tostring
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
      /**
     *@code obtiene una lista de todos los nodos adyacentes por un nodo
     *@param Nodo A
     *@return ArrayList<Nodo> listaAdyacentes
     */
    public ArrayList<Nodo> getAdyacentesByNodo(Nodo nodoA){
        ArrayList<Nodo> nodosConArco = new ArrayList();
        for(Nodo nodoB: listaNodos){
            if(haveArco(nodoA, nodoB)){
                nodosConArco.add(nodoB);
            }
        }
        return nodosConArco;
    }
     /**
     *@code Obtiene si hay un arco entre un par de nodos
     *@param int idNodoA, int idNodoB
     *@return boolean
     */
    public boolean haveArco(int idNodoA, int idNodoB){
        int valor = this.adyacencia[idNodoA][idNodoB];
        if (valor >0){
            return true; //tiene un arco de A -> B
        }else{
            return false; //no hay conexión entre ellos
        }
    }
    //Método sobrecargado de la función anterior, pero con el tipo de dato Nodo
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
      /**
     *@code coloca el alimento en un nodo otorgado
     *@param int id
     *@return vacío
     */
    public void colocarAlimento(int id){
        Nodo unNodo = obtenerNodo(id);
        unNodo.setHaveFood(true);
    }
      /**
     *@code coloca el alimento en un nodo otorgado
     *@param Nodo nodo
     *@return vacío
     */
     public void colocarAlimento(Nodo unNodo){
        unNodo.setHaveFood(true);
    }
    /**
     *@code retira el alimento de todos los nodos que tengan alimento
     *@param vacío
     *@return vacío
     */
    public void retirarAlimento(){
        /*Busca en el grafo el alimento para retirarlo del nodo 
        se supone que habrá un alimento en el grafo solamente*/
        for (int i = 0; i <cantidad_nodos; i++){
            Nodo unNodo = listaNodos.get(i);
            if(unNodo.isHaveFood()){
                unNodo.setHaveFood(false);
            }
        }
    }
    /**
     *@code retira el alimento de un nodo otorgado si este tiene alimento
     *@param Nodo unNodo / int id
     *@return boolean
     */
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
      /**
     *@code retorna el nodo que contiene el alimento
     *@param void
     *@return unNodo-Null en caso de que ningún nodo tenga alimento
     */
    public Nodo getNodoAlimento(){
        for(int i = 0; i<cantidad_nodos; i++){
            Nodo unNodo = listaNodos.get(i);
            if  (unNodo.isHaveFood()){
                return unNodo;
            }
        }
        return null;
    }
     /**
     *@code retorna verdadero si existe algun nodo con el alimento
     *@param vacío
     *@return boolean
     */
    public boolean hayComida(){
        for(Nodo unNodo : this.listaNodos){
            if(unNodo.isHaveFood()){
                return true; //El grafo tiene un alimento
            }
        }
        return false;//El grafo no tiene alimento
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

