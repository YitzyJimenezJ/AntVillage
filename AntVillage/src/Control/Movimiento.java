/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Hormiga;
import Modelo.Nodo;
import Vista.VMedioJuego;
import java.util.ArrayList;
/**
 *
 * @author Esteb
 */
public class Movimiento extends Thread {
    Hormiga hormiga;
    Nodo siguientePaso;
    VMedioJuego ventana; 
    public volatile boolean enMovimiento;
    
    public Movimiento(Hormiga hormiga, VMedioJuego ventana) {
        super();
        this.hormiga = hormiga;
        this.ventana = ventana;
        this.siguientePaso = new Nodo();
        enMovimiento =false;
    }
    public void moverA(Nodo n){
        siguientePaso = n;
    }
    
  
    @Override
    public void run(){
        enMovimiento =true;
        desplazar();
        enMovimiento = false; 
    }
    private boolean desplazar(){
        int xDestino= siguientePaso.getX();
        int yDestino = siguientePaso.getY();
        int xActual = hormiga.getxActual();
        int yActual = hormiga.getyActual();
        while(!hormiga.isInNodo(xDestino, yDestino) && !ventana.detenerMovimiento){
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
            moverLabel(xActual, yActual);
            hormiga.setxActual(xActual);
            hormiga.setyActual(yActual);
            
            this.dormir(); //modularizar el try cath
        }
        if(hormiga.isInNodo(xDestino, yDestino)){
            ventana.detenerMovimiento = true; //detener el moviemiento para que la otra hormiga no se siga moviendo
            return true; //el dezplazamiento se cumplío 
        }else{
            return false; //el desplazamiento se interrumpe porque ganó otra hormiga
        }
    }
    private void moverLabel(int x, int y){
        if(hormiga.getId() == 0){ // Hormiga azul
            this.ventana.vistaHormigaAzul.setLocation(x+5, y-20);
        }else if(hormiga.getId() == 1){ //hormiga verde
            this.ventana.vistaHormigaVerde.setLocation(x+5, y-20);  
        }
    }
    public void reestablecer(){
       
        int[] pos = hormiga.restartPoint();
        moverLabel(pos[0], pos[1]);
    }
    private void dormir(){
        try
        {
            sleep(hormiga.getVelocidad());
        }catch(InterruptedException e)
        {
            System.out.println("Error al dormir el hilo");
            System.out.println(e);
        }
    }
     
     //GETTER AND SETTER    
    
}