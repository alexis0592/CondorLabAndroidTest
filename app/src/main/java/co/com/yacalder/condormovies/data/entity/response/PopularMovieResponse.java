package co.com.yacalder.condormovies.data.entity.response;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Movie;

public class PopularMovieResponse {

    private Movie result;

    public Movie getResult() {
        return result;
    }

    public void setResult(Movie result) {
        this.result = result;
    }
}
