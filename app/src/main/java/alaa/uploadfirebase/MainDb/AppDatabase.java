package alaa.uploadfirebase.MainDb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {QuranWdefaultSheikh.class,AnotherLangTable.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME="alaa";
    public static volatile  AppDatabase instance;
    private  static final Object LOCK = new Object();

    public static AppDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            synchronized (LOCK)
            {
                if(instance == null)
                {
                    instance = Room.databaseBuilder(context.getApplicationContext() , AppDatabase.class , DATABASE_NAME).enableMultiInstanceInvalidation()
                            .allowMainThreadQueries().build();
                }
            }
        }
        return instance;
    }




    public abstract DAO.Quran quranDao();
    public abstract DAO.AnotherLang anotherLangDao();


}
