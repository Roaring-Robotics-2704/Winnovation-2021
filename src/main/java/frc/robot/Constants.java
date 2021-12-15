// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //constants
    //public static int c_joystick = 0;\
    public static int c_xbox = 0;
    public static int c_rightMotor = 2;
    public static int c_leftMotor = 1;
    public static int c_leftJoystickAxis = 5;
    public static int c_rightJoystickAxis = 1;
    public static int c_leftTriggerAxis = 3;
    public static int c_rightTriggerAxis = 2;

    public static final class ArmConstants {
        public static int[] kEncoderPorts = {0,1};
        public static int kMotor = 3;

        // TODO: fill in correct values for CPR and diameter
        public static final int kEncoderCPR = 1024;
        public static final double kWheelDiameterInches = 6;
        public static final double kEncoderDistancePerPulse =
        // Assumes the encoders are directly mounted on the wheel shafts
        (kWheelDiameterInches * Math.PI) / (double) kEncoderCPR;
        
        // Needs to be tuned according to driver feel
        public static int kAngleTolerance = 3; // degrees
        public static final double kAlpha = 0.05;
        public static final double kInputScale = 25.0;

        // Find correct values        
        public static int kMinAngle = 1; // degrees
        public static int kMaxAngle = 200; // degrees

        // todo: tune these gains! 
        // Feed Forward
        public static final double kStatic = 0.0;
        public static final double kGravity = 0.0;
        public static final double kVolts = 0.0;

        // PID
        public static final double kP = 1.0;
        public static final double kI = 0.0;
        public static final double kD = 0.0;
    }
    public static double c_deadBand = 0.02;
    public static double c_inputScaling = 2;
    public static double c_armSpeed = 1.5;
}
