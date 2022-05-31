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
    private Movimiento movimiento;
    private Nodo destino;

    public HiloHormigaA(Hormiga hAzul, VMedioJuego ventana, FuerzaBruta FB) {
        super();
        this.hAzul = hAzul;
        this.ventana = ventana;
        this.FB = FB;
        movimiento = new Movimiento(hAzul, ventana);
        destino = new Nodo();
    }
    public HiloHormigaA(Hormiga hAzul, VMedioJuego ventana, FuerzaBruta FB, Nodo destino) {
        super();
        this.hAzul = hAzul;
        this.ventana = ventana;
        this.FB = FB;
        movimiento = new Movimiento(hAzul, ventana);
        this.destino = destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }
    
    @Override
    public void run(){
        FB.restart();
        while(!FB.hallegado(destino) && !ventana.pausado){
            if(!movimiento.enMovimiento){
                Nodo nRuta = FB.siguienteCamino();
                System.out.println("La hormiga azul va al nodo : "+String.valueOf(nRuta.getId()));
                movimiento.moverA(nRuta);
                movimiento.start();
            }
            try
            {
                sleep(10);
            }catch(InterruptedException e)
            {
                System.out.println("Error al dormir el hilo");
                System.out.println(e);
            }
        }
        if(FB.hallegado(destino)){
            if(hAzul.sumarRecolectada()){
                ventana.juegoTerminado = true;
            }
            System.out.println("La hormiga azul ha llegado de primero");
            this.ventana.getTxtAA().setText(String.valueOf(hAzul.getComidaRecolectada()));
            this.ventana.ocultarAlimento(ventana.imAlimentoActual);
            ventana.pausado = true;
        }
        int[] posIn = hAzul.restartPoint();
        this.ventana.moverHormiga(ventana.vistaHormigaAzul, posIn[0], posIn[1]);
        
    }    
}
