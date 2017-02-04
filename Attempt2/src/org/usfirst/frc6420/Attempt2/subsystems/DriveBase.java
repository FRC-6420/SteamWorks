// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6420.Attempt2.subsystems;

import org.usfirst.frc6420.Attempt2.RobotMap;
import org.usfirst.frc6420.Attempt2.commands.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveBase extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController rightA = RobotMap.driveBaseRightA;
    private final SpeedController rightB = RobotMap.driveBaseRightB;
    private final SpeedController leftA = RobotMap.driveBaseLeftA;
    private final SpeedController leftB = RobotMap.driveBaseLeftB;
    private final RobotDrive driveBaseController = RobotMap.driveBaseDriveBaseController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final DoubleSolenoid shifter = RobotMap.shift;
    private Gear shiftMode = Gear.LOW;
    private final ADXRS450_Gyro gyro = RobotMap.gyro;
    private final Encoder leftEncoder = RobotMap.leftDriveEncoder;
    private final Encoder rightEncoder = RobotMap.rightDriveEncoder;
    
    public void driveArcade( double movementValue, double turnValue ){
    	driveBaseController.arcadeDrive( movementValue, turnValue );
    }
    
    public void shift( Gear shift ){
    	shiftMode = shift;
    	if( shift == Gear.LOW ){
    		shifter.set(DoubleSolenoid.Value.kForward);
    	}else{
    		shifter.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    public Gear getShiftMode(){
    	return shiftMode;
    }
    
    public double getAngle(){
    	return gyro.getAngle();
    }
    
    public double getAverageEncoderCount(){
    	return (rightEncoder.get() - leftEncoder.get()) * 0.5;
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveWithJoystick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public enum Gear {LOW, HIGH}
}

