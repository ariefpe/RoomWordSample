package net.medinacom.roomwordsample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository extends Repository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        runAsync(() -> mWordDao.insert(word));
    }
}
