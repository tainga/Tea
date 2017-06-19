import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Leaves {
	private Runnable hotWater;
	private ScheduledExecutorService executor;
	public Leaves() {
		Robot robot;
		try {
			robot = new Robot();
			hotWater = new Runnable() {
			    public void run() {
			    	robot.keyPress(KeyEvent.VK_F10);
			        robot.keyRelease(KeyEvent.VK_F10);
			    }
			};
		} 
		catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(hotWater, 0, 59, TimeUnit.SECONDS);
		
	}
	
	public void stop() {
		executor.shutdown();
	}
}
