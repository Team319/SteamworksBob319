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

import org.usfirst.frc319.SteamworksBob319.CommandGroups.DeployCollectorAfterWait;
import org.usfirst.frc319.SteamworksBob319.CommandGroups.FuelCollectorDeployThenCollect;
import org.usfirst.frc319.SteamworksBob319.CommandGroups.SmartShoot;
import org.usfirst.frc319.SteamworksBob319.CommandGroups.SmartShootAuto;
import org.usfirst.frc319.SteamworksBob319.CommandGroups.SmartShootVariable;
import org.usfirst.frc319.SteamworksBob319.commands.DoNothing;
import org.usfirst.frc319.SteamworksBob319.commands.DriveTrain.FollowTrajectory;
import org.usfirst.frc319.SteamworksBob319.commands.DriveTrain.FollowTrajectoryAndCollect;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorDeploy;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorDeployWaitThenHopperFlap;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorIn;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorStop;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.HopperFlapDeploy;
import org.usfirst.frc319.SteamworksBob319.commands.GearCollector.GearCollectorArmGoToDepositGear;
import org.usfirst.frc319.SteamworksBob319.subsystems.*;

/**
 *
 */
public class BlueHopperThenShootAutoLeftSide extends CommandGroup {


  
    public BlueHopperThenShootAutoLeftSide() {
    	
    	//addParallel(new FuelCollectorDeployWaitThenHopperFlap());
    	addSequential(new GearCollectorArmGoToDepositGear());
    	addParallel(new FuelCollectorDeployWaitThenHopperFlap());
    	addSequential(new FollowTrajectory("BlueHopperThenShootAutoLeftSidePt1"));//stage 1
    	addSequential(new DoNothing(),3.19);// do nothing 3 seconds
    	addSequential(new FollowTrajectory("BlueHopperThenShootAutoLeftSidePt2v4"));//stage 2
    //	addSequential(new SmartShootAuto());
    //	addSequential(new FollowTrajectoryAndCollect("RedHopperThenShootAutoRightSidePt3v3"));//stage 3
    	addSequential(new SmartShootVariable(-740.0));
    	//addSequential(new SmartShoot());
    	addSequential(new DoNothing(), 3);
    	addSequential(new FuelCollectorIn(0.3));
    	//addParallel(new FuelCollectorStop());


    } 
}
