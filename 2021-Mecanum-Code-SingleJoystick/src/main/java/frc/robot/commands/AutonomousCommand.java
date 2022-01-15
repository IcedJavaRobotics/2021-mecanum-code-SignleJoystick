// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutonomousCommand extends CommandBase {

  protected double power;
  protected double time;
  protected double endTime;

  /** Creates a new AutonomousTimer. */
  public AutonomousCommand(double power, double timeInMillis) {

    // Use addRequirements() here to declare subsystem dependencies.
    this.power = power;
    this.time = timeInMillis;
    addRequirements(Robot.driveTrainSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    long startTime = System.currentTimeMillis();
    endTime = startTime + this.time;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    Robot.driveTrainSubsystem.moveAuto( power );

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeInMillis() >= endTime;
  }

}
