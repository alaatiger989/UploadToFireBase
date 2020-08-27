package alaa.uploadfirebase.Model;

import com.google.gson.annotations.SerializedName;

public class QuranResponse {
    private int code;
    private String status;
    @SerializedName("data")
    private QuranData data;

    public QuranResponse(int code, String status, QuranData quranData) {
        this.code = code;
        this.status = status;
        this.data = quranData;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public QuranData getData() {
        return data;
    }
}
