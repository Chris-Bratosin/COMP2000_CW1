package com.example.comp2000_cw1.Models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERS.db";
    private static final int DATABASE_VERSION = 3;

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_ROLE = "role";

    public DbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_USERS + "("  +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "  +
                COLUMN_EMAIL + " TEXT NOT NULL, "  +
                COLUMN_PASSWORD + "TEXT NOT NULL, "  +
                COLUMN_ROLE + "TEXT NOT NULL "  +
                ")";
        db.execSQL(createTable);


        db.execSQL("INSERT INTO " + TABLE_USERS + " (" + COLUMN_EMAIL + ", " + COLUMN_PASSWORD + ", " + COLUMN_ROLE + ") VALUES ('admin@gmail.com', 'admin123', 'admin')");
        db.execSQL("INSERT INTO " + TABLE_USERS + " (" + COLUMN_EMAIL + ", " + COLUMN_PASSWORD + ", " + COLUMN_ROLE + ") VALUES ('employee123@gmail.com', 'employee123', 'employee')");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    @SuppressLint("Range")
    public String validateUser(String email, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT " + COLUMN_ROLE + " FROM " + TABLE_USERS + " WHERE " +
                COLUMN_EMAIL + " = ? AND " + COLUMN_PASSWORD + " = ?";

        Cursor cursor = db.rawQuery(query, new String[] {email, password});

        String role = null;
        if (cursor.moveToFirst())
        {
            role = cursor.getString(cursor.getColumnIndex(COLUMN_ROLE));
        }
        cursor.close();
        db.close();

        return role;
    }
}

