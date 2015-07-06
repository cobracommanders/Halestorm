package org.usfirst.frc.team498.robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;

public class DecayTrackPoint {
	Timer clock = new Timer();
	Relay relay;
	Relay.Value value;
	DecayTrackPoint(Barrel barrel){
	clock.start();
	relay = barrel.getRelay();
	value = barrel.getValue();
	}
}
