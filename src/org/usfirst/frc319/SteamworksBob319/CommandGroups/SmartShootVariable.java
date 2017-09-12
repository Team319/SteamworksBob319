// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.SteamworksBob319.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc319.SteamworksBob319.commands.DoNothing;
import org.usfirst.frc319.SteamworksBob319.commands.DriveTrain.FollowTrajectory;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorIn;
import org.usfirst.frc319.SteamworksBob319.commands.Rollervator.RollervatorGo;
import org.usfirst.frc319.SteamworksBob319.commands.Shooter.ShooterGoToSpeed;
import org.usfirst.frc319.SteamworksBob319.commands.Shooter.ShooterGoToSpeedVariable;
import org.usfirst.frc319.SteamworksBob319.subsystems.*;

/**
 *
 */
public class SmartShootVariable extends CommandGroup {


  
    public SmartShootVariable(double speed) {

    	addSequential(new ShooterGoToSpeedVariable(speed));
    	addSequential(new RollervatorGo());
    	addSequential(new WaitCommand(1.0));
    	addSequential(new FuelCollectorIn(0.3));
 
    } 
}