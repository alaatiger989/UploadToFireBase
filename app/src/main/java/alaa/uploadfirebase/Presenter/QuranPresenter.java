package alaa.uploadfirebase.Presenter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import alaa.uploadfirebase.MainDb.AppDatabase;
import alaa.uploadfirebase.MainDb.QuranWdefaultSheikh;
import alaa.uploadfirebase.Model.QuranModel;
import alaa.uploadfirebase.View.IMainView;

public class QuranPresenter{
    private IMainView mainView;
    private Context context;
    private AppDatabase database;

    private int count;
    public QuranPresenter(IMainView mainView , Context context) {
        this.mainView = mainView;
        this.context = context;
    }

    public void requestQuranData(){
        new GettingQuranDataAsync(mainView , context).execute(114);
    }

    public void gettingStatusOfDataBase(){
        database = AppDatabase.getInstance(context);
        if (database.quranDao().getCount() == 6236)
        {
            mainView.messageOfStatusOfDatabase("Database Completed! and have the whole data");
        }
        else{
            mainView.messageOfStatusOfDatabase("Database not Completed! you need to download it again !!");
            requestQuranData();
        }
    }

    public void uploadingToFirebaseFireStore(){
        database = AppDatabase.getInstance(context);
        if (database.quranDao().getCount() == 6236 && statusOfFirebase() == 6236)
        {
            List<QuranWdefaultSheikh> quranWdefaultSheikhs = new ArrayList<>();
            quranWdefaultSheikhs.addAll(database.quranDao().getQuran());
            if(quranWdefaultSheikhs.size() > 0 ){
                for(QuranWdefaultSheikh d : quranWdefaultSheikhs){
                    Task<DocumentReference> quranRef = FirebaseFirestore.getInstance().collection("QuranData").add(d).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            mainView.onSuccessUploading("Success Uploading");
                        }
                    });

                }
            }
        }else{
            requestQuranData();
            uploadingToFirebaseFireStore();
        }
    }

    public int statusOfFirebase(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("QuranData").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    count = 0;
                    for (DocumentSnapshot document : task.getResult()) {
                        count++;
                    }
                    Log.i("bigstuff", count + "");
                    Log.i("bigstuff" , "The size : "  + task.getResult().size());
                    displayingStatusOfFirebase(String.valueOf(count));
                } else {
                    Log.i("bigstuff", "Error getting documents: ", task.getException());
                    displayingStatusOfFirebase("Error getting documents: "+task.getException());

                }
            }
        });
        return count;
    }

    public void displayingStatusOfFirebase(String count){
        mainView.displayStatusOfFirebase(count);
    }




}
