package co.com.yacalder.condormovies.presenter.interfaces;

public interface IPresenter<T> {

    void addView(T view);
    void removeView();
}
