import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rescate implements Runnable{

    private final Barco barco;
    private final Balsa balsa;
    private final String nombreBalsa;

    public Rescate(Barco barco, Balsa balsa, String nombreBalsa) {
        this.barco = barco;
        this.balsa = balsa;
        this.nombreBalsa = nombreBalsa;
    }

    @Override
    public void run() {
        while (barco.hayPasajeros()) {

            List<Pasajero> rescatados = new ArrayList<>();

            while (!balsa.estaLleno() && barco.hayPasajeros()) {
                Pasajero p = barco.entregarPasajeroPrioritario();

                if (p != null) {
                    balsa.embarcarPasajero(p);
                    rescatados.add(p);
                }
            }

            if (!rescatados.isEmpty()) {
                System.out.println("--- RESCATADOS ---");
                System.out.println("Balsa: " + nombreBalsa +
                        " (" + balsa.getCapacidad() + " plazas)");

                String ids = rescatados.stream()
                        .map(Pasajero::getId)
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));
                System.out.println("Pasajeros (ID): [" + ids + "]");

                try {
                    long tiempoEsperaMs = (long) (balsa.getTiempoRescate() * 1000);
                    System.out.println(nombreBalsa + " regresa en " + balsa.getTiempoRescate() + "s...");
                    Thread.sleep(tiempoEsperaMs);
                } catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
                balsa.vaciar();
            }
        }
    }
}
