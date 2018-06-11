package co.com.yacalder.condormovies.view;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;

public interface MovieDetailView extends BaseView {

    void fillMovieDetails(Result result);

    void validateUrlTrailer(String url);

}
