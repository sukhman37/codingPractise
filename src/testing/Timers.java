package testing;

import java.util.Timer;
import java.util.TimerTask;

public class Timers {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				for(int i = 0 ; i < 3 ; i++) {
					System.out.println("hi");
				}
				
			}
		}, 5000,2000);
	}

}
