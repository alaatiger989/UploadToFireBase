package alaa.uploadfirebase.View;

public interface IMainView {
    void messageOfStatusOfDatabase(String message);
    void onSuccessUploading(String message);
    void onCallingDataResult(String message);

    void displayStatusOfFirebase(String count);
}
