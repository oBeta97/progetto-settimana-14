package progettosettimana14.entities;

import java.util.HashSet;
import java.util.stream.Collectors;

public class LibraryGeneralStatistics {
    private int videoGameCount;
    private int tableGameCount;
    private int gameCount;
    private double avgPrice;

    public LibraryGeneralStatistics(HashSet<Game> library) {
        setVideoGameCount((int) library.stream().filter(game -> game instanceof VideoGame).count());
        setTableGameCount((int) library.stream().filter(game -> game instanceof TableGame).count());
        setGameCount(library.size());
        setAvgPrice(library.stream().collect(Collectors.averagingDouble(Game::getPrice)));
    }

    public int getVideoGameCount() {
        return videoGameCount;
    }

    private void setVideoGameCount(int videoGameCount) {
        this.videoGameCount = videoGameCount;
    }

    public int getTableGameCount() {
        return tableGameCount;
    }

    private void setTableGameCount(int tableGameCount) {
        this.tableGameCount = tableGameCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    private void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    private void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }
}
