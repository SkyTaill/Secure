package ru.gb.ProductRep;

public class Product {
    private float id;
    private String name;
    private float price;

    public Product() {
    }

    public Product(float id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public void setId(float id) {
        this.id = id;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}