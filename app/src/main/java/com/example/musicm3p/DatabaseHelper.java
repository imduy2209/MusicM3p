package com.example.musicm3p;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.musicm3p.CommentRating;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TABLE_COMMENTS = "comments";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SONG_ID = "song_id";
    private static final String COLUMN_COMMENT_TEXT = "comment_text";
    private static final String COLUMN_RATING = "rating";

    public DatabaseHelper(Context context) {
        super(context, "music_database1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_COMMENT_TABLE = "CREATE TABLE " + TABLE_COMMENTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SONG_ID + " INTEGER,"
                + COLUMN_COMMENT_TEXT + " TEXT,"
                + COLUMN_RATING + " REAL)"; // Thêm cột rating vào bảng
        db.execSQL(CREATE_COMMENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }

    public void addComment(CommentRating commentRating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SONG_ID, commentRating.getSongId());
        values.put(COLUMN_COMMENT_TEXT, commentRating.getComment());
        values.put(COLUMN_RATING, commentRating.getRating()); // Thêm giá trị của rating vào cơ sở dữ liệu
        db.insert(TABLE_COMMENTS, null, values);
        db.close();
    }

    public List<CommentRating> getAllCommentsForSong(int songId) {
        List<CommentRating> comments = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_COMMENTS + " WHERE " + COLUMN_SONG_ID + " = ?";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(songId)});
        if (cursor.moveToFirst()) {
            do {
                String commentText = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_COMMENT_TEXT));
                float rating = cursor.getFloat(cursor.getColumnIndexOrThrow(COLUMN_RATING)); // Lấy giá trị của rating từ cơ sở dữ liệu
                CommentRating commentRating = new CommentRating(songId, rating, commentText,AnimalNameGenerator.getRandomAnimalName());
                comments.add(commentRating);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return comments;
    }
}
