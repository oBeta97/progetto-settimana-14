package progettosettimana14.entities;

import progettosettimana14.enums.VideoGameGenre;
import progettosettimana14.enums.VideoGamePlatforms;

import java.time.LocalDate;

public class VideoGame extends Game{

    private VideoGamePlatforms platforms;
    private int gameDuration;
    private VideoGameGenre genre;

    public VideoGame(String title, LocalDate publishYear, double price, VideoGamePlatforms platforms, int gameDuration, VideoGameGenre genre) {
        super(title, publishYear, price);
        setPlatforms(platforms);
        setGameDuration(gameDuration);
        setGenre(genre);
    }

    public VideoGamePlatforms getPlatforms() {
        return platforms;
    }

    public void setPlatforms(VideoGamePlatforms platforms) {
        this.platforms = platforms;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(int gameDuration) {
        this.gameDuration = gameDuration;
    }

    public VideoGameGenre getGenre() {
        return genre;
    }

    public void setGenre(VideoGameGenre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\ttype=VideoGame" +
                "\n\tplatforms=" + platforms +
                "\n\tgameDuration=" + gameDuration +
                "\n\tgenre=" + genre +
                "\n}\n";
    }
}


