package progettosettimana14;

import progettosettimana14.entities.Game;
import progettosettimana14.suplier.Suppliers;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!"); // riga lasciata di proposito

        List<Game> test = Suppliers.getRandomGameList(10);

        System.out.println(test);

    }
}
