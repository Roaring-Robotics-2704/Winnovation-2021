package frc.robot;

public class ProcessInput {
    double c_Deadband;
    double c_InputScaling;

    ProcessInput(double deadband, double scaling){
        this.c_Deadband = deadband;
        this.c_InputScaling = scaling;
    }

    public double process(double joystickValue) {
        this.c_Deadband = prefs.getDouble("stick_deadband", 0.05);
        this.c_InputScaling = prefs.getDouble("stick_scaling", 2);
        // deadband
        if (-c_Deadband <= joystickValue && joystickValue <= c_Deadband){
            return 0;
        }

        //scaling
        if (joystickValue <= 0){
            return - Math.pow(joystickValue, c_InputScaling);
        }
        else{
            return Math.pow(joystickValue, c_InputScaling);
        }
    }
}