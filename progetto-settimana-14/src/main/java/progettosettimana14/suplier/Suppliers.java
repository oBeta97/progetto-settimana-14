package progettosettimana14.suplier;

import com.github.javafaker.Faker;
import progettosettimana14.entities.Game;
import progettosettimana14.entities.TableGame;
import progettosettimana14.entities.VideoGame;
import progettosettimana14.enums.VideoGameGenre;
import progettosettimana14.enums.VideoGamePlatforms;
import progettosettimana14.exceptions.ToManyPlayerException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class Suppliers {

    public static Supplier<LocalDate> getRandomDate = () -> {
        LocalDate startDate = LocalDate.of(2010, 1, 1);

        // Definisci la data di fine (ultimo giorno del mese scorso)
        LocalDate endDate = LocalDate.now().minusMonths(1).withDayOfMonth(LocalDate.now().minusMonths(1).lengthOfMonth());

        // Calcola il numero di giorni tra le due date
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        // Genera un numero casuale di giorni da aggiungere alla data di inizio
        long randomDays = ThreadLocalRandom.current().nextLong(daysBetween + 1);

        // Crea la data casuale
        return startDate.plusDays(randomDays);
    };

    public static Supplier<VideoGamePlatforms> getRandomVGPlatform = () -> {
        Random r = new Random();
        return VideoGamePlatforms.values()[r.nextInt(VideoGamePlatforms.values().length)];
    };

    public static Supplier<VideoGameGenre> getRandomVGGenre = () ->{
        Random r = new Random();

        return VideoGameGenre.values()[r.nextInt(VideoGameGenre.values().length)];
    };

    public static Supplier<Game> getRandomGame = () -> {
        Faker faker = new Faker(Locale.ITALY);
        Random r = new Random();

        if(r.nextBoolean())
            return new VideoGame(faker.aviation().aircraft(), getRandomDate.get() , r.nextDouble(150.0), getRandomVGPlatform.get(), r.nextInt(400), getRandomVGGenre.get());
        else{
            while(true){
                try{
                    return new TableGame(faker.funnyName().name(), getRandomDate.get(), r.nextDouble(150.0), r.nextInt(2, 11), r.nextInt(180));
                } catch (ToManyPlayerException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    };


    public static List<Game> getRandomGameList(int listLength) {

        List<Game> res = new ArrayList<>();

        for (int i = 0; i < listLength; i++) {
            res.add(getRandomGame.get());
        }
        return res;
    };

}
