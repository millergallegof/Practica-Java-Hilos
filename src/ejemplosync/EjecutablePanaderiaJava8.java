package ejemplosync;

import ejemplosync.runnable.Consumidor;
import ejemplosync.runnable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class EjecutablePanaderiaJava8 {

    public static void main(String[] args) {
        Panaderia panaderia = new Panaderia();

//        cuando el panadero hornea un pan y nadie lo consume, el estado del hilo se queda esperando
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                panaderia.hornear("Pan No " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                panaderia.consumir();
            }
        }).start();

    }
}
