package Clases;

public class ClasePrincipal {

    public static void main(String[] args) {
//        SIN HILOS
//        for (int i = 0; i <= 5; i++) {
//            System.out.println("Proceso 1");
//        }
//
//        System.out.println("");
//
//        for (int i = 0; i <= 5; i++) {
//            System.out.println("Proceso 2");
//        }

        ProcesoUno procesoUno = new ProcesoUno();
        ProcesoUno procesoTres = new ProcesoUno();
        Thread procesoDos = new Thread(new ProcesoDos());

//        arrancar un hilo con el metodo
//        para que los hilos funcionen de manera simultanea se tienen que ejecutar al mismo tiempo
        procesoUno.start();
        procesoTres.start();
        procesoDos.start();



    }
}
