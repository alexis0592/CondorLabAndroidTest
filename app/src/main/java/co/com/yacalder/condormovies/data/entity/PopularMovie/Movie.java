package co.com.yacalder.condormovies.data.entity.PopularMovie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;

public class Movie {

    @SerializedName("results")
    private List<Result> results = null;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
