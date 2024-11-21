package com.example.app.model;

import com.example.app.entity.Fact;
import com.example.app.entity.Joke;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppModel {

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Joke getJokeByCategory(String category) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(String.format("https://v2.jokeapi.dev/joke/%s?type=single", category))
        ).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Joke.class);
    }

    public Fact getCatFact() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(
                URI.create("https://catfact.ninja/fact")
        ).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Fact.class);
    }

}
