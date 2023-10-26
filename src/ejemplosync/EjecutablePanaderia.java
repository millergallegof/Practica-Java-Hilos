package ejemplosync;

import ejemplosync.runnable.Consumidor;
import ejemplosync.runnable.Panadero;

public class EjecutablePanaderia {

    public static void main(String[] args) {
        Panaderia panaderia = new Panaderia();

//        cuando el panadero hornea un pan y nadie lo consume, el estado del hilo se queda esperando
        new Thread(new Panadero(panaderia)).start();
        new Thread(new Consumidor(panaderia)).start();


    }
}
