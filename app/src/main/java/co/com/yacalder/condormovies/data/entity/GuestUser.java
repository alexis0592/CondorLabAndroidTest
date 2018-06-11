package co.com.yacalder.condormovies.data.entity;


import com.google.gson.annotations.SerializedName;

public class GuestUser {

    @SerializedName("guest_session_id")
    private String guestSessionId;
    @SerializedName("success")
    private Boolean success;

    public GuestUser(String guestSessionId) {
        this.guestSessionId = guestSessionId;
    }

    public String getGuestSessionId() {
        return guestSessionId;
    }

    public void setGuestSessionId(String guestSessionId) {
        this.guestSessionId = guestSessionId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
