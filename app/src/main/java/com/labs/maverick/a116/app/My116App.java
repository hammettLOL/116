package com.labs.maverick.a116.app;

import android.app.Application;

/**
 * Created by Maverick on 4/08/2017.
 */

public class My116App extends Application {
    private static My116App instance;

    public My116App(){
        super();
        instance = this;
    }
    public static My116App getInstance(){
        return instance;
    }
}
