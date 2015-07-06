/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team498.robot;

import java.util.ArrayList;
import java.util.List;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {
	
	public double shotDecayTime = .4;
	List<DecayTrackPoint> decayQueue = new ArrayList<DecayTrackPoint>();
	List<Barrel> LoadedBarrels = new ArrayList<Barrel>();
    
    Joystick Stick1 = new Joystick(1);
    RobotDrive Drive = new RobotDrive(1, 2);//Right Drive is (2, 2) Left is (2, 1)
    //RobotDrive Drive = new RobotDrive(1, 2);
    //Thing Variable = new Thing(Digital Modual, Channel);
    //Van Motors for Turret Movement
    Victor Window1 = new Victor(2, 3);
    Talon Window2 = new Talon(2, 4);
  //Barrels
    Relay Spike1 = new Relay(1);
    Relay Spike2 = new Relay(2);
    Relay Spike3 = new Relay(3);
    Relay Spike4 = new Relay(4);
    Relay Spike5 = new Relay(5);

    /*
     * 
     * Compressors are done soley through electrical now. Roborio Things*
     * 
     */
    
    
    //Turret Movment Limit Switches
    DigitalInput Switch1 = new DigitalInput(1);
    DigitalInput Switch2 = new DigitalInput(1);
    DigitalInput Switch3 = new DigitalInput(1);
    DigitalInput Switch4 = new DigitalInput(1);
    

    AutoFire autofire;
    ManualFire manualfire = new ManualFire(this);
    ButtonFire buttonfire = new ButtonFire(this);
    TimerManager clock = new TimerManager();
    
    public Barrel TOPLEFT = new Barrel(Spike1,Relay.Value.kForward,this);
    public Barrel TOPCENTERLEFT = new Barrel(Spike1, Relay.Value.kReverse,this);
    public Barrel TOPCENTER= new Barrel(Spike2, Relay.Value.kForward, this);
    public Barrel TOPCENTERRIGHT = new Barrel(Spike2, Relay.Value.kReverse,this);
    public Barrel TOPRIGHT = new Barrel(Spike3, Relay.Value.kForward, this);
    public Barrel BOTTOMLEFT = new Barrel(Spike3, Relay.Value.kReverse, this);
    public Barrel BOTTOMCENTERLEFT = new Barrel(Spike4, Relay.Value.kForward, this);
    public Barrel BOTTOMCENTER = new Barrel(Spike4, Relay.Value.kReverse, this);
    public Barrel BOTTOMCENTERRIGHT = new Barrel(Spike5, Relay.Value.kForward, this);
    public Barrel BOTTOMRIGHT 	= new Barrel(Spike5, Relay.Value.kReverse, this);
    
    
    public void TurretMovement() {
        if (Stick1.getRawAxis(5) > .1 ) {
            Window1.set(Stick1.getRawAxis(5));

        } else if (Stick1.getRawAxis(5) < -.1 ) {
            Window1.set(Stick1.getRawAxis(5));
        } else {
            Window1.set(0);
        }
        if (Stick1.getRawAxis(4) > .1 ) {
            Window2.set(Stick1.getRawAxis(4));
        } else if (Stick1.getRawAxis(4) < -.1 ) {
            Window2.set(Stick1.getRawAxis(4));
        } else {
            Window2.set(0);
        }
    }
    

    
    

    public void NewShoot() {
        if (Stick1.getRawButton(5)) {
            manualfire.manualShot();
        } else if (Stick1.getRawButton(7) && Stick1.getRawButton(6)) { //Select && Right Bumper
            autofire = new AutoFire(this);
        	autofire.begin();
        } else if (Stick1.getRawButton(8) && Stick1.getRawButton(5)) { //Start && Left Bumper
        	manualfire = new ManualFire(this);
        } /*else if (Stick1.getRawButton(8) && Stick1.getRawButton(1)) {
            TOPLEFT.load();
        } else if (Stick1.getRawButton(8) && Stick1.getRawButton(2)) {
           TOPCENTERLEFT.load();
        } else if (Stick1.getRawButton(8) && Stick1.getRawButton(3)) {
           TOPCENTER.load();
        } else if (Stick1.getRawButton(8) && Stick1.getRawButton(4)) {
           TOPCENTERRIGHT.load();
        } else if (Stick1.getRawButton(8) && Stick1.getRawButton(10)) { //Start && Right Joystick Button
           TOPRIGHT.load();
        } else if (Stick1.getRawButton(8) && Stick1.getRawButton(1)) {
           BOTTOMLEFT.load();
        } else if (Stick1.getRawButton(8) && Stick1.getRawButton(2)) {
           BOTTOMCENTERLEFT.load();
        } else if (Stick1.getRawButton(8) && Stick1.getRawButton(3)) {
           BOTTOMCENTER.load();
        } else if (Stick1.getRawButton(8) && Stick1.getRawButton(4)) {
           BOTTOMCENTERRIGHT.load();
        } else if (Stick1.getRawButton(8) && Stick1.getRawButton(10)) { //Start && Right Joystick Button
           BOTTOMRIGHT.load();
        } */else if (Stick1.getRawButton(8) && Stick1.getRawButton(9)) { //Start && Left Joystick Button
        	TOPLEFT.load();
        	TOPCENTERLEFT.load();
        	TOPCENTER.load();
        	TOPCENTERRIGHT.load();
        	TOPRIGHT.load();
        	BOTTOMLEFT.load();
        	BOTTOMCENTERLEFT.load();
        	BOTTOMCENTER.load();
        	BOTTOMCENTERRIGHT.load();
        	BOTTOMRIGHT.load();
         }else {
        
            buttonfire.begin();
        }
    }

    public void Print() {
        //Name then Value
        SmartDashboard.putBoolean("Barrel TOPLEFT Loaded? ", TOPLEFT.isLoaded());
        SmartDashboard.putBoolean("Barrel TOPCENTERLEFT Loaded?", TOPCENTERLEFT.isLoaded());
        SmartDashboard.putBoolean("Barrel TOPCENTER Loaded?", TOPCENTER.isLoaded());
        SmartDashboard.putBoolean("Barrel TOPCENTERRIGHT Loaded?", TOPCENTERRIGHT.isLoaded());
        SmartDashboard.putBoolean("Barrel TOPRIGHT Loaded?", TOPRIGHT.isLoaded());
        SmartDashboard.putBoolean("Barrel BOTTOMLEFT Loaded?", BOTTOMLEFT.isLoaded());
        SmartDashboard.putBoolean("Barrel BOTTOMCENTERLEFT Loaded?", BOTTOMCENTERLEFT.isLoaded());
        SmartDashboard.putBoolean("Barrel BOTTOMCENTER Loaded?", BOTTOMCENTER.isLoaded());
        SmartDashboard.putBoolean("Barrel BOTTOMCENTERRIGHT Loaded?", BOTTOMCENTERRIGHT.isLoaded());
        SmartDashboard.putBoolean("Barrel BOTTOMRIGHT Loaded?", BOTTOMRIGHT.isLoaded());
    }

    public void autonomous() {
        //Empty
    }
    
    public void updatedLoadedBarrelList() {
    	if (TOPLEFT.isLoaded()) {
			LoadedBarrels.add(TOPLEFT);
		}
		if (TOPCENTERLEFT.isLoaded()) {
			LoadedBarrels.add(TOPCENTERLEFT);
		}
		if (TOPCENTER.isLoaded()) {
			LoadedBarrels.add(TOPCENTER);
		}
		if (TOPCENTERRIGHT.isLoaded()) {
			LoadedBarrels.add(TOPCENTERRIGHT);
		}
		if (TOPRIGHT.isLoaded()) {
			LoadedBarrels.add(TOPRIGHT);
		}
		if (BOTTOMLEFT.isLoaded()) {
			LoadedBarrels.add(BOTTOMLEFT);
		}
		if (BOTTOMCENTERLEFT.isLoaded()) {
			LoadedBarrels.add(BOTTOMCENTERLEFT);
		}
		if (BOTTOMCENTER.isLoaded()) {
			LoadedBarrels.add(BOTTOMCENTER);
		}
		if (BOTTOMCENTERRIGHT.isLoaded()) {
			LoadedBarrels.add(BOTTOMCENTERRIGHT);
		}
		if (BOTTOMRIGHT.isLoaded()) {
			LoadedBarrels.add(BOTTOMRIGHT);
		}
    }
    public void checkShotDecay() {
    	 //Autmatically Turns A Barrel Off After Firing
        for(int i = 0; i < decayQueue.size(); i++) {
        	if(decayQueue.get(i).clock.get() > shotDecayTime) {
        		if(decayQueue.get(i).relay.get() == Relay.Value.kOn) {
        			if(decayQueue.get(i).value == Relay.Value.kForward) {
        				decayQueue.get(i).relay.set(Relay.Value.kReverse);
        			} else {
        				decayQueue.get(i).relay.set(Relay.Value.kForward);
        			}
        		} else {
        			decayQueue.get(i).relay.set(Relay.Value.kOff);
        		}
        		decayQueue.get(i).clock.stop();
        		decayQueue.remove(i);
        	}
        	
        }
    }
    public void operatorControl() { //important CAZ LOOP
    	if (Stick1.getRawAxis(3) > 0) {
			Drive.arcadeDrive(Stick1.getRawAxis(3), Stick1.getX() * -1);
		} else {
			Drive.arcadeDrive(Stick1.getRawAxis(2) * -1, Stick1.getX() * -1);
		}
        TurretMovement();
        NewShoot();
        Print();
        checkShotDecay();
        updatedLoadedBarrelList();
       
    }

    
}


