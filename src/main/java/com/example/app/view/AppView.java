package com.example.app.view;

import com.example.app.util.Constants;

import java.util.Scanner;

public class AppView {

    private final Scanner IN = new Scanner(System.in);

    public void display(String message) {
        System.out.println(message);
    }

    public int getInt(String message){
        System.out.print(message);
        return IN.nextInt();
    }

}
