package progettosettimana14.entities;

import java.time.LocalDate;

public abstract class Game {

    private int id;
    private String title;
    private LocalDate publishYear;
    private double price;

    public Game(String title, LocalDate publishYear, double price) {
        setId(hashCode());
        setTitle(title);
        setPublishYear(publishYear);
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
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
