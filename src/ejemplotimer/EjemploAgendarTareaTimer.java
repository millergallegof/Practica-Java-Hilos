package ejemplotimer;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimer {

    public static void main(String[] args) {
//        toolkit es una clase donde tiene efectos del sistema operativo de la computadora
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        AtomicInteger contadorAtomic = new AtomicInteger(3);
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if(i <= 0) {
                    timer.cancel();
                }
                toolkit.beep();
                System.out.println("Esto es la tarea ");
            }

        }, 1000, 4000);


    }
}
