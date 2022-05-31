
package Control;

import Modelo.Dijkstra;
import Modelo.FuerzaBruta;
import Modelo.Hormiga;
import Modelo.Nodo;
import Vista.VMedioJuego;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author 
 */
/*
El juego es prácticamente la conexión entre el modelo y la vista
*/
public class Juego extends Thread{
    private AdmGrafo admGrafo;
    private Hormiga hormiga_azul;
    private Hormiga hormiga_verde;
    private VMedioJuego ventana;
    private final int cantidadNodos;
    private final int totalAlimento; //alimento para ganar

    public Dijkstra dijsktra;
    public FuerzaBruta fuerza_bruta;
    
    
    public Juego(VMedioJuego ventana, int totalAlimento) {
        super();
        this.ventana = ventana;
        this.totalAlimento = totalAlimento;
        this.cantidadNodos = ventana.getCantidad_nodos();
        prepararJuego();
        
        
    }
    /* =========================================================================
     *              FUNCIONES DEL JUEGO
     =========================================================================*/
    private boolean prepararJuego(){
        int x_min = 0;
        int y_min = 20; //ajuste para que los botones no queden demasiado a las esquinas
        int x_max = (this.ventana.getGamePanel().getWidth())-20;
        int y_max = (this.ventana.getGamePanel().getHeight())-20;
        admGrafo = new AdmGrafo(cantidadNodos, x_min, y_min, x_max, y_max);
        admGrafo.iniciarGrafo();
        admGrafo.colocarArcos();
        admGrafo.imprimirGrafo(); //lo imprime en terminar 
        //colocar las hormigas a su punto de inicio
        int x = admGrafo.getNodoGrafo(0).getX(); //obtiene el nodo
        int y = admGrafo.getNodoGrafo(0).getY();
        hormiga_azul =  new Hormiga(0,"Hormiga Azul",  x+5,y-20,100, totalAlimento);
        hormiga_verde = new Hormiga(1,"Hormiga Verde", x+5,y-20,100, totalAlimento);
        colocar_nodos_interfaz();
        hormigasEnJuego(); //coloca los label de las hormigas según su posición
        dijsktra = new Dijkstra(admGrafo);
        fuerza_bruta = new FuerzaBruta(admGrafo);
        return true;
    }
    /*
        El juego contiene n partidas, el juego termina hasta que la hormiga
        recolecte el alimento máximo y la partida termina hasta que la primer
        hormiga llege al alimento que seleccionó el usuario.
    */

