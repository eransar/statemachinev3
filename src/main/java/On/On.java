package On;


import On.Disk.Disk;
import On.Download.*;
import On.InternetConnection.InternetConnection;
import On.MoviePlayer.Hold;
import On.MoviePlayer.MovieIdle ;
import On.MoviePlayer.MoviePlayer;
import On.MoviePlayer.Play;
import On.User.User;
import State.Context;
import State.IState;

import java.lang.Error;
import java.util.ArrayList;
import java.util.List;

public  class On implements IState {

    IState off;
    IState download_history;
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
    public void resume(Context context) {
        if(((MoviePlayer) on_substates.get(3)).getCurrentState() instanceof Hold){
            if(!context.isError() && context.isConnection()){
                System.out.println("exit hold state ");

                System.out.println("enter play state ");
                ((MoviePlayer) on_substates.get(3)).setCurrentState(((MoviePlayer) on_substates.get(3)).getMovieplayer_substates().get(3));
            }





                System.out.println("enter initialize state");
                ((MoviePlayer) on_substates.get(3)).setCurrentState(((MoviePlayer) on_substates.get(3)).getMovieplayer_substates().get(2));
                System.out.println("exit initialize state");
                System.out.println("enter play state");
                ((MoviePlayer) on_substates.get(3)).setCurrentState(((MoviePlayer) on_substates.get(3)).getMovieplayer_substates().get(3));



            }
    }

    public void movieOn(Context context) {
        if(((MoviePlayer) on_substates.get(3)).getCurrentState() instanceof MovieIdle){
            if(context.isDown()){
                System.out.println("exit idle state (movie player) state");

                System.out.println("enter initialize state");
                ((MoviePlayer) on_substates.get(3)).setCurrentState(((MoviePlayer) on_substates.get(3)).getMovieplayer_substates().get(2));
                System.out.println("exit initialize state");
                System.out.println("enter play state");
                ((MoviePlayer) on_substates.get(3)).setCurrentState(((MoviePlayer) on_substates.get(3)).getMovieplayer_substates().get(3));



            }
        }

    }

    public void startPlay(Context context) {

    }

    public void holdMovie(Context context) {
        if (((MoviePlayer) on_substates.get(3)).getCurrentState() instanceof Play) {

            System.out.println("exit play state");

            System.out.println("enter hold state");
            ((MoviePlayer) on_substates.get(3)).setCurrentState(((MoviePlayer) on_substates.get(3)).getMovieplayer_substates().get(0));


        }

    }

    public void holeMovie(boolean connect, boolean error) {

    }

    public void movieOff(Context context) {
        if (((MoviePlayer) on_substates.get(3)).getCurrentState() instanceof Play) {

            System.out.println("exit play state");

            System.out.println("enter idle state");
            ((MoviePlayer) on_substates.get(3)).setCurrentState(((MoviePlayer) on_substates.get(3)).getMovieplayer_substates().get(0));


        }
        else if (((MoviePlayer) on_substates.get(3)).getCurrentState() instanceof Hold) {

            System.out.println("exit hold state");

            System.out.println("enter idle state");
            ((MoviePlayer) on_substates.get(3)).setCurrentState(((MoviePlayer) on_substates.get(3)).getMovieplayer_substates().get(0));


        }

    }

    public void restartMovie(Context context) {
        if (((MoviePlayer) on_substates.get(3)).getCurrentState() instanceof Play) {

            System.out.println("exit play state");

            System.out.println("enter initialize state");
            ((MoviePlayer) on_substates.get(3)).setCurrentState(((MoviePlayer) on_substates.get(3)).getMovieplayer_substates().get(2));


        }
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
        this.CheckConnection(context);

    }

    public void internetOff(Context context) {
        if(context.isConnection()){
        context.setConnection(false);
            System.out.println("exit hasconnection state");
            System.out.println("enter noconnection state");
            context.setDown(false);
            this.CheckConnection(context);

        }

    }

    public void when(Context context, int point) {

    }

