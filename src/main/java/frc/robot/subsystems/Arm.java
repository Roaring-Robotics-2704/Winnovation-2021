// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Arm extends SubsystemBase {
  private WPI_VictorSPX armMotor = new WPI_VictorSPX(Constants.c_armMotor);
  public static Encoder armEncoder = new Encoder(Constants.c_armEncoderPorts[0], Constants.c_armEncoderPorts[1]);
  /** Creates a new ExampleSubsystem. */
  public Arm() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void move(double speed){
    armMotor.set(speed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
