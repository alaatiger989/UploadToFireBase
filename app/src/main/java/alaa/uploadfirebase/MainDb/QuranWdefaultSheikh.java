package alaa.uploadfirebase.MainDb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quran")
public class QuranWdefaultSheikh {
    @PrimaryKey(autoGenerate = true)
    public int id;

    /**************  Data of Each Sourah  **************/
    @ColumnInfo(name = "sourah_english_name")
    public String sourah_english_name;

    @ColumnInfo(name = "sourah_number")
    public String sourah_number;


    @ColumnInfo(name = "sourah_arabic_name")
    public String sourah_arabic_name;

    @ColumnInfo(name = "revelationType")
    public String revelationType;
    /****************************************************/

    /****************** Identifier of Sheikh *****************/
    @ColumnInfo(name = "sheikh_id")
    public String sheikh_id;

    @ColumnInfo(name = "sheikh_name")
    public String sheikh_name;
   /***************************************************************/

    /***************** Ayats Of Each Sourah *************/
    @ColumnInfo(name = "audio")
    public String audio;

    @ColumnInfo(name = "ar_ayats")
    public String ar_ayats;

    @ColumnInfo(name = "number_in_sourah")
    public String number_in_sourah;

    @ColumnInfo(name = "number_of_ayats")
    public String number_of_ayats;

    @ColumnInfo(name = "number_in_api")
    public String number_in_api;

    @ColumnInfo(name = "juz")
    public String juz;

    @ColumnInfo(name = "sajda")
    public String sajda;

    @ColumnInfo(name = "page")
    public String page;

    @ColumnInfo(name = "hizb_qurater")
    public String hizb_qurater;

    public QuranWdefaultSheikh(int id, String sourah_english_name, String sourah_number, String sourah_arabic_name, String revelationType, String sheikh_id, String sheikh_name, String audio, String ar_ayats, String number_in_sourah, String number_of_ayats, String number_in_api, String juz, String sajda, String page, String hizb_qurater) {
        this.id = id;
        this.sourah_english_name = sourah_english_name;
        this.sourah_number = sourah_number;
        this.sourah_arabic_name = sourah_arabic_name;
        this.revelationType = revelationType;
        this.sheikh_id = sheikh_id;
        this.sheikh_name = sheikh_name;
        this.audio = audio;
        this.ar_ayats = ar_ayats;
        this.number_in_sourah = number_in_sourah;
        this.number_of_ayats = number_of_ayats;
        this.number_in_api = number_in_api;
        this.juz = juz;
        this.sajda = sajda;
        this.page = page;
        this.hizb_qurater = hizb_qurater;
    }

    public int getId() {
        return id;
    }

    public String getSourah_english_name() {
        return sourah_english_name;
    }

    public String getSourah_number() {
        return sourah_number;
    }

    public String getSourah_arabic_name() {
        return sourah_arabic_name;
    }

    public String getRevelationType() {
        return revelationType;
    }

    public String getSheikh_id() {
        return sheikh_id;
    }

    public String getSheikh_name() {
        return sheikh_name;
    }

    public String getAudio() {
        return audio;
    }

    public String getAr_ayats() {
        return ar_ayats;
    }

    public String getNumber_in_sourah() {
        return number_in_sourah;
    }

    public String getNumber_of_ayats() {
        return number_of_ayats;
    }

    public String getNumber_in_api() {
        return number_in_api;
    }

    public String getJuz() {
        return juz;
    }

    public String getSajda() {
        return sajda;
    }

    public String getPage() {
        return page;
    }

    public String getHizb_qurater() {
        return hizb_qurater;
    }
}
