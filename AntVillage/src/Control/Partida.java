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
public class Partida extends Thread {
    Hormiga hormiga;
    Nodo destinoFinal;
    VMedioJuego ventana; 
    private ArrayList<Nodo> camino; //cada partida es recorrer un camino tiene un camino a recorrer 
    
    public Partida(Hormiga hormiga, VMedioJuego ventana) {
        super();
        this.hormiga = hormiga;
        this.ventana = ventana;
    }

    public void setCamino(ArrayList<Nodo> camino) {
        this.camino = camino;
    }
    
    @Override
    public void run(){
        ventana.pausado = false; //la partida comenzó, las hormigas se mueven
        boolean llego =false;
        for (Nodo unNodo : camino) { //este ciclo que recorre el camino debe ir en un hilo
            llego = dezplazar(unNodo);
            if(!llego){
                break;
            }
        }
        if(llego){
            ventana.ganadora_Partida = hormiga.getId(); //es la hormiga que ganó
            hormiga.setComidaRecolectada(hormiga.getComidaRecolectada()+1); //primero Actualiza la comida
            update_txtAlimento(); //luego actualiza la ventana
        }
        reestablecer();
        ventana.pausado = false; //la partida comenzó, las hormigas se mueven
    }
    private boolean dezplazar(Nodo destino){
        int xDestino= destino.getX();
        int yDestino = destino.getY();
        int xActual = hormiga.getxActual();
        int yActual = hormiga.getyActual();
        while(!hormiga.isInNodo(xDestino, yDestino) && ventana.ganadora_Partida == -1){
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
            return true; //el dezplazamiento se cumplío 
        }else{
            return false; //el desplazamiento se interrumpe porque ganó otra hormiga
        }
    }
    private void update_txtAlimento(){
        if(hormiga.getId() == 0){ //es la hormiga azul
            this.ventana.getTxtAA().setText(String.valueOf(hormiga.getComidaRecolectada()));
        }else if(hormiga.getId() == 1){
            this.ventana.getTxtAV().setText(String.valueOf(hormiga.getComidaRecolectada()));
        }
    }

    private void moverLabel(int x, int y){
        if(hormiga.getId() == 0){ // Hormiga azul
            this.ventana.vistaHormigaAzul.setLocation(x+5, y-20); // otra es actualizarlo desde la ventana 
        }else if(hormiga.getId() == 1){ //hormiga verde
            this.ventana.vistaHormigaAzul.setLocation(x+5, y-20); // otra es actualizarlo desde la ventana     
        }
    }
    private void reestablecer(){
        int [] pos = hormiga.restartPoint();
        moverLabel(pos[0], pos[1]);
    }
    private void dormir(){
        try
        {
            System.out.println("SLEEP: "+ hormiga.nombre);
            sleep(hormiga.getVelocidad());
        }catch(InterruptedException e)
        {
            System.out.println("Error al dormir el hilo");
            System.out.println(e);
        }
    }
     
     //GETTER AND SETTER

    public void setDestinoFinal(Nodo destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public Nodo getDestinoFinal() {
        return destinoFinal;
    }
    
    
}
