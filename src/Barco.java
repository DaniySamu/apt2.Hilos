import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Barco {

    private final List<Pasajero> pasajeros = new ArrayList<>();

    private final Semaphore semaforo = new Semaphore(1);

    public Barco(List<Pasajero> pasajeros) {
        this.pasajeros.addAll(pasajeros);
    }

    public boolean hayPasajeros() {
        return !pasajeros.isEmpty();
    }

    public Pasajero entregarPasajeroPrioritario() {
        try {
            if (pasajeros.isEmpty()) {
                return null;
            }
    
            Pasajero pasajeroMasPrioritario = null;
            int prioridadMinima = Integer.MAX_VALUE;
            int indiceMasPrioritario = -1;
    
            for (int i = 0; i < pasajeros.size(); i++) {
                Pasajero actual = pasajeros.get(i);
    
                if (actual.getPrioridad() < prioridadMinima) {
                    prioridadMinima = actual.getPrioridad();
                    pasajeroMasPrioritario = actual;
                    indiceMasPrioritario = i;
                }
            }
    
            if (indiceMasPrioritario != -1) {
                pasajeros.remove(indiceMasPrioritario);
                return pasajeroMasPrioritario;
            }
    
            return null; // No debería ocurrir si hayPasajeros() es true
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Buena práctica restaurar la interrupción
            return null;
        } finally {
            // 5. IMPORTANTE: Liberar el permiso siempre en finally
            semaforo.release();
        }
    }
}
