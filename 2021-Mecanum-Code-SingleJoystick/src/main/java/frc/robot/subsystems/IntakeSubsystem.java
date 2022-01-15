// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

  private Spark intakeSpark;

  /** Creates a new IntakeSubsystem. */

  public IntakeSubsystem() {

    intakeSpark = new Spark(Constants.INTAKE_SPARK);
    intakeSpark.setInverted(false);

  }

  public void ballPickup() {

    intakeSpark.set(Constants.INTAKE_SPEED);

  }

  public void ballDrop() {

    intakeSpark.set(-Constants.INTAKE_SPEED);

  }

  public void intakeStop() {

    intakeSpark.set(0);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
