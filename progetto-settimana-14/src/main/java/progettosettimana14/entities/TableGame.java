package progettosettimana14.entities;

import progettosettimana14.exceptions.ToManyPlayerException;

import java.time.LocalDate;

public class TableGame extends Game {
    private int numberOfPlayer;
    private int avgGameDuration;

    public TableGame(String title, LocalDate publishYear, double price, int numberOfPlayer, int avgGameDuration) throws ToManyPlayerException {
        super(title, publishYear, price);
        setNumberOfPlayer(numberOfPlayer);
        setAvgGameDuration(avgGameDuration);
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) throws ToManyPlayerException {
        if(numberOfPlayer < 2 || numberOfPlayer > 10 )
            throw new ToManyPlayerException();

        this.numberOfPlayer = numberOfPlayer;
    }

    public int getAvgGameDuration() {
        return avgGameDuration;
    }

    public void setAvgGameDuration(int avgGameDuration) {
        this.avgGameDuration = avgGameDuration;
    }
}
