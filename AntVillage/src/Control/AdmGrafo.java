/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Dijkstra;
import Modelo.FuerzaBruta;
import Modelo.Grafo;
import Modelo.Nodo;
import java.lang.Math;
import java.util.ArrayList;
/**
 * @author 
 */
public class AdmGrafo extends FuerzaBruta{
    int MIN_X;//Minimo pixeles en la ventana
    int MAX_X;//maximo pixeles en la ventana
    int MIN_Y;//Minimo pixeles en la ventana
    int MAX_Y;//maximo pixeles en la ventana
   
    private final int FACTOR_PESO = 100;
    private final int GRAN_PESO = 999999 ;
    //todas las variables privadas
    private final Grafo grafo;
    private final int cantidad_nodos;
    private Nodo nodo_espera_alimento;
    
  

    public AdmGrafo( int cantidad_nodos, int xmin,int ymin,int xmax,int ymax) {
        this.cantidad_nodos = cantidad_nodos;
        this.grafo = new Grafo(cantidad_nodos);
        MIN_X = xmin;
        MIN_Y = ymin;
        MAX_X = xmax;
        MAX_Y = ymax;
        
    }
      /*
        Función que me genera el grafo con valores aleatorios según la cantidad
        de nodo que ingresó el usuario
        */ 

    public void iniciarGrafo(){
        int x; //recibirá el valor aleatorio de x respecto a su posición en el frame
        int y; //recibirá el valor aleatorio de x respecto a su posición en el frame
        for (int i = 0; i<cantidad_nodos;i++ ){
            x = generarAleatorioX();
            y = generarAleatorioY();
            this.grafo.agregar(i, x, y);
        }
    }
    public void colocarArcos(){
        for (int i = 0; i < cantidad_nodos; i++){
            int nodoA = i; // es lo mismo pero se entenderá mejor
            int cantidadArcos = (int ) (Math.random() * cantidad_nodos);
            for(int j = 0; j < cantidadArcos; j++){
                    int nodoB = escogerNodoAleatorio(nodoA);
                    if(!grafo.haveArco(nodoA, nodoB)){
                        int pesoAB = (int) (Math.random() * FACTOR_PESO);
                        int pesoBA = (int) (Math.random() * FACTOR_PESO);
                        this.grafo.colocarArco(nodoA, nodoB, pesoAB);
                        this.grafo.colocarArco(nodoB, nodoA, pesoBA);
                    }else{
                        System.out.println("El nodo: "+String.valueOf(i)+ " ya "
                                + "tiene un arco ");
                    }
            }
        }
    }
    private int escogerNodoAleatorio(int a){
        int b = (int)  (Math.random() * (this.cantidad_nodos-1));//+1 porque los nodos empiezan desde 0
        while (a == b)//evitar que sea el mismo nodo o que ya tenga arco
        { 
            b = (int) (Math.random() * (this.cantidad_nodos-1));
        }
        return b;
    }
    //Generador de números aleatorios
    private int generarAleatorioX(){
        int rango = (MAX_X-MIN_X)+1;
        return (int)(Math.random()*rango)+MIN_X;
    }
    private int generarAleatorioY(){
        int rango = (MAX_Y-MIN_Y)+1;
        return (int)(Math.random()*rango)+MIN_Y;
    }
    //=========================================================================
    //                      Métodos de control de alimento
    //=========================================================================
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
    public int aparecerAlimentoEspera(int i){
        this.grafo.setAlimentoEspera(i);
        return i;
     }
    //=======================================================================
    //                  Getter-setter--imprimir grafo 
    //========================================================================
 
    public Nodo getNodoGrafo(int i){
        return this.grafo.obtenerNodo(i);
    }
    public void imprimirGrafo(){
        for(int i = 0; i < this.cantidad_nodos; i++){
            System.out.println(getNodoGrafo(i).toString());
            System.out.println(this.grafo.get_Arcos_To_String(i));
        }   
    }
    public Grafo getGrafo() {
        return grafo;
    }
    public Nodo getNodoAlimento(){
        return grafo.getNodoAlimento();
    }

    public void setNodo_espera_alimento(Nodo nodo_espera_alimento) {
        this.nodo_espera_alimento = nodo_espera_alimento;
    }
    public int getMAX(){
        return this.GRAN_PESO;
    }

}
