package com.gmail.elnora.fet.usersdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DBAdapter(Context context){
        dbHelper = new DBHelper(context.getApplicationContext());
    }

    public DBAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    private Cursor getAllEntries(){
        String[] columns = new String[] {DBHelper.COLUMN_ID, DBHelper.COLUMN_NAME, DBHelper.COLUMN_YEAR};
        return  database.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    public List<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        Cursor cursor = getAllEntries();
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME));
                int year = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_YEAR));
                users.add(new User(id, name, year));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return  users;
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DBHelper.TABLE_NAME);
    }

    public User getUser(long id){
        User user = null;
        String query = String.format("SELECT * FROM %s WHERE %s=?", DBHelper.TABLE_NAME, DBHelper.COLUMN_ID);
        Cursor cursor = database.rawQuery(query, new String[]{ String.valueOf(id)});
        if(cursor.moveToFirst()){
            String name = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME));
            int year = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_YEAR));
            user = new User(id, name, year);
        }
        cursor.close();
        return  user;
    }

    public long insert(User user){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_NAME, user.getName());
        cv.put(DBHelper.COLUMN_YEAR, user.getYear());
        return  database.insert(DBHelper.TABLE_NAME, null, cv);
    }

    public long delete(long userId){
        String whereClause = "_id = ?";
        String[] whereArgs = new String[]{String.valueOf(userId)};
        return database.delete(DBHelper.TABLE_NAME, whereClause, whereArgs);
    }

    public long update(User user){
        String whereClause = DBHelper.COLUMN_ID + "=" + String.valueOf(user.getId());
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_NAME, user.getName());
        cv.put(DBHelper.COLUMN_YEAR, user.getYear());
        return database.update(DBHelper.TABLE_NAME, cv, whereClause, null);
    }

}
