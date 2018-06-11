package co.com.yacalder.condormovies.model.interactor;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Movie;
import co.com.yacalder.condormovies.data.rest.MovieApiImpl;
import co.com.yacalder.condormovies.model.interactor.interfaces.IBaseCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMovieInteractor {

    public static final String TAG = "PopularMovieInteractor";

    public void getPopularMovies(final IBaseCallback popularMovieCallback){

        Call<Movie> call = MovieApiImpl.getInstance().getPopularMovies();
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful()){
                    Movie popularMovieResponse = response.body();
                    popularMovieCallback.onSuccess(popularMovieResponse);
                }else {
                    popularMovieCallback.onError("An error ocurred in " + TAG);
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });

    }
}
