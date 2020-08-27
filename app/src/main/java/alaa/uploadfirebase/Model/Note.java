package alaa.uploadfirebase.Model;

public class Note {


    private String sourah_english_name;

    private String sourah_number;


    private String sourah_arabic_name;

    private String revelationType;



    private String sheikh_id;

    private String sheikh_name;



    private String audio;

    private String ar_ayats;

    private String number_in_sourah;

    private String number_of_ayats;

    private String number_in_api;

    private String juz;

    private String sajda;

    private String page;

    private String hizb_qurater;

    public Note(){

    }
    public Note(String sourah_english_name, String sourah_number, String sourah_arabic_name, String revelationType, String sheikh_id, String sheikh_name, String audio, String ar_ayats, String number_in_sourah, String number_of_ayats, String number_in_api, String juz, String sajda, String page, String hizb_qurater) {
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
