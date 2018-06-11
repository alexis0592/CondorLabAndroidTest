package co.com.yacalder.condormovies.view;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Movie;

public interface MovieListView extends BaseView{

    void initializeData(Movie movie);
    void showLoading();
    void hideLoading();
}
