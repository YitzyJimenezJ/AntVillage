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
        while(!FB.hallegado(destino) && !ventana.detenerMovimiento){
            if(!movimiento.enMovimiento){
                Nodo nRuta = FB.siguienteCamino();
                movimiento.moverA(nRuta);
                movimiento.start();
            }
            try{
                sleep(10);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        if(FB.hallegado(destino)){
            hAzul.setComidaRecolectada(hAzul.getComidaRecolectada()+1);
            this.ventana.getTxtAA().setText(String.valueOf(hAzul.getComidaRecolectada()));
        }
    }    
}
