import Off.Off;
import State.Context;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        Off off = new Off();
        context.setState(off);
        context.getState().turnOn(context);
        context.getState().internetOn(context);
        context.getState().FileRequest(context,64);
        context.getState().DownloadAborted(context);

    }
}
