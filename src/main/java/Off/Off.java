package Off;

import On.On;
import State.Context;
import State.IState;

public class Off implements IState {
IState on;

    public Off(){
        on=new On(this);
    }
    public void turnOn(Context context) {
        this.exitState();
        on.turnOn(context);
        context.setOn(true);

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

    public void FileRequest(Context context, int size) {

    }

    public void FileRequest(Context context) {

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

    public void exitState(){System.out.println("exit "+getClass().getSimpleName()+" state");}

    public void enterState() {
        System.out.println("entered off");
    }

    public void turnOff(Context context) {

    }

    public void turnOff() {

    }




}
