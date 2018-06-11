package co.com.yacalder.condormovies.model.interactor;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Movie;
import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;
import co.com.yacalder.condormovies.data.rest.MovieApiImpl;
import co.com.yacalder.condormovies.model.interactor.interfaces.IBaseCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailInteractor {

    public static final String TAG = "MovieDetailInteractor";

    public void getPopularMovies(String movieId, final IBaseCallback popularMovieCallback){

        Call<Result> call = MovieApiImpl.getInstance().getMovieDetail(movieId);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    Result movieDetail = response.body();
                    popularMovieCallback.onSuccess(movieDetail);
                }else {
                    popularMovieCallback.onError("An error ocurred in " + TAG);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

    }
}
