package com.ntk.quizzy.Database;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {QuestionModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract QuesDAO QuesDAO();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "Ques_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PDBAsyncTask(instance).execute();
        }
    };

    private static class PDBAsyncTask extends AsyncTask<Void, Void, Void> {
        private QuesDAO QuesDAO;

        private PDBAsyncTask(AppDatabase db) {
            QuesDAO = db.QuesDAO();
        }

        //On First Install Create Add Three Questions To Our Database
        @Override
        protected Void doInBackground(Void... voids) {
            QuesDAO.insert(new QuestionModel("What animal is white?","Flamingo","Tuna","Polar Bear","Phoenix",3));
            QuesDAO.insert(new QuestionModel("What bird can fly?","Penguin","Pigeon","Dodo","Ostrich",2));
            QuesDAO.insert(new QuestionModel("What is not a food?","Rock","Pizza","Hotdog","Cake",1));
            return null;
        }
    }

}