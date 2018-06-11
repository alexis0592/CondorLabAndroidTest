package co.com.yacalder.condormovies.data.sqlite;

import android.content.ContentValues;
import android.content.Context;

import co.com.yacalder.condormovies.data.entity.PopularMovie.Result;

public class SqliteController {

    private SqLiteHelper sqLiteHelper;
    private Context context;

    public SqliteController(Context context) {

        this.context = context;
        this.sqLiteHelper = new SqLiteHelper(this.context);
    }

    public boolean saveMovie(Result result){
        ContentValues values = new ContentValues();
        values.put(SqliteTable.MOVIE_ID, result.getId());
        values.put(SqliteTable.BUDGET, result.getBudget());
        values.put(SqliteTable.OVERVIEW, result.getOverview());
        values.put(SqliteTable.RELEASE_DATE, result.getReleaseDate());
        values.put(SqliteTable.URL, result.getHomepage());

        return sqLiteHelper.insertData(SqliteTable.TABLE_MOVIE, values);
    }
}
