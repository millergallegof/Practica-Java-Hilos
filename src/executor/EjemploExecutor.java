package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {

    public static void main(String[] args) {

//        esta libreria de concurrent facilita el manejo de los hilos en java
//        en este caso creamos un objeto tipo Service Executor
//        donde recibe un objeto tipo executor
//        en este caso utilizamos una fabrica Factory que crea objetos de manera automatica
//        le pedimos que cre un singleThread
        ExecutorService excutor = Executors.newSingleThreadExecutor();

//        despues de tener este objeto creamos el objeto runneable
//        el cual sera la tarea que se va a ejecutar es decir el hilo
        Runnable tarea = () -> {
            System.out.println("inicio la Tarea");
            try {
//                timeUnit es una clase de java concurrent para ejecutar diferentes funciones de los hilos
//                en este caso ejecutamos la funcion de sleep
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea");
        };

//        hasta el momento solo se ha creado la tarea, esta instanciada por asi decirlo
//        vamos a ejecutar el hilo utilizando una funcion de executor submit donde recibe como parametro la tarea o el hilo
        excutor.submit(tarea);

//        sin embargo el anterior metodo hace que la tarea se ejecute indefinidamente por esa razon existe un proceso para terminar el hilo
        excutor.shutdown();

    }
}
