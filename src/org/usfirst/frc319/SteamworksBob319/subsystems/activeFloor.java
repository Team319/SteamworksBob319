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
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class activeFloor extends Subsystem {

    
    private final CANTalon activeFloor = RobotMap.activeFloorActiveFloor;

   

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
     
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

