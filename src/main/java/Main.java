import Off.Off;
import On.On;
import State.Context;
import State.IState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        IState Off = new Off();
        context.setState(Off);

        while(true){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter event name");

            String event = myObj.nextLine();  // Read user input


            switch (event){
                case "turnOff":
                    context.getState().turnOff(context);
                    break;
                case "turnOn":
                    context.getState().turnOn(context);
                    break;
                case "internetOn":
                    context.getState().internetOn(context);
                    break;
                case "internetOff":
                    context.getState().internetOff(context);
                    break;
                case "fileRequest":
                    Scanner fr = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("please enter size");
                    String size = fr.nextLine();
                    try{
                        int sizeasint = Integer.parseInt(size);
                        context.getState().FileRequest(context,sizeasint);
                    }
                    catch(Error e){
                        System.out.println("Please enter a number");
                    }
                    break;
                case "downloadAborted":
                    context.getState().DownloadAborted(context);
                    break;
                case "downloadError":
                    context.getState().downloadError(context);
                    break;
                case "errorFixed":
                    context.getState().downloadFixed(context);////
                    break;
                case "movieOn":
                    context.getState().movieOn(context);
                    break;
                case "restartMovie":
                    context.getState().restartMovie(context);
                    break;
                case "holdMovie":
                    context.getState().holdMovie(context);
                    break;
                case "movieOff":
                    context.getState().movieOff(context);
                    break;
                case "resume":
                    try{
                        ((On) context.getState()).holdMovie(context);
                    }
                    catch(Error e) {

                    }

                    break;
                case "increaseSpace":
                    try{
                        Scanner is = new Scanner(System.in);  // Create a Scanner object
                        System.out.println("please enter size");
                        String space = is.nextLine();
                        int spaceasint = Integer.parseInt(space);
                        context.setSize(context.getSize()+spaceasint);
                    }
                    catch(Error e) {

                    }

                    break;
            }

        }
        }

}
