import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Completar Codigo
        List<Pasajero> pasajeros = new ArrayList<>();

        Balsa bAcasta = new Balsa(1 , 0.5);
        Balsa bBanff = new Balsa(2 , 1);
        Balsa bCadiz = new Balsa(3 , 2);
        Balsa bDeimos = new Balsa(4 , 4);
        Balsa bExpedicion = new Balsa(5 , 8);

        for (int i = 1 ; i <= 352; i++){
            int prioridad = ((int) (Math.random()*(4-1)+1));
            Pasajero pasajero = new Pasajero(i, prioridad);
            pasajeros.add(pasajero);
        }




    }
}