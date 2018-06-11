package co.com.yacalder.condormovies.ui;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MovieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
