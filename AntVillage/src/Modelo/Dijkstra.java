/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Control.AdmGrafo;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Dijkstra {
    private int mcostos[][];
    private int ultimo[];
    private int minimos[]; //D
    private boolean visitados[]; //F
    private int origen;
    private int n;
    private AdmGrafo admgrafo;

    public Dijkstra( AdmGrafo adm) {
        admgrafo = adm;
        this.origen = admgrafo.getNodoGrafo(0).getId(); //id del primer nodo
        n = admgrafo.getGrafo().getCantidad_nodos();

        //matriz costos
        inicializar_mcostos();
        ultimo = new int[n];
        minimos = new int[n];
        visitados = new boolean[n];
        caminosMinimos();
        imprimir();
    }
    private void caminosMinimos(){
        for(int i= 0; i<n; i++){ //inicializador de vectores
            visitados[i] = false;
            minimos[i] = mcostos[origen][i];
            ultimo[i] = origen;
        }
        visitados[origen] = true; //el primero ya está visitado
        minimos[origen] = 0; //tiene un costo de cero porque llegar al mismo nodo no cuesta nada
        
        for(int i = 0; i<n; i++){
            int idnodo = minino();
            visitados[idnodo] = true;
            for(int k = 0; k<n;i++){
                if(!visitados[k]){ //no visitado
                    if((minimos[idnodo]+ mcostos[idnodo][idnodo])< minimos[k]){
                        minimos[k] = minimos[idnodo]+mcostos[idnodo][k];
                        ultimo[k] = idnodo;
                    }
                }
            }
        }
        
    }
    private void imprimir(){
        for(int i = 0; i<n; i++){
            System.out.println("Costo minimo a "+i+": "+minimos[i]);
        }
    }
    private int minino(){
        int max = admgrafo.getMAX();
        int nodo = 1; //se inicializa pero este valor será cambiado
        for(int j = 0; j <n ; j++){
            if (!visitados[j]&&(minimos[j] <=max)){ //no visitado y menor a el peso máximo
                max = minimos[j];
                nodo = j;
            }
        }
        return nodo;
    }
    private void inicializar_mcostos(){
        mcostos = new int[n][n];
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                mcostos[i][j] = admgrafo.getGrafo().getArco(i, j);
            }
        }
    }
    public ArrayList<Nodo> ruta(int idDestino){
        ArrayList<Nodo> camino = new ArrayList();
        if(idDestino != origen){
            for(int i = 0; i< idDestino;i++){
                Nodo unNodo= admgrafo.getNodoGrafo(ultimo[i]);
                camino.add(unNodo);
            }
        }else{
            System.out.println("El nodo de destino no puede ser el mismo del "
                    + "origen");
        }
        return camino;

    }
    
   
    
    
}
