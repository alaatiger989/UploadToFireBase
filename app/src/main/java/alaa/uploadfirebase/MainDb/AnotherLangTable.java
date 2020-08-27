package alaa.uploadfirebase.MainDb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "anotherLang")
public class AnotherLangTable {
    @PrimaryKey(autoGenerate = true)
    public int ayahId;
    @ColumnInfo(name = "numberInApi")
    public String NUMBER_IN_API;
    @ColumnInfo(name = "numberOfSourah")
    public String NUMBER_OF_SOURAH;
    @ColumnInfo(name = "arSourahName")
    public String ARABIC_SOURAH_NAME;
    @ColumnInfo(name = "enSourahName")
    public String ENGLISH_NAME;
    @ColumnInfo(name = "revelationType")
    public String REVELATION_TYPE;
    @ColumnInfo(name = "numberOfAyahs")
    public String NUMBER_OF_AYAHS;
    @ColumnInfo(name = "anotherLangText")
    public String TEXT;
    @ColumnInfo(name = "numberInSourah")
    public String NUMBER_IN_SOURAH;
    @ColumnInfo(name = "juz")
    public String JUZ;
    @ColumnInfo(name = "page")
    public String PAGE;
    @ColumnInfo(name = "hizb_quarter")
    public String HIZB_QUARTER;
    @ColumnInfo(name = "sajda")
    public String SAJDA;

    public AnotherLangTable(int ayahId , String NUMBER_IN_API, String NUMBER_OF_SOURAH, String ARABIC_SOURAH_NAME, String ENGLISH_NAME, String REVELATION_TYPE, String NUMBER_OF_AYAHS, String TEXT, String NUMBER_IN_SOURAH, String JUZ, String PAGE, String HIZB_QUARTER, String SAJDA) {
        this.ayahId = ayahId;
        this.NUMBER_IN_API = NUMBER_IN_API;
        this.NUMBER_OF_SOURAH = NUMBER_OF_SOURAH;
        this.ARABIC_SOURAH_NAME = ARABIC_SOURAH_NAME;
        this.ENGLISH_NAME = ENGLISH_NAME;
        this.REVELATION_TYPE = REVELATION_TYPE;
        this.NUMBER_OF_AYAHS = NUMBER_OF_AYAHS;
        this.TEXT = TEXT;
        this.NUMBER_IN_SOURAH = NUMBER_IN_SOURAH;
        this.JUZ = JUZ;
        this.PAGE = PAGE;
        this.HIZB_QUARTER = HIZB_QUARTER;
        this.SAJDA = SAJDA;
    }

    public String getNUMBER_IN_API() {
        return NUMBER_IN_API;
    }

    public String getNUMBER_OF_SOURAH() {
        return NUMBER_OF_SOURAH;
    }

    public String getARABIC_SOURAH_NAME() {
        return ARABIC_SOURAH_NAME;
    }

    public String getENGLISH_NAME() {
        return ENGLISH_NAME;
    }

    public String getREVELATION_TYPE() {
        return REVELATION_TYPE;
    }

    public String getNUMBER_OF_AYAHS() {
        return NUMBER_OF_AYAHS;
    }

    public String getTEXT() {
        return TEXT;
    }

    public String getNUMBER_IN_SOURAH() {
        return NUMBER_IN_SOURAH;
    }

    public String getJUZ() {
        return JUZ;
    }

    public String getPAGE() {
        return PAGE;
    }

    public String getHIZB_QUARTER() {
        return HIZB_QUARTER;
    }

    public String getSAJDA() {
        return SAJDA;
    }
}
