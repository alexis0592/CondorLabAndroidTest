package co.com.yacalder.condormovies.data.sqlite;

public class SqliteTable {

    public static final String TABLE_MOVIE = "movies";
    public static final String MOVIE_ID = "id";
    public static final String OVERVIEW = "overview";
    public static final String RELEASE_DATE = "release_date";
    public static final String BUDGET = "budget";
    public static final String URL = "url";

    public static final String DB_MOVIE = "CREATE TABLE " + TABLE_MOVIE + "(" + MOVIE_ID + " INTEGER PRIMARY KEY, "
            + OVERVIEW + " TEXT, " + RELEASE_DATE + " TEXT, " + BUDGET + " TEXT, " + URL + " TEXT" + ")";


}
