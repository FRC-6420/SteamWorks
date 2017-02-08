// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6420.Attempt2.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc6420.Attempt2.LVDash;
import org.usfirst.frc6420.Attempt2.Robot;
import org.usfirst.frc6420.Attempt2.RobotMap;

/**
 *
 */
public class DriveWithJoystick extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveWithJoystick() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveBase);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        this.setInterruptible( true );
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.driveBase.driveArcade( Robot.oi.fancyStick );
    	double x = Robot.oi.fancyStick.getX();
    	if( Math.abs( x ) < 0.1 ) {
    		x = 0;
    	}
    	Robot.driveBase.driveArcade( Robot.oi.fancyStick.getY(), -x );
    	//Robot.driveBase.shift( Robot.oi.getFancyStick().getTrigger() ? Gear.HIGH : Gear.LOW );
    	LVDash.setString( 0, String.valueOf( RobotMap.rightDriveEncoder.get() ) );
    	LVDash.setString( 1, String.valueOf( RobotMap.leftDriveEncoder.get() ) );
    	LVDash.setString( 2, String.valueOf( RobotMap.gyro.getAngle() ) );
    	LVDash.setString( 3, String.valueOf( RobotMap.ultrasonicSensor.getValue() ) );
    	LVDash.setString( 4, Robot.driveBase.getShiftMode().toString());
    	LVDash.setString( 7, String.valueOf( Robot.driveBase.getAverageEncoderCount() ) );
    	//LVDash.setString( 5, "" + RobotMap.imu.getAngle() );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
