package progettosettimana14.entities;

import java.time.LocalDate;

public abstract class Game  {

    private static int newID = 0;

    private int id;
    private String title;
    private LocalDate publishYear;
    private double price;

    public Game(String title, LocalDate publishYear, double price) {
        setId();
        setTitle(title);
        setPublishYear(publishYear);
        setPrice(price);
    }

    // Override di equals per far si che i set controllino per ID e non per indice di memoria
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Game)) return false;
        Game otherGame = (Game) obj;

        return this.id == otherGame.id;
    }

    private int getNewId (){
        return Game.newID++;
    }


    public int getId() {
        return id;
    }

    private void setId() {
        this.id = getNewId();
    }

    protected void updateID(int newID){
        this.id = newID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(LocalDate publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
