package On.Download;


import State.Context;
import State.IState;

import java.util.ArrayList;
import java.util.List;

public class Download implements IState {
    List<IState> download_substates;



    IState CurrentState;
    public Download(){
        download_substates = new ArrayList<IState>() {{
            add(new CheckingSpace());
            add(new ConnectionWait());
            add(new DownloadProgress());
            add(new Error());
            add(new Idle());
        }};
        this.CurrentState=download_substates.get(4);
    }


    public void exitState() {

    }

    public void enterState() {

    }

    public void turnOff(Context context) {

    }

    public void turnOn(Context context) {

    }

    public void resume(boolean error, boolean connect) {

    }

    public void movieOn(Context context) {

    }

    public void startPlay(Context context) {

    }

    public void holdMovie(Context context) {

    }

    public void holeMovie(boolean connect, boolean error) {

    }

    public void movieOff(Context context) {

    }

    public void restartMovie(Context context) {

    }

    public void checkingSpace(Context context, int size) {

    }

    public void delete(Context context, int size) {

    }

    public void updateSize(Context context, int size) {

    }

    public void internetOn(Context context) {

    }

    public void internetOff(Context context) {

    }

    public void when(Context context, int point) {

    }

    public void DownloadAborted(Context context) {

    }

    public void FileRequest(Context context , int size) {

    }

    public void finish(Context context) {

    }

    public void check(Context context, boolean space, boolean connect) {

    }

    public void CheckConnection(Context context, boolean connect) {

    }

    public void getStatus(Context context) {

    }

    public void downloadError(Context context) {

    }

    public void downloadFixed(Context context) {

    }
    public List<IState> getDownload_substates() {
        return download_substates;
    }

    public void setDownload_substates(List<IState> download_substates) {
        this.download_substates = download_substates;
    }

    public IState getCurrentState() {
        return CurrentState;
    }

    public void setCurrentState(IState currentState) {
        CurrentState = currentState;
    }
}
