/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.FuerzaBruta;
import Modelo.Hormiga;
import Modelo.Nodo;
import Vista.VMedioJuego;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class HiloHormigaA extends Thread{
    private Hormiga hAzul;
    private VMedioJuego ventana;
    private FuerzaBruta FB;
    private Nodo destino;

    public HiloHormigaA(Hormiga hAzul, VMedioJuego ventana, FuerzaBruta FB) {
        super();
        this.hAzul = hAzul;
        this.ventana = ventana;
        this.FB = FB;
        destino = new Nodo();
    }
    public HiloHormigaA(Hormiga hAzul, VMedioJuego ventana, FuerzaBruta FB, Nodo destino) {
        super();
        this.hAzul = hAzul;
        this.ventana = ventana;
        this.FB = FB;
        this.destino = destino;
    }
    public void setDestino(Nodo destino) {
        this.destino = destino;
    }
    
    @Override
    public void run(){
        FB.restart();
        int xDesplazo, yDesplazo, xActual, yActual;
        while(!FB.hallegado(destino) && !ventana.pausado){
            Nodo unCamino = FB.siguienteCamino();
            xDesplazo = unCamino.getX();
            yDesplazo = unCamino.getY();
            xActual = hAzul.getxActual();
            yActual = hAzul.getyActual();
            System.out.println("La hormiga azul se desplaza al nodo: "+unCamino.toString());
            while(!hAzul.isInNodo(xDesplazo, yDesplazo) && !ventana.pausado){
                if(xActual <xDesplazo){
                    xActual+=1;
                }else if(xActual>xDesplazo){
                    xActual-=1;
                }
                if(yActual<yDesplazo){
                    yActual+=1;
                }else if(yActual>yDesplazo){
                    yActual-=1;
                }
                this.dormir();
                ventana.moverHormiga(ventana.vistaHormigaAzul, xActual+5, yActual-20);
                hAzul.setxActual(xActual);
                hAzul.setyActual(yActual);
            }
        }
        if(FB.hallegado(destino) && hAzul.isInNodo(destino.getX(), destino.getY())){
                hAzul.sumarRecolectada();
                System.out.println("La hormiga azul ha llegado al alimento");
                ventana.getTxtAA().setText(String.valueOf(hAzul.getComidaRecolectada()));
                ventana.ocultarAlimento(ventana.imAlimentoActual); //la hoja desaparece
                if(hAzul.getComidaRecolectada() == ventana.cantidad_alimento){
                    ventana.juegoTerminado = true;
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
        reestablecer();
        ventana.pausado = true;
        
    }
    
    private void dormir(){
        try
        {
            Thread.sleep(hAzul.getVelocidad());
        }catch(InterruptedException e)
        {
            System.out.println("Error al dormir el hilo");
            System.out.println(e);
        }
    }
    public void reestablecer(){
        int[] pos = hAzul.restartPoint();
        ventana.moverHormiga(ventana.vistaHormigaAzul,pos[0], pos[1]);
        System.out.println("\nHormiga azul reestablecida");
    }
}
