package progettosettimana14.exceptions;

public class ToManyPlayerException extends Exception {

    public ToManyPlayerException (){
        super("Numero di giocatori non valido, inserire un valore da 2 a 10");
    }
}
