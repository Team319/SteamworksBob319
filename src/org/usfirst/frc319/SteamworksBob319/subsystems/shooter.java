// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.SteamworksBob319.subsystems;

import org.usfirst.frc319.SteamworksBob319.Robot;
import org.usfirst.frc319.SteamworksBob319.RobotMap;
import org.usfirst.frc319.SteamworksBob319.commands.*;
import org.usfirst.frc319.SteamworksBob319.commands.Shooter.ShooterMaintainSpeed;
import org.usfirst.frc319.SteamworksBob319.commands.Shooter.ShooterPIDTestMode;
import org.usfirst.frc319.SteamworksBob319.commands.Shooter.ShooterStop;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class shooter extends Subsystem {

    
    public final CANTalon shooterLead = RobotMap.shooterShooterLead;
    private final CANTalon shooterFollow = RobotMap.shooterShooterFollow;
    
    StringBuilder _sb = new StringBuilder();
    int _loops = 0;

public shooter (){
	
	shooterLead.changeControlMode(TalonControlMode.Speed);
	shooterLead.enableBrakeMode(false);
	shooterFollow.enableBrakeMode(false);
	

	shooterLead.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	shooterLead.configEncoderCodesPerRev(1024);
	shooterLead.reverseOutput(false);
	shooterLead.reverseSensor(true);
	
	shooterFollow.changeControlMode(TalonControlMode.Follower);
	shooterFollow.set(shooterLead.getDeviceID());
	shooterFollow.reverseOutput(true);
	
	shooterLead.configNominalOutputVoltage(+0.0f, -0.0f);
	shooterLead.configPeakOutputVoltage(+12.0f, -12.0f);
	shooterFollow.configPeakOutputVoltage(+12.0f, -12.0f);
	
	
	
	shooterLead.setProfile(0);
	shooterLead.setF(0.14);
	shooterLead.setP(1.20); //was 0.64
	shooterLead.setI(0.00); // was 0.001
	shooterLead.setIZone(00); // was 100
	shooterLead.setD(0.29); // was 1.20
	
	
}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	//setDefaultCommand(new MotorTest(this, RobotMap.shooterShooterLead));
    	//setDefaultCommand(new ShooterStop());
    	//setDefaultCommand(new ShooterPIDTestMode());
    	setDefaultCommand(new ShooterMaintainSpeed());
        // Set the default command for a subsystem here.
      
    }
    
    public void shooterGoToSpeed(double speed){
    	shooterLead.changeControlMode(TalonControlMode.Speed);
    	shooterLead.set(speed);
    	
    }
    
    public void shooterStop(){
    	shooterLead.changeControlMode(TalonControlMode.PercentVbus);// used to let the shooter just stop on its own
    	shooterLead.set(0);
    }
    
    public void shooterGoSlowClimbing(){
    	
    }
    
    //------USED TO TUNE SHOOTER --- USE SHOOTER PID TEST COMMAND TO RUN THIS --  MAKE DEFAULT----//
    public void shooterPIDTestMode(){
    
    
    
    /* get gamepad axis */
	double leftYstick = -Robot.oi.operatorController.getLeftStickY();
	double motorOutput = shooterLead.getOutputVoltage() / shooterLead.getBusVoltage();
	/* prepare line to print */
	_sb.append("\tout:");
	_sb.append(motorOutput);
    _sb.append("\tspd:");
    _sb.append(shooterLead.getSpeed() );
    
    if(Robot.oi.operatorController.getRawButton(1)){
    	/* Speed mode */
    	double targetSpeed =  -750; /* 1500 RPM in either direction */
    	shooterLead.changeControlMode(TalonControlMode.Speed);
    	shooterLead.set(targetSpeed); /* 1500 RPM in either direction */
    	//_sb.append(_talon.getControlMode() );
    	
    	//System.out.println(_talonFollower.getControlMode() );
    	/* append more signals to print when in speed mode. */
        _sb.append("\terr:");
        _sb.append(shooterLead.getClosedLoopError());
        _sb.append("\ttrg:");
        _sb.append(targetSpeed);
    } 
    else if (Robot.oi.operatorController.getRawButton(2)){
    	shooterLead.set(-.6);
    	//System.out.println(_talon.getControlMode() );
    	//System.out.println(_talonFollower.getControlMode() );
    	//System.out.println("constant voltage mode");
    }
    
    else {
    	/* Percent voltage mode */
    	//System.out.println(_talon.getControlMode() );
    	//System.out.println(_talonFollower.getControlMode() );
    	shooterLead.changeControlMode(TalonControlMode.PercentVbus);
    	shooterLead.set(leftYstick);
    	//System.out.println("joystick vbus mode");
    }

    if(++_loops >= 10) {
    	_loops = 0;
    	System.out.println(_sb.toString());
    }
    _sb.setLength(0);
}

    public double getShooterSpeed(){
    	return shooterLead.getSpeed();
    }
    public double getShooterError(){
    	return shooterLead.getSetpoint() + shooterLead.getSpeed();
    }
    public double getShooterCurrent(){
    	return shooterLead.getOutputCurrent();
    }
    public boolean shooterIsAtSpeed(double threshhold){
    	if (shooterLead.getSpeed() - shooterLead.getSetpoint() > threshhold) 
    		return false;
    	else
    		return true;
    }
    
    
    
}
    	
 


