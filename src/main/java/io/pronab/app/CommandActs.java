package io.pronab.app;

import org.apache.commons.lang3.StringUtils;

public class CommandActs {
    //PLACE,MOVE,,LEFT,RIGHT,REPORT
    public static void init(Facing F, int xpos, int ypos) {

        if (xpos >= ToyRobot.minX &&
                xpos < ToyRobot.maxX + 1 &&
                ypos >= ToyRobot.minY &&
                ypos < ToyRobot.maxY + 1) {

            ToyRobot.setCURRENT_FACING(F);
            ToyRobot.setCURRENT_X(xpos);
            ToyRobot.setCURRENT_Y(ypos);
            ToyRobot.setState(ToyRobot.ACTIVE);
        } else {

            ToyRobot.setStatus_message(ToyRobot.init_constrained + "F:" + F.toString() + " X:" + xpos + " Y:" + ypos);
            ToyRobot.output();
        }
    }

    public static void report() {

        ToyRobot.setStatus_message(ToyRobot.outpost + ToyRobot.getCURRENT_X() + "," + ToyRobot.getCURRENT_Y() + ", " + ToyRobot.getCURRENT_FACING().toString());

        ToyRobot.output();
    }


    public static void takeInput(String input) {

        input = input.trim();
        String[] instruct = {};
        String command = null;
        if (input.contains(" ")) {
            int space_pos = input.indexOf(" ");
            command = input.substring(0, space_pos);
            String rest = input.substring(space_pos + 1);
            instruct = rest.split(",");
        } else {
            command = input;
        }

        if (ToyRobot.command_PLACE.equals(command)) {
            if (instruct.length != 3) {
                ToyRobot.setStatus_message(ToyRobot.error1);
                report();
            } else if (!StringUtils.isNumeric(instruct[0])) {
                ToyRobot.setStatus_message(ToyRobot.error1);
                report();
            } else if (!StringUtils.isNumeric(instruct[1])) {
                ToyRobot.setStatus_message(ToyRobot.error1);
                report();
            } else if (Facing.valueOf(instruct[2]).getClass() == Facing.class) {

                if ((instruct.length == 3) && (StringUtils.isNumeric(instruct[0])) && (StringUtils.isNumeric(instruct[1]))) {

                    init(Facing.valueOf(instruct[2]), Integer.parseInt(instruct[0]), Integer.parseInt(instruct[1]));

                }


            } else {
                ToyRobot.setStatus_message(ToyRobot.error1);
                ToyRobot.output();
                ;
            }
        } else if (ToyRobot.command_REPORT.equals(command)) {

            report();

        } else if (ToyRobot.getState().equals(ToyRobot.ACTIVE)) {
            if (ToyRobot.command_MOVE.equals(command)) {


                switch (ToyRobot.getCURRENT_FACING()) {

                    case NORTH: {
                        if (ToyRobot.getCURRENT_Y() < ToyRobot.maxY) {
                            ToyRobot.setCURRENT_Y(ToyRobot.getCURRENT_Y() + 1);
                        } else {
                            ToyRobot.setStatus_message(ToyRobot.stopped);
                            ToyRobot.output();
                            ;
                        }
                    }
                    break;
                    case EAST: {
                        if (ToyRobot.getCURRENT_X() < ToyRobot.maxX + 1) {
                            ToyRobot.setCURRENT_X(ToyRobot.getCURRENT_X() + 1);
                        } else {
                            ToyRobot.setStatus_message(ToyRobot.stopped);
                            ToyRobot.output();
                            ;
                        }
                    }
                    break;
                    case SOUTH: {
                        if (ToyRobot.getCURRENT_Y() > 0) {
                            ToyRobot.setCURRENT_Y(ToyRobot.getCURRENT_Y() - 1);
                        } else {
                            ToyRobot.setStatus_message(ToyRobot.stopped);
                            ToyRobot.output();
                            ;
                        }
                    }
                    break;
                    case WEST: {
                        if (ToyRobot.getCURRENT_X() > 0) {
                            ToyRobot.setCURRENT_X(ToyRobot.getCURRENT_X() - 1);
                        } else {
                            ToyRobot.setStatus_message(ToyRobot.stopped);
                            ToyRobot.output();
                            ;
                        }
                    }
                    break;
                    default: {
                        ToyRobot.setStatus_message(ToyRobot.errorX);
                        ToyRobot.output();
                        ;
                    }
                }


            }

            if (ToyRobot.command_LEFT.equals(command)) {

                switch (ToyRobot.getCURRENT_FACING()) {
                    case EAST:
                        ToyRobot.setCURRENT_FACING(Facing.NORTH);
                        break;
                    case NORTH:
                        ToyRobot.setCURRENT_FACING(Facing.WEST);
                        break;
                    case WEST:
                        ToyRobot.setCURRENT_FACING(Facing.SOUTH);
                        break;
                    case SOUTH:
                        ToyRobot.setCURRENT_FACING(Facing.EAST);
                        break;

                    default: {
                        ToyRobot.setStatus_message(ToyRobot.errorX);
                        ToyRobot.output();
                        ;
                    }
                }


            }

            if (ToyRobot.command_RIGHT.equals(command)) {

                switch (ToyRobot.getCURRENT_FACING()) {
                    case EAST:
                        ToyRobot.setCURRENT_FACING(Facing.SOUTH);
                        break;
                    case NORTH:
                        ToyRobot.setCURRENT_FACING(Facing.EAST);
                        break;
                    case WEST:
                        ToyRobot.setCURRENT_FACING(Facing.NORTH);
                        break;
                    case SOUTH:
                        ToyRobot.setCURRENT_FACING(Facing.WEST);
                        break;

                    default: {
                        ToyRobot.setStatus_message(ToyRobot.errorX);
                        ToyRobot.output();
                        ;
                    }


                }

            }
        } else {
            ToyRobot.setStatus_message(ToyRobot.errorA);
            ToyRobot.output();
        }
    }


}





 
 
