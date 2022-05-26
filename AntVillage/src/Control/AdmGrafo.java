/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Grafo;
import Modelo.Nodo;
import java.lang.Math;
/**
 *
 * @author 
 */

public class AdmGrafo {
    /*acordarse que si los ponemos directamente en el panel con pos x y y en = 0
    podríamos quitar los valores mínimos por ser constantes*/
    //todas las variables publicas
    int MIN_X = 0;//Minimo pixeles en la ventana
    int MAX_X = 0;//maximo pixeles en la ventana
    int MIN_Y = 0;//Minimo pixeles en la ventana
    int MAX_Y = 0;//maximo pixeles en la ventana
    int TOPE_ARISTAS= 5;
    final int FACTOR_PESO = 100;
    //todas las variables privadas
    private Grafo grafo;
    private int cantidad_nodos;

    public AdmGrafo( int cantidad_nodos, int xmin,int ymin,int xmax,int ymax) {
        this.cantidad_nodos = cantidad_nodos;
        this.grafo = new Grafo(cantidad_nodos);
        MIN_X = xmin;
        MIN_Y = ymin;
        MAX_X = xmax;
        MAX_Y = ymax;
        if (TOPE_ARISTAS<this.cantidad_nodos){//valida que no vengan menos nodos que aristas
            TOPE_ARISTAS = this.cantidad_nodos;
        }
        //iniciar grafo 
    }
      /*
        Función que me genera el grafo con valores aleatorios según la cantidad
    de nodo que ingresó el usuario
        */ 
    private int generarAleatorioX(){
        int rango = (MAX_X-MIN_X)+1;
        return (int)(Math.random()*rango)+MIN_X;
    }
    private int generarAleatorioY(){
        int rango = (MAX_Y-MIN_Y)+1;
        return (int)(Math.random()*rango)+MIN_Y;
    }
    public boolean iniciarGrafo(){
       
        int x; //recibirá el valor aleatorio de x respecto a su posición en el frame
        int y; //recibirá el valor aleatorio de x respecto a su posición en el frame
        for (int i = 0; i<cantidad_nodos;i++ ){
            x = generarAleatorioX();
            y = generarAleatorioY();
            this.grafo.agregar(i, x, y);
        }
        return true;
    }
    
    public boolean dirigirGrafo(){
        for (int i = 0; i < TOPE_ARISTAS; i++){
            int nodoA = (int ) (Math.random() * (this.cantidad_nodos-1));//conecta con un random
            int nodoB = (int)  (Math.random() * (this.cantidad_nodos-1));//+1 porque los nodos empiezan desde 0
            while (nodoA == nodoB){ //evitar que sea el mismo nodo
                 nodoB = (int) (Math.random() * (this.cantidad_nodos-1));
            }
            int peso = (int) (Math.random() * FACTOR_PESO);
            this.grafo.colocarArco(nodoA, nodoB, peso);
        }
        return true;
    }

    public Grafo getGrafo() {
        return grafo;
    }
    
    /*
    Métodos sobrecargados para colocar alimento, si recibe parámetro, lo inserta
    si no, genera uno aleatorio por si el usuario no coloca la comida en ningún nodo
    lo hará automáticamente
    */
    public int aparecerAlimento(int i ){
        this.grafo.colocarAlimento(i);
        return i; 
    }
    public int aparecerAlimento(){
        int posAlimento = (int)  (Math.random()*(this.cantidad_nodos-1))+1 ;
        this.grafo.colocarAlimento(posAlimento);
        return posAlimento;
    }
    /*
    Cualquiera de los dos métodos siguientes puede ser utilizado para sacar el primer nodo
    solo que uno es más directo que el otro y quedará a criterio del programador
    */
    public Nodo getNodoGrafo(int i){
        return this.grafo.obtenerNodo(i);
    }
    public Nodo getPrimerNodo(){
        return this.grafo.getPrimerNodo();
    }
    public void imprimirGrafo(){
        for(int i = 0; i < this.cantidad_nodos; i++){
            System.out.println(getNodoGrafo(i).toString());
            System.out.println(this.grafo.get_Arcos_To_String(i));
        }
            
    }
    public int getTipoRelacion(int idnodoA, int idnodoB){
        boolean ida = this.grafo.haveArco(idnodoA, idnodoB);
        boolean vuelta = this.grafo.haveArco(idnodoB, idnodoA);
        if(ida){
            return 1; //tiene solo un arco
        }else if(vuelta){
            return 2;
        }else if (ida && vuelta){
            return 3; //tiene los dos arcos 
        }else{
            return 0; // no tiene ningún arco
        }
        
    }
}
