package io.pronab.app;

import rx.Observable;

import java.util.Scanner;

import static rx.Observable.create;


public class ToyRobot {

    // Commands
    public static final String command_PLACE = app.getString("Command.place");
    public static final String command_MOVE = app.getString("Command.move");
    public static final String command_LEFT = app.getString("Command.left");
    public static final String command_RIGHT = app.getString("Command.right");
    public static final String command_REPORT = app.getString("Command.report");

    //Constraints

    public static final int minX = Integer.parseInt(app.getString("Constrain.minX"));
    public static final int maxX = Integer.parseInt(app.getString("Constrain.maxX"));
    public static final int minY = Integer.parseInt(app.getString("Constrain.minY"));
    public static final int maxY = Integer.parseInt(app.getString("Constrain.maxY"));

    //output legend, error or exception messages
    public static final String outpost = Messages.getString("ToyRobot.outpost");

    public static final String init_constrained = Messages.getString("ToyRobot.init_constraint");
    public static final String error1 = Messages.getString("ToyRobot.error1");
    public static final String errorA = Messages.getString("ToyRobot.errorA");
    public static final String errorX = Messages.getString("ToyRobot.errorX");
    public static final String stopped = Messages.getString("ToyRobot.stopfalling");
    private static final String starting = Messages.getString("ToyRobot.starts");
    private static final String byeForNow = Messages.getString("ToyRobot.bye");

    //robot states
    private static Facing CURRENT_FACING = Facing.NORTH;
    private static int CURRENT_X = 0;
    private static int CURRENT_Y = 0;
    private static String input;
    private static String status_message = " ";
    private static String state = " ";
    static final String ACTIVE = "ACTIVE";

    //Robot state set & get
    public static Facing getCURRENT_FACING() {
        return CURRENT_FACING;
    }

    public static void setCURRENT_FACING(Facing cURRENT_FACING) {
        CURRENT_FACING = cURRENT_FACING;
    }

    public static int getCURRENT_X() {
        return CURRENT_X;
    }

    public static void setCURRENT_X(int cURRENT_X) {
        CURRENT_X = cURRENT_X;
    }

    public static int getCURRENT_Y() {
        return CURRENT_Y;
    }

    public static void setCURRENT_Y(int cURRENT_Y) {
        CURRENT_Y = cURRENT_Y;
    }

    public static void setKeyboardObservable(Observable<String> keyboardObservable) {
        ToyRobot.keyboardObservable = keyboardObservable;
    }

    private static Observable<String> keyboardObservable;

    public static void setStatus_message(String status_message) {
        ToyRobot.status_message = status_message;
    }

    public static String getStatus_message() {
        return status_message;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        ToyRobot.state = state;
    }

    // robot output
    public static void output() {
        System.out.println(status_message);
        status_message = " ";

    }

    public static void observeKeyboard(String input) {
        keyboardObservable.subscribe(inx -> {
            ToyRobot.input = inx;
            CommandActs.takeInput(inx);
        });
    }

    public static void main(String[] args) {
        // robot input
        setStatus_message(".....................................");
        output();
        setStatus_message(starting);
        output();
        Scanner keyboard = new Scanner(System.in);

        keyboardObservable = create(subscriber -> {
            while (!subscriber.isUnsubscribed()) {
                input = keyboard.nextLine();
                if (input.equals(app.getString("Command.exit"))) {
                    setStatus_message(byeForNow);
                    output();
                    subscriber.unsubscribe();
                    System.exit(0);

                } else {
                    // io.pronab.app.CommandActs.takeInput(input) ;

                    subscriber.onNext(input);
                }
            }
        });

        // toyRobot  input is handled in CommandActs

        observeKeyboard(input);

    }
}
        	
      

	
	
	
 
