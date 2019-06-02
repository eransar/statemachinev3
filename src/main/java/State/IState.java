package State;

public interface IState {

    void exitState();
    void enterState();
    /*********off*****************/

    void turnOff(Context context);

    /**********on*****************/

    void turnOn(Context context);

    /*********MoviePlayer**********/

    void resume(boolean error , boolean connect);
    void movieOn(Context context);
    void startPlay(Context context);
    void holdMovie(Context context);
    void holeMovie(boolean connect , boolean error);
    void movieOff(Context context);
    void restartMovie(Context context);

    /**********Disk**********/

    void checkingSpace(Context context,int size);
    void delete(Context context,int size);
    void updateSize(Context context,int size);

    /*******InternetConnection*************/

    void internetOn(Context context);
    void internetOff(Context context);

    /*********User**********/

    void when(Context context,int point);

    /********Download******/

    void DownloadAborted(Context context);
    void FileRequest(Context context, int size);
    void finish(Context context);
    void check(Context context,boolean space , boolean connect);
    void CheckConnection(Context context,boolean connect);
    void getStatus(Context context);
    void downloadError(Context context);
    void downloadFixed(Context context);

}
