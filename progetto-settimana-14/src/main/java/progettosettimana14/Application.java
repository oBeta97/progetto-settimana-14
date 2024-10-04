package progettosettimana14;

import progettosettimana14.entities.Game;
import progettosettimana14.entities.GameLibrary;
import progettosettimana14.entities.LibraryGeneralStatistics;
import progettosettimana14.exceptions.DuplicatedGameKeyException;
import progettosettimana14.exceptions.GameNotFoundException;
import progettosettimana14.suplier.Suppliers;
import progettosettimana14.utils.AppActions;
import progettosettimana14.utils.ReadInput;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!"); // riga lasciata di proposito

        Scanner s = new Scanner(System.in);

        GameLibrary myLibrary = new GameLibrary();

        int nrOfGames = ReadInput.readNumber("Quanto sarà lunga la lista di giochi?", s);

        for (int i = 0; i < nrOfGames; i++) {
            try{
                myLibrary.add(Suppliers.getRandomGame.get());
            } catch (DuplicatedGameKeyException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Lista generata con successo!");

        System.out.println(" ");
        System.out.println(" ");

        mainMenu:
        while(true){

            String msg = "Operazioni disponibili:" +
                    "\n\t 1. Aggiungi gioco" +
                    "\n\t 2. Ricerca per ID" +
                    "\n\t 3. Ricerca per prezzo" +
                    "\n\t 4. Ricerca per numero di giocatori (table games)" +
                    "\n\t 5. Rimuovi gioco" +
                    "\n\t 6. Aggiorna dettagli gioco" +
                    "\n\t 7. Statistiche della libreria" +
                    "\n\t 8. Visualizza libreria" +
                    "\n\t 0. Esci";

            switch(ReadInput.readNumber(msg, s)){
                case 1:
                    try{
                        myLibrary.add(AppActions.addGame(s));
                    } catch (DuplicatedGameKeyException e) {
                        System.out.println("Errore nell'inserimento, chiave doppia");
                    }
                    break;
                case 2:
                    try{
                        System.out.println(myLibrary.searchByID(
                                ReadInput.readNumber("Indica l'id che vuoi cercare:", s)
                        ));

                    } catch (GameNotFoundException e) {
                        System.out.println("ID Non trovato!");
                    }
                    break;
                case 3:
                    try{
                        System.out.println(myLibrary.searchByPrice(
                                ReadInput.readDouble("Inserisci il prezzo massimo da ricercare:",s)
                        ));
                    } catch (GameNotFoundException e) {
                        System.out.println("Non ci sono giochi con un prezzo inferiore a quello inserito");
                    }
                    break;
                case 4:
                    try{
                        System.out.println(myLibrary.searchByNumberOfPlayer(
                                ReadInput.readNumber("Inserisci il nr massimo di giocatori da ricercare", s)
                        ));
                    } catch (GameNotFoundException e) {
                        System.out.println("Non ci sono giochi con un numero di giocatori inferiore a quello inserito");
                    }
                    break;
                case 5:
                    try{
                        System.out.println("L'indice " +
                            myLibrary.removeID(
                                ReadInput.readNumber("Inserisci l'indice da eliminare:",s)
                            )
                            + " è stato rimosso"
                        );
                    } catch (GameNotFoundException e) {
                        System.out.println("Indice non trovato");
                    }
                    break;
                case 6:
                    try{
                        if(ReadInput.readYN("Attenzione! Dovrai reinserire tutti i dati del gioco. Continuare?",s)){

                            myLibrary.updateByID(
                                    ReadInput.readNumber("Inserisci l'indice da modificare",s),
                                    AppActions.addGame(s)
                            );
                            System.out.println("Dettagli Aggiornati!");
                        }
                    } catch (GameNotFoundException e) {
                        System.out.println("Indice non trovato");
                    }
                    break;
                case 7:
                    LibraryGeneralStatistics stats = myLibrary.statistics();

                    System.out.println("Nr totale giochi: " + stats.getGameCount());
                    System.out.println("Nr video giochi: " + stats.getVideoGameCount());
                    System.out.println("Nr giochi da tavolo: " + stats.getTableGameCount());
                    System.out.println("Media dei prezzi: " + stats.getAvgPrice());
                    break;
                case 8:
                    System.out.println(myLibrary);
                    break;
                case 0:
                    break mainMenu;
                default:
                    System.out.println("Valore inserito non corretto!");
            }
        }











        s.close();
//        TEST!
//        List<Game> test = Suppliers.getRandomGameList(10);
//
//        System.out.println(test);

    }
}
