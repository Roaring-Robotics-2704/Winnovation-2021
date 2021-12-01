// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;
import frc.robot.Constants;

public class ArmCommand extends CommandBase {
  /** Creates a new ArmCommand. */
  public ArmCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftInput = RobotContainer.m_xbox.getRawAxis(Constants.c_leftTriggerAxis);
    double rightInput = RobotContainer.m_xbox.getRawAxis(Constants.c_rightTriggerAxis);
    double sumInput = -leftInput + rightInput;

    SmartDashboard.putNumber("Arm Encoder Get Distance", Arm.armEncoder.getDistance());
    SmartDashboard.putNumber("Arm Encoder Get Raw", Arm.armEncoder.getRaw());
    SmartDashboard.putNumber("Arm Encoder Get Rate", Arm.armEncoder.getRate());


    RobotContainer.m_arm.move(sumInput);
   // RobotContainer.m_arm.move(0.1);
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
