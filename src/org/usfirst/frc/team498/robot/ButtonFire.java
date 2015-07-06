/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team498.robot;

import java.util.ArrayList;
import java.util.List;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tTargetClass;

/**
 *
 * @author Curt
 */

public class ButtonFire {

	private Robot t;

    ButtonFire(Robot instance) {
    	t = instance;
    }

    public void begin() {
        //7 is SELECT
    	//10 is RIGHT BUMPER
        if (!t.Stick1.getRawButton(7) && t.Stick1.getRawButton(1)) {
            t.TOPLEFT.Shoot();
        } else if (!t.Stick1.getRawButton(7) && t.Stick1.getRawButton(2)) {
           t.TOPCENTERLEFT.Shoot();
        } else if (!t.Stick1.getRawButton(7) && t.Stick1.getRawButton(3)) {
            t.TOPCENTER.Shoot();
        } else if (!t.Stick1.getRawButton(7) && t.Stick1.getRawButton(4)) {
            t.TOPCENTERRIGHT.Shoot();
        } else if (!t.Stick1.getRawButton(7) && t.Stick1.getRawButton(10)) {
            t.TOPRIGHT.Shoot();
        } else if (t.Stick1.getRawButton(7) && t.Stick1.getRawButton(1)) {
            t.BOTTOMLEFT.Shoot();
        } else if (t.Stick1.getRawButton(7) && t.Stick1.getRawButton(2)) {
            t.BOTTOMCENTERLEFT.Shoot();
        } else if (t.Stick1.getRawButton(7) && t.Stick1.getRawButton(3)) {
            t.BOTTOMCENTER.Shoot();
        } else if (t.Stick1.getRawButton(7) && t.Stick1.getRawButton(4)) {
            t.BOTTOMCENTERRIGHT.Shoot();
        }else if (t.Stick1.getRawButton(7) && t.Stick1.getRawButton(10)) {
            t.BOTTOMRIGHT.Shoot();
        }else if (t.Stick1.getRawButton(7) && t.Stick1.getRawButton(8)) {
            t.TOPLEFT.Shoot();
            t.TOPCENTERLEFT.Shoot();
            t.TOPCENTER.Shoot();
            t.TOPCENTERRIGHT.Shoot();
            t.TOPRIGHT.Shoot();
            t.BOTTOMLEFT.Shoot();
            t.BOTTOMCENTERLEFT.Shoot();
            t.BOTTOMCENTER.Shoot();
            t.BOTTOMCENTERRIGHT.Shoot();
            t.BOTTOMRIGHT.Shoot();
        }         
    }
}


