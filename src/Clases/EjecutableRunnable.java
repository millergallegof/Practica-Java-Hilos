package Clases;

public class EjecutableRunnable {

    public static void main(String[] args) throws InterruptedException {

//        esta es la forma de asignar un hilo de manera imperativa
//        de igual forma se puede crear un hilo de manera declarativa
        Runnable viaje = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
//                    el metodo currentThread trae el hilo actual que se esta ejecutando
//                    y se extrae el atributo nombre para traer el nombre
                    System.out.println(i + " - " + Thread.currentThread().getName());
                }
            }
        };

//        forma de obtener un hilo en el scope
        Thread main = Thread.currentThread();


//        forma de crear un hilo de manera declarativa
//        los hilos estan ejecutandose de manera asincrona, en el mismo espacio de memoria
        Runnable viajeDeclarativa = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    System.out.println("Error en el hilo" + e);
                }
            }
            System.out.println(main.getState());
        };


        Thread v1 = new Thread(viaje, "Isla de Pascua");
        Thread v2 = new Thread(viajeDeclarativa, "San Andres");

        v1.start();
        v2.start();
//        metodo join espera a que se ejecuten los hilos y despues hace unas acciones
//        esto hace que los procesos despues de este join se ejecuten inmediatamente
        v1.join();


        System.out.println("Continuado con la ejecucion del metodo main");


    }
}
