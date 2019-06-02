package On;


import On.Disk.Disk;
import On.Download.CheckingSpace;
import On.Download.Download;
import On.Download.Idle;
import On.InternetConnection.InternetConnection;
import On.MoviePlayer.MoviePlayer;
import On.User.User;
import State.Context;
import State.IState;

import java.util.ArrayList;
import java.util.List;

public  class On implements IState {

    IState off;
    List<IState> on_substates;
    public On(IState off){
        this.off=off;
          on_substates = new ArrayList<IState>() {{
            add(new Disk());
            add(new Download());
            add(new InternetConnection());
            add(new MoviePlayer());
            add(new User());
        }};

    }

    public void turnOn(Context context) {
        this.enterState();
        context.setState(this);
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
        for (IState state : on_substates){
            state.internetOn(context);
        }

    }

    public void internetOff(Context context) {

    }

    public void when(Context context, int point) {

    }

    public void DownloadAborted(Context context) {
        if(((Download) on_substates.get(1)).getCurrentState() instanceof CheckingSpace){
            System.out.println("exit checkingspace state");

            System.out.println("enter idle state");
            ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(4));

        }

    }

    public void FileRequest(Context context , int size) {
        if(((Download) on_substates.get(1)).getCurrentState() instanceof Idle){
                context.setDown(true);
                System.out.println("exit idle state");
                System.out.println("enter checkingspace state");
                ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(0));
                if(size > context.getSpace()){
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(size < context.getSpace()){
                    if(context.isConnection()){
                        this.updateSize(context,size);
                        System.out.println("exit checkingspace state");
                        System.out.println("enter download state");
                        ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(2));
                    }
                    else {
                        System.out.println("exit checkingspace state");
                        System.out.println("enter connection_wait state");
                        ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(1));
                    }

                }
        }


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

    public void exitState() {
        System.out.println("exit on");
    }

    public void enterState() {
        System.out.println("entered on");
    }

    public void turnOff(Context context) {

    }


}
