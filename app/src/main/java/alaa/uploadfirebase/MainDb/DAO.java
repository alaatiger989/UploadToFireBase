package alaa.uploadfirebase.MainDb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface DAO{



    @Dao
    public interface Quran{
        @Query("SELECT * FROM quran")
        List<QuranWdefaultSheikh> getQuran();

        @Query("SELECT * FROM quran WHERE sourah_number LIKE :sourahNumber LIMIT 1")
        List<QuranWdefaultSheikh> getSourahDetails(String sourahNumber);

        @Query("SELECT * FROM quran WHERE sourah_number LIKE :sourahNumber")
        List<QuranWdefaultSheikh> getSourahAyat(String sourahNumber);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(QuranWdefaultSheikh sourah);
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<QuranWdefaultSheikh> sourahs);

        @Query("SELECT COUNT(*) FROM quran")
        int getCount();

    }



    @Dao
    public interface AnotherLang{
        @Query("SELECT * FROM anotherLang")
        List<AnotherLangTable> getAyats();
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(AnotherLangTable ayah);
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<AnotherLangTable> ayahs);

        @Query("SELECT COUNT(*) FROM anotherLang")
        int getCount();

        @Query("SELECT * FROM anotherLang WHERE numberOfSourah LIKE :sourahNumber")
        List<AnotherLangTable> getSourahAyat(String sourahNumber);

        @Query("DELETE FROM anotherLang")
        int deleteAll();

    }
}


