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
import org.usfirst.frc319.SteamworksBob319.commands.DriveTrain.JoystickDrive;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorGo;
import org.usfirst.frc319.SteamworksBob319.commands.FuelCollector.FuelCollectorStop;
import org.usfirst.frc319.SteamworksBob319.commands.GearCollector.GearCollectorGo;
import org.usfirst.frc319.SteamworksBob319.commands.GearCollector.GearCollectorStop;

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
    // One type of button is a joystick button which is any button on a joystick.
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

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton aButton;
    public JoystickButton bButton;
    public JoystickButton xButton;
    public JoystickButton yButton;
    public JoystickButton leftBumper;
    public JoystickButton rightBumper;
    public Joystick driverController;
    public JoystickButton selectButton;
    public Joystick operatorController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        operatorController = new Joystick(1);
        
        selectButton = new JoystickButton(operatorController, 1);
        selectButton.whileHeld(new AutonomousCommand());
        driverController = new Joystick(0);
        
        rightBumper = new JoystickButton(driverController, 6);
        rightBumper.whenPressed(new GearCollectorStop());
        leftBumper = new JoystickButton(driverController, 5);
        leftBumper.whenPressed(new GearCollectorGo());
        yButton = new JoystickButton(driverController, 4);
        yButton.whenPressed(new FuelCollectorGo());
        xButton = new JoystickButton(driverController, 3);
        xButton.whenPressed(new FuelCollectorStop());
        bButton = new JoystickButton(driverController, 2);
        bButton.whenPressed(new CommandGroup1());
        aButton = new JoystickButton(driverController, 1);
        aButton.whenPressed(new JoystickDrive());


        // SmartDashboard Buttons
        SmartDashboard.putData("FuelCollectorGo", new FuelCollectorGo());
        SmartDashboard.putData("AutonomousCommand", new AutonomousCommand());
        SmartDashboard.putData("JoystickDrive", new JoystickDrive());
        SmartDashboard.putData("FuelCollectorStop", new FuelCollectorStop());
        SmartDashboard.putData("GearCollectorGo", new GearCollectorGo());
        SmartDashboard.putData("GearCollectorStop", new GearCollectorStop());
        SmartDashboard.putData("CommandGroup1", new CommandGroup1());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getdriverController() {
        return driverController;
    }

    public Joystick getoperatorController() {
        return operatorController;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

