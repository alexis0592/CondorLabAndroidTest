package co.com.yacalder.condormovies.data.rest;

import co.com.yacalder.condormovies.data.entity.GuestUser;
import co.com.yacalder.condormovies.data.entity.PopularMovie.Movie;
import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;
import co.com.yacalder.condormovies.data.entity.response.GuestUserResponse;
import co.com.yacalder.condormovies.data.entity.response.PopularMovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IMovieAPI {

    @GET("/3/authentication/guest_session/new?api_key=ee29c874c4dd194887b129ef3b347523&order=desc")
    Call<GuestUser>authenticateGuestSession();

    @GET("/3/movie/popular?api_key=ee29c874c4dd194887b129ef3b347523&language=en-US&page=1")
    Call<Movie>getPopularMovies();

    @GET("/3/movie/{id}?api_key=ee29c874c4dd194887b129ef3b347523&language=en-US")
    Call<Result>getMovieDetail(@Path("id") String movieId);
}
