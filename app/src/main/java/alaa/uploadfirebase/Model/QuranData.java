package alaa.uploadfirebase.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuranData {
    @SerializedName("surahs")
    public List<Surahs> surahsList;


    public void setSurahsList(List<Surahs> surahsList) {
        this.surahsList = surahsList;
    }

    public List<Surahs> getSurahsList() {
        return surahsList;
    }
}
