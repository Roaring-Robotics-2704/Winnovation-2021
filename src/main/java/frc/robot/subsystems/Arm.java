// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants.ArmConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;



public class Arm extends PIDSubsystem {
  private WPI_VictorSPX armMotor = new WPI_VictorSPX(ArmConstants.kMotor);
  public static Encoder armEncoder = new Encoder(ArmConstants.kEncoderPorts[0], ArmConstants.kEncoderPorts[1]);

  private final ArmFeedforward armFeedForward =
      new ArmFeedforward(ArmConstants.kStatic, ArmConstants.kGravity, ArmConstants.kVolts);

  private double setpoint = ArmConstants.kMinAngle;

  /** Creates a new ExampleSubsystem. */
  public Arm() {
      super(new PIDController(ArmConstants.kP, ArmConstants.kI, ArmConstants.kD));
      getController().setTolerance(ArmConstants.kAngleTolerance);
      armEncoder.setDistancePerPulse(ArmConstants.kEncoderDistancePerPulse);
      setSetpoint(setpoint);
  }

  @Override
  public void useOutput(double output, double setpoint) {
    armMotor.setVoltage(output + armFeedForward.calculate(setpoint, 0));
  }

  @Override
  public double getMeasurement() {
    return armMotor.get();
  }

  public void adjust_position(double change) {
    // TODO: Alpha filter -  use ArmConstants.kAlpha and (1 - ArmConstants.kAlpha)

    // TODO: Safety bounds
    // Make sure we don't try to drive the arm past the boundaries. 
    // Use rmConstants.kMinAngle and rmConstants.kMaxAngle


    // TODO: update setpoint with the new 
    SmartDashboard.putNumber("Arm Setpoint", setpoint);

  }

  public boolean atSetpoint() {
    return false;
  }

  public void stopFeeder() {
    armMotor.set(0);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
