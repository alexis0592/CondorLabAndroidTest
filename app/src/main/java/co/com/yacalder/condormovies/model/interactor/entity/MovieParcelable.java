package co.com.yacalder.condormovies.model.interactor.entity;

import android.os.Parcel;
import android.os.Parcelable;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;

public class MovieParcelable implements Parcelable {

    private String title;
    private String overview;
    private String releaseDate;
    private String budget;
    private String trailer;

    public MovieParcelable() {
    }

    protected MovieParcelable(Parcel in){
        this.title = in.readString();
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.budget = in.readString();
        this.trailer = in.readString();
    }

    public static final Parcelable.Creator<MovieParcelable> CREATOR = new Parcelable.Creator<MovieParcelable>(){

        @Override
        public MovieParcelable createFromParcel(Parcel parcel) {
            return new MovieParcelable(parcel);
        }

        @Override
        public MovieParcelable[] newArray(int i) {
            return new MovieParcelable[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.overview);
        parcel.writeString(this.releaseDate);
        parcel.writeString(this.budget);
        parcel.writeString(this.trailer);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
