package alaa.uploadfirebase.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import alaa.uploadfirebase.MainDb.AppDatabase;
import alaa.uploadfirebase.Model.Note;
import alaa.uploadfirebase.Presenter.QuranPresenter;
import alaa.uploadfirebase.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener {

    @BindView(R.id.upload_button)
    Button uploadButton;
    @BindView(R.id.download_button)
    Button downloadButton;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.button_add_note)
    FloatingActionButton buttonAddNote;
    @BindView(R.id.status_db)
    Button statusDb;
    @BindView(R.id.status_firebase)
    Button statusFirebase;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("QuranData");
    private NoteAdapter noteAdapter;
    private QuranPresenter quranPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        quranPresenter = new QuranPresenter(this, MainActivity.this);
        statusDb.setOnClickListener(this);
        uploadButton.setOnClickListener(this);
        statusFirebase.setOnClickListener(this);

//        setUpRecyclerView();


        //How to get data from the FirebaseFireStore
//        FirebaseFirestore quranRef = FirebaseFirestore.getInstance();
//        final List<QuranWdefaultSheikh> quranWdefaultSheikhs = new ArrayList<>();
//        quranRef.collection("QuranData")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
////                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
////                                Log.i("test112", document.getId() + " => " + document.getData());
////
////                            }
//                            Log.i("test112" , "Success");
//                        } else {
//                            Log.i("test112", "Error getting documents.", task.getException());
//                        }
//                    }
//                });


    }

    private void setUpRecyclerView() {
        Query query = notebookRef.orderBy("sourah_number", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>().setQuery(query, Note.class).build();
        noteAdapter = new NoteAdapter(options);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(noteAdapter);
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        noteAdapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        noteAdapter.stopListening();
//    }

    @Override
    public void messageOfStatusOfDatabase(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccessUploading(String message) {
        Toast.makeText(getApplicationContext() , message , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCallingDataResult(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayStatusOfFirebase(String count) {
        Toast.makeText(MainActivity.this, count, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.status_db:
                quranPresenter.gettingStatusOfDataBase();
                break;
            case R.id.upload_button:
                quranPresenter.uploadingToFirebaseFireStore();
                break;
            case R.id.status_firebase:
                quranPresenter.statusOfFirebase(db);
                break;
        }
    }
}
