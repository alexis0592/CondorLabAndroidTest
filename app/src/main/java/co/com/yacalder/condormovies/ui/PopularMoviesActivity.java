package co.com.yacalder.condormovies.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import co.com.yacalder.condormovies.R;
import co.com.yacalder.condormovies.data.entity.PopularMovie.Movie;
import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;
import co.com.yacalder.condormovies.presenter.PopularMovieListPresenter;
import co.com.yacalder.condormovies.ui.Adapters.MovieAdapter;
import co.com.yacalder.condormovies.view.MovieAdapterView;
import co.com.yacalder.condormovies.view.MovieListView;

public class PopularMoviesActivity extends Activity implements MovieListView{

    private PopularMovieListPresenter movieListPresenter;

    private RecyclerView recyclerView;
    private View vLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_movies);

        initComponents();

        this.movieListPresenter = new PopularMovieListPresenter();
        this.movieListPresenter.addView(this);

        this.movieListPresenter.getPopularMoviesList();
    }

    private void initComponents() {

        this.recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        vLoading = findViewById(R.id.vLoading);
        vLoading.setVisibility(View.GONE);
    }

    @Override
    public void initializeData(Movie movie) {
        MovieAdapter movieAdapter = new MovieAdapter(movie, new MovieAdapterView() {
            @Override
            public Context getContext() {
                return null;
            }

            @Override
            public void onMovieSelected(Result movie) {
                Intent intent = new Intent(PopularMoviesActivity.this, MovieDetailActivity.class);
                intent.putExtra("ID", movie.getId().toString());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(movieAdapter);
    }

    @Override
    public void showLoading() {
        vLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        vLoading.setVisibility(View.GONE);
    }

    @Override
    public Context getContext() {
        return null;
    }
}
