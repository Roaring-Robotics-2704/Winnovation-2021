// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private WPI_VictorSPX m_leftMotor = new WPI_VictorSPX(1);
  private WPI_VictorSPX m_rightMotor = new WPI_VictorSPX(2);
  private DifferentialDrive drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  public DriveTrain() {
  }
  public void tankDrive(double left, double right){
    //move y-axis, turn z-axis
    drive.tankDrive(left,right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}
