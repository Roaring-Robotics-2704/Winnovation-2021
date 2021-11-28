// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotContainer;
import frc.robot.Constants;

public class DriveRobot extends CommandBase {
  /** Creates a new DriveRobot. */
  public DriveRobot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
  }
  
  private double processInput(double joystickValue) {
    // deadband
    if (-Constants.c_deadBand <= joystickValue && joystickValue <= Constants.c_deadBand){
        return 0;
    }
    // scaling
    if (joystickValue <= 0){
        return - Math.pow(joystickValue, Constants.c_inputScaling);
    }
    else{
        return Math.pow(joystickValue, Constants.c_inputScaling);
    }
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftInput = processInput(RobotContainer.m_xbox.getRawAxis(5));
    double rightInput = processInput(RobotContainer.m_xbox.getRawAxis(1));

    SmartDashboard.putNumber("Left Input", leftInput);
    SmartDashboard.putNumber("Right Input", rightInput);
    //double processedInput = processInput(forwardInput);

    //double moveSpeed = RobotContainer.m_stick.getY();
    //double turnSpeed = RobotContainer.m_stick.getZ();
    //double moveSpeed = RobotContainer.m_controller.getY();
    //double turnSpeed = RobotContainer.m_controller.getZ();
    RobotContainer.m_driveTrain.tankDrive(leftInput, rightInput);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
