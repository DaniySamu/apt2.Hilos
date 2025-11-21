import java.util.ArrayList;
import java.util.List;

public class Balsa {

    private int capacidad;
    private double tiempo;

    public Balsa(int capacidad, double tiempo) {
        this.capacidad = capacidad;
        this.tiempo = tiempo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    private final List<Pasajero> pasajerosActuales = new ArrayList<>();

    public double getTiempoRescate() {
        return tiempo;
    }

    public void embarcarPasajero(Pasajero p) {
        if (!estaLleno()) {
            pasajerosActuales.add(p);
        }
    }

    public boolean estaLleno() {
        return pasajerosActuales.size() == capacidad;
    }

    public void vaciar() {
        pasajerosActuales.clear();
    }

    public List<Pasajero> getPasajerosActuales() {
        return pasajerosActuales;
    }
}
