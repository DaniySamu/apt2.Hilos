import java.util.ArrayList;
import java.util.List;

public class Barco {

    private final List<Pasajero> pasajeros = new ArrayList<>();

    public Barco(List<Pasajero> pasajeros) {
        this.pasajeros.addAll(pasajeros);
    }

    public boolean hayPasajeros() {
        return !pasajeros.isEmpty();
    }

    public synchronized Pasajero entregarPasajeroPrioritario() {
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
    }
}
