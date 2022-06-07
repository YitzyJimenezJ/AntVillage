


package Modelo;


public class NodoHistorico {
    public  int partida;
    private int cantidadNodos;
    private int cantidadAlimento; 
    private int recolectadoVerdes;
    private int recolectadoAzules;

    private NodoHistorico anterior;
    private NodoHistorico siguiente;

    public NodoHistorico(int partida, int cantidadNodos, int cantidadAlimento, 
            int recolectadoVerdes, int recolectadoAzules, NodoHistorico anterior, 
            NodoHistorico siguiente) {
        this.partida = partida;
        this.cantidadNodos = cantidadNodos;
        this.cantidadAlimento = cantidadAlimento;
        this.recolectadoVerdes = recolectadoVerdes;
        this.recolectadoAzules = recolectadoAzules;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    public NodoHistorico(int partida, int cantidadNodos, int cantidadAlimento, int recolectadoVerdes, int recolectadoAzules) {
        this.partida = partida;
        this.cantidadNodos = cantidadNodos;
        this.cantidadAlimento = cantidadAlimento;
        this.recolectadoVerdes = recolectadoVerdes;
        this.recolectadoAzules = recolectadoAzules;
    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }

    public void setCantidadNodos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
    }

    public int getCantidadAlimento() {
        return cantidadAlimento;
    }

    public void setCantidadAlimento(int cantidadAlimento) {
        this.cantidadAlimento = cantidadAlimento;
    }

    public int getRecolectadoVerdes() {
        return recolectadoVerdes;
    }

    public void setRecolectadoVerdes(int recolectadoVerdes) {
        this.recolectadoVerdes = recolectadoVerdes;
    }

    public int getRecolectadoAzules() {
        return recolectadoAzules;
    }

    public void setRecolectadoAzules(int recolectadoAzules) {
        this.recolectadoAzules = recolectadoAzules;
    }

    public NodoHistorico getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoHistorico anterior) {
        this.anterior = anterior;
    }

    public NodoHistorico getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHistorico siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    public NodoHistorico() {
    }
    
 
    
}
