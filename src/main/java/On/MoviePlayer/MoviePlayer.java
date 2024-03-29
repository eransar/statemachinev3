package On.MoviePlayer;

import State.Context;
import State.IState;

import java.util.ArrayList;
import java.util.List;

public class MoviePlayer implements IState {
    List<IState> movieplayer_substates;
    IState CurrentState;
    public MoviePlayer(){
        movieplayer_substates= new ArrayList<IState>() {{
            add(new Hold());
            add(new MovieIdle());
            add(new Initialize());
            add(new Play());
        }};
        this.CurrentState=movieplayer_substates.get(1);
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

    public List<IState> getMovieplayer_substates() {
        return movieplayer_substates;
    }

    public void setMovieplayer_substates(List<IState> movieplayer_substates) {
        this.movieplayer_substates = movieplayer_substates;
    }

    public IState getCurrentState() {
        return CurrentState;
    }

    public void setCurrentState(IState currentState) {
        CurrentState = currentState;
    }
}
