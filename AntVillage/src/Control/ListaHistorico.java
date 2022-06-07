


package Control;

import Modelo.NodoHistorico;


public class ListaHistorico {
    NodoHistorico primero; 
    NodoHistorico ultimo;

    public ListaHistorico() {
        primero = null; 
        ultimo = null;
    }
    public void Insertar(int partida, int cantidadNodos, int cantidadAlimento, 
            int recolectadoVerdes, int recolectadoAzules){
        NodoHistorico nuevo = new NodoHistorico(partida, cantidadNodos, 
                cantidadAlimento, recolectadoVerdes, recolectadoAzules);
        
        if(primero == null){
            primero = nuevo;
            ultimo = nuevo; 
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
        }else{
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
            primero.setAnterior(ultimo);
        }
        System.out.println("\nNodo historico agregado");
    }
    
    public void eliminar(int i){
        if(primero!=null){
            NodoHistorico aux = primero; 
            NodoHistorico ant = null; 
            while(aux.getSiguiente()!=primero){
                if(aux.partida == i){
                    if(ant == null){
                        if(aux.getSiguiente()==primero){
                            primero = null;
                        }else{
                            ant= aux.getAnterior();
                            ant.setSiguiente(aux.getSiguiente());
                            aux = aux.getSiguiente();
                            aux.setAnterior(ant);
                            primero = aux;
                            ant = null;
                        }
                    }else{
                        aux.setAnterior(null);
                        ant.setSiguiente(aux.getSiguiente());
                        aux = aux.getSiguiente();
                        aux.setAnterior(ant);
                    }
                }else{
                    ant = aux;
                    aux  = aux.getSiguiente();
                }
            }
            System.out.println("El nodo ha sido elimado");
        }else{
            System.out.println("No se ha eliminado ningún nodo");
        }
    }
    
    
    
}
