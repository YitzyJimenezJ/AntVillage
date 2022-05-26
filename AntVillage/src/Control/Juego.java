
package Control;

import Modelo.Hormiga;
import Modelo.Nodo;
import Vista.VMedioJuego;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author 
 */
public class Juego {
    private AdmGrafo admGrafo;
    private Hormiga hormiga_azul;
    private Hormiga hormiga_verde;
    private VMedioJuego ventana;
    private int cantidadNodos;
    private int totalAlimento; //alimento para ganar

    public Juego(VMedioJuego ventana, int totalAlimento) {
        this.ventana = ventana;
        this.totalAlimento = totalAlimento;
        this.cantidadNodos = ventana.getCantidad_nodos();
        iniciarJuego();
        trazar();
        colocar_nodos_interfaz();
        hormigasEnJuego(); //coloca los label de las hormigas según su posición
        ventana.getGamePanel().repaint();
    }
    private boolean iniciarJuego(){
        int x_min = 0;
        int y_min = 20; //ajuste para que los botones no queden demasiado a las esquinas
        int x_max = (this.ventana.getGamePanel().getWidth())-20;
        int y_max = (this.ventana.getGamePanel().getHeight())-20;
        admGrafo = new AdmGrafo(cantidadNodos, x_min, y_min, x_max, y_max);
        admGrafo.iniciarGrafo();
        admGrafo.dirigirGrafo();
        
        admGrafo.imprimirGrafo(); //lo imprime en terminar 
        //colocar las hormigas a su punto de inicio
        int x = admGrafo.getPrimerNodo().getX(); 
        int y = admGrafo.getPrimerNodo().getY();
        hormiga_azul =  new Hormiga(0,"Hormiga Azul", this.ventana, x,y-20,500);
        hormiga_verde = new Hormiga(1,"Hormiga Verde", this.ventana, x,y-20,500);
        
       
        return true;
    }
    /*
    Este función coloca los label de las hormigas
    */
    private void hormigasEnJuego(){
       Nodo primernodo = admGrafo.getPrimerNodo();
       this.ventana.setimagenesHormigas(primernodo.getX(), primernodo.getY());
    }
    private void colocar_nodos_interfaz(){
        for (int i = 0; i<cantidadNodos-1;i++){
            Nodo unNodo = admGrafo.getNodoGrafo(i);
            JButton btncreado =crearBoton(i, unNodo.getX(), unNodo.getY());
            //unNodo.getX(), unNodo.getY() corresponden a su respectiva posición en el grafo.
            
            this.ventana.agregarBoton(btncreado);
            
        }
    }
    public JButton crearBoton(int i, int x, int y){
        JButton nuevoBoton = new JButton();
        nuevoBoton.setHorizontalAlignment(CENTER);//coloca el cursor en el centro 
        nuevoBoton.setBounds(x+10, y-10, 20, 20);
        //nuevoBoton.setText(String.valueOf(i));//para identificarlo
        
       
        if(i == 0){
            nuevoBoton.setBackground(Color.yellow); //el primer nodo será amarillo
            //además no podrá colocar el alimento en el primer nodo
            nuevoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.getTxtNodoPresionado().setText(String.valueOf(i));
                ventana.getTxaDetalles().setText(
                        admGrafo.getGrafo().get_Arcos_To_String(i));
                
            }
        });
        }else{
            nuevoBoton.setBackground(Color.white);
            nuevoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btnColocar = cbotonColocarAlimento(i);
                ventana.addBoton_to_DatosPanel(btnColocar);
                ventana.getTxtNodoPresionado().setText(String.valueOf(i));
                ventana.getTxaDetalles().setText(
                        admGrafo.getGrafo().get_Arcos_To_String(i));
                
            }
        });
        }
        return nuevoBoton;
        }
    public JButton cbotonColocarAlimento(int i){
        JButton nuevoBoton = new JButton();
        nuevoBoton.setHorizontalAlignment(CENTER);//coloca el cursor en el centro 
        nuevoBoton.setBounds(200,241, 100, 30);
        nuevoBoton.setText("Alimento");
        nuevoBoton.setBackground(Color.GREEN);
        nuevoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admGrafo.aparecerAlimento(i);
                nuevoBoton.setVisible(false);
                ventana.removeBoton_to_DatosPanel(nuevoBoton);
                ventana.getTxtNodoPresionado().setText("");
                ventana.getTxaDetalles().setText("");
                System.out.println("Has colocado el alimento en el nodo: "+
                        String.valueOf(i));
                //falta cargar la imagen de hoja
                //además validar 
            }
        });
        return nuevoBoton;
    }
    public void trazar(){
        for (int i = 0; i < cantidadNodos; i++){
            for(int j = 0; j < cantidadNodos; j++){
                int tipoTrazo = admGrafo.getTipoRelacion(i, j);
                Nodo nodoA = admGrafo.getNodoGrafo(i);
                Nodo nodoB = admGrafo.getNodoGrafo(j);
                if(tipoTrazo == 1){
                    ventana.dibujarLinea(ventana.getGamePanel().getGraphics(), 
                            nodoA.getX(), nodoA.getY(), nodoB.getX(), nodoB.getY(), Color.BLACK);
                    
                }else if(tipoTrazo==2){ //si tiene camino de ida y de vuelta se pinta amarillo
                    ventana.dibujarLinea(ventana.getGamePanel().getGraphics(), 
                            nodoA.getX(), nodoA.getY(), nodoB.getX(), nodoB.getY(), Color.yellow);
                }
            }
   
        }
        
        
        System.out.println("Trazos dibujados");
    }
    
    
    /* un update de ir tratando de igualar los valores de sus posiciones hacia el nuevo nodo para 
    el dezplazamiento de las hormigas como están en un hilo cada una puede ir sumando los valores
    una por una */
}
