/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Control;

import Modelo.Dijkstra;
import Modelo.FuerzaBruta;
import Modelo.Nodo;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdmGrafo adm = new AdmGrafo(10, 0, 0, 100, 100);
        adm.iniciarGrafo();
        adm.colocarArcos();
        adm.imprimirGrafo();
        
        adm.getGrafo().colocarAlimento(4);
        
        Dijkstra D = new Dijkstra(adm);
        FuerzaBruta FB = new FuerzaBruta(adm);   
        
        ArrayList<Nodo> rutaD = D.getRuta(4);

        System.out.println("Camino Dijkstra: \n");
        for (Nodo n : rutaD){
            System.out.print(n.getId()+" ->");
        }
        System.out.println("Camino Fuerza Bruta: \n");
        while(!FB.hallegado(adm.getNodoGrafo(4))){
            FB.siguienteCamino();
        }
         System.out.println("Camino Fuerza Bruta2: \n");
        FB.restart();
        while(!FB.hallegado(adm.getNodoGrafo(4))){
            FB.siguienteCamino();
        }
    }
}
