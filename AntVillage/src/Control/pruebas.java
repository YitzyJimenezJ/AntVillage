/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Control;

/**
 *
 * @author Esteb
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       for(int i = 0; i<100; i++){
            int posAlimento = (int) (Math.random()*(12-1)+1);
            if(posAlimento<12)
                System.out.println(posAlimento);
       }
    }
    
}
