package co.com.yacalder.condormovies.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "movie_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = SqLiteHelper.class.getSimpleName();



    public SqLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SqliteTable.DB_MOVIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS movie_database " , null);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String table, ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(table, null, values);

        if(result == -1){
            Log.d(TAG, "Failed to save data");
            return false;
        }else {
            Log.d(TAG, "Save successful");
            return true;
        }
    }

}
