package helpers;

public class Helpers {
	
	public void sleepSeconds(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