    public void DownloadAborted(Context context) {
        if(((Download) on_substates.get(1)).getCurrentState() instanceof CheckingSpace){
            System.out.println("exit checkingspace state");

            System.out.println("enter idle state");
            ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(4));
            context.setDown(false);

        }
        else if(((Download) on_substates.get(1)).getCurrentState() instanceof DownloadProgress){
            System.out.println("exit download state");

            System.out.println("enter idle state");
            ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(4));
            this.movieOff(context);



        }
        else if(((Download) on_substates.get(1)).getCurrentState() instanceof ConnectionWait){
            System.out.println("exit connection_wait state");

            System.out.println("enter idle state");
            ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(4));


        }
        else if(((Download) on_substates.get(1)).getCurrentState() instanceof Error){
            System.out.println("exit error state");

            System.out.println("enter idle state");
            ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(4));


        }


        context.setPoints(context.getPoints()-1);
        context.setSpace(context.getSize()+context.getSpace());
        context.setDown(false);

    }

    public void FileRequest(Context context , int size) {
        context.setSize(size);
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
                        context.setSpace(context.getSpace()-size);

                    }
                    else {
                        System.out.println("exit checkingspace state");
                        System.out.println("enter connection_wait state");
                        ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(1));
                        download_history=((Download) on_substates.get(1)).getDownload_substates().get(0);
                    }

                }
                else{
                    if(context.getPoints()>0){
                        context.setPoints(context.getPoints()-1);
                    }
                    System.out.println("exit checkingspace state");

                    System.out.println("enter idle state");
                    ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(4));
                    context.setDown(false);

                }
        }


    }


    public void finish(Context context) {

    }

    public void check(Context context, boolean space, boolean connect) {

    }

    public void CheckConnection(Context context, boolean connect) {

    }
    public void CheckConnection(Context context){
        if(((Download) on_substates.get(1)).getCurrentState() instanceof DownloadProgress){
            if(!context.isConnection()){
                System.out.println("exit download state");
                ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(1));
                System.out.println("enter connection_wait state");
                download_history=((Download) on_substates.get(1)).getDownload_substates().get(2);
                this.holdMovie(context);
            }
        }
        else if(((Download) on_substates.get(1)).getCurrentState() instanceof ConnectionWait){
            if(context.isConnection()){
                System.out.println("exit connection_wait state");

                ((Download) on_substates.get(1)).setCurrentState(download_history);
                System.out.println("enter" +download_history.getClass().getSimpleName()+" state");



            }
            else {

            }
        }


    }

    public void getStatus(Context context) {

        try {
            System.out.println("exit download state");
            Thread.sleep((context.getSize()/context.getStatuslist().get(context.getStatus()).intValue()));
            System.out.println("enter download state");
            context.setDown(true);
            //then finish
            this.movieOff(context);
            System.out.println("exit download state");
            ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(4));
            System.out.println("enter idle state");
            context.setDown(false);



        } catch (InterruptedException e) {

        }



    }

    public void downloadError(Context context) {
        if (((Download) on_substates.get(1)).getCurrentState() instanceof DownloadProgress) {
            context.setDown(true);
            System.out.println("exit download state");
            System.out.println("enter error state");
            ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(3));
            context.setError(true);
            this.holdMovie(context);
        }
        try {
            Thread.sleep(3000);
            if(context.isError()){
                context.setPoints(context.getPoints()-1);
                context.setSpace(context.getSpace()+context.getSize());
                System.out.println("enter idle state");
                ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(4));
                context.setError(false);
                context.setDown(false);
                context.setPoints(context.getPoints()-1);

            }
        } catch (InterruptedException e) {

        }

    }

    public void downloadFixed(Context context) {
        if (((Download) on_substates.get(1)).getCurrentState() instanceof Error) {
            context.setDown(true);
            System.out.println("exit error state");
            System.out.println("enter download state");
            ((Download) on_substates.get(1)).setCurrentState(((Download) on_substates.get(1)).getDownload_substates().get(3));
            context.setError(false);
        }

    }

    public void exitState() {
        System.out.println("exit on");
    }

    public void enterState() {
        System.out.println("enter on state");
    }

    public void turnOff(Context context) {
        if (context.isOn()) {
            context.setDown(true);
            System.out.println("exit on state");
            System.out.println("enter off state");
            context.setError(false);
            context.setState(off);
            context.setOn(false);
        }

    }


}
