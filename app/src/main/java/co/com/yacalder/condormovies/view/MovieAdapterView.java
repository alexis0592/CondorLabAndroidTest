package co.com.yacalder.condormovies.view;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Movie;
import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;

public interface MovieAdapterView extends BaseView {

    void onMovieSelected(Result movie);

}
