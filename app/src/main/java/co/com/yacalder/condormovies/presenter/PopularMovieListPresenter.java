package co.com.yacalder.condormovies.presenter;

import android.util.Log;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Movie;
import co.com.yacalder.condormovies.model.interactor.PopularMovieInteractor;
import co.com.yacalder.condormovies.model.interactor.interfaces.IBaseCallback;
import co.com.yacalder.condormovies.presenter.interfaces.IPresenter;
import co.com.yacalder.condormovies.view.MovieListView;

public class PopularMovieListPresenter implements IPresenter<MovieListView>, IBaseCallback {

    private PopularMovieInteractor popularMovieInteractor;
    private MovieListView movieListView;

    public void getPopularMoviesList(){
        this.movieListView.showLoading();
        this.popularMovieInteractor.getPopularMovies(this);
    }

    @Override
    public void onSuccess(Object object) {
        Movie movieList = (Movie)object;
        this.movieListView.hideLoading();
        movieListView.initializeData(movieList);
        Log.d("Hola", "hola");
    }

    @Override
    public void onError(Object object) {

    }

    @Override
    public void addView(MovieListView view) {
        this.movieListView = view;
        this.popularMovieInteractor = new PopularMovieInteractor();
    }

    @Override
    public void removeView() {

    }

}
