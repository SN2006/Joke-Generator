package com.example.app.entity;

public class Joke {

    private Long id;
    private String joke;
    private String category;

    public Joke() {}

    public Joke(Long id, String joke, String category) {
        this.id = id;
        this.joke = joke;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Joke from category " + category + " with id " + id + ":\n" + joke;
    }
}
