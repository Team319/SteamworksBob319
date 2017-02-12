// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc319.SteamworksBob319;

import org.usfirst.frc319.SteamworksBob319.commands.*;
import org.usfirst.frc319.SteamworksBob319.commands.DriveTrain.FollowTrajectory;
//import org.usfirst.frc319.SteamworksBob319.commands.DriveTrain.FollowBothMotionProfiles;
import org.usfirst.frc319.SteamworksBob319.commands.DriveTrain.JoystickDrive;
import org.usfirst.frc319.SteamworksBob319.commands.DriveTrain.ShiftToggle;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorDeploy;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorIn;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorRetract;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorStop;
import org.usfirst.frc319.SteamworksBob319.commands.GearCollector.GearCollectorDeploy;
import org.usfirst.frc319.SteamworksBob319.commands.GearCollector.GearCollectorIn;
import org.usfirst.frc319.SteamworksBob319.commands.GearCollector.GearCollectorRetract;
import org.usfirst.frc319.SteamworksBob319.commands.GearCollector.GearCollectorStop;
import org.usfirst.frc319.SteamworksBob319.commands.Rollervator.RollervatorClimb;
import org.usfirst.frc319.SteamworksBob319.commands.Rollervator.RollervatorGo;
import org.usfirst.frc319.SteamworksBob319.commands.Rollervator.RollervatorStop;
import org.usfirst.frc319.SteamworksBob319.commands.Shooter.ShooterGoToSpeed;
import org.usfirst.frc319.SteamworksBob319.commands.Shooter.ShooterStop;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc319.SteamworksBob319.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public BobController driverController;
	public BobController operatorController;

	public OI() {

		operatorController = new BobController(1);
		driverController = new BobController(0);
		

		// --------OPERATOR---------------//

		//operatorController.selectButton.whenPressed(new BlueHopperAuto());
		operatorController.leftBumper.whenPressed(new FollowTrajectory("RedHopperAutoPt1"));
		//operatorController.rightBumper.whenPressed(new BlueHopperAuto());
		//operatorController.rightBumper.whenPressed(new FollowTrajectory("Drive15ft"));
		operatorController.rightBumper.whenPressed(new FollowTrajectory("RedHopperAutoPt2"));
		operatorController.yButton.whenPressed(new FollowTrajectory("RedHopperAutoPt3"));
		operatorController.aButton.whenPressed(new RollervatorClimb()); // was gearCollectorIn
		operatorController.bButton.whenPressed(new GearCollectorStop());
		operatorController.xButton.whenPressed(new GearCollectorDeploy());
		operatorController.startButton.whenPressed(new GearCollectorRetract());

		// -----------DRIVER-----------//

		driverController.leftBumper.whenPressed(new RollervatorGo());
		driverController.yButton.whenPressed(new ShooterGoToSpeed());
		driverController.xButton.whenPressed(new ShiftToggle());
		driverController.bButton.whenPressed(new ShooterRollervatorStop());
		driverController.aButton.whenPressed(new FuelCollectorRetract());
		driverController.rightBumper.whenPressed(new FuelCollectorDeploy());
		driverController.startButton.whenPressed(new BrakePadDeploy());
		driverController.selectButton.whenPressed(new BrakePadRetract());

		/*
		 * // SmartDashboard Buttons SmartDashboard.putData("FuelCollectorGo",
		 * new FuelCollectorGo()); SmartDashboard.putData("AutonomousCommand",
		 * new AutonomousCommand()); SmartDashboard.putData("JoystickDrive", new
		 * JoystickDrive()); SmartDashboard.putData("FuelCollectorStop", new
		 * FuelCollectorStop()); SmartDashboard.putData("GearCollectorGo", new
		 * GearCollectorGo()); SmartDashboard.putData("GearCollectorStop", new
		 * GearCollectorStop()); SmartDashboard.putData("CommandGroup1", new
		 * CommandGroup1());
		 */

	}

	public Joystick getdriverController() {
		return driverController;
	}

	public Joystick getoperatorController() {
		return operatorController;
	}

}
