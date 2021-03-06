// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.SteamworksBob319.commands.Rollervator;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc319.SteamworksBob319.commands.BrakePadDeploy;
import org.usfirst.frc319.SteamworksBob319.commands.BrakePadRetract;
import org.usfirst.frc319.SteamworksBob319.commands.Rollervator.RollervatorGo;
import org.usfirst.frc319.SteamworksBob319.commands.Shooter.ShooterGoSlowClimbing;
import org.usfirst.frc319.SteamworksBob319.commands.Shooter.ShooterGoToSpeed;
import org.usfirst.frc319.SteamworksBob319.subsystems.*;

/**
 *
 */
public class AutomatedRollervatorClimb extends CommandGroup {


  
    public AutomatedRollervatorClimb() {

    	//addSequential(new ClimbStart(800.0), 2);
    //	addParallel(new ShooterGoSlowClimbing());
    	//addSequential(new RollervatorClimbStageOne(0.4));
    	addSequential(new RollervatorClimb(1.0));
    	
    	// start rollervator for one second 
    	// have command that climbs while monitoring current
   
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
