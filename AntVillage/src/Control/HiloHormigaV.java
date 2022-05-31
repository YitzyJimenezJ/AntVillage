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
    private Movimiento movimiento;
    

    public HiloHormigaV(Hormiga hVerde, VMedioJuego ventana, ArrayList<Nodo> ruta) {
        super();
        this.hVerde = hVerde;
        this.ventana = ventana;
        this.ruta = ruta;
        
        movimiento = new Movimiento(hVerde, ventana);
        
    }
    @Override
    public void run(){
        ventana.pausado =false;
        int i = 1; // el primer nodo es el origen y ese no debe recorrerlo entonces inicia en 1
        while((i<ruta.size()-1) && !ventana.detenerMovimiento){
            if(!movimiento.enMovimiento){ // si no está en movimiento asigna otra
                Nodo nRuta = ruta.get(i);
                movimiento.moverA(nRuta);
                movimiento.start();
                i++;
            }
            try{
                sleep(10);
            }catch(InterruptedException e){
               System.out.println(e);
            }
        }
        if(i== ruta.size()-1){ //significa que terminó porque esta ganó
            hVerde.setComidaRecolectada(hVerde.getComidaRecolectada()+1);
            this.ventana.getTxtAV().setText(String.valueOf(hVerde.getComidaRecolectada()));
            this.ventana.ocultarAlimento(ventana.imAlimentoActual);
            ventana.pausado = true; 
        }
        
    }

    
    
    
    
}
