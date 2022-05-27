
package Modelo;

import Vista.VMedioJuego;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class HiloMovimiento extends Thread{
    private int actual; //puede ser actual x o y dependiendo del que ingrese
    private int destino; 
    private int velocidad; //el sleep en segundos simultaneamente al hilo de hormiga
  
    public HiloMovimiento(VMedioJuego ventana,Hormiga hormiga,int actual, int destino, int velocidad) {
        super();
        this.actual = actual;
        this.destino = destino;
        this.velocidad = velocidad;
        
    }
       @Override
    public void run() {
        ///while contador
        if(actual < destino){
            while(actual < destino){
                actual+=1;
                try {
                
                    sleep(velocidad);      
                } catch (InterruptedException ex) {
                    System.out.println("Error en el ciclo de movimiento hilo");
                }
            }
        }else{
            while(actual> destino){
                actual-=1;
                try {
                   sleep(velocidad);
                }catch (InterruptedException ex) {
                   System.out.println("Error en el ciclo de movimiento hilo");
                }
            }
        }
        
    }
 
    
    
    
}
