package co.com.yacalder.condormovies.data.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieApiImpl {

    private static final String HOST = "https://api.themoviedb.org/";
    private static final String API_KEY = "ee29c874c4dd194887b129ef3b347523";
    private static IMovieAPI movieApiInterface;
    private static OkHttpClient.Builder httpClient;

    public static IMovieAPI getInstance(){

        if(movieApiInterface == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(HOST)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            movieApiInterface = retrofit.create(IMovieAPI.class);
        }

        return  movieApiInterface;
    }


}
