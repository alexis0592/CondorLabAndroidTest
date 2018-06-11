package co.com.yacalder.condormovies.model.interactor;

import co.com.yacalder.condormovies.data.entity.GuestUser;
import co.com.yacalder.condormovies.data.rest.MovieApiImpl;

import co.com.yacalder.condormovies.model.interactor.interfaces.IBaseCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestUserInteractor {

    private static final String TAG = "GuestSessionInteractor";

    public void authenticateGuestUser(final IBaseCallback guestUserCallback){

        Call<GuestUser> call = MovieApiImpl.getInstance().authenticateGuestSession();
        call.enqueue(new Callback<GuestUser>() {
            @Override
            public void onResponse(Call<GuestUser> call, Response<GuestUser> response) {
                if(response.isSuccessful()){
                    GuestUser guestUserResponse = response.body();
                    guestUserCallback.onSuccess(guestUserResponse);
                }else {
                    guestUserCallback.onError("an error ocurred " + TAG);
                }
            }

            @Override
            public void onFailure(Call<GuestUser> call, Throwable t) {

            }
        });

    }
}
