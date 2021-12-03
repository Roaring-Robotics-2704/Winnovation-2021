// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.Robot;

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
   // double leftInput = RobotContainer.m_xbox.getRawAxis(Constants.c_left_trigger);
    //double rightInput = RobotContainer.m_xbox.getRawAxis(Constants.c_right_trigger);

<<<<<<< Updated upstream
    //double sumInput = -leftInput + rightInput;
    
   // RobotContainer.m_arm.move(sumInput);
=======
    SmartDashboard.putNumber("Arm Encoder Get Distance", Arm.armEncoder.getDistance());


    RobotContainer.m_arm.move(sumInput);
   // RobotContainer.m_arm.move(0.1);
>>>>>>> Stashed changes
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return //!RobotContainer.m_armDownButton.get() || 
      Math.abs(Arm.armEncoder.getDistance()) <=0 || Math.abs(Arm.armEncoder.getDistance()) >= 1000;
   // return false;
  }
}
