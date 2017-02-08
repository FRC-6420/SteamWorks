package org.usfirst.frc6420.Attempt2.commands;

import org.usfirst.frc6420.Attempt2.LVDash;
import org.usfirst.frc6420.Attempt2.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoMove extends Command {
	private int target;
	private double absolute_target;

    public AutoMove( int encoderCounts ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	target = encoderCounts;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	absolute_target = Robot.driveBase.getAverageEncoderCount() + target;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	LVDash.setString( 7, String.valueOf( Robot.driveBase.getAverageEncoderCount() ) );
    	if( target > 0 ){
    		Robot.driveBase.driveArcade( -0.5, 0 );
    	}else{
    		Robot.driveBase.driveArcade( 0.5, 0 );
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs( Robot.driveBase.getAverageEncoderCount() - this.absolute_target ) < 10;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.driveArcade(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
