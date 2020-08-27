package alaa.uploadfirebase.Data;

import alaa.uploadfirebase.Model.QuranResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IRetrofitQuran {
    @GET("ar.husary")
    Call<QuranResponse> getQuran();
}
