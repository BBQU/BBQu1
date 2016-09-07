package com.example.lenovo.bbqu.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lenovo.bbqu.model.User;

/**
 * Created by lenovo on 2016/6/13.
 */
public class UserDBAdapter {
    private static final String DB_NAME = "UserDemo.db";
    private static final String DB_TABLE = "userinfo";
    private static final int DB_VERSION = 1;
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PASS = "pass";

    private SQLiteDatabase db;
    private Context context;
    private DBOpenHelper dbOpenHelper;

    public UserDBAdapter(Context _context) {
        context = _context;
    }
    /** Close the database */
    public void close() {
        if (db != null){
            db.close();
            db = null;
        }
    }

    /** Open the database */
    public void open() throws SQLiteException {
        dbOpenHelper = new DBOpenHelper(context, DB_NAME, null, DB_VERSION);
        try {
            db = dbOpenHelper.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            db = dbOpenHelper.getReadableDatabase();
        }
    }

    public long insert(User user) {
        ContentValues newValues = new ContentValues();

        newValues.put(KEY_ID,user.getUserID());
        newValues.put(KEY_NAME,user.getUserName());
        newValues.put(KEY_PASS,user.getPassWord());

        return db.insert(DB_TABLE, null, newValues);
    }
    public User[] queryOneData(long id) {
        Cursor results =  db.query(DB_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_PASS},
                KEY_ID + "=" + id, null, null, null, null);
        return ConvertToUser(results);
    }

    private User[] ConvertToUser(Cursor cursor){
        int resultCounts = cursor.getCount();
        if (resultCounts == 0 || !cursor.moveToFirst()){
            return null;
        }
        User[] users = new User[resultCounts];
        for (int i = 0 ; i<resultCounts; i++){
            users[i] = new User();
            users[i].setUserID( cursor.getLong(cursor.getColumnIndex(KEY_ID)));
            users[i].setUserName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            users[i].setPassWord(cursor.getLong(cursor.getColumnIndex(KEY_PASS)));

            cursor.moveToNext();
        }
        return users;
    }

    private static class DBOpenHelper extends SQLiteOpenHelper {

        public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        private static final String DB_CREATE = "create table " +
                DB_TABLE + " (" + KEY_ID + " integer primary key, " +
                KEY_NAME+ " text not null, " + KEY_PASS+ " integer);";
        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
            _db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(_db);
        }
    }
}
