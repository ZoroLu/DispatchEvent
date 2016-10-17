package me.zoro.dispatchevent;

import android.app.Application;

/**
 * Created by luguanquan on 2016/10/17.
 */

public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static App getInstance() {
        return app;
    }
}
