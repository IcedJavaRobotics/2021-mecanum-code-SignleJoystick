// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //DriveTrain
    public static final int FRONT_LEFT_SPARK = 4;
    public static final int BACK_LEFT_SPARK = 2;
    public static final int FRONT_RIGHT_SPARK = 3;
    public static final int BACK_RIGHT_SPARK = 1;

    //Controller
    public static final int JOYSTICK = 0;
    public static final int CONTROLLER = 1;
    public static final double DEADZONE = 0.2;

    //Intake 
    public static final int INTAKE_SPARK = 1;
    public static final double INTAKE_SPEED = 0.4;

    //Shooter
    public static final int SHOOTER_SPARK_A = 2;
    public static final int SHOOTER_SPARK_B = 3;
    public static final double SHOOTER_SPEED = 1;

    //Climber
    public static final int CLIMBER_SPARK_LEFT = 4;
    public static final int CLIMBER_SPARK_RIGHT = 5;
    public static final int WINCH_SPARK = 9;
    public static final double CLIMBER_UP_SPEED = .4;
    public static final double CLIMBER_DOWN_SPEED = -.4;
    public static final double WINCH_UP_SPEED = .35;
    public static final double WINCH_DOWN_SPEED = -0.35;
    
    //Servo
    public static final int SERVO = 7;
    public static final double SERVO_EXTEND = 4.0;
    public static final double SERVO_RETRACT = -4.0;
}
