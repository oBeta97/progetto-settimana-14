package progettosettimana14.exceptions;

public class GameNotFoundException extends Exception{
    public GameNotFoundException(){
        super("Gioco non trovato");
    }
}
