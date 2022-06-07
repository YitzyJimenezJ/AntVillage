
package Modelo;


public class Nodo {
    private int id;
    private int x;
    private int y; 
    private boolean haveFood;

    public Nodo(int id, int x, int y, boolean haveFood) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.haveFood = haveFood;
    }

    public Nodo() {
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isHaveFood() {
        return haveFood;
    }

    public void setHaveFood(boolean haveFood) {
        this.haveFood = haveFood;
    }

    @Override
    public String toString() {
        return "Nodo{" + "id=" + id + ", x=" + x + ", y=" + y + '}';
    }
    
    
}
