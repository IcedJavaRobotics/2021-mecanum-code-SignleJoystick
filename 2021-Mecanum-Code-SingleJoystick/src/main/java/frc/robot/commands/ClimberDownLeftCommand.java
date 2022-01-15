// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberDownLeftCommand extends CommandBase {
  /** Creates a new ClimberDownLeftCommand. */

  private final ClimberSubsystem climberSubsystem;

  public ClimberDownLeftCommand( ClimberSubsystem subsystem ) {
    climberSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements( climberSubsystem );
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climberSubsystem.climberDownLeft();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climberSubsystem.climberStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
