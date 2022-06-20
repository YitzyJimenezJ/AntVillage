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
 * 
 */
public class Hormiga {
    private int id; //identificadores que serán necesarios si queremos dejar el programa escalable
    public String nombre;  
    private int xActual;
    private int yActual;
    private int xInicial;
    private int yInicial;
    private int comidaRecolectada; 
    private int totalAlimento;
    private int velocidad; 
  
  /*La velocidad podría ser o no una constante, pero por ahora parametrizamos los
    valores porque sabemos que el algoritmo de dijkstra recorre el camino más corto
    directamente; será más rápido que el de fuerza bruta, por lo tanto las hormigas
    verdes tienen la ventaja; entonces podríamos modificar la velocidad para que las verdes
    se muevan más lento y las azules más rápido*/

    public Hormiga(int id, String nombre, int x, int y, int velocidad, int totalAlimento) {
        this.id = id;
        this.nombre = nombre;
        this.xActual = x; //recibe el parámetro del x del primer nodo (inicio)
        this.yActual = y; //recibe el parámetro del y del primer nodo (inicio)
        this.comidaRecolectada = 0; //ambas hormigas inician sin alimento
        this.velocidad = velocidad;
        this.xInicial = x; //inicializa los valores de una vez en el constructor
        this.yInicial = y; //inicializa los valores de una vez en el constructor
        this.totalAlimento = totalAlimento;
    }

    public Hormiga() {
    }
    //devuelve  a la hormiga a la posición del primer nodo una vez que encuentre la comida
    public int[] restartPoint(){
        xActual = xInicial;
        yActual = yInicial;
        int[] pos = {xActual, yActual};
        return pos;
    }


    public boolean isInNodo(int x , int y){
        if(xActual == x && yActual == y){
            return true; 
        }else{
            return false;
        }
    }
    // MÉTODOS GETTER AND SETTER

    public int getxActual() {
        return xActual;
    }

    public int getyActual() {
        return yActual;
    }

    public int getxInicial() {
        return xInicial;
    }

    public void setxActual(int xActual) {
        this.xActual = xActual;
    }

    public void setyActual(int yActual) {
        this.yActual = yActual;
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

    public int getId() {
        return id;
    }
    public void sumarRecolectada(){ 
        this.comidaRecolectada++;
    }
    
    
    
    
    
}
