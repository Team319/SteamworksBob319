// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.SteamworksBob319.commands.AutoModes;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc319.SteamworksBob319.CommandGroups.SmartShoot;
import org.usfirst.frc319.SteamworksBob319.commands.DriveTrain.FollowTrajectory;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorDeploy;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.HopperFlapDeploy;
import org.usfirst.frc319.SteamworksBob319.commands.GearCollector.AutoDepositGear;
import org.usfirst.frc319.SteamworksBob319.commands.GearCollector.DepositGear;
import org.usfirst.frc319.SteamworksBob319.subsystems.*;

/**
 *
 */
public class BlueGearThenShootAutoLeftSide extends CommandGroup {


  
    public BlueGearThenShootAutoLeftSide() {
    	
    	

    	addSequential(new FollowTrajectory("BlueGearAutoLeftSide"));
    	addSequential(new AutoDepositGear()); // check isfinished
    	addSequential(new FuelCollectorDeploy());
    	addSequential(new FollowTrajectory("BlueGearAutoLeftSideShoot")); 
    	addSequential(new HopperFlapDeploy());
    	addSequential(new SmartShoot());
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
 
    } 
}
