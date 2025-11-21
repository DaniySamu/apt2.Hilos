import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Completar Codigo
        List<Pasajero> pasajeros = new ArrayList<>();

        for (int i = 1 ; i <= 352; i++){
            int prioridad = ((int) (Math.random()*(4-1)+1));
            Pasajero pasajero = new Pasajero(i, prioridad);
            pasajeros.add(pasajero);
        }

        Barco barco1 = new Barco(pasajeros);

        Balsa bAcasta = new Balsa(1 , 0.5);
        Balsa bBanff = new Balsa(2 , 1);
        Balsa bCadiz = new Balsa(3 , 2);
        Balsa bDeimos = new Balsa(4 , 4);
        Balsa bExpedicion = new Balsa(5 , 8);

        Thread tAcasta = new Thread(new Rescate(barco1, bAcasta, "Acasta"));
        Thread tBanff = new Thread(new Rescate(barco1, bBanff, "Banff"));
        Thread tCadiz = new Thread(new Rescate(barco1, bCadiz, "Cadiz"));
        Thread tDeimos = new Thread(new Rescate(barco1, bDeimos, "Deimos"));
        Thread tExpedicion = new Thread(new Rescate(barco1, bExpedicion, "Expedición"));

        tAcasta.start();
        tBanff.start();
        tCadiz.start();
        tDeimos.start();
        tExpedicion.start();

        try {
            tAcasta.join();
            tBanff.join();
            tCadiz.join();
            tDeimos.join();
            tExpedicion.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------");
        System.out.println("FIN DEL RESCATE");
        System.out.println("--------------------");


    }
}