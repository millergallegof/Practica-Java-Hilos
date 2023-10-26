package Clases;

public class ProcesoUno extends Thread {
//    heredar de una clase llamada Thread


//    metodo run de la clase thread
    @Override
    public void run () {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Proceso 1");
        }
    }
}
