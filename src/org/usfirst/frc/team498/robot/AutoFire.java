/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team498.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Curt
 */
public class AutoFire {
	int i = 0;
	int q = 0;
	double timeBetweenAutoShots = 2;
	int barrelNum = 0;
	Random r = new Random();
	private Robot t;
	long time;
	boolean timeSet;
	AutoFire(Robot instance) {
		t = instance;
		
	}
	private void newNumber() {
		q = r.nextInt(t.LoadedBarrels.size() - 1);
	}
	public void begin() {
		while (!t.Stick1.getRawButton(8)) {
			switch (i) {
			case 0:
				if (t.Stick1.getRawButton(8)) {
					break;
				}
				t.LoadedBarrels.get(q).Shoot();
				t.LoadedBarrels.remove(q);
				if (t.LoadedBarrels.isEmpty()) {
					break;
				}
				newNumber();
				t.clock.reset();
				i++;
				begin();
				break;
			case 1:
				if (t.clock.hasTimeElapsed(timeBetweenAutoShots)) {
					i = 0;
					begin();
					break;
				} else if (t.Stick1.getRawButton(8)) {
					break;
				} else {
					begin();
					break;
				}
			}
		}
	}
}