    /*
    Este función coloca los label de las hormigas
    */
    private void hormigasEnJuego(){
       Nodo primernodo = admGrafo.getNodoGrafo(0);
       this.ventana.setimagenesHormigas(primernodo.getX(), primernodo.getY());
    }
    //==========================================================================
    //          Funciones de colocar los nodos/botones en la interfaz
    //==========================================================================
    private void colocar_nodos_interfaz(){
        for (int i = 0; i<cantidadNodos;i++){
            Nodo unNodo = admGrafo.getNodoGrafo(i);
            JButton btncreado =crearBotonNodo(i, unNodo.getX(), unNodo.getY());
            //unNodo.getX(), unNodo.getY() corresponden a su respectiva posición en el grafo.
            this.ventana.agregarBoton(btncreado);
            
        }
    }
    public JButton crearBotonNodo(int i, int x, int y){
        /*
        Crea los botones del nodo dependiendo de su posición 
        */
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
                ventana.btnAlimentar.setVisible(false);
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
                eliminarEventos_btnAlimento(); //elimina los eventos del botón para poner el nuevo evento
                aparecer_btnAlimento(i);
                ventana.getTxtNodoPresionado().setText(String.valueOf(i));
                ventana.getTxaDetalles().setText(
                        admGrafo.getGrafo().get_Arcos_To_String(i));
                
            }
        });
        }
        return nuevoBoton;
        }
    //==========================================================================
    private void aparecer_btnAlimento(int i){
        this.ventana.btnAlimentar.setVisible(true);
        this.ventana.btnAlimentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ventana.pausado == true){
                    admGrafo.aparecerAlimento(i);
                    iniciarPartida();
                }else{//Significa que hay una partida en ejecución
                    admGrafo.getGrafo().setAlimentoEspera(i);
                    int xhojaGris = admGrafo.getGrafo().getEspera().getX();
                    int yhojaGris = admGrafo.getGrafo().getEspera().getY();
                    ventana.posAlimento(ventana.imAlimentoSiguiente, xhojaGris, yhojaGris);
                    ventana.mostrarAlimento(ventana.imAlimentoSiguiente);
                }
                ventana.btnAlimentar.setVisible(false);//lo desaparece
                ventana.getTxtNodoPresionado().setText("");
                ventana.getTxaDetalles().setText("");
                System.out.println("Has colocado el alimento en el nodo: "+
                            String.valueOf(i));       
            }
        });
    }
    /*
        Diseñamos esta función porque una versión de los botones generaba
        los botones uno encima del otro por cada nodo seleccionado
        esta versión maneja solo un botón de alimento que solo le cambia 
        el evento del anterior nodo seleccionado por el nuevo nodo
        para ello no existe una función así que mejor diseñamos esta que
        elimina todos los eventos del botón
    */
    private boolean eliminarEventos_btnAlimento(){
        try
        {
            for( ActionListener al : ventana.btnAlimentar.getActionListeners() ) 
            {
                ventana.btnAlimentar.removeActionListener( al );
            }
        }catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public void iniciarPartida(){
        ventana.pausado = false;
        int xhoja = admGrafo.getGrafo().getNodoAlimento().getX();
        int yhoja = admGrafo.getGrafo().getNodoAlimento().getY();

        ventana.posAlimento(ventana.imAlimentoActual, xhoja, yhoja);
        ventana.mostrarAlimento(ventana.imAlimentoActual);
        Nodo nodoDestino = admGrafo.getNodoAlimento();
        fuerza_bruta.restart();
        ArrayList<Nodo> rutaD = dijsktra.getRuta(nodoDestino.getId());
        HiloHormigaV hhv = new HiloHormigaV(hormiga_verde, ventana, rutaD);
        HiloHormigaA hha = new HiloHormigaA(hormiga_azul, ventana, fuerza_bruta,nodoDestino);
       
        hhv.start();
        hha.start();
        //las hojas deben cambiar de posición; es decir, la verde colocarse en la que está la gris y la gris debe desaparecer
        //acordarse que el nodo en espera debe regresar a null
    }
    
    @Override 
    public void run(){ //está comparando constantemente si una de las hormigas ha ganado
        while(!ventana.juegoTerminado){
            if(ventana.pausado){
                if(admGrafo.getGrafo().getEspera() != null){
                    admGrafo.getGrafo().retirarAlimento();
                    admGrafo.getGrafo().colocarAlimento(admGrafo.getGrafo().getEspera());
                    ventana.ocultarAlimento(ventana.imAlimentoSiguiente);
                    admGrafo.setNodo_espera_alimento(null); //regresa a null para que el siguiente no sea el mismo
                    iniciarPartida();

                }
            }
            try{
                sleep(10);
            }catch(InterruptedException e){
               System.out.println(e);
            }
        }
        if(hormiga_azul.getComidaRecolectada()== totalAlimento){
            finalizarJuego(hormiga_azul,  hormiga_verde);
        }else if(hormiga_verde.getComidaRecolectada()== totalAlimento){
            finalizarJuego(hormiga_verde,  hormiga_azul);
        }
        
    }
    public void finalizarJuego(Hormiga ganadora, Hormiga perdedora){
        ventana.desactivarBotones();
        ventana.getGamePanel().setBackground(Color.GRAY);
        //generar el XML

    }
    
}
