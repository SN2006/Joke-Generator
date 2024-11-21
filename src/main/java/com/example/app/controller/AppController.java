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
        while (isRunning){
            int commandId = view.getChoose();
            try{
                switch (commandId){
                    case 1 ->
                            view.display(model
                                    .getJokeByCategory(Constants.PROGRAMMING_CATEGORY).toString());
                    case 0 -> isRunning = false;
                    default -> view.display(Constants.INVALID_COMMAND_MSG);
                }
            }catch (IOException | InterruptedException e){
                view.display(Constants.SMTH_WRONG_MSG);
            }
        }
    }

}
