package ejemplosync;

public class Panaderia {
    private String pan;
    private boolean disponible;

    public synchronized void hornear(String masa) {
        while (disponible) {
            try {
//                el metodo wiat funciona basicamente para que espere a que otro hilo termine de operar
//                este hilo va a permanecer en espera hasta que otro hilo utilice el metodo notify o notufyAll
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error esperando" + e);
            }
        }

        this.pan = masa;
        System.out.println("El panadero hornea el pan" + this.pan);
        this.disponible = true;
//        hace que un hilo en espera pueda continuar su flujo, sin embargo este metodo no especifica cual hilo puede continuar
        notify();
    }

    public synchronized String consumir() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error esperando" + e);
            }
        }
        System.out.println("Cliente consume: " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }

}
