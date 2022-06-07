


package Control;

import Modelo.Hormiga;
import Modelo.Nodo;
import Vista.VMedioJuego;
import java.util.ArrayList;

/**
*@code Esta clase controla los moviemientos de la hormiga verde, a diferencia de
* la clase de la hormiga azul, esta ya recibe el la ruta por completo entonces
* solo deberá recorrerla.
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
        for(i = 1; i<ruta.size(); i++){ //por cada nodo en ruta
            Nodo unCamino = ruta.get(i); //obtiene el nodo 
            xDesplazo= unCamino.getX();
            yDesplazo = unCamino.getY();
            xActual = hVerde.getxActual();
            yActual = hVerde.getyActual();
            System.out.println(String.valueOf(i)+"-> La hormiga verde se desplaza "
                    + "al nodo: "+unCamino.toString());
            while(!hVerde.isInNodo(xDesplazo, yDesplazo) && !ventana.pausado){
                //si la hormiga no se encuenta en nodo, ni la otra ha llegado
                //entonces se desplaza
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
        if(i==ruta.size()){//si esto es equivalente es porque completó el camino
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
        reestablecer();//si la hormiga azul gana o si la verde gana ambos deben reestablecerce
    }
    /**
     *@code Duerme la hormiga según su velocidad 
     *@param vacío 
     *@return vacío
     */
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
    /**
     *@code  Reestablece la hormiga y la imagen a su punto de origen 
     *@param vacío
     *@return vacío
     */
    public void reestablecer(){
        int[] pos = hVerde.restartPoint();
        ventana.moverHormiga(ventana.vistaHormigaVerde,pos[0], pos[1]);
        System.out.println("\nHormiga verde reestablecida");
    }
    
    
    
    
}
