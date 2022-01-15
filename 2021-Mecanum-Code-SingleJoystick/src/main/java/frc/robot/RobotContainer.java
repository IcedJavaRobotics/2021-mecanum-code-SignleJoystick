// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.ClimberDownCommand;
import frc.robot.commands.ClimberDownLeftCommand;
import frc.robot.commands.ClimberDownRightCommand;
import frc.robot.commands.ClimberUpCommand;
import frc.robot.commands.ClimberUpLeftCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.OuttakeCommand;
//import frc.robot.commands.ServoExtendCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.WinchDownCommand;
import frc.robot.commands.WinchLiftCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
//import frc.robot.subsystems.ServoSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  //private final ServoSubsystem servoSubsystem = new ServoSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private double startTime;

  XboxController m_driverController = new XboxController(Constants.CONTROLLER);
  Joystick m_flightStick = new Joystick(Constants.JOYSTICK);

  //JoystickButton a_button = new JoystickButton(m_driverController, 1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    System.out.println("1");

    // Configure the button bindings
    configureButtonBindings(); {

      //a_button.whileHeld( new IntakeCommand(intakeSubsystem) );
      new JoystickButton(m_driverController, Button.kB.value)
      .whileHeld(new IntakeCommand(intakeSubsystem));

      new JoystickButton(m_driverController, Button.kY.value)
      .whileHeld(new OuttakeCommand(intakeSubsystem));

      new JoystickButton(m_driverController, Button.kA.value)
      .whileHeld(new ShooterCommand(shooterSubsystem));

      // new JoystickButton(m_driverController, Button.kX.value)
      // .whileHeld(new ServoExtendCommand(servoSubsystem));

      new JoystickButton(m_driverController, Button.kStart.value)
      .whileHeld(new WinchLiftCommand(climberSubsystem));

      new JoystickButton(m_driverController, Button.kBack.value)
      .whileHeld(new WinchDownCommand(climberSubsystem));

      new JoystickButton(m_driverController, Button.kLeftBumper.value)
      .whileHeld(new ClimberUpCommand(climberSubsystem));

      new JoystickButton(m_driverController, Button.kRightBumper.value)
      .whileHeld(new ClimberDownCommand(climberSubsystem));

      new JoystickButton(m_driverController, Button.kLeftStick.value)
      .whileHeld(new ClimberDownLeftCommand(climberSubsystem));

      new JoystickButton(m_driverController, Button.kRightStick.value)
      .whileHeld(new ClimberDownRightCommand(climberSubsystem));

      System.out.println("2");

    }

    driveTrainSubsystem.setDefaultCommand(
      new RunCommand(() -> driveTrainSubsystem.mecanumDrive(getJoystickTwist(), getJoystickY(), getJoystickX()), driveTrainSubsystem)
    );

    System.out.println("3");

  }

  private double deadZoneMod(double val) {
    if (Math.abs(val) <= Constants.DEADZONE) {
      return 0;
    } else {
      return ((val -0.2) * 1.25) ;
    }
  }

  public double getControllerRightX() {
    if ( m_driverController != null ) {
      return deadZoneMod(m_driverController.getRightX());
    } else {
      return 0;
    }
  }

  public double getControllerLeftX() {
    if (m_driverController != null ) {
      return deadZoneMod(m_driverController.getLeftX());
    } else {
      return 0;
    }
  }

  public double getControllerRightY() {
    if ( m_driverController != null ) {
      return deadZoneMod(m_driverController.getRightY());
    } else {
      return 0;
    }
    
  }

  public double getJoystickX() {
    if ( m_flightStick != null ) {
      return deadZoneMod(m_flightStick.getX());
    } else {
      return 0;
    }
  }

  public double getJoystickY() {
    if ( m_flightStick != null ) {
      return deadZoneMod(m_flightStick.getY());
    } else {
      return 0;
    }
  }

  public double getJoystickTwist() {
    if ( m_flightStick != null ) {
      return deadZoneMod(m_flightStick.getTwist());
    } else {
      return 0;
    }
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
  //  double time = Timer.getFPGATimestamp();
  int x = 0;
  while (x < 5000) {
    //if (time - startTime < 3) {
      x = x + 1;
      driveTrainSubsystem.moveAuto(0.6);
    }
  //} else {
     // driveTrainSubsystem.moveAuto(0);
  //}
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
