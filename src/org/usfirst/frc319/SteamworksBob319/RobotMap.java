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


import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    public static CANTalon driveTrainLeftDriveLead;
    public static CANTalon driveTrainRightDriveLead;
    public static CANTalon driveTrainLeftDriveFollow;
    public static CANTalon driveTrainRightDriveFollow;
    public static RobotDrive driveTrainJoystickDrive;
    public static DoubleSolenoid driveTrainShifter;
    public static CANTalon shooterShooterLead;
    public static CANTalon shooterShooterFollow;
    public static CANTalon fuelCollectorFuelCollector;
    public static DoubleSolenoid fuelCollectorFuelPiston;
    public static CANTalon rollervatorRollervatorLead;
    public static CANTalon rollervatorRollervatorFollow;
    public static DoubleSolenoid gearCollectorGearPiston;
    public static CANTalon gearCollectorGearCollectorMotor;
    public static DoubleSolenoid brakePadBrakePadPiston;
    public static Compressor compressorCompressor;
    public static AnalogInput compressorPressureSensor;
    



    public static void init() {
        
    	//-------------------drivetrain----------------------- 
    	
        driveTrainLeftDriveLead = new CANTalon(7);
        driveTrainLeftDriveFollow = new CANTalon(8);
        
        driveTrainRightDriveLead = new CANTalon(2);
        driveTrainRightDriveFollow = new CANTalon(3);
        
        driveTrainJoystickDrive = new RobotDrive(driveTrainLeftDriveLead, driveTrainRightDriveLead);
        
        driveTrainJoystickDrive.setSafetyEnabled(false);//changed from true for velocity control testing 2/10/17
        driveTrainJoystickDrive.setExpiration(0.1);
        driveTrainJoystickDrive.setSensitivity(0.5);
        driveTrainJoystickDrive.setMaxOutput(1.0);

      //  driveTrainJoystickDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        driveTrainShifter = new DoubleSolenoid(0, 0, 1);
        
        //---------------------------shooter--------------------------//
        
        shooterShooterLead = new CANTalon(1);
        shooterShooterFollow = new CANTalon(6);
   
        //----------------fuelCollector----------------------------//
        
        fuelCollectorFuelCollector = new CANTalon(9);
        fuelCollectorFuelPiston = new DoubleSolenoid(0, 2, 3);
       
        //------------rollervator----------------------
        
        rollervatorRollervatorLead = new CANTalon(0);
        rollervatorRollervatorFollow = new CANTalon(5);
        
        //----------------------gearCollector----------------------
       
        gearCollectorGearPiston = new DoubleSolenoid(0, 4, 5);
        gearCollectorGearCollectorMotor = new CANTalon(4);
        
      //---------------------------brakePad-------------------------------
        
        brakePadBrakePadPiston = new DoubleSolenoid(0, 6, 7);
        
        //------------------------compressor-----------------------------
        
        compressorCompressor = new Compressor(0);
        compressorPressureSensor = new AnalogInput(0);
       

    }
}
