import edu.wpi.first.wpilibj.Timer;


/**
 *
 * @author Curt
 */
public class TimerManager {

    double a = 0;
    boolean hasbeenset = false;
    Timer useClock = new Timer();
    Timer mainClock = new Timer();
    TimerManager() {
    	useClock.start();
    	mainClock.start();
    	
    }
    public void reset() {
    useClock.reset();
    }
    
    public double getTimeSinceStartUp() {
    	return mainClock.get();
    }
    
    public double getTimeElapsed() {
    	return useClock.get();
    }
    
    //This Method Must be looped
    
    public boolean hasTimeElapsed(double b) {
        if (!hasbeenset) {
            this.reset();
        }
        if (this.getTimeElapsed() > b) {
            hasbeenset = false;
            return true;
        } else {
            return false;
        }
    }
}


