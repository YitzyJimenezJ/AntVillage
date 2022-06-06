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
public class HiloHormigaV extends Thread{
    private Hormiga hVerde;
    private VMedioJuego ventana;
    private ArrayList<Nodo> ruta;
    

    public HiloHormigaV(Hormiga hVerde, VMedioJuego ventana, ArrayList<Nodo> ruta) {
        super();
        this.hVerde = hVerde;
        this.ventana = ventana;
        this.ruta = ruta;
        
    }
    @Override
    public void run(){
        int xDesplazo, yDesplazo, xActual, yActual;
        int i;
        for(i = 1; i<ruta.size(); i++){
            Nodo unCamino = ruta.get(i);
            xDesplazo= unCamino.getX();
            yDesplazo = unCamino.getY();
            xActual = hVerde.getxActual();
            yActual = hVerde.getyActual();
            System.out.println(String.valueOf(i)+"-> La hormiga verde se desplaza "
                    + "al nodo: "+unCamino.toString());
            while(!hVerde.isInNodo(xDesplazo, yDesplazo) && !ventana.pausado){
                
                if(xActual < xDesplazo)
                {
                    xActual+=1;
                }else if(xActual> xDesplazo)
                {
                    xActual-=1;
                }
                if(yActual < yDesplazo)
                {
                    yActual+=1;
                }else if(yActual>yDesplazo)
                {
                    yActual-=1;
                }
                if(ventana.pausado){ //sale del ciclo del desplazamiento
                    break;
                }
                //controla los cambios en la interfaz
                this.dormir();
                ventana.moverHormiga(ventana.vistaHormigaVerde, xActual+5, yActual-20);
                hVerde.setxActual(xActual);
                hVerde.setyActual(yActual);
            }
            
            if(ventana.pausado){ //sale del ciclo que recorre el camino
                break;
            }
        }
        if(i==ruta.size()){
            hVerde.sumarRecolectada();
            System.out.println("La hormiga verde ha llegado de primero al alimento");
            this.ventana.getTxtAV().setText(String.valueOf(hVerde.getComidaRecolectada()));
            this.ventana.ocultarAlimento(ventana.imAlimentoActual);
            if(hVerde.getComidaRecolectada()==ventana.cantidad_alimento){
                ventana.juegoTerminado =true;
            }
            try
            {
                Thread.sleep(100);
            }catch(InterruptedException e)
            {
                System.out.println("Error al dormir el hilo");
                System.out.println(e);
            }
        }
        ventana.pausado = true; //pausa la partida aunque ya esté pausada
        reestablecer();//en ambos casos termina y deben reestablecerce
    }
    
    private void dormir(){
            try
            {
                Thread.sleep(hVerde.getVelocidad());
            }catch(InterruptedException e)
            {
                System.out.println("Error al dormir el hilo");
                System.out.println(e);
            }
        }
    public void reestablecer(){
        int[] pos = hVerde.restartPoint();
        ventana.moverHormiga(ventana.vistaHormigaVerde,pos[0], pos[1]);
        System.out.println("\nHormiga verde reestablecida");
    }
    
    
    
    
}
