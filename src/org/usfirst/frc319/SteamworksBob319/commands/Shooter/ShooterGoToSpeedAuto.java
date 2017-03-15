// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.SteamworksBob319.commands.Shooter;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc319.SteamworksBob319.Robot;

/**
 *
 */
public class ShooterGoToSpeedAuto extends Command {

   
    public ShooterGoToSpeedAuto() {

    
        requires(Robot.shooter);

   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = -770; // was 750
    	Robot.shooter.shooterGoToSpeed(speed);
    	System.out.println("Shooter Error" + Robot.shooter.getShooterError());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double threshhold = 50;
        return Robot.shooter.shooterIsAtSpeed(threshhold);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
