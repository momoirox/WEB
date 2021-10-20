package primer02threadsync;

public class ThreadTest {

	/** Broj niti koje ce se pokrenuti */
	public static final int THREAD_COUNT = 2;
	
	/**
	 * Pokrece sve niti i zavrsava sa radom
	 * 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		for (int i = 0; i < THREAD_COUNT; i++) {
			PrviThread pt = new PrviThread(i, counter);
			pt.start();
		}
		System.out.println("Threads started.");
		Thread.currentThread().sleep(2000);
		System.out.println("Main, counter: " + counter.count);
	}
}