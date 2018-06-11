package co.com.yacalder.condormovies.presenter;

import android.content.Context;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;
import co.com.yacalder.condormovies.data.sqlite.SqliteController;
import co.com.yacalder.condormovies.model.interactor.MovieDetailInteractor;
import co.com.yacalder.condormovies.model.interactor.interfaces.IBaseCallback;
import co.com.yacalder.condormovies.presenter.interfaces.IPresenter;
import co.com.yacalder.condormovies.view.MovieDetailView;

public class MovieDetailPresenter implements IPresenter<MovieDetailView>, IBaseCallback {

    private MovieDetailInteractor movieDetailInteractor;
    private MovieDetailView movieDetailView;
    private SqliteController sqliteController;
    private Context context;

    public MovieDetailPresenter(Context context) {
        this.context = context;
        this.sqliteController = new SqliteController(this.context);
    }

    public void getMovieDetail(String movieId){
        this.movieDetailInteractor.getPopularMovies(movieId, this);
    }

    @Override
    public void onSuccess(Object object) {
        Result movieDetailResult = (Result)object;
        movieDetailView.fillMovieDetails(movieDetailResult);
        movieDetailView.validateUrlTrailer(movieDetailResult.getHomepage());

       this.sqliteController.saveMovie(movieDetailResult);
    }

    @Override
    public void onError(Object object) {

    }

    @Override
    public void addView(MovieDetailView view) {
        this.movieDetailView = view;
        this.movieDetailInteractor = new MovieDetailInteractor();

    }

    @Override
    public void removeView() {

    }
}
