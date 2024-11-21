package com.example.app;

import com.example.app.controller.AppController;
import com.example.app.model.AppModel;
import com.example.app.view.AppView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new AppController(
                new AppView(),
                new AppModel()
        ).run();
    }
}
