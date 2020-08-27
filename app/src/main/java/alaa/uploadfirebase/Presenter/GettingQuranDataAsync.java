package alaa.uploadfirebase.Presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

import alaa.uploadfirebase.MainDb.AppDatabase;
import alaa.uploadfirebase.View.IMainView;


public class GettingQuranDataAsync extends AsyncTask<Integer,Integer,String> {

    Context context;
    ProgressDialog progressDialog;
    IMainView mainView;
    public GettingQuranDataAsync(IMainView mainView, Context context)
    {
        this.context = context;
        this.mainView = mainView;
    }
    @Override
    protected void onPreExecute() {
    super.onPreExecute();
    progressDialog = new ProgressDialog(context);
    progressDialog.setMax(114);
    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    progressDialog.setIndeterminate(false);
    progressDialog.setCancelable(false);
    progressDialog.setTitle("Please Wait ...");
    progressDialog.setMessage("تحميل البيانات النصية");
    progressDialog.show();
    }
    @Override
    protected String doInBackground(Integer... integers) {

        AppDatabase db = AppDatabase.getInstance(context);

        if (db.quranDao().getCount() == 6236)
        {
            return "Please Click on Download";
        }
        else{
            new BodyCallingQuran(mainView , context);
            for (int i = 0 ; i < integers[0] ; i++)
            {
                publishProgress(i *100 /100);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return "Please Click on Download";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context , s , Toast.LENGTH_LONG).show();
        progressDialog.setProgress(0);
        progressDialog.dismiss();

    }

}
