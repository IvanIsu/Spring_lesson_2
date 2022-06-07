package ru.geekbrains;

public class Product {

    private Long id;
    private String title;
    private Double cost;

    public Product( String title, Double cost) {
        this.title = title;
        this.cost = cost;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "<tr><td>" + id + "</td><td>" + title +"</td><td>"+ cost + " USD" + "</td></tr>";
    }

    public String getTitle() {
        return title;
    }

    public Double getCost() {
        return cost;
    }

    public Long getId() {
        return id;
    }
}
