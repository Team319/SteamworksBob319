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

import org.usfirst.frc319.SteamworksBob319.RobotMap;
import org.usfirst.frc319.SteamworksBob319.commands.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class brakePad extends Subsystem {

  
    private final DoubleSolenoid brakePadPiston = RobotMap.brakePadBrakePadPiston;

   

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new BrakePadDoNothing());
    	
       
    }
    public void brakePadDeploy(){
    	brakePadPiston.set(DoubleSolenoid.Value.kForward);
    }
    public void brakePadRetract(){
    	brakePadPiston.set(DoubleSolenoid.Value.kReverse);
    }
}

