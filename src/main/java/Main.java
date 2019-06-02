import Off.Off;
import State.Context;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        Off off = new Off();
        context.setState(off);
        context.getState().turnOn(context);
        context.getState().internetOn(context);
        context.setSpace(40);
        context.getState().FileRequest(context,39);
        context.getState().DownloadAborted(context);

    }
}
