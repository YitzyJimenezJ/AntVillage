/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Control.AdmGrafo;
import java.util.ArrayList;

/**
     *@code Clase del algoritmo Dijkstra
     */
public class Dijkstra {
    private int mcostos[][]; //matriz de costos
    private int ultimo[];   //la ruta almacenada
    private int minimos[]; 
    private boolean visitados[]; //lista de nodos visitados
    private int origen;
    private int n; //cantidad de nodos
    private AdmGrafo admgrafo;
    
    private ArrayList<Nodo> ruta = new ArrayList();

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
    /**
     *@code Obtiene los caminos mínimos a cada no
     */
    private void caminosMinimos(){
        for(int i= 0; i<n; i++){ //inicializador de vectores
            visitados[i] = false;
            minimos[i] = mcostos[origen][i];
            ultimo[i] = origen;
        }
        visitados[origen] = true; //el primero ya está visitado
        minimos[origen] = 0; //tiene un costo de cero porque llegar al mismo nodo no cuesta nada
        
        for(int i = 1; i<n; i++){
            int idnodo = minino();
            visitados[idnodo] = true;
            for(int k = 1; k<n;k++){
                if(!visitados[k]){ //no visitado
                    if((minimos[idnodo]+ mcostos[idnodo][k])< minimos[k]){
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
        for(int j = 1; j <n ; j++){
            if (!visitados[j]&&(minimos[j] <=max)){ //no visitado y menor a el peso máximo
                max = minimos[j];
                nodo = j;
            }
        }
        return nodo;
    }
    /**
     *@code obtiene la matriz de costos del grafo (los pesos) y rellena mcostos
     */
    private void inicializar_mcostos(){
        mcostos = new int[n][n];
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                int costo =  admgrafo.getGrafo().getArco(i, j);
                if(costo== 0){
                    mcostos[i][j] =admgrafo.getMAX();
                }else{
                    mcostos[i][j] = costo;
                }
                
            }
        }
    }
    /**
     *@code obtiene la ruta en forma de objetos de los nodos
     *@param int idDestino
     *@return ArrayList<Nodo> ruta
     */
    public ArrayList<Nodo> getRuta(int idDestino){
        ruta = new ArrayList(); //lo vuelvo vacío
        recuperaCamino(idDestino);
        System.out.println("");//salto de línea
        return ruta;
    }
    /**
     *@code Obtiene el la ruta en forma de los id de los nodos
     *@param Iddestino
     *@return void
     */
    private void recuperaCamino(int v)
    {
        int anterior = ultimo[v];
        if (v != origen)
        {
            recuperaCamino(anterior); // vuelve al último del último
            ruta.add(admgrafo.getNodoGrafo(v));
            System.out.print(" -> V" + v);
        } else{
            ruta.add(admgrafo.getNodoGrafo(origen));
            System.out.print("V" + origen);
            
        }
        
    }
    
    
   
    
    
}
