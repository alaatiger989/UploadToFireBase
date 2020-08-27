package alaa.uploadfirebase.Presenter;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import alaa.uploadfirebase.Data.RetrofitClientQuran;
import alaa.uploadfirebase.MainDb.AppDatabase;
import alaa.uploadfirebase.MainDb.QuranWdefaultSheikh;
import alaa.uploadfirebase.Model.QuranModel;
import alaa.uploadfirebase.Model.QuranResponse;

import alaa.uploadfirebase.View.IMainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BodyCallingQuran {

    public List<QuranWdefaultSheikh> quranWdefaultSheikhList = new ArrayList<>();
    public AppDatabase db;
    public BodyCallingQuran(final IMainView mainView, final Context context)
    {

        db = AppDatabase.getInstance(context);
        Call<QuranResponse> call = RetrofitClientQuran.getInstance().getSourahs().getQuran();
        call.enqueue(new Callback<QuranResponse>() {
            @Override
            public void onResponse(Call<QuranResponse> call, Response<QuranResponse> response) {
                QuranResponse quranResponse = response.body();
                try{
                    if(quranResponse.getCode() == 200)
                    {
                        QuranModel.setStatus(quranResponse.getStatus());
                        try{
                            for (int i = 0 ; i < quranResponse.getData().getSurahsList().size() ; i++)
                            {
                                for (int k = 0; k < quranResponse.getData().getSurahsList().get(i).getAyahsList().size() ; k++)
                                {
                                    quranWdefaultSheikhList.add(new QuranWdefaultSheikh(Integer.parseInt(quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getNumberInApi())
                                            ,quranResponse.getData().getSurahsList().get(i).getEnglishName()
                                            ,quranResponse.getData().getSurahsList().get(i).getNumberOfSourah()
                                            ,quranResponse.getData().getSurahsList().get(i).getArabicName()
                                            ,quranResponse.getData().getSurahsList().get(i).getRevelationType()
                                            , "ar.husary"
                                            ,"El Husary"
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getAudio()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getAyah()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getNumberInSourah()
                                            ,String.valueOf(quranResponse.getData().getSurahsList().get(i).getAyahsList().size())
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getNumberInApi()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getJuz()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getSajda()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getPage()
                                            ,quranResponse.getData().getSurahsList().get(i).getAyahsList().get(k).getHizbQuarter()
                                    ));

                                }

                                try {
                                    db.quranDao().insertAll(quranWdefaultSheikhList);
                                    quranWdefaultSheikhList = new ArrayList<>();

                                    if (db.quranDao().getCount() ==6236)
                                    {
                                        mainView.onCallingDataResult("Data is Downloaded Successfully !! and Database is completed");
                                    }
                                    else{
                                        mainView.onCallingDataResult("Data is not not Downloaded SuccessFully !!");
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<QuranResponse> call, Throwable t) {

                Log.i("elmushafDB","Err "+call.request().url() + "ss" +t);
                new BodyCallingQuran(mainView, context);

            }
        });
    }
}
