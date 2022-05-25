/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.VMedioJuego;

/**
 *
 * @author Esteb
 */
public class Hormiga extends Thread{
    private int id; //identificadores que serán necesarios si queremos dejar el programa escalable
    public int nombre;  
    private VMedioJuego ventana; //modificar movimientos de la hormiga
    private int x;
    private int y;
    private int comidaRecolectada; 
    private int velocidad; 
  /*La velocidad podría ser o no una constante, pero por ahora parametrizamos los
    valores porque sabemos que el algoritmo de dijkstra recorre el camino más corto
    directamente; será más rápido que el de fuerza bruta, por lo tanto las hormigas
    verdes tienen la ventaja; entonces podríamos modificar la velocidad para que las verdes
    se muevan más lento y las azules más rápido*/

    public Hormiga(int id, int nombre, VMedioJuego ventana, int x, int y, int velocidad) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.ventana = ventana;
        this.x = x; //recibe el parámetro del x del primer nodo (inicio)
        this.y = y; //recibe el parámetro del y del primer nodo (inicio)
        this.comidaRecolectada = 0; //ambas hormigas inician sin alimento
        this.velocidad = velocidad;
    }
    public Hormiga() {
        super();
        this.comidaRecolectada = 0; 
    }
    //Hilo
    @Override
    public void run(){
        while(true){
            try
            {
                /*falta encontrar la comida, desplazarse etc etc*/
                System.out.println("SLEEP");
                sleep(velocidad);
                System.out.println("NO SLEEP");
            }catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
   
    
    
    // MÉTODOS GETTER AND SETTER

    public int obtenerId() {
        return id;
    }
    
    
    

    public int getVelocidad() {
        return velocidad;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getComidaRecolectada() {
        return comidaRecolectada;
    }

    public void setComidaRecolectada(int comidaRecolectada) {
        this.comidaRecolectada = comidaRecolectada;
    }
    
    
    
    
}
