// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;
//import jdk.vm.ci.meta.Constant;
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
    double armSpeed;

    SmartDashboard.putNumber("Arm Encoder Get Distance", Arm.armEncoder.getDistance());

    if ((Math.abs(Arm.armEncoder.getDistance()) > 0 && Math.abs(Arm.armEncoder.getDistance()) <= 20)
      || (Math.abs(Arm.armEncoder.getDistance()) >= 100 && Math.abs(Arm.armEncoder.getDistance()) < 120)) {
      armSpeed = (Constants.c_armSpeed/2) * sumInput;
    } else {
      armSpeed = Constants.c_armSpeed * sumInput;
    }
    RobotContainer.m_arm.move(armSpeed);
    //RobotContainer.m_arm.move(sumInput);
   // RobotContainer.m_arm.move(0.1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //if (Math.abs(Arm.armEncoder.getDistance()) <= 0 || Math.abs(Arm.armEncoder.getDistance()) >= 120) {
    //  return true;
    //} else {
      return false;
    //}
  }
}
