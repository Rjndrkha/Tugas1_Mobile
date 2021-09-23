package org.aplas.tugas1_rajendra.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;

    static final String DATABASE_NAME = "digitalent.db";

    public static final String TABLE_SQLITE = "sqlite";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_NUMBER = "number";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_SQLITE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY autoincrement, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_ADDRESS + " TEXT NOT NULL," +
                COLUMN_NUMBER + " TEXT NOT NULL" +
                " )";

        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SQLITE);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<HashMap<String, String>> getAllData() {
        ArrayList<HashMap<String, String>> wordList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ TABLE_SQLITE;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put(COLUMN_ID, cursor.getString(0));
                map.put(COLUMN_NAME, cursor.getString(1));
                map.put(COLUMN_ADDRESS, cursor.getString(2));
                map.put(COLUMN_NUMBER, cursor.getString(3));
                wordList.add(map);
            } while (cursor.moveToNext());
        }
        Log.e("select sqlite ", "getAllData: "+wordList);
        database.close();
        return wordList;
    }
    public void insert(String name, String address,String number){
        SQLiteDatabase database = this.getWritableDatabase();
        String queryValues = "INSERT INTO "+ TABLE_SQLITE+ " (name, address, number) "+
                "VALUES ('"+name+"', '"+address+"','"+number+"')";

        Log.e("insert sqlite ", "insert: "+queryValues);
        database.execSQL(queryValues);
        database.close();
    }

    public void update(int id, String name, String address,String number){
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "UPDATE "+TABLE_SQLITE+ " SET "
                + COLUMN_NAME + "= '"+name+"', "
                + COLUMN_ADDRESS +"= '"+address+"',"
                + COLUMN_NUMBER +"= '"+number+"'"
                + " WHERE "+ COLUMN_ID + "='"+id+"'";

        Log.e("update sqlite ", "update: "+updateQuery );
        database.execSQL(updateQuery);
        database.close();
    }

    public void delete(int id){
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "DELETE FROM "+ TABLE_SQLITE + " WHERE "+ COLUMN_ID + "= '"+id+"'";
        Log.e("update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }
}
