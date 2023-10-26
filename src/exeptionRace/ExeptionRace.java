package exeptionRace;

import java.util.concurrent.atomic.AtomicInteger;

public class ExeptionRace implements Runnable {

    private AtomicInteger contador = new AtomicInteger(0);

    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contador.incrementAndGet();
        }
    }

    public int getContador() {
        return contador.get();
    }

    public static void main(String[] args) {
        ExeptionRace carreraEjemplo = new ExeptionRace();
        Thread hilo1 = new Thread(carreraEjemplo);
        Thread hilo2 = new Thread(carreraEjemplo);
        hilo1.start();
        hilo2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final del contador: " + carreraEjemplo.getContador());
    }
}
