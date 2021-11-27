package frc.robot.test;

public class processInput{
    double c_Deadband;
    double c_InputScaling;

    processInput(double deadband,double scaling){
        this.c_Deadband = deadband;
        this.c_InputScaling = scaling;
    }

    public double processInput(double joystickValue) {
        //TODO: implement deadband/deadzone
        if (-c_deadBand <= joystickValue && joystickValue <= c_deadBand){
            return 0;
        }
        //TODO: implement joystick scaling
        if (joystickValue <= 0){
            return - Math.pow(joystickValue, c_inputScaling);
        }
        else{
            return Math.pow(joystickValue, Constants.c_inputScaling);
        }
    }
}