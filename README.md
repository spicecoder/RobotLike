# RobotLike
A small java  ToyRobot with RX binding for keyboard input  commands to allow unit test in an automated test environment.
ToyRobot works with a static class named ToyRobot that has the main()  method that drives the System.in  keyboard command inputs and pass the input to the class CommandActs that executes the commands for the placement ,move and face directions . The class ToyRobot holds the robot state i.e facing and position coordinates; ToyRobot class treats the keyboard input as RX observable ; this allows firstly the key inputs to be supplied within the test cases and thus works well in an automated test environment, and also makes  the CommandActions class itself testable in isolation.
There are two propertiy files ; the first one message.property , this holds the literals used in the system ,thus allowing for locale translation or simply customisation  of all the messages displayed. The ToyRobot also gives start and ending messages ,along with notification when the command could not be carried out because the constraints and to stop from falling off the max x, max Y  square (eg. 5,5 ) . The notifications makes it easier to relate the constraint rules to the Robots behaviour and thus makes future maintenance task more informative.
The other property file app.properties holds the parameters like maxium and minimum of vaid X.Y positions for the Robot without falling off and hence  the Robot constraints can be changed by just changing the proprty file.

The project is a maven built , and thus can be exceuted from the uber jar that has all the dependencies.Thus it can be run from the target directory in the root of the project with the following command:

 >java -jar toyrobot-jar-with-dependencies.jar

The maven build also runs the tests that are included, which can also be run in isolation by running  ' mvn test ' command from the project root.
The whole project can be rebuilt by 'mvn instal' command.

 Following is a sample of the ToyRobot in action from the command line:
 .....................................
ToyRobot @ your command, commands are:PLACE,MOVE,LEFT,RIGHT,REPORT & EXIT :
PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT
Output:3,3, NORTH
EXIT
Happy to Obey!,bye for now
Process finished with exit code 0
