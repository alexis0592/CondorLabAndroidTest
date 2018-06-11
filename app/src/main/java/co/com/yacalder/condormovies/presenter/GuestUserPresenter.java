package co.com.yacalder.condormovies.presenter;

import co.com.yacalder.condormovies.data.entity.GuestUser;
import co.com.yacalder.condormovies.model.interactor.GuestUserInteractor;
import co.com.yacalder.condormovies.model.interactor.interfaces.IBaseCallback;
import co.com.yacalder.condormovies.presenter.interfaces.IPresenter;
import co.com.yacalder.condormovies.view.GuestUserView;

public class GuestUserPresenter implements IPresenter<GuestUserView>, IBaseCallback {

    private GuestUserInteractor guestUserInteractor;
    private GuestUserView guestUserView;
    private GuestUser guestUser;

    public GuestUserPresenter() {
    }

    public void authenticateGuestuser(){
        this.guestUserInteractor = new GuestUserInteractor();
        guestUserInteractor.authenticateGuestUser(this);
    }

    public GuestUser getGuestUser() {
        return guestUser;
    }

    public void setGuestUser(GuestUser guestUser) {
        this.guestUser = guestUser;
    }



    @Override
    public void onSuccess(Object object) {
        this.guestUser = (GuestUser)object;
        this.guestUserView.getSessionId(this.guestUser.getGuestSessionId());
    }

    @Override
    public void onError(Object object) {

    }


    @Override
    public void addView(GuestUserView view) {
        this.guestUserView = view;
        this.guestUserInteractor = new GuestUserInteractor();
    }

    @Override
    public void removeView() {

    }
}
