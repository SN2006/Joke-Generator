package com.example.app.controller;

import com.example.app.model.AppModel;
import com.example.app.util.Constants;
import com.example.app.view.AppView;

import java.io.IOException;

public class AppController {

    private final AppView view;
    private final AppModel model;

    public AppController(AppView view, AppModel model) {
        this.view = view;
        this.model = model;
    }

    public void run(){
        boolean isRunning = true;
        while(isRunning){
            int commandId = view.getInt(Constants.SELECT_MENU_MENU);
            switch (commandId){
                case 1 -> jokesGeneratorMenu();
                case 2 -> factsGeneratorMenu();
                case 0 -> isRunning = false;
                default -> view.display(Constants.INVALID_COMMAND_MSG);
            }
        }
    }

    private void factsGeneratorMenu(){
        boolean isRunning = true;
        while (isRunning){
            int commandId = view.getInt(Constants.FACT_MENU);
            try{
                switch (commandId){
                    case 1 ->
                        view.display(
                                model.getCatFact().toString()
                        );
                    case 0 -> isRunning = false;
                    default -> view.display(Constants.INVALID_COMMAND_MSG);
                }
            }catch (IOException | InterruptedException e){
                view.display(Constants.SMTH_WRONG_MSG);
            }
        }
    }

    private void jokesGeneratorMenu(){
        boolean isRunning = true;
        while (isRunning){
            int commandId = view.getInt(Constants.JOKE_MENU);
            try{
                switch (commandId){
                    case 1 ->
                            view.display(model
                                    .getJokeByCategory(Constants.PROGRAMMING_CATEGORY)
                                    .toString());
                    case 2 ->
                        view.display(model
                                .getJokeByCategory(Constants.DARK_CATEGORY)
                                .toString());
                    case 3 ->
                            view.display(model
                                    .getJokeByCategory(Constants.PUN_CATEGORY)
                                    .toString());
                    case 4 ->
                            view.display(model
                                    .getJokeByCategory(Constants.MISCELLANEOUS_CATEGORY)
                                    .toString());
                    case 0 -> isRunning = false;
                    default -> view.display(Constants.INVALID_COMMAND_MSG);
                }
            }catch (IOException | InterruptedException e){
                view.display(Constants.SMTH_WRONG_MSG);
            }
        }
    }

}
