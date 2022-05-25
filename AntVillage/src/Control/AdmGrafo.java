/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Grafo;
import java.lang.Math;
/**
 *
 * @author 
 */

public class AdmGrafo {
    /*acordarse que si los ponemos directamente en el panel con pos x y y en = 0
    podríamos quitar los valores mínimos por ser constantes*/
    final int MIN_X = 0;//Minimo pixeles en la ventana
    final int MAX_X = 0;//maximo pixeles en la ventana
    final int MIN_Y = 0;//Minimo pixeles en la ventana
    final int MAX_Y = 0;//maximo pixeles en la ventana
    final int TOPE_ARISTAS= 5;
    final int FACTOR_PESO = 100;
    
    private Grafo grafo;
    private int cantidad_alimento;
    private int cantidad_nodos;
    //otras como hormigas azules y verdes etc etc

    public AdmGrafo(int cantidad_alimento, int cantidad_nodos) {
        this.cantidad_alimento = cantidad_alimento;
        this.cantidad_nodos = cantidad_nodos;
        this.grafo = new Grafo(cantidad_nodos);
        
        
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
        this.dirigirGrafo();
        return true;
    }
    
    private boolean dirigirGrafo(){
        for (int i = 0; i < TOPE_ARISTAS; i++){
            int nodoA = (int ) (Math.random() * (this.cantidad_nodos-1));//conecta con un random
            int nodoB = (int)  (Math.random() * (this.cantidad_nodos-1));//+1 porque los nodos empiezan desde 0
            while (nodoA == nodoB){ //evitar que sea el mismo nodo
                 nodoB = (int) (Math.random() * (this.cantidad_nodos-1));
            }
            int peso = (int) Math.random() * FACTOR_PESO;
            this.grafo.colocarArco(nodoA, nodoB, peso);
        }
        return true;
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
        int posAlimento = (int) Math.random()* (this.cantidad_nodos-1)+2 ;
        this.grafo.colocarAlimento(posAlimento);
        return posAlimento;
    }
    
}
