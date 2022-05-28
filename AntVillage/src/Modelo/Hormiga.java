/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.VMedioJuego;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Esteb
 */
public class Hormiga extends Thread{
    private int id; //identificadores que serán necesarios si queremos dejar el programa escalable
    public String nombre;  
    private VMedioJuego ventana; //modificar movimientos de la hormiga
    private int xActual;
    private int yActual;
    private int xInicial;
    private int yInicial;
    private int comidaRecolectada; 
    private int velocidad; 
    private JLabel imagen;
    private ArrayList<Nodo> camino;
    public volatile boolean ganador; //se sabe quién es el ganador 
  /*La velocidad podría ser o no una constante, pero por ahora parametrizamos los
    valores porque sabemos que el algoritmo de dijkstra recorre el camino más corto
    directamente; será más rápido que el de fuerza bruta, por lo tanto las hormigas
    verdes tienen la ventaja; entonces podríamos modificar la velocidad para que las verdes
    se muevan más lento y las azules más rápido*/

    public Hormiga(int id, String nombre, VMedioJuego ventana, int x, int y, int velocidad) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.ventana = ventana;
        this.xActual = x; //recibe el parámetro del x del primer nodo (inicio)
        this.yActual = y; //recibe el parámetro del y del primer nodo (inicio)
        this.comidaRecolectada = 0; //ambas hormigas inician sin alimento
        this.velocidad = velocidad;
        this.xInicial = x; //inicializa los valores de una vez en el constructor
        this.yInicial = y; //inicializa los valores de una vez en el constructor
        this.camino = new ArrayList<>();
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }
    
    //devuelve  a la hormiga a la posición del primer nodo una vez que encuentre
    //la comida
    public void restartPoint(){
        this.xActual = this.xInicial;
        this.yActual = this.yInicial;
        this.imagen.setLocation(this.xInicial, this.yInicial);
    }
    public Hormiga() {
        super();
        this.comidaRecolectada = 0; 
    }
    //Hilo
    @Override
    public void run(){
        boolean respuesta =true;
        while(!ganador){
            if(camino!=null){
                for(int i = 0; i < camino.size(); i++){
                    Nodo unNodo = camino.get(i);
                    respuesta =dezplazar(unNodo.getX(), unNodo.getY());
                    if (!respuesta){
                        break; //evitar que siga porque ya perdió 
                    }
                }
                if(respuesta){
                    this.ventana.hormiga_ganadora = this.id; //esto debe ir aquí porque es cuando justo terminó de recorrer todo el algoritmo
                }
            }else{
                System.out.println("Error lista de caminos vacía");
            }
            ganador =true;    
        }
        restartPoint();
        if(respuesta){
            this.comidaRecolectada+=1;
            if(this.id == 0){
                this.ventana.getTxtAA().setText(String.valueOf(this.comidaRecolectada));
            }else{
                 this.ventana.getTxtAV().setText(String.valueOf(this.comidaRecolectada));
            }
        }
    }
    private boolean dezplazar(int xDestino, int yDestino){
        boolean salir = false;
        while(!salir){
            if(ventana.hormiga_ganadora != this.id && ventana.hormiga_ganadora !=-1){
                return false; //si es diferente a -1 y diferente este id es porque ganó otra
            }
            if(xActual == xDestino && yActual == yDestino)
            {
                salir = true;
            }
            if(xActual < xDestino)
            {
                xActual+=1;
            }else if(xActual> xDestino)
            {
                xActual-=1;
            }
            if(yActual < yDestino)
            {
                yActual+=1;
            }else if(yActual>yDestino)
            {
                yActual-=1;
            }
            this.imagen.setLocation(xActual, yActual); // otra es actualizarlo desde la ventana 
            try
            {
                System.out.println("SLEEP: "+ this.nombre);
                sleep(velocidad);
            }catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
        return true;
    }
    public void setCamino (ArrayList<Nodo> camino){
        this.camino = camino;
    }
   
    
    // MÉTODOS GETTER AND SETTER

    public JLabel getImagen() {
        return imagen;
    }

    public int getxActual() {
        return xActual;
    }

    public int getyActual() {
        return yActual;
    }

    public int getxInicial() {
        return xInicial;
    }

    public int getyInicial() {
        return yInicial;
    }
    
    
    
    
    public int obtenerId() {
        return id;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public int getComidaRecolectada() {
        return comidaRecolectada;
    }

    public void setComidaRecolectada(int comidaRecolectada) {
        this.comidaRecolectada = comidaRecolectada;
    }
    
    
    
    
}
