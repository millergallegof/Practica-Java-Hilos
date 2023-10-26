package ejemplosync.runnable;

import ejemplosync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable {
    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            panaderia.hornear("Pan No " + i);
            try {
//            el objeto ThreadLocalRandom crea un intervalo random
//            este metodo current().nextInt crea un numero entre los parametros que se envie
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
