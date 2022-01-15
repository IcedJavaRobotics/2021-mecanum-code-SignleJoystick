// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  
  private Spark shooterSparkA;
  private Spark shooterSparkB;
  private Servo shooterServo;

  /** Creates a new ShooterSubsystem. */

  public ShooterSubsystem() {

    shooterSparkA = new Spark(Constants.SHOOTER_SPARK_A);
    shooterSparkB = new Spark(Constants.SHOOTER_SPARK_B);
    shooterSparkA.setInverted(false);
    shooterSparkB.setInverted(true);
    shooterServo = new Servo(Constants.SERVO);
    shooterServo.setBounds(1.5, 1.5, 1.5, 1.5, 1.0);

  }

  public void ballShoot() {

    shooterSparkA.set(Constants.SHOOTER_SPEED);
    shooterSparkB.set(Constants.SHOOTER_SPEED);
    shooterServo.set(Constants.SERVO_RETRACT);

  }

  public void shootStop() {

    shooterSparkA.set(0);
    shooterSparkB.set(0);
    shooterServo.set(Constants.SERVO_EXTEND);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
