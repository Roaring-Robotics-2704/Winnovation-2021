// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//mport edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.DriveRobot;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;

//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static DriveTrain m_driveTrain = new DriveTrain();
  public static Arm m_arm = new Arm();

  public static DriveRobot m_driveRobot = new DriveRobot();
  public static ArmCommand m_armCommand = new ArmCommand();

  //OI Objects and Hardware
  //public static Joystick m_stick = new Joystick(Constants.c_joystick);
  public static XboxController m_xbox = new XboxController(Constants.c_xbox);
  public static JoystickButton m_armUpButton = new JoystickButton(m_xbox, Constants.c_leftTriggerAxis);
  public static JoystickButton m_armDownButton = new JoystickButton(m_xbox, Constants.c_rightTriggerAxis);
  //public static XboxController m_controller = new XboxController(Constants.c_joystick);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_driveTrain.setDefaultCommand(m_driveRobot);
    m_arm.setDefaultCommand(m_armCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   // m_armUpButton.whileHeld(new ArmDown());
    //m_armDownButton.whileHeld(new ArmDown());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
//  return m_autoCommand;
 // }
}
