package progettosettimana14.exceptions;

public class DuplicatedGameKeyException extends Exception{

    public DuplicatedGameKeyException() {
        super("Chiave inserita già presente");
    }
}
