/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team498.robot;



/**
 *
 * @author Curt
 * 
 */
public class ManualFire {

    private Robot t;


    ManualFire(Robot instance) {
    	t = instance;
    	
    }
    public void manualShot() {
            
            if(!t.LoadedBarrels.isEmpty()) {
            	t.LoadedBarrels.get(0).Shoot();
                t.LoadedBarrels.remove(0);
            }        
    }
}