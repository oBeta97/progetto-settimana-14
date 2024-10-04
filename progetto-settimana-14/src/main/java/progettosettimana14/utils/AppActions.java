package progettosettimana14.utils;

import progettosettimana14.entities.Game;
import progettosettimana14.entities.TableGame;
import progettosettimana14.entities.VideoGame;
import progettosettimana14.enums.VideoGameGenre;
import progettosettimana14.enums.VideoGamePlatforms;
import progettosettimana14.exceptions.ToManyPlayerException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class AppActions {

    public static Game addGame (Scanner s){

        String gameTypeMsg = "Vuoi inserire un gioco da tavolo (0) o un video game(1)?";

        while (true) {
            switch (ReadInput.readNumber(gameTypeMsg, s)) {
                case 0:
                    while (true){
                        String title = ReadInput.readString("Titolo:", s);
                        LocalDate publishDate = ReadInput.readDate("Data di pubblicazione...", s);
                        double price = ReadInput.readDouble("Prezzo:", s);
                        int nrPlayer = ReadInput.readNumber("Nr Giocatori:", s);
                        int gameLength = ReadInput.readNumber("Durata media partita (min):", s);

                        try {
                            return new TableGame(title,publishDate,price,nrPlayer,gameLength);
                        } catch (ToManyPlayerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                case 1:
                    String title = ReadInput.readString("Titolo:", s);
                    LocalDate publishDate = ReadInput.readDate("Data di pubblicazione...", s);
                    double price = ReadInput.readDouble("Prezzo:", s);
                    VideoGamePlatforms vgPlatform = ReadInput.readEnum("Piattaforma:", Arrays.stream(VideoGamePlatforms.values()).toList(), s);
                    int gameLength = ReadInput.readNumber("Durata media videogioco (hours):", s);
                    VideoGameGenre vgGenre = ReadInput.readEnum("Genere:", Arrays.stream(VideoGameGenre.values()).toList(), s);

                    return new VideoGame(title,publishDate,price,vgPlatform,gameLength,vgGenre);
                default:
                    System.out.println("Input non valido!");
            }
        }

    }
}
