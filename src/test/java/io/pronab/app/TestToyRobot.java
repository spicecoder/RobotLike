package io.pronab.app;

import org.junit.jupiter.api.Test;
import rx.Observable;

class TestToyRobot {


    @Test
    void testBinding_ToyRobot_CommandActs() {
        Facing orig = ToyRobot.getCURRENT_FACING();
        Observable<String> kb = Observable.just("MOVE");
        ToyRobot.setKeyboardObservable(kb);
        ToyRobot.observeKeyboard("MOVE");
        assert (ToyRobot.getCURRENT_FACING() == orig);
    }

    @Test
    void testCommand_PLACE_ToyRobot() {
        CommandActs.takeInput("PLACE 3,4,NORTH");
        assert (ToyRobot.getCURRENT_FACING() == Facing.NORTH);
    }

    @Test
    void testCommand_MOVE__ToyRobot() {
        CommandActs.takeInput("PLACE 3,4,NORTH");
        CommandActs.takeInput("MOVE");
        assert (ToyRobot.getCURRENT_Y() == 5);
        assert (ToyRobot.getCURRENT_X() == 3);
    }

    @Test
    void testCommand_LEFT_ToyRobot() {
        CommandActs.takeInput("PLACE 3,4,NORTH");
        CommandActs.takeInput("LEFT");
        assert (ToyRobot.getCURRENT_FACING() == Facing.WEST);
    }

    @Test
    void testCommand_RIGHT_ToyRobot() {
        CommandActs.takeInput("PLACE 3,4,EAST");
        CommandActs.takeInput("RIGHT");
        assert (ToyRobot.getCURRENT_FACING() == Facing.SOUTH);
    }

    @Test
    void testconstrain_ToyRobot() {
        CommandActs.takeInput("PLACE 3,4,NORTH");
        CommandActs.takeInput("MOVE");
        CommandActs.takeInput("MOVE");
        CommandActs.takeInput("MOVE");
        assert (ToyRobot.getCURRENT_Y() == ToyRobot.maxY);
    }


}