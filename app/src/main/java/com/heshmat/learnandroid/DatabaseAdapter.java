package com.heshmat.learnandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.heshmat.learnandroid.models.Question;
import com.heshmat.learnandroid.models.Topic;
import com.heshmat.learnandroid.models.User;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DatabaseAdapter {
    private static final String DB_NAME = "LEARN_ANDROID_DB";
    private Context context;
    private static String TABLE_USER = "USER";
    private static String TABLE_TOPIC = "TOPIC";
    private static String TABLE_QUESTION = "QUESTION";

    private SQLiteDatabase sqLiteDatabase;
    private static DatabaseAdapter databaseAdapter;
    private static final String CREATE_TABLE_USER = ("CREATE TABLE  USER (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,role INTEGER NOT NULL, name varchar NOT NULL, email varchar UNIQUE NOT NULL, password varchar NOT NULL, imgUrl varchar )");
    private static final String CREATE_TABLE_TOPIC = ("CREATE TABLE  TOPIC (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,title TEXT NOT NULL,content TEXT NOT NULL,level TEXT NOT NULL,status INTEGER)");
    private static final String CREATE_TABLE_QUESTION = ("CREATE TABLE  QUESTION (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,question TEXT NOT NULL,answers TEXT NOT NULL,correctChoice TEXT NOT NULL,topicID INTEGER)");


    private DatabaseAdapter(Context context) {
        if (sqLiteDatabase == null) {
            this.context = context;
            int version = 1;
            sqLiteDatabase = new DatabaseAdapterHelper(context, DB_NAME, version).getReadableDatabase();
        }

    }

    public static DatabaseAdapter getDatabaseAdapter(Context context) {
        if (databaseAdapter == null) {
            databaseAdapter = new DatabaseAdapter(context);
        }
        return databaseAdapter;
    }

    public User insertUser(User user) throws SQLiteConstraintException {
        long id = -1;
        ContentValues values = new ContentValues();
        values.put("role", user.getRole());
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        values.put("imgUrl", user.getImgUrl());
        id = sqLiteDatabase.insertOrThrow(TABLE_USER, null, values);

        return id > -1 ? new User(id, user.getRole(), user.getName(), user.getEmail(), user.getPassword(), user.getImgUrl()) : null;


    }

    public User getUser(String email, String password) {
        String query = String.format("SELECT * FROM %s WHERE %s = '%s' AND %s = '%s'", TABLE_USER, StaticFields.USER_COLUMN_EMAIL, email, StaticFields.USER_COLUMN_PASSWORD, password);
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                return new User(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));

            }
        }


        return null;
    }

    /*Topics*/
    public boolean insertTopic(Topic topic) throws SQLiteConstraintException {
        ContentValues values = new ContentValues();
        values.put("title", topic.getTitle());
        values.put("content", topic.getContent());
        values.put("level", topic.getLevel());
        values.put("status", topic.getStatus());
        long id = sqLiteDatabase.insert(TABLE_TOPIC, null, values);
        if (id != -1 && !topic.getExercise().isEmpty()) {
            for (Question q : topic.getExercise()) {
                insertQuestion(id, q);

            }


        }

        return id > -1;


    }

    public boolean insertQuestion(long topicId, Question question) {
        //("CREATE TABLE  QUESTION (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,question TEXT NOT NULL,answers TEXT NOT NULL,correctChoice TEXT NOT NULL,topicID INTEGER)")
        ContentValues values = new ContentValues();
        values.put("question", question.getQuestion());
        values.put("answers", question.getQuestion());
        values.put("correctChoice", question.getCorrectChoice());
        values.put("topicID", topicId);
        return sqLiteDatabase.insert(TABLE_QUESTION, null, values) > -1;


    }

    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(TABLE_TOPIC, StaticFields.TOPIC_TABLE_COLUMNS, null, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Topic topic = new Topic(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
                List<Question> questions = getQuestions(topic.getId());
                topic.setExercise(questions);
                topics.add(topic);

            }

        }
        return topics;
    }

    public List<Question> getQuestions(long topicId) {
        List<Question> questions = new ArrayList<>();
        String query = String.format("SELECT * FROM %s WHERE %s = %s", TABLE_QUESTION, "topicID", topicId);
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                //"CREATE TABLE  QUESTION (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,question TEXT NOT NULL,answers TEXT NOT NULL,correctChoice TEXT NOT NULL,topicID INTEGER)"
                Question question = new Question(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
                questions.add(question);

            }
        }
        return questions;
    }


    public User getUserById(long id) {
        String query = String.format("SELECT * FROM %s WHERE %s = %s", TABLE_USER, StaticFields.USER_COLUMN_ID, id);
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                return new User(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));

            }
        }


        return null;
    }


    private static class DatabaseAdapterHelper extends SQLiteOpenHelper {


        public DatabaseAdapterHelper(@Nullable Context context, @Nullable String name, int version) {
            super(context, name, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_USER);
            db.execSQL(CREATE_TABLE_TOPIC);
            db.execSQL(CREATE_TABLE_QUESTION);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
