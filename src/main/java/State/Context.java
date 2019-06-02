package State;

import java.util.Dictionary;
import java.util.HashMap;

public class Context{

    IState state;
    boolean down=false;
    int points = 0;
    boolean on = false;
    int score = 0;
    boolean connection = false;
    int space = 100;
    int size = 0;
    String status = "beginner";
    boolean error=false;
    int percent = 0;
    HashMap<String,Double> statuslist = new HashMap<>();

    public Context(IState state ){
        this.state=state;
        statuslist.put("beginner",1.0);
        statuslist.put("advanced",1.2);
        statuslist.put("professional",1.5);
    }
    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
        if(this.points >=4 && this.points < 7){
            this.status="advanced";

        }
        else if(this.points >= 7){
            this.status="professional";
        }
        else
            this.status="beginner";
        }


    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isConnection() {
        return connection;
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }


    public Context(){
        this.state=null;
    }

    public IState getState() {
        return state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<String, Double> getStatuslist() {
        return statuslist;
    }

    public void setStatuslist(HashMap<String, Double> statuslist) {
        this.statuslist = statuslist;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
