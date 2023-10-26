package Clases;
import static Clases.EjemploSincronizacionThread.imprimirFrases;

public class ImprimirFrase implements  Runnable{
    String frase1, frase2;
    public ImprimirFrase(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        try {
            imprimirFrases(this.frase1, this.frase2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
