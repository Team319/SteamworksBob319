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
import org.usfirst.frc319.SteamworksBob319.commands.Rollervator.RollervatorStop;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class rollervator extends Subsystem {

    
    private final CANTalon rollervatorLead = RobotMap.rollervatorRollervatorLead;
    private final CANTalon rollervatorFollow = RobotMap.rollervatorRollervatorFollow;

    StringBuilder _sb = new StringBuilder();
    int _loops = 0;
    
    public rollervator(){
    	/*
    	rollervatorLead.changeControlMode(TalonControlMode.Speed);
    	rollervatorFollow.changeControlMode(TalonControlMode.Follower);
    	rollervatorFollow.set(rollervatorLead.getDeviceID());
    	*/

        rollervatorLead.changeControlMode(TalonControlMode.Speed);
        rollervatorLead.enableBrakeMode(false);
        rollervatorFollow.enableBrakeMode(false);
        
        rollervatorLead.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        rollervatorLead.reverseOutput(false);
        rollervatorLead.reverseSensor(true);
        
        rollervatorFollow.changeControlMode(TalonControlMode.Follower);
        rollervatorFollow.set(rollervatorLead.getDeviceID());
        rollervatorFollow.reverseOutput(true);
       // talon7.reverseSensor(true);  There is no sensor, doing this for continuity
        
        rollervatorLead.configNominalOutputVoltage(+0.0f, -0.0f);
        rollervatorLead.configPeakOutputVoltage(+12.0f, -12.0f);
        rollervatorFollow.configPeakOutputVoltage(+12.0f, -12.0f);
        
        rollervatorLead.setProfile(0);
        rollervatorLead.setF(.10);
        rollervatorLead.setP(0.06);
        rollervatorLead.setI(0);
        rollervatorLead.setIZone(0);
        
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
      
    	setDefaultCommand(new RollervatorStop());

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void rollervatorStop(){
    	//rollervatorLead.changeControlMode(TalonControlMode.PercentVbus);
    	rollervatorLead.set(0);
   }
    public void rollervatorGo(double speed){
    	//rollervatorLead.changeControlMode(TalonControlMode.Speed);
    	rollervatorLead.set(speed); 
    }
    public void rollervatorClimb(double speed){
    	rollervatorLead.set(speed);
    }
    public void changeModeToSpeed(){
    	rollervatorLead.changeControlMode(TalonControlMode.Speed);
    }
    public void changeModeToVbus(){
    	rollervatorLead.changeControlMode(TalonControlMode.PercentVbus);
    }
    public void rollervatorPIDTestMode(){
        
        SmartDashboard.putInt("motorspeed", rollervatorLead.getEncVelocity());
        
        /* get gamepad axis */
    	double leftYstick = Robot.oi.driverController.getLeftStickY();
    	double motorOutput = rollervatorLead.getOutputVoltage() / rollervatorLead.getBusVoltage();
    	/* prepare line to print */
    	_sb.append("\tout:");
    	_sb.append(motorOutput);
        _sb.append("\tspd:");
        _sb.append(rollervatorLead.getSpeed() );
        
        if(Robot.oi.driverController.getRawButton(1)){
        	/* Speed mode */
        	double targetSpeed =  1000; /* 1500 RPM in either direction */
        	rollervatorLead.changeControlMode(TalonControlMode.Speed);
        	rollervatorLead.set(targetSpeed); /* 1500 RPM in either direction */
        	//_sb.append(_talon.getControlMode() );
        	
        	//System.out.println(_talonFollower.getControlMode() );
        	/* append more signals to print when in speed mode. */
            _sb.append("\terr:");
            _sb.append(rollervatorLead.getClosedLoopError());
            _sb.append("\ttrg:");
            _sb.append(targetSpeed);
        } 
        else if (Robot.oi.driverController.getRawButton(2)){
        	rollervatorLead.set(-.6);
        	//System.out.println(_talon.getControlMode() );
        	//System.out.println(_talonFollower.getControlMode() );
        	//System.out.println("constant voltage mode");
        }
        
        else {
        	/* Percent voltage mode */
        	//System.out.println(_talon.getControlMode() );
        	//System.out.println(_talonFollower.getControlMode() );
        	rollervatorLead.changeControlMode(TalonControlMode.PercentVbus);
        	rollervatorLead.set(leftYstick);
        	//System.out.println("joystick vbus mode");
        }

        if(++_loops >= 10) {
        	_loops = 0;
        	System.out.println(_sb.toString());
        }
        _sb.setLength(0);
    }

        public int getShooterSpeed(){
        	return rollervatorLead.getEncVelocity();
        }
        
    
    public double getRollervatorCurrent(){
    	return rollervatorLead.getOutputCurrent();
    }
    public boolean rollervatorHasExceededCurrentThreshhold(double threshhold){
    	if (rollervatorLead.getOutputCurrent() > threshhold){
    		return true;
    	}
    	else return false;
    }
    
    
}


