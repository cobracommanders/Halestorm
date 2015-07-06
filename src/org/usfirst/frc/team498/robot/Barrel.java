package org.usfirst.frc.team498.robot;

import edu.wpi.first.wpilibj.Relay;

public class Barrel {
	private Relay relay;
	private Relay.Value value;
	private Boolean loaded;
	private Robot t;
	
	Barrel(Relay relay_a, Relay.Value relayValue_a,Robot instance) {
		relay = relay_a;
		value = relayValue_a;
		t = instance;
	}
	
	public void Shoot() {
		if(loaded) {
			if(relay.get() == Relay.Value.kForward && value == Relay.Value.kReverse) {
				relay.set(Relay.Value.kOn);
			} else if (relay.get() == Relay.Value.kReverse && value == Relay.Value.kForward) {
				relay.set(Relay.Value.kOn);
			} else {
				relay.set(value);
			}
			this.loaded = false;
			t.decayQueue.add(new DecayTrackPoint(this));
		}
	}
	
	public boolean isLoaded() {
		return loaded;
	}
	
	public void load() {
		this.loaded = true;
	}
	public Relay getRelay() {
		return relay;
	}
	
	public Relay.Value getValue() {
		return value;
	}
	
}
