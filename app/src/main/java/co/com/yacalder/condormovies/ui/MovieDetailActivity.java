package co.com.yacalder.condormovies.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import co.com.yacalder.condormovies.R;
import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;
import co.com.yacalder.condormovies.presenter.MovieDetailPresenter;
import co.com.yacalder.condormovies.view.MovieDetailView;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailView {

    private MovieDetailPresenter movieDetailPresenter;

    private TextView movieTitleTextView;
    private TextView overviewTextView;
    private TextView releaseDateTextView;
    private TextView budgetTextView;
    private TextView trailerUrlTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Bundle extras = getIntent().getExtras();
        String movieId = extras.getString("ID");

        initComponents();

        this.movieDetailPresenter = new MovieDetailPresenter(this.getApplicationContext());
        this.movieDetailPresenter.addView(this);
        this.movieDetailPresenter.getMovieDetail(movieId);

    }

    private void initComponents() {
        this.movieTitleTextView = (TextView)findViewById(R.id.title_movie);
        this.overviewTextView = findViewById(R.id.overview_desc);
        this.releaseDateTextView = findViewById(R.id.release_date_value);
        this.budgetTextView = findViewById(R.id.budgetValue);
        this.trailerUrlTextView = findViewById(R.id.trailer_value);
    }

    @Override
    public void fillMovieDetails(Result result) {
        this.movieTitleTextView.setText(result.getTitle());
        this.overviewTextView.setText(result.getOverview());
        this.releaseDateTextView.setText(result.getReleaseDate());
        this.budgetTextView.setText(result.getBudget());
    }

    @Override
    public void validateUrlTrailer(String url) {
        if(url != null || !url.isEmpty()){
            this.trailerUrlTextView.setText(url);
        }else {
            this.trailerUrlTextView.setText("No trailer available");
        }
    }

    @Override
    public Context getContext() {
        return null;
    }
}
