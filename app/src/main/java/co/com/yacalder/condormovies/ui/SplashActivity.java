package co.com.yacalder.condormovies.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import co.com.yacalder.condormovies.presenter.GuestUserPresenter;
import co.com.yacalder.condormovies.view.GuestUserView;

public class SplashActivity extends AppCompatActivity implements GuestUserView{

    private GuestUserPresenter guestUserPresenter;
    private Button guestUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_movie_list);

        guestUserPresenter = new GuestUserPresenter();
        guestUserPresenter.addView(this);
        guestUserPresenter.authenticateGuestuser();

        startActivity(new Intent(SplashActivity.this, PopularMoviesActivity.class));

        finish();

    }

    @Override
    public void getSessionId(String id) {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
