package Clases;

public class EjemploSincronizacionThread {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImprimirFrase("Hola ", "Que tal?")).start();
        new Thread(new ImprimirFrase("Quien ", "Eres tu")).start();

//        en este caso esperamos para que se ejecute el hilo 3 y realize las acciones
//        sin embargo el metodo como tiene la propiedad synchronized - el hilo 3 va estar en un estado bloqueado
//        hasta que termine primero con los hilos anteriores
        Thread.sleep(100);
        Thread h3 = new Thread(new ImprimirFrase("Muchas ", "Gracias Amigo"));
        h3.start();
        Thread.sleep(100);
        System.out.println(h3.getState());

    }

//con la palabra synchronized podemos hacer que los hilos que ingresen en este metodo
//    se realicen de forma sincronizada - es decir que si si esta ejecutando el primer hilo el segundo esta en espera
    public synchronized static void imprimirFrases(String frase1, String frase2) throws InterruptedException {
        System.out.print(frase1);
        Thread.sleep(500);
        System.out.println(frase2);
    }
}
