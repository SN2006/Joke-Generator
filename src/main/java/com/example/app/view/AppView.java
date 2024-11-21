package com.example.app.view;

import java.util.List;
import java.util.Scanner;

public class AppView {

    private final Scanner IN = new Scanner(System.in);

    public void display(String message) {
        System.out.println(message);
    }

    public void display(List<? extends Object> list) {
        list.stream()
                .map(value -> String.format("~~~ %s", value))
                .forEach(System.out::println);
    }

    public int getInt(String message){
        System.out.print(message);
        return IN.nextInt();
    }

}
